import java.util.Arrays;

/**
 * Sorts the list with Arrays.sort
 */
public class StandardSort implements SortingStrategy {
    @Override
    public ZipfSong[] sort(ZipfSong[] data) {
        Arrays.sort(data);
        return data;
    }
}
