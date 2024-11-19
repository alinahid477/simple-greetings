package local.simplegreetings.Controllers.api;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

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
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return new GreetingResponseObject(this.appProperties.getGreetingText()+" "+year);
    } 

    @GetMapping("/heavy")
    public GreetingResponseObject heavy() {
        logger.info("Inside heavy..");
        List<Integer> list = IntStream.range(0, 10000000).parallel().map(IntUnaryOperator.identity()).collect(LinkedList::new, List::add, List::addAll);
        long start = System.nanoTime();
        int value = list.get(9500000);
        long end = System.nanoTime() - start;
        String outputText = String.format("Found value %d in %d nanos\n", value, end);
        return new GreetingResponseObject(outputText);
    } 
}