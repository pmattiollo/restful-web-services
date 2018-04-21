package br.com.pmattiollo.restfulwebservices.resource;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class GreetingResource {

    private MessageSource messageSource;

    public GreetingResource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/greetings/hello")
    public String sayHello(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("greeting.hello", null, locale);
    }

}
