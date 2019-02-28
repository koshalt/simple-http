package com.kosh.simplehttp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.kosh.simplehttp.models.Person;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ReaderServiceImpl implements ReaderService {

    List<Person> people;
    Gson serializer;

    public ReaderServiceImpl() {
        this.people = new ArrayList<>();
        serializer = new Gson();
    }

    @Override
    public Date getTime() {
        return new Date();
    }

    @Override
    public void addUser(Person p) {
        this.people.add(p);
    }

    @Override
    public List<Person> getPeople(String nameFilter) {
        List<Person> toReturn = new ArrayList<>();
        if (StringUtils.isEmpty(nameFilter)) {
            toReturn = this.people;
        } else {
            for (Person p : people) {
                if (p.getName().compareTo(nameFilter) == 0) {
                    toReturn.add(p);
                }
            }
        }
        return toReturn;
    }

}
