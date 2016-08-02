package example.mockito;


import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MiddleMock {
    public static void main(String[] args) {
        List<String> list = mock(List.class);

        when(list.get(Mockito.anyInt())).thenReturn("0");
        when(list.get(eq(5))).thenReturn("A");

        ArgumentMatcher<Integer> matcher = new ArgumentMatcher<Integer>() {
            public boolean matches(Object arg) {
                return (arg instanceof Integer) && ((Integer) arg) % 3 == 0;
            }
        };
        when(list.get(Mockito.intThat(matcher))).thenReturn("every third");
        when(list.get(eq(9))).thenThrow(new RuntimeException("Boo!"));

        for (int k = 0; k < 10; k++) {
            System.out.println("list.get(" + k + "): " + list.get(k));
        }
    }
}
