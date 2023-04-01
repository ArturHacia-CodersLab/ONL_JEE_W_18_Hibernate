package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
  private final BookDao bookDao;
  private final BookRepository bookRepository;

  public void save(Book book) {
    bookDao.save(book);
  }

  public Book findById(long id) {
    return bookDao.findById(id);
  }

  public Book findWithAuthorById(long id) {
    return bookDao.findWithAuthorById(id);
  }

  public void update(Book book) {
    bookDao.update(book);
  }

  public void delete(Book book) {
    bookDao.delete(book);
  }

  public List<Book> all() {
    return bookDao.all();
  }

  public List<Book> allWithAuthors() {
    return bookDao.allWithAuthors();
  }

  public List<Book> allWithRating(int rating) {
    return bookDao.allWithRating(rating);
  }

  public List<Book> getBookWithPublisher() {
    return bookDao.getBookWithPublisher();
  }

  public List<Book> getBookWithPublisher(Publisher publisher) {
    return bookDao.getBookWithPublisher(publisher);
  }

  public List<Book> getBookWithAuthor(Author author) {
    return bookDao.getBookWithAuthor(author);
  }

  @Transactional
  public List<Book> getBooksWithTitle(String title) {
    List<Book> books = bookRepository.readBooksByTitle(title);
    getAuthorsToBookList(books);
    return books;
  }

  @Transactional
  public List<Book> getBookWithCategory(Category category) {
    List<Book> books = bookRepository.readBooksByCategory(category);
    getAuthorsToBookList(books);
    return books;
  }

  @Transactional
  public List<Book> getBooksWithCategoryId(Long id) {
    List<Book> books = bookRepository.readBooksByCategoryId(id);
    getAuthorsToBookList(books);
    return books;
  }

  private void getAuthorsToBookList(List<Book> books) {
    books.stream()
        .forEach(b -> Hibernate.initialize(b.getAuthors()));
  }
}
