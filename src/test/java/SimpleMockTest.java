import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.lang.Integer.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class SimpleMockTest {

    @Mock
    private Set mockedSet;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp(){
//        MockitoAnnotations.initMocks(this);
    }



//    private Set mockedSet = mock(Set.class);

    @Test
    public void shouldCreate(){

        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.add("one");
//        mockedList.add("one");
        verify(mockedList, atLeast(2)).add(anyString());



        mockedList.size();
        verify(mockedList).size();

    }

    @Test
    public void testMockingMaps(){
        Map mockedMap = mock(Map.class);

        Object result = mockedMap.containsKey("a");
        mockedMap.get("a");
        mockedMap.containsKey("a");

        verify(mockedMap, times(2)).containsKey(anyString());
        verify(mockedMap).get(anyString());

    }

    @Test
    public void testStubbing(){
        Map mockedMap = mock(Map.class);

        when(mockedMap.get("one"))
                .thenReturn(2)
                .thenReturn(3);

        Object result1 = mockedMap.get("one");
        Object result2 = mockedMap.get("one");
        Object result3 = mockedMap.get("one");


        assertThat(result1).isEqualTo(valueOf(2));
        assertThat(result2).isEqualTo(valueOf(3));
        assertThat(result3).isEqualTo(valueOf(3));
    }

    @Test
    public void testMockedSet(){
        mockedSet.add("one");

        verify(mockedSet).add("one");
    }




}
