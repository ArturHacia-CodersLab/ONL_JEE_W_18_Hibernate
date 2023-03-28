package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
  private final AuthorDao authorDao;

  public void save(Author author) {
    authorDao.save(author);
  }

  public Author findById(long id) {
    return authorDao.findById(id);
  }

  public List<Author> all() {
    return authorDao.all();
  }

  public void update(Author author) {
    authorDao.update(author);
  }

  public void delete(Author author) {
    authorDao.delete(author);
  }
}
