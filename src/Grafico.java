import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.*;

public class Grafico extends JFrame {
    public Grafico(XYSeries seriesMelhorCaso, XYSeries seriesPiorCaso, XYSeries seriesSelectionMelhorCaso, XYSeries seriesSelectionPiorCaso, XYSeries seriesInsertionMelhorCaso, XYSeries seriesInsertionPiorCaso, XYSeries seriesQuickMelhorCaso, XYSeries seriesQuickPiorCaso, XYSeries seriesMergeMelhorCaso, XYSeries seriesMergePiorCaso, XYSeries seriesRadixMelhorCaso, XYSeries seriesRadixPiorCaso, XYSeries seriesHeapMelhorCaso, XYSeries seriesHeapPiorCaso, XYSeries seriesShellMelhorCaso, XYSeries seriesShellPiorCaso) {
        super("Complexidade do Algoritmo");

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesMelhorCaso);
        dataset.addSeries(seriesPiorCaso);
        dataset.addSeries(seriesSelectionMelhorCaso); // Adiciona as séries do Selection Sort
        dataset.addSeries(seriesSelectionPiorCaso);   // Adiciona as séries do Selection Sort
        dataset.addSeries(seriesInsertionMelhorCaso);
        dataset.addSeries(seriesInsertionPiorCaso);
        dataset.addSeries(seriesQuickMelhorCaso);
        dataset.addSeries(seriesQuickPiorCaso);
        dataset.addSeries(seriesMergeMelhorCaso);
        dataset.addSeries(seriesMergePiorCaso);
        dataset.addSeries(seriesRadixMelhorCaso);
        dataset.addSeries(seriesRadixPiorCaso);
        dataset.addSeries(seriesHeapMelhorCaso);
        dataset.addSeries(seriesHeapPiorCaso);
        dataset.addSeries(seriesShellMelhorCaso);
        dataset.addSeries(seriesShellPiorCaso);

        JFreeChart chart = ChartFactory.createXYLineChart("Gráfico de Complexidade", "Tamanho do Vetor", "Quantidade de Operações", dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
