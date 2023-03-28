package pl.coderslab.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
  private String firstName;
  private String lastName;
  private String gender;
  private String country;
  private String notes;
  private boolean mailingList;
  private List<String> programmingSkills;
  private List<String> hobbies;
}
