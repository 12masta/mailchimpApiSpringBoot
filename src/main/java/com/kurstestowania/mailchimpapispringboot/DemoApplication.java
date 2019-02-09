package com.kurstestowania.mailchimpapispringboot;

import com.kurstestowania.mailchimpapispringboot.contact.ContactContainer;
import com.kurstestowania.mailchimpapispringboot.model.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    @ResponseBody
    Response home() {
        return new Response(200, "Hello World v1.1!!");
    }

    @PostMapping("/createorupdatecontact")
    @CrossOrigin(origins = {"http://localhost:3000", "https://kurstestowania.pl", "https://www.kurstestowania.pl"})
    @ResponseBody
    Response createorupdatecontact(@RequestBody ContactContainer contact) {

        return new Response(200, "Hello World v1.1!!");
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
