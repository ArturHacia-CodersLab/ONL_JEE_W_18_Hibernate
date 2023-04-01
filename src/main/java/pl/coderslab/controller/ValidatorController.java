package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class ValidatorController {
  private final Validator validator;

  @RequestMapping("/validate")
  @ResponseBody
  public String validate() {
    Book book = new Book();
    Set<ConstraintViolation<Book>> violations = validator.validate(book);
    if (!violations.isEmpty()) {
      for (ConstraintViolation<Book> violation : violations) {
        System.out.println(violation.getPropertyPath() + " : " + violation.getMessage());
      }
    }
    return "walidacja";
  }
}
