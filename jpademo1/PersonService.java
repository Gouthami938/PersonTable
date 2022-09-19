package com.ivy.training.jpademo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

//@service - allows developers to add business functionalities
@Service
public class PersonService {
    //@autowired is used for dependency injection
    @Autowired
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }


    public void addPerson(Person entry) {
        repository.save(entry);
        System.out.println("entry added");
    }
    public List <Person> getPersonList(){
        return repository.findAll();
    }

    public  Person retrieveinfo(int id) {
        return repository.findById((long) id).get();
    }

  //  public Person delinfo(int id) {
   //     return repository
    //     .deleteAllById((long) id).get();

    // }
    //public List<Person> findAllById(Iterable<id> ids);

    public void delinfo(int id){
         repository.deleteById((long) id);




    }

    public Person updateById(long id, Person updatebyId) {

        return repository.save(updatebyId);
    }

    public List<Person> findById(int id) {
        return repository.findAll();
    }




/*
    public Person getPerson(Person per,int id) {
        for(int i=0;i<repository.size();i++){
            Person p = per.get(i);
            if(p.getId().equals(id)){
                per.set(i,per);
                return;
            }
        }
    }
    */

/*
    public Person updatePerson(Person person){
        int age=person.getAge();
        Person per = repository.findById((long) age).get();
        per.setName(per.getName());
        per.setAge(per.getAge());
       return repository.save(per);

    }

    /*
public void updateById(Long id,Person entry) {
    Person personData=repository.findById(id).get();
    if(personData!=null)
    {
        Person _person=personData;
        _person.setAge(entry.getAge());
        _person.setName(entry.getName());
        repository.save(_person);
    }
    else {
        System.out.println("Update failed");
    }
}

     */


}
