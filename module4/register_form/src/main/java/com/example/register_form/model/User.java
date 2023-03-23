package com.example.register_form.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity(name = "user_register")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5,max = 45,message = "first name không được được ngắn quá 5 kí tự và dài quá 45 kí tự")
    private String firstName;
    @Size(min = 5,max = 45,message = "last name không được được ngắn quá 5 kí tự và dài quá 45 kí tự")
    private String lastName;
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "không đúng định dạng số điện thoại")
    private String phoneNumber;
    @Min(value = 18,message = "tuổi không được dưới 18")
    private int age;
    @Email(message = "không đúng định dạng email")
    private String email;

    public User(Long id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
