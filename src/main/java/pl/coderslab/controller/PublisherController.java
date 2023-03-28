package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.PublisherService;

@Controller
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {
  private final PublisherService publisherService;

  @RequestMapping("/add")
  @ResponseBody
  public String addPublisher() {
    Publisher publisher = new Publisher();
    publisher.setName("Helion");
    publisherService.save(publisher);
    return "Id dodanego wydawcy to:" + publisher.getId();
  }

  @RequestMapping("/get/{id}")
  @ResponseBody
  public String getPublisher(@PathVariable long id) {
    Publisher publisher = publisherService.findById(id);
    return publisher.toString();
  }

  @RequestMapping("/all")
  @ResponseBody
  public String findAll() {
    return publisherService.all().toString();
  }

  @RequestMapping("/update/{id}/{name}")
  @ResponseBody
  public String updatePublisher(@PathVariable long id, @PathVariable String name) {
    Publisher publisher = publisherService.findById(id);
    publisher.setName(name);
    publisherService.update(publisher);
    return publisher.toString();
  }

  @RequestMapping("/delete/{id}")
  @ResponseBody
  public String deletePublisher(@PathVariable long id) {
    Publisher publisher = publisherService.findById(id);
    publisherService.delete(publisher);
    return "deleted";
  }
}
