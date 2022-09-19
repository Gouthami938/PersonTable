package com.ivy.training.jpademo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Repository
//@repository used to indicate the class provides the mechanism for storage,retrieval,search,update and delete operations on object
public interface PersonRepository extends JpaRepository<Person,Long> {

 //   List<Person> findByName(String name);

    List<Person> findByNameAndAge(String name, int age);

    //  MultiValueMap<String, String> findByAge(int age);
}
