package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Person;

@Service
@RequiredArgsConstructor
public class PersonService {
  private final PersonDao personDao;

  public void save(Person person) {
    personDao.save(person);
  }

  public Person findById(long id) {
    return personDao.findById(id);
  }

  public void update(Person person) {
    personDao.update(person);
  }

  public void delete(Person person) {
    personDao.delete(person);
  }
}
