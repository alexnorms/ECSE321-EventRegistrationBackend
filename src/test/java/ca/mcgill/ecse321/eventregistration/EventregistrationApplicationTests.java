package ca.mcgill.ecse321.eventregistration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.eventregistration.controller.EventRegistrationController;
import ca.mcgill.ecse321.eventregistration.model.Participant;
import ca.mcgill.ecse321.eventregistration.repository.EventRegistrationRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventregistrationApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Mock
	private EventRegistrationRepository participantDao;

	@InjectMocks
	private EventRegistrationController controller;

	private static final String PARTICIPANT_KEY = "TestParticipant";
	private static final String NONEXISTING_KEY = "NotAParticipant";

	@Before
	void setMockOutput() {
	  when(participantDao.getParticipant(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
	    if(invocation.getArgument(0).equals(PARTICIPANT_KEY)) {
	      Participant participant = new Participant();
	      participant.setName(PARTICIPANT_KEY);
	      return participant;
	    } else {
	      return null;
	    }
	  });
	}
	
	@Test
	public void testParticipantQueryFound() {
	  assertEquals(controller.queryParticipant(PARTICIPANT_KEY), PARTICIPANT_KEY);
	}

	@Test
	public void testParticipantQueryNotFound() {
	  assertEquals(controller.queryParticipant(NONEXISTING_KEY), EventRegistrationController.ERROR_NOT_FOUND_MESSAGE);
	}

}
