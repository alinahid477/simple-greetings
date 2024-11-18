package local.simplegreetings.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GreetingResponseObject {
    
    @JsonProperty("greeting_text")
    private String greetingText;

    public GreetingResponseObject() {}

    public GreetingResponseObject(String greetingText) {
        this.greetingText = greetingText;
    }

    public String getGreetingText() {
        return this.greetingText;
    }

    public void setGreetingText(String greetingText) {
        this.greetingText = greetingText;
    }

    @Override
    public String toString() {
        return "{" +
            " greetingText='" + greetingText + "'" +
            "}";
    }



}
