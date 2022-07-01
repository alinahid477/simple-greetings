package local.simplegreetings.Controllers.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.simplegreetings.AppProperties;
import local.simplegreetings.Models.GreetingResponseObject;


@RestController
@RequestMapping("/api/greetings")
public class GreetingsController {


    private final Logger logger = LoggerFactory.getLogger(GreetingsController.class);


    @Autowired
    private AppProperties appProperties;


    @GetMapping("/healthcheck")
    public GreetingResponseObject healthCheck() {
        logger.info("Inside healthcheck..");
        return new GreetingResponseObject("running");
    }


    @GetMapping("/do")
    public GreetingResponseObject greeting() {
        logger.info("Inside greeting..");
        return new GreetingResponseObject(this.appProperties.getGreetingText());
    } 
}