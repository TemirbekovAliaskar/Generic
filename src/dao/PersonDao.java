package dao;

import db.DataBase;
import models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao implements DaoCrud<Person,Long> {

    private final DataBase dataBase;

    public PersonDao(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public boolean add(Person type) {
        return dataBase.add(type);
    }

    @Override
    public boolean delete(Person type) {
        return dataBase.remove(type);
    }

    @Override
    public Person findById(Long id) {
        List<Person> people = dataBase.personList();
        for (Person person : people) {
            if (person.getId() == id)return person;
        }
        throw new RuntimeException(String.format("This not id  !", id));
    }

    @Override
    public List<Person> findAll() {
        return dataBase.personList();
    }

}
