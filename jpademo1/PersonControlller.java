package com.ivy.training.jpademo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController-used for making restful web services
@RestController
//@RequestMapping-maps a specific request path on to a controller
@RequestMapping("/per_api")
public class PersonControlller {

    //@autowired is used for dependency injection
@Autowired
    private PersonService personservice;
@Autowired
private PersonRepository rep;

//When u perform dependency injection write the constructor
    public PersonControlller(PersonService personservice){

        this.personservice=personservice;
    }


//@GetMapping-Get-request matched with the url
    //no values will send in url
    @GetMapping("/per_info")
    public List<Person> list(){

        return personservice.getPersonList();
    }

//@postmapping-we will sending data in body (values wat ever there in page will transfer)
//values will send with the url as name and value pair

        //@RequestBody-nothing u wat to send here u want to send from postman
      //  @PostMapping("/insert_map")
//public void insertion(@RequestBody Person entry){
  //  personservice.addPerson(entry);
//}
    @PostMapping("/per_map")
    public void insertion(@RequestBody Person entry){
        personservice.addPerson(entry);
    }
/*@GetMapping("/person/{id}/{name}")
    @ResponseBody
    public String getpersoninfo(@PathVariable int id,@PathVariable String name){
        return "id:" +id+"Name:"+name;
    }
*/
   // public String getName(@PathVariable("id") int id){
      //  return personservice.getPersonList(id);
   // }
   @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable(name="id") int id){

       return personservice.retrieveinfo(id);
    }

    @DeleteMapping("/per/{id}")
    public void delperson(@PathVariable("id")int id){
      personservice.delinfo(id);
    }

/*
    @RequestMapping(method = RequestMethod.PUT,value="/per/{id}")
    public void updatinginfo(@RequestBody Person per,@PathVariable int id){
        personservice.getPerson(per, id);
    }

*/
    /*
    @PutMapping()
    public ResponseEntity<Person> getPersonId(@PathVariable Long id,@RequestBody Person person){
        Person getper = personrepository.getById(id);
        getper.setAge(person.getAge());
        getper.setName(person.getName());

        Person updateper = personrepository.save(getper);
        return  ResponseEntity.ok().body(getper);
    }

     */
/*
    @PutMapping("/update/{id}")
    public  Person updatePerson(@RequestBody Person person){
        return null;
    }

    /*
@PutMapping("/update_person/{id}")
public void update(@PathVariable long id,@RequestBody Person entry)
{
     personservice.updateById(id,entry);
}
*/

    @PutMapping("/update/{id}")
    public Person updateperson(@PathVariable long id,
                               @RequestBody Person updatebyId){
        return personservice.updateById(id,updatebyId);
    }
/*
    @GetMapping("person/name")
    public ResponseEntity<List<Person>>getPersonById(@RequestParam String name){
        return new ResponseEntity<>(rep.findByName(name), HttpStatus.OK);
    }
*/


    @GetMapping("/persons/nameandage")
    public ResponseEntity<List<Person>> getPersonByNameandAge(@RequestParam String name,@RequestParam int age){
        return new ResponseEntity<>(rep.findByNameAndAge(name,age),HttpStatus.OK);
    }














}
