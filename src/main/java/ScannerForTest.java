public class ScannerForTest implements ConsoleReader{
    @Override
    public int readInt() {
        return 1;
    }

    @Override
    public String readLine() {
        return "test";
    }
}
