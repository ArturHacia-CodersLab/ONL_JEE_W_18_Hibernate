package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
  @ModelAttribute("countries")
  public List<String> countries() {
    return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
  }

  @ModelAttribute("programmingSkills")
  public List<String> programmingSkills() {
    return Arrays.asList("C++", "Java", "PHP", "Python", "JavaScript");
  }

  @ModelAttribute("hobbies")
  public List<String> hobbies() {
    return Arrays.asList("sport", "gry komputerowe", "muzyka", "używki", "filmy i seriale");
  }

  @GetMapping("/add")
  public String addStudent(Model model) {
    model.addAttribute("student", new Student());
    return "student/form";
  }

  @PostMapping("/add")
  @ResponseBody
  public String saveStudent(@ModelAttribute Student student) {
    return student.toString();
  }
}
