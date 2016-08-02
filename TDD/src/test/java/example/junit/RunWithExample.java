package example.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RunWithExample {

    @Test
    public void test() {
        System.out.println("Hello!");
    }
}
