package example.junit;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExceptionsExample_0 {
    private List<String> list;

    @Before
    public  void setUp() {
        this.list = new ArrayList<>();
    }

    @Test
    public void test_old_style(){
        try {
            list.get(0);
            // FAIL
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            // OK
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_new_style() {
        list.get(0);
    }

}
