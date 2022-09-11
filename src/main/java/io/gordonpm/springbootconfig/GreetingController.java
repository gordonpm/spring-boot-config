package io.gordonpm.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class GreetingController {

    @Value("${my.greeting: defaultValue}")
    private String greetingMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

//    @Value("#{${dbValues}}")
//    private Map<String, String> dbValues;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/greeting")
    public String greeting() {
        return "my.greeting=" + greetingMessage + "db.connnection=" + dbSettings.getConnection() + " " + dbSettings.getHost() + " " + dbSettings.getPort();
    }
}
