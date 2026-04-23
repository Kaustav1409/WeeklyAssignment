public class RiskLookup {

    // Linear Search
    static int linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    // Binary Search Floor
    static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return floor;
    }

    // Binary Search Ceiling
    static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38};

        int target = 15;

        // Linear Search
        int result = linearSearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }

        // Floor & Ceiling (array must be sorted)
        int f = floor(arr, target);
        int c = ceiling(arr, target);

        System.out.println("Floor of " + target + ": " + f);
        System.out.println("Ceiling of " + target + ": " + c);
    }
}