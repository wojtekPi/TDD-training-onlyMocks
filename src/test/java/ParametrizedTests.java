import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ParametrizedTests {

    @Test
    @Parameters({"17, 3, 20",
            "22, -22, 0",
            "1, 1, 2"})
    public void ourFirstParametrizedTest(int firstNumber,
                             int secondNumber, int expectedResult){

        Calculator testedObject = new Calculator();

        int result = testedObject.add(firstNumber,secondNumber);

        assertThat(result).isEqualTo(expectedResult);
    }

    private Object[][] dataForTestingNullsAndNumbers(){
        return new Object[][]{
                {17, 3, 20},
                {22, -22, 0},
                {1, 1, 2},
                {null, 8, null}
        };
    }

    @Test
    @Parameters(method = "dataForTestingNullsAndNumbers")
    public void parametrizedTestWhichUseMethodToProvideArguments(Integer firstNumber,
                                  Integer secondNumber, Integer expectedResult){
        Calculator testedObject = new Calculator();

        Integer result = testedObject.add(firstNumber,secondNumber);

        assertThat(result).isEqualTo(expectedResult);
    }

}
