public record EmployeeRecord(long id,
                             String firstName,
                             String lastName,
                             String email,
                             int age) {

  //권장되지 않음
  static boolean minor;

  //권장되지 않음
  public String fullName() {
    return firstName + " " + lastName;
  }

}
