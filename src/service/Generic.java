package service;

import java.util.List;

public interface Generic<T> {

    String add(List<T>t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(int number);
    List<T> filterByGender(Long num);
    List<T> clear();

}
