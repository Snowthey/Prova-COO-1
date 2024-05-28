public class Operacoes {

    // Bubble Sort para o melhor caso (vetor já ordenado)
    public long bubbleSortMelhorCaso(int[] arr) {
        long operations = 0;
        boolean swapped;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                operations++; // Conta a operação de comparação
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Se não houve trocas, o vetor já está ordenado
            if (!swapped) {
                break;
            }
        }
        return operations;
    }

    // Bubble Sort para o pior caso (vetor em ordem decrescente)
    public long bubbleSortPiorCaso(int[] arr) {
        long operations = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                operations++; // Conta a operação de comparação
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return operations;
    }

    public long selectionSortMelhorCaso(int[] arr) {
        long operations = 0;
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                operations++;
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return operations;
    }

    // Selection Sort para o pior caso (vetor em ordem decrescente)
    public long selectionSortPiorCaso(int[] arr) {
        long operations = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                operations++; // Conta a operação de comparação
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
        }
        return operations;
    }

    public long insertionSortMelhorCaso(int[] arr) {
        long operations = 0;
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                operations++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return operations;
    }

    public long insertionSortPiorCaso(int[] arr) {
        long operations = 0;
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                operations++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return operations;
    }

    // Quick Sort
    public long quickSortMelhorCaso(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    public long quickSortPiorCaso(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private long quickSort(int[] arr, int low, int high) {
        long operations = 0;
        if (low < high) {
            int pi = partition(arr, low, high);
            operations += pi - low + 1;
            operations += high - pi + 1;
            operations += quickSort(arr, low, pi - 1);
            operations += quickSort(arr, pi + 1, high);
        }
        return operations;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Merge Sort
    public long mergeSortMelhorCaso(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public long mergeSortPiorCaso(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private long mergeSort(int[] arr, int l, int r) {
        long operations = 0;
        if (l < r) {
            int m = (l + r) / 2;
            operations += mergeSort(arr, l, m);
            operations += mergeSort(arr, m + 1, r);
            operations += merge(arr, l, m, r);
        }
        return operations;
    }

    private long merge(int[] arr, int l, int m, int r) {
        long operations = 0;
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            operations++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return operations;
    }

    // Radix Sort
    public long radixSortMelhorCaso(int[] arr) {
        int max = getMax(arr);
        long operations = 0;
        for (int exp = 1; max / exp > 0; exp *= 10) {
            operations += countSort(arr, exp);
        }
        return operations;
    }

    public long radixSortPiorCaso(int[] arr) {
        return radixSortMelhorCaso(arr);
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private long countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        long operations = 0;

        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
            operations++;
        }

        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
        return operations;
    }

    // Heap Sort
    public long heapSortMelhorCaso(int[] arr) {
        long operations = 0;
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            operations += heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            operations += heapify(arr, i, 0);
        }
        return operations;
    }

    public long heapSortPiorCaso(int[] arr) {
        return heapSortMelhorCaso(arr);
    }

    private long heapify(int[] arr, int n, int i) {
        long operations = 0;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            operations += heapify(arr, n, largest);
        }
        return operations;
    }

    // Shell Sort
    public long shellSortMelhorCaso(int[] arr) {
        long operations = 0;
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                    operations++;
                }
                arr[j] = temp;
            }
        }
        return operations;
    }

    public long shellSortPiorCaso(int[] arr) {
        long operations = 0;
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] < temp; j -= gap) {
                    arr[j] = arr[j - gap];
                    operations++;
                }
                arr[j] = temp;
            }
        }
        return operations;
    }
}
