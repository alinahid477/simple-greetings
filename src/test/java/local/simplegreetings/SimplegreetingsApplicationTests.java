package local.simplegreetings;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import local.simplegreetings.Controllers.api.GreetingsController;

@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
class SimplegreetingsApplicationTests {

	@Autowired
	private GreetingsController controller;

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

	@Test
    public void shouldPassIfStringMatches() throws Exception {
        assertTrue(restTemplate.getForObject("http://localhost:" + port + "/api/greetings/healthcheck", String.class).contains("running"));
    }

}
