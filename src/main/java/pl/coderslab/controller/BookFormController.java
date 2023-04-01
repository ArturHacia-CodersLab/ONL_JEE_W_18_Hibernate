package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book/form")
@RequiredArgsConstructor
public class BookFormController {
  private final PublisherService publisherService;
  private final BookService bookService;
  private final AuthorService authorService;

  @ModelAttribute("publishers")
  public List<Publisher> getPublishers() {
    return publisherService.all();
  }

  @ModelAttribute("authorsList")
  public List<Author> getAuthors() {
    return authorService.all();
  }

  @GetMapping("/add")
  public String add(Model model) {
    model.addAttribute("book", new Book());
    return "/book/form";
  }

  @PostMapping("/add")
  public String addSave(@Valid Book book, BindingResult result) {
    if (result.hasErrors()) {
      return "/book/form";
    }
    bookService.save(book);
    return "redirect:/book/all";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable long id, Model model) {
    model.addAttribute("book", bookService.findWithAuthorById(id));
    return "/book/form";
  }

  @PostMapping("/edit/{id}")
  public String update(@Valid Book book, BindingResult result) {
    if (result.hasErrors()) {
      return "/book/form";
    }
    bookService.update(book);
    return "redirect:/book/all";
  }

  @GetMapping("/confirm/{id}")
  public String confirm(@PathVariable long id, Model model) {
    model.addAttribute("id", id);
    return "/book/confirm";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable long id) {
    Book book = bookService.findById(id);
    bookService.delete(book);
    return "redirect:/book/all";
  }
}
