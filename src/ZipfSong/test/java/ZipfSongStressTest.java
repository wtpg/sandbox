import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Stress test for ZipfSong
 */
@RunWith(Parameterized.class)
public class ZipfSongStressTest {
    private int N;
    private int M;

    @Parameterized.Parameters
    public static Collection params()  {
        return Arrays.asList(new Object[][]{
                {100000, 10},
                {50000000, 10}});
    }

    public ZipfSongStressTest(int N, int M) {
        this.N = N;
        this.M = M;
    }

    @Test
    public void testGetMostPopular() throws Exception {
        long start = System.nanoTime();
        ZipfSong[] input = new ZipfSong[N];
        ZipfSong.setSorter(new QuickSort());
        for (int i = 0; i < N; i++) {
            input[i] = ZipfSong.convert(((i + 7 )), "abl" + i, i);
        }
        String[] result = ZipfSong.getMostPopular(input, M);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("which is " + seconds + " seconds");
        assertTrue(result != null);
    }
    @Test
    public void testGetMostPopular1() throws Exception {
        long start = System.nanoTime();
        ZipfSong[] input = new ZipfSong[N];
        ZipfSong.setSorter(new MergeSort());
        for (int i = 0; i < N; i++) {
            input[i] = ZipfSong.convert(((i + 8 )), "bab" + i, i);
        }
        String[] result = ZipfSong.getMostPopular(input, M);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("which is " + seconds + " seconds");
        assertTrue(result != null);
    }


    @Test
    public void testGetMostPopular2() throws Exception {
        long start = System.nanoTime();
        ZipfSong[] input = new ZipfSong[N];
        ZipfSong.setSorter(new StandardSort());
        for (int i = 0; i < N; i++) {
            input[i] = ZipfSong.convert(((i + 8 )), "bab" + i, i);
        }
        String[] result = ZipfSong.getMostPopular(input, M);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("which is " + seconds + " seconds");
        assertTrue(result != null);
    }
}
