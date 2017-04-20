package pl.akademiakodu.dao;

import pl.akademiakodu.model.Person;

import java.util.List;

/**
 * Created by User on 30.03.2017.
 */
public interface PersonDao {
    void save(Person person);
    List<Person> findAll();
    List<Person> findBySurname(String surname);
    void remove (Long id);
    void remove (Person person);
}
