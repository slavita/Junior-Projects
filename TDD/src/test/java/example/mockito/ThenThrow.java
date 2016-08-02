package example.mockito;


import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThenThrow {
    public static void main(String[] args) {
        List<String> list = mock(List.class);
        when(list.get(eq(9))).thenThrow(new RuntimeException("Boo!"));

        for (int k = 0; k < 10; k++) {
            System.out.println("list.get(" + k + "): " + list.get(k));
        }
    }

}
