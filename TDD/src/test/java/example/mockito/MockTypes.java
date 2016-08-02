package example.mockito;


import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

public class MockTypes {
    public static void main(String[] args) {
        List listDefault = Mockito.mock(List.class);
        System.out.println(listDefault.size());
        System.out.println(listDefault.isEmpty());
        System.out.println(listDefault.iterator());

        System.out.println();

        List listDeepStub = Mockito.mock(List.class, Mockito.withSettings().defaultAnswer(RETURNS_DEEP_STUBS));
        System.out.println(listDeepStub.size());
        System.out.println(listDeepStub.isEmpty());
        System.out.println(listDeepStub.iterator());
        System.out.println(listDeepStub.iterator().hasNext());
        System.out.println(listDeepStub.iterator().next());
        System.out.println(listDeepStub.subList(0, 10).get(0).toString());
    }
}
