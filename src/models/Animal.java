package models;

import java.util.Comparator;

public class Animal implements Comparator<Animal> {

    public Animal(long id, String name, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private long id;
    private String name;
    private int age;
    public Gender gender;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public static Comparator<Animal> sortByNameAsc = new Comparator<Animal>() {

        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Animal> sortByNameDesc = new Comparator<Animal>() {

        @Override
        public int compare(Animal o1, Animal o2) {
            return o2.getName().compareTo(o1.getName());
        }

    };

    @Override
    public int compare(Animal o1, Animal o2) {
        return 0;
    }
}

