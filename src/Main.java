import org.jfree.data.xy.XYSeries;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Operacoes objOperacoes = new Operacoes();
        Grafico objGrafico;

        XYSeries seriesMelhorCaso = new XYSeries("Bubble Sort - Melhor Caso");
        XYSeries seriesPiorCaso = new XYSeries("Bubble Sort - Pior Caso");

        XYSeries seriesSelectionMelhorCaso = new XYSeries("Selection Sort - Melhor Caso");
        XYSeries seriesSelectionPiorCaso = new XYSeries("Selection Sort - Pior Caso");

        XYSeries seriesInsertionMelhorCaso = new XYSeries("Insertion Sort - Melhor Caso");
        XYSeries seriesInsertionPiorCaso = new XYSeries("Insertion Sort - Pior Caso");

        XYSeries seriesQuickMelhorCaso = new XYSeries("Quick Sort - Melhor Caso");
        XYSeries seriesQuickPiorCaso = new XYSeries("Quick Sort - Pior Caso");

        XYSeries seriesMergeMelhorCaso = new XYSeries("Merge Sort - Melhor Caso");
        XYSeries seriesMergePiorCaso = new XYSeries("Merge Sort - Pior Caso");

        XYSeries seriesRadixMelhorCaso = new XYSeries("Radix Sort - Melhor Caso");
        XYSeries seriesRadixPiorCaso = new XYSeries("Radix Sort - Pior Caso");

        XYSeries seriesHeapMelhorCaso = new XYSeries("Heap Sort - Melhor Caso");
        XYSeries seriesHeapPiorCaso = new XYSeries("Heap Sort - Pior Caso");

        XYSeries seriesShellMelhorCaso = new XYSeries("Shell Sort - Melhor Caso");
        XYSeries seriesShellPiorCaso = new XYSeries("Shell Sort - Pior Caso");

        for (int size = 100; size <= 2000; size += 100) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = i;
            }
            long operationsCount = objOperacoes.bubbleSortMelhorCaso(arr);
            seriesMelhorCaso.add(size, operationsCount);
            long operationsCount2 = objOperacoes.selectionSortMelhorCaso(arr);
            seriesSelectionMelhorCaso.add(size, operationsCount2);
            long operationsCount3 = objOperacoes.insertionSortMelhorCaso(arr);
            seriesInsertionMelhorCaso.add(size, operationsCount3);
            long operationsCount4 = objOperacoes.quickSortMelhorCaso(arr);
            seriesQuickMelhorCaso.add(size, operationsCount4);
            long operationsCount5 = objOperacoes.mergeSortMelhorCaso(arr);
            seriesMergeMelhorCaso.add(size, operationsCount5);
            long operationsCount6 = objOperacoes.radixSortMelhorCaso(arr);
            seriesRadixMelhorCaso.add(size, operationsCount6);
            long operationsCount7 = objOperacoes.heapSortMelhorCaso(arr);
            seriesHeapMelhorCaso.add(size, operationsCount7);
            long operationsCount8 = objOperacoes.shellSortMelhorCaso(arr);
            seriesShellMelhorCaso.add(size, operationsCount8);
        }


        for (int size = 100; size < 2000; size = size + 100) {
            int[] arr = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                arr[size - 1 - i] = i;
            }
            long operationsCount = objOperacoes.bubbleSortPiorCaso(arr);
            seriesPiorCaso.add(size, operationsCount);
            long operationsCount2 = objOperacoes.selectionSortPiorCaso(arr);
            seriesSelectionPiorCaso.add(size, operationsCount2);
            long operationsCount3 = objOperacoes.insertionSortPiorCaso(arr);
            seriesInsertionPiorCaso.add(size, operationsCount3);
            long operationsCount4 = objOperacoes.quickSortPiorCaso(arr);
            seriesQuickPiorCaso.add(size, operationsCount4);
            long operationsCount5 = objOperacoes.mergeSortPiorCaso(arr);
            seriesMergePiorCaso.add(size, operationsCount5);
            long operationsCount6 = objOperacoes.radixSortPiorCaso(arr);
            seriesRadixPiorCaso.add(size, operationsCount6);
            long operationsCount7 = objOperacoes.heapSortPiorCaso(arr);
            seriesHeapPiorCaso.add(size, operationsCount7);
            long operationsCount8 = objOperacoes.shellSortPiorCaso(arr);
            seriesShellPiorCaso.add(size, operationsCount8);
        }


        objGrafico = new Grafico(seriesMelhorCaso, seriesPiorCaso, seriesSelectionMelhorCaso, seriesSelectionPiorCaso, seriesInsertionMelhorCaso,
                seriesInsertionPiorCaso, seriesQuickMelhorCaso, seriesQuickPiorCaso, seriesMergeMelhorCaso, seriesMergePiorCaso, seriesRadixMelhorCaso,
                seriesRadixPiorCaso, seriesHeapMelhorCaso, seriesHeapPiorCaso, seriesShellMelhorCaso, seriesShellPiorCaso);
        objGrafico.setVisible(true);

        System.out.println("Gráfico gerado com sucesso!");
    }
}
