package lab8;
public class GenericSortDemo {

    // EXPLAIN: <T extends Comparable<T>> is a bounded type parameter.
    // It guarantees that whatever type T is, it has a compareTo() method.
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // EXPLAIN: compareTo returns > 0 if arr[j] is greater than arr[j+1]
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap elements
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Helper method to print arrays
    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test with Integer array
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Original Integer array: ");
        printArray(intArray);

        bubbleSort(intArray);
        System.out.print("Sorted Integer array: ");
        printArray(intArray);

        // Test with String array
        String[] strArray = {"banana", "apple", "cherry", "date", "elderberry"};
        System.out.print("\nOriginal String array: ");
        printArray(strArray);

        bubbleSort(strArray);
        System.out.print("Sorted String array: ");
        printArray(strArray);
    }
}