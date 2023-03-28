package pl.coderslab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = PersonDetails.TABLE_NAME)
@NoArgsConstructor
@Data
public class PersonDetails {
  public static final String TABLE_NAME = "person_details";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String firstName;
  private String lastName;
  private String streetNumber;
  private String street;
  private String city;
}
