package fr.afcepf.ad1.springpetclinic.services.map;

import fr.afcepf.ad1.springpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID> { //ID = générique pour un identifiant
 //elle ne sera pas instanciée
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values()); //prend toutes les valeurs qui sont contenues dans cette collection Map<Long,t>
    }

    T findById(ID id){
        return map.get(id);
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    T save (T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object); //insertion
        }else{
            throw new RuntimeException(("Object cannot be null"));
        }
        return object;
    }

    private Long getNextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }

        return nextId;
    }
}
