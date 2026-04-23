class Trade {
    String name;
    int volume;

    Trade(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }
}

public class TradeAnalysis {

    // -------- MERGE SORT (ASC - STABLE) --------
    static void mergeSort(Trade[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(Trade[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Trade[] L = new Trade[n1];
        Trade[] R = new Trade[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].volume <= R[j].volume) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // -------- QUICK SORT (DESC) --------
    static void quickSort(Trade[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Trade[] arr, int low, int high) {
        int pivot = arr[high].volume;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].volume > pivot) {
                i++;
                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // -------- MERGE TWO SORTED LISTS --------
    static Trade[] mergeLists(Trade[] a, Trade[] b) {
        int i = 0, j = 0, k = 0;
        Trade[] result = new Trade[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i].volume <= b[j].volume) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        return result;
    }

    // -------- TOTAL VOLUME --------
    static int totalVolume(Trade[] arr) {
        int sum = 0;
        for (Trade t : arr) sum += t.volume;
        return sum;
    }

    // -------- PRINT --------
    static void printTrades(Trade[] arr) {
        for (Trade t : arr) {
            System.out.println(t.name + " : " + t.volume);
        }
        System.out.println();
    }

    // -------- MAIN --------
    public static void main(String[] args) {

        Trade[] trades1 = {
                new Trade("T1", 100),
                new Trade("T2", 50),
                new Trade("T3", 200)
        };

        Trade[] trades2 = {
                new Trade("T4", 75),
                new Trade("T5", 150)
        };

        // Merge Sort ASC
        mergeSort(trades1, 0, trades1.length - 1);
        System.out.println("Merge Sort (ASC):");
        printTrades(trades1);

        // Quick Sort DESC
        quickSort(trades1, 0, trades1.length - 1);
        System.out.println("Quick Sort (DESC):");
        printTrades(trades1);

        // Merge two sorted lists (ASC)
        mergeSort(trades2, 0, trades2.length - 1);
        Trade[] merged = mergeLists(trades1, trades2);

        System.out.println("Merged Trades:");
        printTrades(merged);

        // Total volume
        System.out.println("Total Volume: " + totalVolume(merged));
    }
}