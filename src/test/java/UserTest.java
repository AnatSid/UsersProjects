import org.example.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testGetId() {
        User user1 = new User("Name","Surname",20,1);
        assertEquals(1,user1.getId());
    }
}