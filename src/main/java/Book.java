import java.util.List;

public interface Book {
     void addUser(User user);
     List<User> findAll();
     User getUserById(Integer userId);
     void removeById(Integer userId);
     User getLastAddedUser();

}
