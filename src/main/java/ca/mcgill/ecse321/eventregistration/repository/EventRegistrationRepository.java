package ca.mcgill.ecse321.eventregistration.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.eventregistration.model.Participant;
import ca.mcgill.ecse321.eventregistration.model.RegistrationManager;

@Repository
public class EventRegistrationRepository {

	@Autowired
	EntityManager entityManager;

	@Transactional
	public Participant createParticipant(String name) {
		Participant participant = new Participant();
		RegistrationManager rm = new RegistrationManager();
		rm.setId(1);
		participant.setRegistrationManager(rm);
		participant.setName(name);
		entityManager.persist(participant);
		entityManager.persist(rm);
		return participant;
	}

	@Transactional
	public Participant getParticipant(String name) {
		Participant participant = entityManager.find(Participant.class, name);
		return participant;
	}

}