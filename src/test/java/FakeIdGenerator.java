import org.example.user.UserIdGenerator;

public class FakeIdGenerator implements UserIdGenerator {

    private final int id;

    public FakeIdGenerator(int id) {
        this.id = id;
    }

    @Override
    public int getNextId() {
        return id;
    }
}
