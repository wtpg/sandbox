import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;

/**
 * ZipfSong unit test for negative cases
 */
@RunWith(Parameterized.class)
public class ZipfSongNegativeTest {
    private ZipfSong[] input;
    private String[] expected;

    public ZipfSongNegativeTest(ZipfSong[] input, String[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection params()  {
        ZipfSong[] input1 = ZipfSong.convert(new long[]{30, 30, 15, 25}, new String[]{"one", "two", "three", "four"}).toArray(new ZipfSong[]{});
        String[] expected1 = new String[] {"two"};

        ZipfSong[] input2 = ZipfSong.convert(new long[]{197812, 78906, 189518, 39453, 210492, 26302, 22544, 19727, 17535, 18782, 198189, 13151, 12139, 11272, 10521}, new String[]{"re_hash", "5_4", "tomorrow_comes_today", "new_genious", "clint_eastwood", "man_research", "punk", "sound_check", "double_bass", "rock_the_house", "19_2000", "latin_simone", "starshine", "slow_country", "m1_a1"}).toArray(new ZipfSong[]{});
        String[] expected2 = new String[] {"re_hash", "clint_eastwood", "tomorrow_comes_today"};

        Object[][] params = new Object[][]  {{input1, expected1},
                {input2, expected2}};

        return Arrays.asList(params);
    }

    @Test
    public void testGetMostPopular() throws Exception {
        String[] result = ZipfSong.getMostPopular(input, expected.length);
        assertFalse(Arrays.equals(result, expected));
    }
}