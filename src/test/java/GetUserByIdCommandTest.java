import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetUserByIdCommandTest {
    UsersBook usersBook = new UsersBook();
    GetUserByIdCommand getUserByIdCommand = new GetUserByIdCommand(usersBook);
    InterfaceForGetUserByIdCommand interFaceForGetUserByIdCommand;

    @Test
    void execute() {
        usersBook.addUser(new User("name1", "surname1", 20));
        usersBook.addUser(new User("name2", "surname2", 20));
        int id = 2;

        interFaceForGetUserByIdCommand = new GetUserByIdForTest(usersBook, id);
        getUserByIdCommand.setInterfaceForGetUserByIdCommand(interFaceForGetUserByIdCommand);

//      assertEquals(usersBook.getUserById(id), getUserByIdCommand.execute());
        assertEquals(usersBook.getUserById(id), interFaceForGetUserByIdCommand.assignAndExecute());

    }
}