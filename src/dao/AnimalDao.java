package dao;

import db.DataBase;
import models.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalDao implements DaoCrud<Animal,Long> {
    private final DataBase dataBase;

    public AnimalDao(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public boolean add(Animal type) {
        return dataBase.add(type);
    }

    @Override
    public boolean delete(Animal type) {
        return dataBase.remove(type);
    }

    @Override
    public Animal findById(Long aLong) {
        List<Animal> animals = dataBase.animals();
        for (Animal animal : animals) if (animal.getId() == aLong)return animal;
        throw new RuntimeException(String.format("This not id  !",aLong));
    }

    @Override
    public List<Animal> findAll() {
        return dataBase.animals();
    }

}
