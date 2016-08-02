package example.mockito;


import java.util.List;

import static org.mockito.Mockito.*;

public class WhenEq {
    public static void main(String[] args) {
        List<String> list = mock(List.class);
        when(list.get(eq(5))).thenReturn("A");

        for (int k = 0; k < 10; k++) {
            System.out.println("list.get(" + k + "): " + list.get(k));
        }
    }
}
