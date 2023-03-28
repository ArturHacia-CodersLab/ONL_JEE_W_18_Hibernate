package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
  @PersistenceContext EntityManager entityManager;

  public void save(Book book) {
    entityManager.persist(book);
  }

  public Book findById(long id) {
    return entityManager.find(Book.class, id);
  }

  public void update(Book book) {
    entityManager.merge(book);
  }

  public void delete(Book book) {
    entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
  }

  public List<Book> all() {
    return entityManager.createQuery("select b from Book b").getResultList();
  }

  public List<Book> allWithAuthors() {
    return entityManager.createQuery("select b from Book b join fetch b.authors").getResultList();
  }

  public List<Book> allWithRating(int rating) {
    Query query =entityManager.createQuery("select b from Book b where b.rating = :rating");
    query.setParameter("rating", rating);
    return query.getResultList();
  }
}
