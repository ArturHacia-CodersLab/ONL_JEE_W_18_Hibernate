package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.List;

@Controller
@RequestMapping("/book/form")
@RequiredArgsConstructor
public class BookFormController {
  private final PublisherService publisherService;
  private final BookService bookService;

  @GetMapping("/add")
  public String add(Model model) {
    model.addAttribute("book", new Book());
    return "/book/form";
  }

  @PostMapping("/add")
  public String addSave(Book book) {
    bookService.save(book);
    return "redirect:/book/all";
  }

  @ModelAttribute("publishers")
  public List<Publisher> getPublishers() {
    return publisherService.all();
  }
}
