package ca.mcgill.ecse321.eventregistration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class RegistrationManager{
   private Set<Event> event;
   private Integer id;
   
	public void setId(Integer value) {
		this.id = value;
	}
	@Id
	public Integer getId() {
		return this.id;
	}
   
   @OneToMany(mappedBy="registrationManager" , cascade={CascadeType.ALL})
   public Set<Event> getEvent() {
      return this.event;
   }
   
   public void setEvent(Set<Event> events) {
      this.event = events;
   }
   
   private Set<Registration> registration;
   
   @OneToMany(mappedBy="registrationManager" , cascade={CascadeType.ALL})
   public Set<Registration> getRegistration() {
      return this.registration;
   }
   
   public void setRegistration(Set<Registration> registrations) {
      this.registration = registrations;
   }
   
   private Set<Participant> participant;
   
   @OneToMany(mappedBy="registrationManager" , cascade={CascadeType.ALL})
   public Set<Participant> getParticipant() {
      return this.participant;
   }
   
   public void setParticipant(Set<Participant> participants) {
      this.participant = participants;
   }
   
   }
