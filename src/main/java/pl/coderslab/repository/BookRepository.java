package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> readBooksByTitle(String title);
  List<Book> readBooksByCategory(Category category);
  List<Book> readBooksByCategoryId(Long id);
}
