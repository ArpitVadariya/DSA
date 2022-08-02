// Find target of First and Last index of Apperience

public class SearchFLIndex {
    public static int[] searchRange(int arr[], int target) {
        int[] ans = { -1, -1 };

        ans[0] = search(arr, target, true);
        if (ans[0] != -1) {
            ans[1] = search(arr, target, false);
        }
        return ans;
    }

    public static int search(int arr[], int target, boolean findStartIndex) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int arr[] = {5, 7, 7, 7, 7, 10, 7};
        int arr[] = { 5, 7, 7, 8, 8, 9, 10 };
        int target = 7;

        int ans[] = searchRange(arr, target);

        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}