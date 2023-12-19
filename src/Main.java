import dao.AnimalDao;
import dao.PersonDao;
import db.DataBase;
import models.Animal;
import models.Gender;
import models.Person;
import service.Generic;
import service.impl.AnimalServiceImpl;
import service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        Generic personService = new PersonServiceImpl(new PersonDao(dataBase));
        Generic animalService = new AnimalServiceImpl(new AnimalDao(dataBase));

        List<Person> personList = new ArrayList<>(
                List.of(
                        new Person(1L, "Urmat", 20, Gender.MALE),
                        new Person(2L, "Zhigit", 22, Gender.MALE),
                        new Person(3L, "Aliaskar", 23, Gender.MALE),
                        new Person(4L, "Nurmuhammed", 18, Gender.MALE),
                        new Person(5L, "Mirlan", 29, Gender.MALE)
                )
        );

        List<Animal> animalList = new ArrayList<>(
                List.of(
                        new Animal(1L, "Cat", 3, Gender.MALE),
                        new Animal(2L, "Dog", 6, Gender.FEMALE),
                        new Animal(3L, "Horse", 1, Gender.MALE),
                        new Animal(4L, "Cow", 2, Gender.FEMALE),
                        new Animal(5L, "Wolf", 4, Gender.FEMALE)
                )
        );

        Person person = new Person(1L, "Urmat", 20, Gender.MALE);


        while (true) {
            System.out.print("""
                    1. add people                8. add animals               15. Clear people
                    2. get person by ID          9. get animal by ID          16. Clear animals                   
                    3. get all people            10. get all animals          14. filter FEMALE
                    4. sort - A -Z               11. sort - A -Z
                    5. sort - Z -A               12. sort - Z -A
                    6. filter FEMALE             13. filter MALE
                    7. filter MALE                                        
                  
                                        
                            
                    """);
            System.out.print("Select: ");

            switch (scanner.nextInt()) {
                case 1 -> personService.add(personList);
                case 2 -> System.out.println("personService.getById(3L) = " + personService.getById(3L));
                case 3 -> System.out.println("personService.getAll() = " + personService.getAll());
                case 4 -> System.out.println("personService.sortByName(1) = " + personService.sortByName(1));
                case 5 -> System.out.println("personService.sortByName(2) = " + personService.sortByName(2));
                case 6 -> System.out.println("personService.filterByGender(1L) = " + personService.filterByGender(1L));
                case 7 -> System.out.println("personService.filterByGender(2) = " + personService.filterByGender(2L));
                case 8 -> animalService.add(animalList);
                case 9 -> System.out.println("animalService.getById(2L) = " + animalService.getById(2L));
                case 10-> System.out.println("animalService.getAll() = " + animalService.getAll());
                case 11-> System.out.println("animalService.sortByName(1) = " + animalService.sortByName(1));
                case 12-> System.out.println("animalService.sortByName(2) = " + animalService.sortByName(2));
                case 13-> System.out.println("animalService.filterByGender(1L) = " + animalService.filterByGender(1L));
                case 14-> System.out.println("animalService.filterByGender(2L) = " + animalService.filterByGender(2L));
                case 15-> personService.clear();
                case 16-> animalService.clear();
            }
        }
    }
}