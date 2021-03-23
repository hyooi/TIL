package spring.dispatcherservlet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = "TBL_USERS")
public class User {

  @Id
  @GeneratedValue
  @Column(name = "USER_ID")
  private Long id;

  @Column(name = "USER_NAME")
  @Size(max = 20, min = 3, message = "{user.name.invalid}")
  @NotEmpty(message = "Please Enter your name")
  private String name;

  @Column(name = "USER_EMAIL", unique = true)
  @Email(message = "{user.email.invalid}")
  @NotEmpty(message = "Please Enter your email")
  private String email;
}
