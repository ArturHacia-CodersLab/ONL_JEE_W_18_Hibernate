package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {
  @PersistenceContext
  EntityManager entityManager;

  public void save(Author author) {
    entityManager.persist(author);
  }

  public Author findById(long id) {
    return entityManager.find(Author.class, id);
  }

  public List<Author> all() {
    return entityManager.createQuery("select a from Author a").getResultList();
  }

  public void update(Author author) {
    entityManager.merge(author);
  }

  public void delete(Author author) {
    entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
  }
}
