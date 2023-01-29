package studentdirectory.controller;

import static studentdirectory.validation.UserValidator.validateCourses;
import static studentdirectory.validation.UserValidator.validateUser;

import java.util.List;
import java.util.stream.Collectors;
import studentdirectory.enums.CourseType;
import studentdirectory.models.User;

public final class UserController {

  private UserController() {
    //Default constructor
  }

  public static User createUser(final String name,
                                final int age,
                                final String address,
                                final String rollNo,
                                final List<String> inputCourses) throws Exception {

    validateCourses(inputCourses);
    final List<CourseType> courseTypeList =
        inputCourses.stream().map(CourseType::valueOf).collect(Collectors.toList());

    final User user = User.builder()
        .name(name)
        .age(age).address(address)
        .rollNo(rollNo)
        .courses(courseTypeList)
        .build();
    validateUser(user);

    return user;

  }

}
