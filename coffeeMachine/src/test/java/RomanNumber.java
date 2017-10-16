import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumber {

    @Test
    public void should_return_I()
    {
        String result = turnNumberIntoRoman(1);
        assertEquals(result, "I");
    }

    @Test
    public void should_return_II() {
        String result = turnNumberIntoRoman(2);
        assertEquals(result, "II");
    }

    @Test
    public void should_return_III() {
        String result = turnNumberIntoRoman(3);
        assertEquals(result, "III");
    }

    private String turnNumberIntoRoman(int i)
    {
        String result = "";
        if(i<=3) {
            for(int j = 0; j<i; j++) {
                result = result.concat("I");
            }

        }
        return result;
    }
}
