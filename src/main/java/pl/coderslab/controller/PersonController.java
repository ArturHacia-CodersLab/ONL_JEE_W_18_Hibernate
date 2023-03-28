package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Person;
import pl.coderslab.model.PersonDetails;
import pl.coderslab.service.PersonService;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
  private final PersonService personService;

  @RequestMapping("/add")
  @ResponseBody
  public String create() {
    Person person = new Person();
    person.setLogin("login");
    person.setPassword("1234567890");
    person.setEmail("mail@example.com");

    PersonDetails personDetails = new PersonDetails();
    personDetails.setFirstName("Artur");
    personDetails.setLastName("Hacia");
    personDetails.setStreet("Uliczna");
    personDetails.setStreetNumber("23");
    personDetails.setCity("Warszawa");
    person.setPersonDetails(personDetails);

    personService.save(person);
    return "Id dodanej osoby to:" + person.getId();
  }

  @RequestMapping("/get/{id}")
  @ResponseBody
  public String getPerson(@PathVariable long id) {
    Person person = personService.findById(id);
    return person.toString();
  }

  @RequestMapping("/update/{id}/{login}")
  @ResponseBody
  public String updatePerson(@PathVariable long id, @PathVariable String login ) {
    Person person = personService.findById(id);
    person.setLogin(login);
    personService.update(person);
    return person.toString();
  }

  @RequestMapping("/delete/{id}")
  @ResponseBody
  public String deletePerson(@PathVariable long id) {
    Person person = personService.findById(id);
    personService.delete(person);
    return "deleted";
  }

//  @GetMapping("/form")
//  public String form() {
//    return "/person/form";
//  }
//
//  @PostMapping("/form")
//  @ResponseBody
//  public String add(
//      @RequestParam String login, @RequestParam String password, @RequestParam String email) {
//    Person person = new Person();
//    person.setLogin(login);
//    person.setPassword(password);
//    person.setEmail(email);
//    personService.save(person);
//    return "Dodano osobę o id " + person.getId();
//  }

  @GetMapping("/form")
  public String form(Model model) {
    model.addAttribute("person", new Person());
    return "/person/form";
  }

  @PostMapping("/form")
  @ResponseBody
  public String form(Person person) {
    personService.save(person);
    return "Dodano nową osobę o id " + person.getId();
  }
}
