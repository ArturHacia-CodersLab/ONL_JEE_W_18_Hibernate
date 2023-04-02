package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> readBooksByTitle(String title);
  List<Book> readBooksByCategory(Category category);
  List<Book> readBooksByCategoryId(Long id);

  @Query("select b from Book b where b.title = :title")
  List<Book> findBooksByTitle(@Param("title") String title);

  @Query("select b from Book b where b.category = :category")
  List<Book> findBooksByCategory(@Param("category") Category category);

  @Query(nativeQuery = true, value = "select * from books where category_id = :id")
  List<Book> finddBooksByCategoryId(@Param("id") Long id);
}
