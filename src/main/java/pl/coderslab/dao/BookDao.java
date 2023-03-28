package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

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

  public Book findWithAuthorById(long id) {
    Query query = entityManager.createQuery("select b from Book b join fetch b.authors where b.id = :id");
    query.setParameter("id", id);
    return (Book) query.getSingleResult();
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
    return entityManager.createQuery("select distinct  b from Book b join fetch b.authors order by b.id").getResultList();
  }

  public List<Book> allWithRating(int rating) {
    Query query =entityManager.createQuery("select b from Book b where b.rating = :rating");
    query.setParameter("rating", rating);
    return query.getResultList();
  }

  public List<Book> getBookWithPublisher() {
    Query query = entityManager.createQuery("select distinct b from Book b join b.publisher");
    return query.getResultList();
  }

  public List<Book> getBookWithPublisher(Publisher publisher) {
    Query query = entityManager.createQuery("select distinct b from Book b where b.publisher = :publisher");
    query.setParameter("publisher", publisher);
    return query.getResultList();
  }

  public List<Book> getBookWithAuthor(Author author) {
    Query query = entityManager.createQuery("select distinct b from Book b WHERE :author member of b.authors");
    query.setParameter("author", author);
    return query.getResultList();
  }
}
