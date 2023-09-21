package dk.kvalitetsit.consentservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dk.kvalitetsit.consentservice.entity.Consent;
import dk.kvalitetsit.consentservice.entity.ConsentTemplate;

public interface ConsentRepository extends CrudRepository<Consent,Long>  {

	Consent findByConsentTemplateAndCitizenIdAndRevocationDate(ConsentTemplate template, String citizenId, Date revocationDate);
	
	List<Consent> findByCitizenId(String citizenId);

}
