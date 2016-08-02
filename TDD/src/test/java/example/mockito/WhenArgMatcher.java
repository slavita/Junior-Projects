package example.mockito;

import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhenArgMatcher {
    public static void main(String[] args) {
        List<String> list = mock(List.class);
        ArgumentMatcher<Integer> matcher = new ArgumentMatcher<Integer>() {
            @Override
            public boolean matches(Object arg) {
                return (arg instanceof Integer) && ((Integer) arg) % 3 == 0;
            }
        };
        when(list.get(Mockito.intThat(matcher))).thenReturn("Hello!");


        for (int k = 0; k < 10; k++) {
            System.out.println("list.get(" + k + "): " + list.get(k));
        }
    }
}
