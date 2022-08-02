// import java.util.Scanner;

public class RotatedArray {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // public static int pivot(int arr[]) {
    // int start = 0;
    // int end = arr.length - 1;

    // while (start < end) {
    // int mid = start + (end - start) / 2;
    // // 4 cases
    // if (mid < end && arr[mid] > arr[mid + 1]) {
    // return mid;
    // }
    // if (mid > start && arr[mid] < arr[mid - 1]) {
    // return mid - 1;
    // }
    // if (arr[mid] <= arr[start]) {
    // end = mid - 1;
    // } else {
    // start = mid + 1;
    // }
    // }
    // return -1;
    // }

    public static int pivotD(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            // 4 cases
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                if (arr[end] > arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
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

    public static int search(int arr[], int target) {
        int pivot = pivotD(arr);

        if (pivot == -1) {
            return orderAgnosticBS(arr, target, 0, arr.length - 1);
        }

        if (arr[pivot] == target) {
            return pivot;
        }

        if (target >= arr[0]) {
            return orderAgnosticBS(arr, target, 0, pivot - 1);
        }

        return orderAgnosticBS(arr, target, pivot + 1, arr.length - 1);
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        int arr[] = { 4, 4, 6, 7, 0, 1, 2 , 4 };
        // int arr[] = {3, 4, 5, 6, 2};
        // int arr[] = {2, 9, 2, 2, 2};
        printArray(arr);
        int target = 4;

        System.out.println(search(arr, target));
    }
}