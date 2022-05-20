package local.simplegreetings.Controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.simplegreetings.Models.GreetingResponseObject;


@RestController
@RequestMapping("/api/greetings")
public class GreetingsController {


    private final Logger logger = LoggerFactory.getLogger(GreetingsController.class);


    @Value("${app.greeting-text}")
    private String greetingText;



    @GetMapping("/do")
    public GreetingResponseObject greeting() {
        logger.info("Inside greeting..");
        return new GreetingResponseObject(this.greetingText);
    } 
}