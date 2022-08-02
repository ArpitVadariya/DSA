import java.util.Arrays;
import java.util.Scanner;

public class OrderAgnBS {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static int orderAgnosticBS(int arr[], int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {0, 1, 4, 5, 23, 35, 55, 67, 111};
        Arrays.sort(arr);
        printArray(arr);

        int target = sc.nextInt();

        System.out.println("Index no. of " + target + " is --> " + orderAgnosticBS(arr, target, 0, arr.length-1));

    }
}