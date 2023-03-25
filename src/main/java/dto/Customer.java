package dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(generator = "idg")
	@SequenceGenerator(initialValue = 4512131, allocationSize = 1, name = "idg", sequenceName = "idg")
	int custid;
	String name;
	String email;
	long mobile;
	String password;
	String gender;
	Date dob;
	String address;
	int age;

}
