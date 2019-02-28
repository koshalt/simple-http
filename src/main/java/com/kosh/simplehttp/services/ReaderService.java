package com.kosh.simplehttp.services;

import java.util.Date;
import java.util.List;

import com.kosh.simplehttp.models.Person;

public interface ReaderService {
    public Date getTime();
    public void addUser(Person p);
    public List<Person> getPeople(String nameFilter);
}
