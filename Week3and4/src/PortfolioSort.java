class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double returnRate, double volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }
}

public class PortfolioSort {

    // Merge Sort (ASC, stable)
    static void mergeSort(Asset[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(Asset[] arr, int l, int m, int r) {
        Asset[] temp = new Asset[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (arr[i].returnRate <= arr[j].returnRate) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        for (i = l, k = 0; i <= r; i++, k++) {
            arr[i] = temp[k];
        }
    }

    // Quick Sort (DESC returnRate + ASC volatility)
    static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Asset[] arr, int low, int high) {
        Asset pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].returnRate > pivot.returnRate ||
                    (arr[j].returnRate == pivot.returnRate &&
                            arr[j].volatility < pivot.volatility)) {
                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void printAssets(Asset[] arr) {
        for (Asset a : arr) {
            System.out.println("Name: " + a.name +
                    ", Return Rate: " + a.returnRate +
                    ", Volatility: " + a.volatility);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Asset[] assets1 = {
                new Asset("AssetA", 8.5, 3.2),
                new Asset("AssetB", 6.2, 2.8),
                new Asset("AssetC", 10.0, 4.1),
                new Asset("AssetD", 8.5, 2.5),
                new Asset("AssetE", 7.1, 3.0)
        };

        Asset[] assets2 = {
                new Asset("AssetA", 8.5, 3.2),
                new Asset("AssetB", 6.2, 2.8),
                new Asset("AssetC", 10.0, 4.1),
                new Asset("AssetD", 8.5, 2.5),
                new Asset("AssetE", 7.1, 3.0)
        };

        System.out.println("Original Assets:");
        printAssets(assets1);

        mergeSort(assets1, 0, assets1.length - 1);
        System.out.println("After Merge Sort (Ascending):");
        printAssets(assets1);

        quickSort(assets2, 0, assets2.length - 1);
        System.out.println("After Quick Sort (Descending + tie by volatility):");
        printAssets(assets2);
    }
}