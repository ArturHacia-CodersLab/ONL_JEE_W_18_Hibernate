package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Book;

import javax.management.Query;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
  private final BookDao bookDao;

  public void save(Book book) {
    bookDao.save(book);
  }

  public Book findById(long id) {
    return bookDao.findById(id);
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
}
