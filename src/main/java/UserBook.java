import java.util.List;

public interface UserBook {
     void addUser(User user);
     List<User> findAll();
     User getUserById(Integer userId);
     void removeById(Integer userId);
     User getLastAddedUser();

}
