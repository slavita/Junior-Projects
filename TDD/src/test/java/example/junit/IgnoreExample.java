package example.junit;


import org.junit.Ignore;
import org.junit.Test;

public class IgnoreExample {

    @Test
    public void testOk() {
        System.out.println("This test is Ok and done");
    }

    @Ignore
    @Test
    public void testFailButIgnored() {
        System.out.println("This test is Fail but ignored");
        throw new RuntimeException();
    }
}
