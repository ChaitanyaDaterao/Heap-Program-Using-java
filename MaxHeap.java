public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap() {
        heap = new int[100];
        size = 0;
    }

    public void insert(int data) {
        if (size >= heap.length) {
            throw new IllegalStateException("Heap is full.");
        }
        heap[size + 1] = data;
        int current = size + 1;

        while (current > 1 && heap[current] > heap[current / 2]) {
            int temp = heap[current];
            heap[current] = heap[current / 2];
            heap[current / 2] = temp;

            current /= 2;
        }

        size++;
    }

    public int extractMax() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty.");
        }

        int max = heap[1];

        heap[1] = heap[size];
        size--;

        int current = 1;

        while (true) {
            int leftChild = 2 * current;
            int rightChild = 2 * current + 1;

            if (leftChild > size) {
                break;
            }

            int maxChild = leftChild;

            if (rightChild <= size && heap[rightChild] > heap[leftChild]) {
                maxChild = rightChild;
            }

            if (heap[current] < heap[maxChild]) {
                int temp = heap[current];
                heap[current] = heap[maxChild];
                heap[maxChild] = temp;

                current = maxChild;
            } else {
                break;
            }
        }

        return max;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        heap.insert(10);
        heap.insert(30);
        heap.insert(20);
        heap.insert(15);
        heap.insert(25);

        heap.printHeap();

        System.out.println("Max: " + heap.extractMax());

        heap.printHeap();

        System.out.println("Is Empty: " + heap.isEmpty());
    }

}