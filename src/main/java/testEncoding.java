import java.nio.charset.StandardCharsets;

public class testEncoding {

    public void printText() {
        String text = "dette er norsk med";
        byte[] bytes = text.getBytes();
        String ISO8859String = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(text);
        System.out.println(bytes);
        System.out.println(ISO8859String);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
    }

    public static void main(String[] argv) {
        testEncoding obj = new testEncoding();
        obj.printText();
    }
}
