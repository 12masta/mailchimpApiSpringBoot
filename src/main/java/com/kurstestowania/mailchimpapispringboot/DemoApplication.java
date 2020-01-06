package com.kurstestowania.mailchimpapispringboot;

import com.kurstestowania.mailchimpapispringboot.configuration.ConfigurationApi;
import com.kurstestowania.mailchimpapispringboot.contact.ContactContainer;
import com.kurstestowania.mailchimpapispringboot.convert.JsonConverter;
import com.kurstestowania.mailchimpapispringboot.http.Http;
import com.kurstestowania.mailchimpapispringboot.mailchimp.MergeFields;
import com.kurstestowania.mailchimpapispringboot.mailchimp.Subscribe;
import com.kurstestowania.mailchimpapispringboot.model.Response;
import com.kurstestowania.mailchimpapispringboot.reader.ConfigApiReader;
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
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4000", "https://kurstestowania.pl", "https://www.kurstestowania.pl", "https://kurstestowaniaselenium.web.app", "https://www.kurstestowaniaselenium.web.app", "https://marcinstanek.pl", "http://marcinstanek.pl"})
    @ResponseBody
    Response createorupdatecontact(@RequestBody ContactContainer contact) {
        ConfigurationApi configurationApi = new ConfigApiReader().getConfigApi();
        Http http = new Http(configurationApi);
        Response response = new Response(200, "OK");
        MergeFields mergeFields = new MergeFields();
        mergeFields.setFNAME("");
        mergeFields.setLNAME("");
        Subscribe subscribe = new Subscribe();
        subscribe.setMergeFields(mergeFields);
        subscribe.setEmailAddress(contact.getContact().getEmail());
        subscribe.setStatus("subscribed");
        subscribe.setTags(new String[]{"kurstestowania.pl.16.things.doc"});
        try {
            okhttp3.Response okHttpResponse = http.post("/lists/f00648db58/members/", JsonConverter.toJsonString(subscribe));
            response.setResponse(okHttpResponse.message());
            response.setStatusCode(okHttpResponse.code());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setResponse(e.getMessage());
        }
        return response;
    }

    @PostMapping("/createorupdatecontactseleniumwebinar")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4000", "https://kurstestowania.pl", "https://www.kurstestowania.pl", "https://kurstestowaniaselenium.web.app", "https://www.kurstestowaniaselenium.web.app", "https://marcinstanek.pl", "http://marcinstanek.pl"})
    @ResponseBody
    Response createorupdatecontactseleniumwebinar(@RequestBody ContactContainer contact) {
        ConfigurationApi configurationApi = new ConfigApiReader().getConfigApi();
        Http http = new Http(configurationApi);
        Response response = new Response(200, "OK");
        MergeFields mergeFields = new MergeFields();
        mergeFields.setFNAME("");
        mergeFields.setLNAME("");
        Subscribe subscribe = new Subscribe();
        subscribe.setMergeFields(mergeFields);
        subscribe.setEmailAddress(contact.getContact().getEmail());
        subscribe.setStatus("subscribed");
        subscribe.setTags(new String[]{"seleniumwebinar"});
        try {
            okhttp3.Response okHttpResponse = http.post("/lists/f00648db58/members/", JsonConverter.toJsonString(subscribe));
            response.setResponse(okHttpResponse.message());
            response.setStatusCode(okHttpResponse.code());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setResponse(e.getMessage());
        }
        return response;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
