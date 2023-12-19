package dao;

import java.util.List;

public interface DaoCrud <T,ID> {

    boolean add (T type);
    boolean delete (T type);
    T findById(ID id);
    List<T> findAll();




}
