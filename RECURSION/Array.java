import java.util.ArrayList;

public class Array {

    // check array is sorted or not using recursion
    public static boolean sorted(int arr[], int index) {
        if (index == arr.length - 1) {
            return true;
        }

        return arr[index] <= arr[index + 1] && sorted(arr, index + 1);
    }

    // check element in array or not
    public static boolean find(int arr[], int target, int index) {
        if (index == arr.length) {
            return false;
        }

        return arr[index] == target || find(arr, target, index + 1);
    }

    // find forward in array (savru gotvaanu)
    public static int findIndex(int arr[], int target, int index) {
        if (index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        } else {
            return findIndex(arr, target, index + 1);
        }
    }

    // find backward in array (undhu gotvaanu)
    public static int findIndexLast(int arr[], int target, int index) {
        if (index == -1) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        } else {
            return findIndexLast(arr, target, index - 1);
        }
    }

    // where element is find all index in array
    public static ArrayList<Integer> findAllIndex(int arr[], int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndex(arr, target, index + 1, list);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 4, 5, 6 };

        // System.out.println(sorted(arr, 0));

        // System.out.println(findIndex(arr, 6, 0));
        // System.out.println();
        // System.out.println(findIndexLast(arr, 6, arr.length - 1));

        System.out.println(findAllIndex(arr, 3, 0, new ArrayList<>()));

        System.out.println();
        System.out.println("EOC");

    }
}