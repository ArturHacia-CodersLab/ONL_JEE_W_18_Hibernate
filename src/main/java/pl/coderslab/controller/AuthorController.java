package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.service.AuthorService;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
  private final AuthorService authorService;

  @RequestMapping("/add")
  @ResponseBody
  public String create() {
    Author author = new Author();
    author.setFirstName("Henryk");
    author.setLastName("Sienkiewicz");
    authorService.save(author);
    return "Id dodanego autora to:" + author.getId();
  }

  @RequestMapping("/get/{id}")
  @ResponseBody
  public String get(@PathVariable long id) {
    Author author = authorService.findById(id);
    return author.toString();
  }

  @RequestMapping("/update/{id}/{lastName}")
  @ResponseBody
  public String update(@PathVariable long id, @PathVariable String lastName ) {
    Author author = authorService.findById(id);
    author.setLastName(lastName);
    authorService.update(author);
    return author.toString();
  }

  @RequestMapping("/delete/{id}")
  @ResponseBody
  public String delete(@PathVariable long id) {
    Author author = authorService.findById(id);
    authorService.delete(author);
    return "deleted";
  }

  @RequestMapping("/all")
  @ResponseBody
  public String all() {
    return authorService.all().toString();
  }
}
