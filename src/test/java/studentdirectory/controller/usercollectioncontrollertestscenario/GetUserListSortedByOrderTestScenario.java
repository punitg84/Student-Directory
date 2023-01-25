package studentdirectory.controller.usercollectioncontrollertestscenario;

import java.util.ArrayList;
import java.util.List;
import studentdirectory.enums.SortOrder;
import studentdirectory.models.User;
import studentdirectory.testscenario.GenericTestScenario;

public class GetUserListSortedByOrderTestScenario extends GenericTestScenario {
  List<User> randomUserList = new ArrayList<>();
  List<User> sortedUserList = new ArrayList<>();
  SortOrder order;

  public List<User> getRandomUserList() {
    return randomUserList;
  }

  public void addUserInRandomUserList(User user) {
    randomUserList.add(user);
  }

  public List<User> getSortedUserList() {
    return sortedUserList;
  }

  public void addUserInSortedUserList(User user) {
    sortedUserList.add(user);
  }

  public SortOrder getOrder() {
    return order;
  }

  public void setOrder(SortOrder order) {
    this.order = order;
  }

}