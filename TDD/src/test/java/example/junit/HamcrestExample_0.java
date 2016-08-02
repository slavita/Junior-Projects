package example.junit;


import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class HamcrestExample_0 {
    private List<String> list;

    @Before
    public void setUp() {
        this.list = new ArrayList<>();
    }

    @Test
    public void test_core_java() {
        list.add("A");
        if (!list.get(0).equals("B")) {
            throw new AssertionError();
        }
    }

    @Test
    public void test_junit() {
        list.add("A");
        Assert.assertTrue(list.get(0).equals("B"));
    }

    @Test
    public void test_hamcrest_long() {
        list.add("A");
        Assert.assertThat(list.get(0), Matchers.is("A"));
    }

    @Test
    public void test_hamcrest_internal_dsl() {
        list.add("A");
        assertThat(list.get(0), is("A")); // internal DSL = внутренний предметно-ориентированый язык программирования
    }
}
