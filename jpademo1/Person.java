package com.ivy.training.jpademo1;

import javax.persistence.*;


@Entity
//@Entity specifies class is an entity and is mapped to a database table
@Table
//@Table allows you to specify the details of the table that will be used to persist the entity in the db
public class Person {
    private int age;
    private String name;
    @Id
    //@Id indicates the member field below is the primary key of the current entity
    @SequenceGenerator(name="person_seq",sequenceName = "person_seq",allocationSize =1)
    //@SequenceGenerator defines the primary key generator that may be referenced by name when generated element is specified for the generated value annotation
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "person_seq")
    private long id;
    public Person() {

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
