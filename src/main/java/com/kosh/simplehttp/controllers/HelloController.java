package com.kosh.simplehttp.controllers;

import com.google.gson.Gson;
import com.kosh.simplehttp.models.Person;
import com.kosh.simplehttp.services.ReaderService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private ReaderService reader;
    Gson responseSerializer;

    public HelloController(ReaderService reader) {
        this.reader = reader;
        responseSerializer = new Gson();
    }

    @RequestMapping(value="/", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String index(@RequestParam(value = "nameFilter", required = false)final String nameFilter, @RequestHeader HttpHeaders headers) {
        System.out.println("name filter: " + nameFilter);
        System.out.println("name filter: " + headers.toString());
        return responseSerializer.toJson(reader.getPeople(nameFilter));
    }

    @RequestMapping(value="/time", method=RequestMethod.GET)
    public String getTime() {
        return reader.getTime().toString();

    }

    @RequestMapping(value="/person/new", method=RequestMethod.PUT)
    public void createPerson(@RequestBody Person person) {
        this.reader.addUser(person);
    }

}
