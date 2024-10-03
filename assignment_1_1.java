import java.util.Scanner;
import java.util.Arrays;

public class assignment_1_1 {

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Efficient Bubble Sort
    public static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // If no swaps, the array is already sorted.
        }
    }

    // Merge two sorted arrays without duplicates
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                if (k == 0 || merged[k - 1] != arr1[i]) merged[k++] = arr1[i];
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (k == 0 || merged[k - 1] != arr2[j]) merged[k++] = arr2[j];
                j++;
            } else {
                if (k == 0 || merged[k - 1] != arr1[i]) merged[k++] = arr1[i];
                i++; j++;
            }
        }
        while (i < arr1.length) {
            if (k == 0 || merged[k - 1] != arr1[i]) merged[k++] = arr1[i];
            i++;
        }
        while (j < arr2.length) {
            if (k == 0 || merged[k - 1] != arr2[j]) merged[k++] = arr2[j];
            j++;
        }
        return Arrays.copyOf(merged, k); // Resize array to remove unused space
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for first array
        System.out.print("Enter size of first array (max 30): ");
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        System.out.println("Enter elements of the first array:");
        for (int i = 0; i < size1; i++) arr1[i] = scanner.nextInt();

        // Input for second array
        System.out.print("Enter size of second array (max 30): ");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        System.out.println("Enter elements of the second array:");
        for (int i = 0; i < size2; i++) arr2[i] = scanner.nextInt();

        // Sort the first array using Insertion Sort
        insertionSort(arr1);
        System.out.println("Sorted first array: " + Arrays.toString(arr1));

        // Sort the second array using Bubble Sort
        bubbleSort(arr2);
        System.out.println("Sorted second array: " + Arrays.toString(arr2));

        // Merge two sorted arrays without duplicates
        int[] mergedArray = mergeArrays(arr1, arr2);
        System.out.println("Merged array: " + Arrays.toString(mergedArray));

        // Binary Search
        System.out.print("Enter target value to search in merged array: ");
        int target = scanner.nextInt();
        int index = binarySearch(mergedArray, target);
        if (index != -1)
            System.out.println("Target found at index " + index);
        else
            System.out.println("Target not found in the array.");
    }
}
