import java.util.Arrays;

/**
 * Created by lena on 8/20/14.
 */
public class MergeSort implements SortingStrategy {
    private ZipfSong[] array;
    private ZipfSong[] tempMergArr;
    private int length;

    @Override
    public ZipfSong[] sort(ZipfSong[] data) {
        this.array = data;
        this.length = data.length;
        this.tempMergArr = new ZipfSong[length];
        doMergeSort(0, length - 1);
        return array;
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);

            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);

            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        System.arraycopy(array, lowerIndex, tempMergArr, lowerIndex, higherIndex - lowerIndex + 1);

        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i].compareTo(tempMergArr[j]) < 0) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
