package db;

import models.Animal;
import models.Person;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private List<Animal> animals = new ArrayList<>();
    private List<Person> people = new ArrayList<>();

    public <T> Boolean add (T type){
        if (type instanceof Animal) return animals.add((Animal)type);
        else if (type instanceof Person) return people.add((Person) type);
        throw new RuntimeException("False alarm !");
    }

    public <T> Boolean remove (T type){
        if (type instanceof Animal){
            return animals.remove((Animal) type);
        }
        else if (type instanceof Person){
            return people.remove((Person) type);
        }
        throw new RuntimeException("Incorrect remove ");
    }

    public List<Animal> animals(){
        return animals;
    }
    public List<Person> personList() {
        return people;
    }



}
