import java.util.Arrays;

/**
 * Sorts songs array with the quick sort algorithm
 */
public class QuickSort implements SortingStrategy {
    public int number;
    public ZipfSong[] a;
    public ZipfSong temp;

    @Override
    public ZipfSong[] sort(ZipfSong[] values) {
        // check for empty or null array
        if (values == null || values.length == 0){
            return null;
        }

        // init variables
        temp = null;
        a = values;
        number = values.length;
        doQuickSort(0, number - 1);

        return a;
    }

    private void doQuickSort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
//        double pivot = a[low + (high-low)/2].popularity;
        ZipfSong pivot = a[low + (high-low)/2];
//        System.out.println(pivot);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (a[i].compareTo(pivot) < 0) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (a[j].compareTo(pivot) > 0) {
                j--;
            }
//            System.out.println(pivot + ", " + i + ", " + j);

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        // Recursion
        if (low < j)
            doQuickSort(low, j);
        if (i < high)
            doQuickSort(i, high);
    }

    private void exchange(int i, int j) {
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
