package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {

  StringBuilder name;
  String username;
  String password;
  String email;

  /**
   * Creates a new employee and sets their name, username, password, and email.
   *
   * @param name The employee name.
   * @param password The password chosen by the employee.
   */
  public Employee(String name, String password) {
    this.name = new StringBuilder(name);
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    } else {
      username = "default";
      email = "user@oracleacademy.Test";
    }

    if (isValidPassword(password) == true) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  private void setUsername(String name) {

    Pattern nameAfterSpace = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher nameAfterSpaceMatch = nameAfterSpace.matcher(name);
    nameAfterSpaceMatch.find();
    String lastName = nameAfterSpaceMatch.group(1);

    String initials = name.substring(0, 1) + lastName;

    this.username = initials.toLowerCase();
  }

  private boolean checkName(String name) {
    Pattern pattern = Pattern.compile("\\s");
    Matcher matcher = pattern.matcher(name);
    boolean found = matcher.find();
    return found;
  }

  private void setEmail(String name) {

    Pattern nameBeforeSpace = Pattern.compile("(.*)\\s", Pattern.MULTILINE);
    Matcher nameBeforeSpaceMatch = nameBeforeSpace.matcher(name);
    nameBeforeSpaceMatch.find();
    String firstName = nameBeforeSpaceMatch.group(1);

    Pattern nameAfterSpace = Pattern.compile("\\s(.*)", Pattern.MULTILINE);
    Matcher nameAfterSpaceMatch = nameAfterSpace.matcher(name);
    nameAfterSpaceMatch.find();
    String lastName = nameAfterSpaceMatch.group(1);

    this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@oracleacademy.Test";
  }

  private boolean isValidPassword(String password) {

    String regex = "^(?=.[A-Z])+^(?!.[^!a-zA-Z0-9@#$^+=])";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(password);
    boolean found = matcher.find();
    return found;
  }

  /**
   * toString() returns a string of the properties of an employee (their log-in information).
   *
   * @return String of the employee name, username, email, and password.
   */
  public String toString() {
    return "Employee Details\n"
        + "Name : "
        + name
        + "\n"
        + "Username : "
        + username
        + "\n"
        + "Email : "
        + email
        + "\n"
        + "Initial Password : "
        + password;
  }

  /**
   * The employee password which passes through the recursive method to be encrypted.
   *
   * @param id A string inputted by the user.
   * @return The reverse order of the ID.
   */
  public String reverseString(String id) {
    if (id.length() == 1) {
      return id;
    }
    return reverseString(id.substring(1)) + id.charAt(0);
  }
}
