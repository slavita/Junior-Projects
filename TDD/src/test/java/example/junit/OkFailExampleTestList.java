package example.junit;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OkFailExampleTestList {

    @Test
    public void test_size_add_one() {
        List<String> list = new ArrayList<>();
        list.add("A");
        if (list.size() != 1) {
            throw new AssertionError();
        }
    }

    @Test
    public void test_size_add_two() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("A");
        if (list.size() != 2) {
            throw new AssertionError();
        }
    }

    @Test
    public void test_convert_A_to_B() {
        List<String> list = new ArrayList<>();
        list.add("A");
        if (!list.get(0).equals("A")) {
            throw new AssertionError();
        }
    }
}
