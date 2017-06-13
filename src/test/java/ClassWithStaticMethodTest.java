import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassWithStaticMethod.class)
public class ClassWithStaticMethodTest {

    @Test
    public void addTest(){
        Integer result = ClassWithStaticMethod.add(1, 2);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void mockingStaticMethod() throws Exception {
        PowerMockito.mockStatic(ClassWithStaticMethod.class);
        Mockito.when(ClassWithStaticMethod.add(1,2)).thenReturn(4);

        Integer result = ClassWithStaticMethod.add(1, 2);

        assertThat(result).isEqualTo(4);
    }

}