import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Zipf’s Song puzzle implementation.
 * Zipf’s Law predicts that the relative frequency of the i’th most common object (in this case, a song) should be proportional to 1/i.
 * If the song i has been played fi times but that Zipf’s Law predicts that it would have been played zi times. Then the quality of song i to be qi = fi / zi.
 * That gives qi = fi * i.
 */
public class ZipfSong implements Comparable<ZipfSong> {
    private String name;
    private float popularity;

    /**
     * Package level access, please use {@link ZipfSong#convert(int[], String[])} instead to assign correct popularity value, based on the song's position in the list
     */
    private ZipfSong(@NotNull String name, float popularity) {
        this.name = name;
        this.popularity = popularity;
    }

    /**
     * Helper method to convert the input into a list of objects. Defines the song's popularity based on the position in the list and the amount of played times.
     */
    public static List<ZipfSong> convert(@NotNull int[] frequencies, @NotNull String[] names) {
        assert(frequencies != null && names != null);
        assert(frequencies.length == names.length);

        List<ZipfSong> result = new ArrayList<ZipfSong>(frequencies.length);
        for (int i = 0; i < frequencies.length; i++) {
            result.add(new ZipfSong(names[i], (frequencies[i] * (i == 0 ? 0.5f : i))));
        }

        return result;
    }

    /**
     * Helper method to get an array of names
     */
    protected static String[] getNames(List<ZipfSong> data) {
        if (data == null) {
            return null;
        } else if (data.size() == 0) {
            return new String[]{};
        } else {
            String[] result = new String[data.size()];
            for (int i = 0; i < data.size(); i++) {
                result[i] = data.get(i).name;
            }

            return result;
        }
    }

    /**
     * Returns {@code limit} number of songs with the highest quality
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public static String[] getMostPopular(@NotNull List<ZipfSong> data, int limit) {
        if (data == null) {
            throw new IllegalArgumentException("Non null list of songs is expected!");
        } else if (data.size() == 0) {
            return new String[]{};
        }

        if (limit < 0 || limit > data.size()) {
            limit = data.size();
        }

        Collections.sort(data);

        data = data.subList(0, limit);
        return getNames(data);
    }

    public int compareTo(@NotNull ZipfSong o) {
        if (o == null) {
            return -1;
        } else {
            return popularity == o.popularity ? 0 : popularity < o.popularity ? 1 : -1;
        }
    }

    public boolean equals(@NotNull Object o) {
        if (o != null && o instanceof ZipfSong) {
            return ((ZipfSong)o).name.equals(name);
        }

        return false;
    }
}
