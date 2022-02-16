package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4,10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] list, int left, int right) {
        while (left < right) {
            int val = list[left];
            while (left < right && list[left] < val) left++;
            while (left < right && list[right] > val) right--;

            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
        return left;
    }

    public static void quickSort(int[] list, int left, int right) {
        if (left < right) {
            int point = partition(list, left, right);
            quickSort(list, left, point);
            quickSort(list, point + 1, right);
        }
    }
}
