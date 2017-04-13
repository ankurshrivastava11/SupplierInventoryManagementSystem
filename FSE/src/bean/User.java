package bean;
import java.util.Date;

public class User implements java.io.Serializable
{
   private String firstName = null;
   private String lastName = null;
   private int age = 0;
   private int birthMonth = 0;
   private int birthDay = 0;
   private int birthYear = 0;
   private String password = null;
   private String passwordConfirm = null;
   private int adminKey = 0;
   private int managerKey = 0;
   private String email = null;
   private String gender = null;
   private String phone = null;


   public User() {
   }
   public String getFirstName(){
      return firstName;
   }
   public String getLastName(){
      return lastName;
   }
   public int getAge(){
      return age;
   }
   public String getPassword(){
      return password;
   }
   public String getPasswordConfirm(){
      return passwordConfirm;
   }
   public String getEmail(){
      return email;
   }
   public int getBirthMonth(){
      return birthMonth;
   }
   public int getBirthDay(){
      return birthDay;
   }
   public int getBirthYear(){
      return birthYear;
   }
   public String getGender(){
      return gender;
   }
   public String getPhone(){
      return phone;
   }
   public void setFirstName(String firstName){
      this.firstName = firstName;
   }
   public void setLastName(String lastName){
      this.lastName = lastName;
   }
   public void setAge(Integer age){
      this.age = age;
   }
   public void setPassword(String password){
      this.password = password;
   }
   public void setPasswordConfirm(String passwordConfirm){
      this.passwordConfirm = passwordConfirm;
   }
   public void setEmail(String email){
      this.email = email;
   }
   public void setBirthMonth(int birthMonth){
      this.birthMonth = birthMonth;
   }
   public void setBirthDay(int birthDay){
      this.birthDay = birthDay;
   }
   public void setBirthYear(int birthYear){
      this.birthYear = birthYear;
   }
   public void setGender(String gender){
      this.gender = gender;
   }
   public void setPhone(String phone){
      this.phone = phone;
   }
   
   
   private boolean passwordValidation(){
	   boolean valid = false;
	   
	   return valid;
   }
}