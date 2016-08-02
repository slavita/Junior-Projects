package example.mockito;


import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhenAll {
    public static void main(String[] args) {
        List<String> list = mock(List.class);
        when(list.size()).thenReturn(Integer.MAX_VALUE);
        when(list.get(Mockito.anyInt())).thenReturn("A");

        List<String> list1000 = Collections.nCopies(1000, "Hello");
        System.out.println(list1000);

        System.out.println(list.size());
        for (int k = 0; k < 10; k++) {
            System.out.println("list.get(" + k + "): " + list.get(k));
        }
    }
}
