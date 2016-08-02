package example.mockito;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;


public class VerifyArg {
    private ArrayList<String> list = new ArrayList<>();

    @Before
    public void setUp(){
        this.list = new ArrayList<>();
    }

    @Test
    public void test_addAll() {
        // create + programming
        Collection<String> collection = mock(Collection.class);
        when(collection.toArray()).thenReturn(new String[]{"A", "B", "C"});
        when(collection.iterator()).thenReturn(Arrays.asList("A", "B", "C").iterator());

        // use
        collection.size();
        list.addAll(collection);
        list.addAll(collection);
        list.addAll(collection);

        // ask?
        Assert.assertThat(list, Matchers.equalTo(Arrays.asList("A", "B", "C", "A", "B", "C", "A", "B", "C")));
        verify(collection, times(3)).toArray();
        verify(collection, times(1)).size();
        verifyNoMoreInteractions(collection);
    }

}
