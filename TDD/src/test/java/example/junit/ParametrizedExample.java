package example.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import static java.lang.Math.*;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParametrizedExample {
    @Parameters
    public static Iterable<Object[]> data() {
        return asList(new Object[][] {{-3, 3}, {-2, 2}, {-1, 1}, {0, 0}});
    }

    @Parameter(0)
    public int input;

    @Parameter(1)
    public int expectedResult;

    @Test
    public void test() {
        assertThat(abs(input), is(expectedResult));
    }

}
