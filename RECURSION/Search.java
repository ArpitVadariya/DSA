import java.util.ArrayList;

public class Search {

    public static void main(String[] args) {

        // int arr[] = { 5, 6, 7, 0, 1, 2, 3 };

        // System.out.println(BS(arr, 6, 0, arr.length - 1));

        // System.out.println(BS1(arr, 1, 0, arr.length - 1));

        // System.out.println(LS1(arr, 6, 0));

        // System.out.println(LS2(arr, 6, arr.length - 1));

        // System.out.println(findAllIndex(arr, 3, 0, new ArrayList<>()));

        System.out.println();
        System.out.println("EOC");
    }

    // Binary Search
    public static int BS(int arr[], int target, int start, int end) {

        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return BS(arr, target, start, mid - 1);
        } else {
            return BS(arr, target, mid + 1, end);
        }
    }

    // this technique help in this type of array --> [5, 6, 7, 0, 1, 2, 3]
    public static int BS1(int arr[], int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target <= arr[mid]) {
                return BS1(arr, target, start, mid - 1);
            } else {
                return BS1(arr, target, mid + 1, end);
            }
        }

        if (target >= arr[mid] && target <= arr[end]) {
            return BS1(arr, target, mid + 1, end);
        }

        return BS1(arr, target, start, mid - 1);

    }

    // Linear Search Forward (seedhu gotvaanu)
    public static int LS1(int arr[], int target, int index) {
        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        } else {
            return LS1(arr, target, index + 1);
        }
    }

    // Linear Search Forward (undhu gotvaanu)
    public static int LS2(int arr[], int target, int index) {
        if (index == -1) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        } else {
            return LS2(arr, target, index - 1);
        }
    }

    // here we return ArrayList
    public static ArrayList<Integer> findAllIndex(int arr[], int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndex(arr, target, index + 1, list);
    }
}