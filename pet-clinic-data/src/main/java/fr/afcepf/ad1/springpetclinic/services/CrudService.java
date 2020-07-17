package fr.afcepf.ad1.springpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();
    T findById(ID id);
    T save (Object T);
    void delete(T object);
    void deleteById(ID id);
}
