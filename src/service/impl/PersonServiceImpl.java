package service.impl;

import dao.PersonDao;
import models.Gender;
import models.Person;
import service.Generic;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements Generic<Person> {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public String add(List<Person> t) {
        for (Person person : t) {
            personDao.add(person);
        }
        return "Added !";
    }

    @Override
    public Person getById(Long id) {
        return personDao.findById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.findAll();
    }

    @Override
    public List<Person> sortByName(int number) {
        List<Person> personList = new ArrayList<>(personDao.findAll());
        if (number == 1){
            personList.sort(Person.sortByNameAsc);
        } else if (number == 2) {
            personList.sort(Person.sortByNameDesc);
        }
        return personList;
    }

    @Override
    public List<Person> filterByGender(Long num) {
        List<Person> personList = new ArrayList<>(personDao.findAll());
        List<Person> personList1 = new ArrayList<>();
        if (num == 1) {
            for (Person person : personList) {
                if (person.getGender().equals(Gender.MALE)){
                    personList1.add(person);
                }
            }
        } else if (num == 2) {
            for (Person person : personList) {
                if (person.getGender().equals(Gender.FEMALE)){
                    personList1.add(person);
                }
            }
        }
        return personList1;
    }

    @Override
    public List<Person> clear() {
        personDao.findAll().clear();
        return personDao.findAll();
    }
}
