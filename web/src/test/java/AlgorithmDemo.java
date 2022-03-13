import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AlgorithmDemo {

    @Test
    public void demo1() {
        int[] arr = {5, 3, 2, 1, 4, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr, int left, int right) {
        while (left < right) {
            int pivotVal = arr[left];
            while (left < right && arr[left] < pivotVal) left++;
            while (left < right && arr[right] > pivotVal) right--;

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
}
