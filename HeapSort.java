public class HeapSort {

    public static void sort(int[] arr) {
        int n = arr.length - 1;

        // Build a heap from the first non-leaf node
        for (int i = n / 2; i >= 0; i--) {
            sink(arr, i, n);
        }

        // Heapify the array
        for (int i = n; i > 0; i--) {
            swap(arr, 0, i);
            sink(arr, 0, i - 1);
        }
    }

    private static void sink(int[] arr, int i, int n) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            int largest = i;

            if (left <= n && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right <= n && arr[right] > arr[largest]) {
                largest = right;
            }

            if (i == largest) {
                break;
            }

            swap(arr, i, largest);

            i = largest;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        sort(arr);

        System.out.println("Sorted Array:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}