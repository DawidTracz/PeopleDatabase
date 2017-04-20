package pl.akademiakodu.dao;

import org.springframework.stereotype.Component;
import pl.akademiakodu.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by User on 30.03.2017.
 */
@Transactional
@Component
public class PersonDaoImplementation implements PersonDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Person person) {

        entityManager.persist(person);
    }

    @Override
    public List<Person> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Person p");
        return query.getResultList();
    }

    @Override
    public List<Person> findBySurname(String surname) {
        Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.surname='" + surname + "'");
        return query.getResultList();
    }


    public void remove(Person person) {
        entityManager.remove(person);
    }


    @Override
    public void remove(Long id) {
        Person person = entityManager.getReference(Person.class, id);
        entityManager.remove(person);
    }

//    @Override
//    public void remove(Long id) {
//        entityManager.remove("REMOVE p FROM Person p WHERE p.id="+id+"");
//    }


}