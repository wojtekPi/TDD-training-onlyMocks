import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SimpleSpyTest {

    @Test
    public void testSpys(){
        List list = new LinkedList();
        List spy = Mockito.spy(list);

        //optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

        //using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

        assertThat(spy.get(0)).isEqualTo("one");
        assertThat(spy.get(1)).isEqualTo("two");
        verify(spy).add("one");
        verify(spy).add("two");

        assertThat(spy.size()).isEqualTo(100);
    }
}
