package chapter1_strings_number_math;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DuplicateCharactersCountingTest {

    @Test
    public void shouldCount() {
        String string = "string";
        Map<Character, Integer> map = DuplicateCharactersCounting.duplicateCharactersCounting(string);
        assertThat(map.keySet().size(), equalTo(string.length()));
    }

    @Test
    public void shouldCountDuplicates() {
        String string = "ssstriiiingg";
        Map<Character, Integer> map = DuplicateCharactersCounting.duplicateCharactersCounting(string);
        assertEquals("{" +
                "s=3, " +
                "t=1, " +
                "r=1, " +
                "i=4, " +
                "n=1, " +
                "g=2}",map.toString());
    }

    @Test
    public void shouldCountDuplicatesWithMapNewMethod() {
        String string = "ssstriiiingg";
        Map<Character, Integer> map = DuplicateCharactersCounting.duplicateCharactersCountingWithMapCompute(string);
        assertEquals("{" +
                "s=3, " +
                "t=1, " +
                "r=1, " +
                "i=4, " +
                "n=1, " +
                "g=2}",map.toString());
    }

    @Test
    public void shouldCountDuplicatesWithStreams() {
        String string = "ssstriiiingg";
        Map<Character, Long> map = DuplicateCharactersCounting.duplicateCharactersCountingByStream(string);
        assertEquals("{" +
                "r=1, " +
                "s=3, " +
                "t=1, " +
                "g=2, " +
                "i=4, " +
                "n=1}",map.toString());
    }
}