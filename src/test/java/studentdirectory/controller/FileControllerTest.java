package studentdirectory.controller;

import static org.junit.jupiter.api.Assertions.*;
import static studentdirectory.controller.FileController.readUserDetailsFromFile;
import static studentdirectory.controller.FileController.writeUserDetailsToFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.controller.filecontrollertestscenario.ReadWriteUserDetailsToFileTestScenario;
import studentdirectory.enums.Courses;
import studentdirectory.models.User;
import studentdirectory.models.UserCollection;

class FileControllerTest {

  private static Stream<ReadWriteUserDetailsToFileTestScenario> generateTestCaseForReadWriteUserDetailsToFile() {
    //Test Case
    ReadWriteUserDetailsToFileTestScenario testCase =
        new ReadWriteUserDetailsToFileTestScenario();
    User firstUser =
        new User("User 1", 10, "address 1", "Roll No 1",
            Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    User secondUser =
        new User("User 2", 18, "address 2", "Roll No 1",
            Arrays.asList(Courses.A, Courses.B, Courses.C, Courses.D));
    testCase.addUser(firstUser);
    testCase.addUser(secondUser);
    testCase.setTestCaseName("Adding user in file and then reading them");
    testCase.setErrMessage("");
    return Stream.of(testCase);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForReadWriteUserDetailsToFile")
  void testReadWriteUserDetailsToFile(ReadWriteUserDetailsToFileTestScenario testCase) {
    UserCollection userCollection = UserCollection.getInstance();
    for (User user : testCase.getUserList()) {
      userCollection.addUser(user);
    }
    try {
      writeUserDetailsToFile();
      List<User> oldData = new ArrayList<>(userCollection.getUserList());
      userCollection.clearUserList();
      readUserDetailsFromFile();
      List<User> newData = new ArrayList<>(userCollection.getUserList());
      assertEquals(oldData, newData, testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(testCase.getErrMessage(), e.getMessage(), testCase.getTestCaseName());
    }
  }
}