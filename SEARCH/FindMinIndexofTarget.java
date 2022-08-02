public class FindMinIndexofTarget {
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
    public static int searchMinI(int arr[], int target){
        int peak = peak(arr);
        int first = orderAgnosticBS(arr, target, 0, peak);
        if(first != -1){
            return first;
        }

        return orderAgnosticBS(arr, target, peak+1, arr.length-1);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 3, 2, 1};
        int target = 3;

        System.out.println(searchMinI(arr, target));
    }
}