import java.util.Arrays;
import java.util.Random;

public class SortingArray {
    public static void bubble(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertion(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                // Keep swapping
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        Random rd = new Random();

        int arr[] = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(50);
        }
        System.out.println("BEFORE");
        System.out.println(Arrays.toString(arr));
        System.out.println("BUBBLE SORT");
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
}