package service.impl;

import dao.AnimalDao;
import models.Animal;
import models.Gender;
import service.Generic;

import javax.print.attribute.standard.PrinterMoreInfoManufacturer;
import java.util.ArrayList;
import java.util.List;

public class AnimalServiceImpl implements Generic<Animal> {

    private final AnimalDao animalDao;

    public AnimalServiceImpl(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public String add(List<Animal> t) {
        for (Animal animal : t) {
            animalDao.add(animal);
        }
        return "Successful add !" ;
    }
    @Override
    public Animal getById(Long id) {
        return animalDao.findById(id);
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.findAll();
    }

    @Override
    public List<Animal> sortByName(int number) {
        List<Animal> animals = new ArrayList<>(animalDao.findAll());
        if (number == 1){
            animals.sort(Animal.sortByNameAsc);
        }else if (number == 2){
            animals.sort(Animal.sortByNameDesc);
        }

        return animals;
    }

    @Override
    public List<Animal> filterByGender(Long num) {
        List<Animal> animals = new ArrayList<>(animalDao.findAll());
        List<Animal> animals1 = new ArrayList<>();
        if (num == 1){
            for (Animal animal : animals) {
                if (animal.getGender().equals(Gender.MALE)){
                    animals1.add(animal);
                }
            }
        } else if (num == 2) {
            for (Animal animal : animals) {
                if (animal.getGender().equals(Gender.FEMALE)){
                    animals1.add(animal);
                }
            }
        }
        return animals1;
    }

    @Override
    public List<Animal> clear() {
        animalDao.findAll().clear();
        return animalDao.findAll();
    }
}
