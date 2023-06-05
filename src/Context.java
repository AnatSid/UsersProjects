public class Context {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    void exucuteCommand(UsersBook usersBook){
        command.exucute(usersBook);
    }
}
