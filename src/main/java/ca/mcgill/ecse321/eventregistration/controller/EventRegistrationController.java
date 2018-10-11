package ca.mcgill.ecse321.eventregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.eventregistration.model.Participant;
import ca.mcgill.ecse321.eventregistration.repository.EventRegistrationRepository;

@RestController
public class EventRegistrationController {

	@Autowired
	EventRegistrationRepository repository;

	@RequestMapping("/")
	public String greeting() {
		return "Hello world!";
	}

	@PostMapping("/participants/{name}")
	public String createParticipant(@PathVariable("name") String name) {
		Participant participant = repository.createParticipant(name);
		return participant.getName();
	}

	@GetMapping("/participants/{name}")
	public String queryParticipant(@PathVariable("name") String name) {
		Participant participant = repository.getParticipant(name);
		if(participant == null) {
			return "NOT FOUND";
		}
		return participant.getName();
	}

}