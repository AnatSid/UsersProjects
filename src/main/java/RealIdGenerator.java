public class RealIdGenerator implements UserIdGenerator{

    private static int id = 0;
    @Override
    public int getNextId() {
        id++;
        return id;
    }
}
