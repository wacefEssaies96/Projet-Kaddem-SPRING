package tn.esprit.service.classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.entities.Contrat;
import tn.esprit.persistance.entities.Etudiant;
import tn.esprit.persistance.repositories.ContratRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.service.interfaces.ContratService;

@Service
@Slf4j
public class ContratServiceImpl implements ContratService {
	
	@Autowired
	private ContratRepository cr;
	@Autowired
	private EtudiantRepository er;

	@Override
	public List<Contrat> retrieveAllContrats() {
		List<Contrat> l = this.cr.findAll();
		for(Contrat c : l) {
			log.info("Contacts : " + c.toString());
		}
		return l;
	}

	@Override
	public Contrat updateContrat(Contrat ce) {
		Contrat c =  null;
		try {
			c = this.cr.save(ce);
			log.info("Contrat à été modifié avec succés !");
		}catch(EntityNotFoundException e) {
			log.error(e.getMessage());
		}
		return c;
	}

	@Override
	public Contrat addContrat(Contrat ce) {
		Contrat c =  null;
		try {
			c = this.cr.save(ce);
			log.info("Contrat à été ajouté avec succés !");
		}catch(PersistenceException e) {
			log.error(e.getMessage());
		}
		return c;
	}

	@Override
	public Contrat retrieveContrat(Integer idContrat) {
		Contrat c =  null;
		try {
			c = cr.findById(idContrat).get();
			log.info(c.toString());
		} catch (EntityNotFoundException e) {
			log.error(e.getMessage());
		}
		return c;
	}
	
	@Override
    public void removeContrat(Integer idContrat) {
    	try {
    		cr.deleteById(idContrat);
     		log.info("Contrat supprimé ");
    	}catch(NoSuchElementException e) {
    		log.info("Echec de supprimer un Contrat  :"+e.getMessage());
        }
        
    }

	@Override
	public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
		float result = 0;
		for(Contrat c : this.cr.retriveContratBetweenDate(startDate, endDate)) {
			long mois = ChronoUnit.MONTHS.between(
				LocalDate.parse(c.getDateDebutContrat().toString()),
				LocalDate.parse(c.getDateFinContrat().toString())
			);
			switch (c.getSpecialite().name()) {
				case "IA":
					result += 300*mois;
					break;
				case "RESEAUX":
					result += 350*mois;
					break;
				case "CLOUD":
					result += 400*mois;
					break;
				case "SECURITE":
					result += 450*mois;
					break;		
				default:
					break;
			}
		}
		log.info("Chiffre d'affaire : "+result);
		return result;
	}

	@Override
	public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
		try {
			int nbrContrat = this.cr.countContratsByEtudiant(nomE, prenomE);
			if(nbrContrat <= 5) {
				Etudiant e = this.er.findByNomEAndPrenomE(nomE, prenomE);
				ce.setEtudiant(e);
				this.cr.save(ce);
				log.info("L'etudiant "+e.getIdEtudiant()+" est affecté au contrat "+ce.getIdContrat());
			}
		} catch (Exception e) {
			log.error(e.getMessage());		
		}
		return ce;
	}
	
	@Override
	public Integer nbContratsValides(Date startDate, Date endDate) {
		return this.cr.countContratBetweenTwoDates(startDate, endDate);
	}
	
	@Scheduled(cron = "0 18 12 * * *" )
	@Override
	public String retrieveAndUpdateStatusContrat() {
		String result = "";
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 15);
		Date deadLine = calendar.getTime();
		this.cr.updateContratArchive(new Date());
		List<Contrat> l = this.cr.retrieveContratsGoingToEnd(deadLine);
		for(Contrat c : l) {
			result += "Contrat "+c.getIdContrat()+
					" : "+c.getDateFinContrat()+
					" | "+c.getSpecialite()+
					" | "+c.getEtudiant().toString()+" sera archivé dans 15 jours !\n";
		}
		log.info(result);
		return result;
	}

	@Override
	public List<Object[]> countBySpecialite() {
		// TODO Auto-generated method stub
		return this.cr.getNbrSpecialite();
	}
	
	@Override
	public Integer incrementNbrLike(Contrat c) {
		int inc = c.getNbrLike();
		inc++;
		c.setNbrLike(inc);
		cr.save(c);
		return inc;
	}

}
