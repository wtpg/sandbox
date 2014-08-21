import java.util.*;

/**
 * Zipf’s Song puzzle implementation.
 * Zipf’s Law predicts that the relative frequency of the i’th most common object (in this case, a song) should be proportional to 1/i.
 * If the song i has been played fi times but that Zipf’s Law predicts that it would have been played zi times. Then the quality of song i to be qi = fi / zi.
 * That gives qi = fi * i.
 */
public class ZipfSong implements Comparable<ZipfSong> {
    private String name;
    private double popularity;
    private int index;
    private static SortingStrategy sorter = new StandardSort(); // TODO: read it as a param

    /**
     * Package level access, please use {@link ZipfSong#convert(long, String, int)} instead to assign correct popularity value, based on the song's position in the list
     */
    private ZipfSong(String name, double popularity, int index) {
        this.name = name;
        this.popularity = popularity;
        this.index = index;
    }

    /**
     * Helper method to convert the input into a list of objects. Defines the song's popularity based on the position in the list and the amount of played times.
     */
    public static List<ZipfSong> convert(long[] frequencies, String[] names) {
        assert(frequencies != null && names != null);
        assert(frequencies.length == names.length);

        List<ZipfSong> result = new ArrayList<ZipfSong>(frequencies.length);
        for (int i = 0; i < frequencies.length; i++) {
            result.add(convert(frequencies[i], names[i], i));
        }

        return result;
    }

    public static ZipfSong convert(long frequency, String name, int position) {
        double popularity = frequency;
        return new ZipfSong(name, (popularity * (position + 1)), position + 1);
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

//    /**
//     * Returns {@code limit} number of songs with the highest quality
//     * @throws java.lang.IllegalArgumentException if data is null
//     */
//    public static String[] getMostPopular(List<ZipfSong> data, int limit) {
//        if (data == null) {
//            throw new IllegalArgumentException("Non null list of songs is expected!");
//        } else if (data.size() == 0) {
//            return new String[]{};
//        }
//
//        if (limit < 0 || limit > data.size()) {
//            limit = data.size();
//        }
//
//        Collections.sort(data);
//
//        data = data.subList(0, limit);
//        return getNames(data);
//    }

    public int compareTo(ZipfSong o) {
        if (o == null) {
            return -1;
        } else {
            return popularity < o.popularity ? 1 : popularity > o.popularity ? -1 :
                    index > o.index ? 1 : index > o.index ? -1 : 0;
        }
    }

    public boolean equals(Object o) {
        if (o != null && o instanceof ZipfSong) {
            return ((ZipfSong)o).name.equals(name);
        }

        return false;
    }

    public static void setSorter(SortingStrategy sorter) {
        ZipfSong.sorter = sorter;
    }

    public static void main(String...args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(); // the number of songs in the album
        int m = in.nextInt(); // the number of songs to be returned

        assert(n <= 50000 && n >= 1);
        assert(m <= n && m >= 1);

        ZipfSong[] songs = new ZipfSong[n];
        for (int i = 0; i < n; i++) {
            songs[i] = (convert(in.nextLong(), in.next(), i));
        }

        String[] result = getMostPopular(songs, m);
        StringBuilder sb = new StringBuilder();
        for (String song : result) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(song);
        }

        System.out.println(sb.toString());
    }

    public static String[] getMostPopular(ZipfSong[] songs, int limit) {
        sorter.sort(songs);
        //System.out.println(Arrays.asList(a));

        String[] result = new String[limit];
        for (int i = 0; i < limit; i++) {
            result[i] = songs[i].name;
        }
//        System.out.println(Arrays.asList(result));

        return result;
    }

    public String toString() {
        return name + ":" + popularity;
    }
}