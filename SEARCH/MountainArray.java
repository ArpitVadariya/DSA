public class MountainArray {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int peak(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // you are in dec part
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        // int arr[] = { 1, 2, 1, 3, 5, 6, 4, 0};
        // ans --> either 2 or 6
        int arr[] = {0, 3, 4, 6, 7, 5, 4, 3, 2, 1, 0};
        // ans --> 7
        printArray(arr);
        System.out.println("Index no. :- " + peak(arr));
        System.out.println("Element :- " + arr[peak(arr)]);

    }
}