import org.assertj.core.api.Assertions;
import org.junit.Test;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final String FIZZBUZZ = "FizzBuzz";

    @Test
    public void should_return_one() {
        String result = transformIntIntoAString(1);
        Assertions.assertThat(result).isEqualTo("1");
    }

    @Test
    public void should_return_two() {
        String result = transformIntIntoAString(2);
        Assertions.assertThat(result).isEqualTo("2");
    }

    @Test
    public void should_return_fizz() {
        String result = transformIntIntoAString(3);
        Assertions.assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void should_return_four() {
        String result = transformIntIntoAString(4);
        Assertions.assertThat(result).isEqualTo("4");
    }

    @Test
    public void should_return_buzz() {
        String result = transformIntIntoAString(5);
        Assertions.assertThat(result).isEqualTo(BUZZ);
    }

    @Test
    public void should_return_fizz_when_multiple_of_three() {
            String result = transformIntIntoAString(9);
            Assertions.assertThat(result).isEqualTo(FIZZ);
    }

    @Test
    public void should_return_fizz_when_multiple_of_five() {
        String result = transformIntIntoAString(10);
        Assertions.assertThat(result).isEqualTo(BUZZ);
    }

    @Test
    public void should_return_fizz_when_multiple_of_three_and_five() {
        String result = transformIntIntoAString(15);
        Assertions.assertThat(result).isEqualTo(FIZZBUZZ);
    }

    private String transformIntIntoAString(int i) {
        String result = "";
        if(i%3==0)
        {
            result = result.concat(FIZZ);
        }
        if(i%5==0)
        {
            result = result.concat(BUZZ);
        }
        if(!(result.length() > 0)) {
            result = String.valueOf(i);
        }
        return result;
    }
}
