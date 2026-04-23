import java.util.Arrays;

public class AccountSearch {

    // Linear Search (first occurrence)
    static int linearSearch(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear Search Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Linear Search Comparisons: " + comparisons);
        return -1;
    }

    // Binary Search
    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Search Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary Search Comparisons: " + comparisons);
        return -1;
    }

    // Count occurrences
    static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] accounts = {"Aman", "Bob", "Charlie", "David", "Bob", "Esha"};

        String target = "Bob";

        System.out.println("Original Array: " + Arrays.toString(accounts));

        // Linear Search
        int linearResult = linearSearch(accounts, target);
        if (linearResult != -1) {
            System.out.println("Linear Search: Found at index " + linearResult);
        } else {
            System.out.println("Linear Search: Not Found");
        }

        // Count occurrences
        int occurrences = countOccurrences(accounts, target);
        System.out.println("Occurrences of " + target + ": " + occurrences);

        // Binary Search needs sorted array
        Arrays.sort(accounts);
        System.out.println("Sorted Array for Binary Search: " + Arrays.toString(accounts));

        int binaryResult = binarySearch(accounts, target);
        if (binaryResult != -1) {
            System.out.println("Binary Search: Found at index " + binaryResult);
        } else {
            System.out.println("Binary Search: Not Found");
        }
    }
}