package Sort;

import java.time.LocalDate;
import java.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    
	public static Integer[] carregarArquivo(String nomeArquivo) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
        Integer[] numeros = new Integer[linhas.size()];
        for (int i = 0; i < linhas.size(); i++) {
            numeros[i] = Integer.parseInt(linhas.get(i).trim());
        }
        return numeros;
    }
	
    public static void main(String[] args) throws IOException {

        Integer[] vetor = carregarArquivo("numeros_aleatorios.txt");

        System.out.println("Antes de ordenar: " + Arrays.toString(vetor));

        // Bubble Sort
        Integer[] vetorBubbleSort = vetor.clone();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(vetorBubbleSort);
        System.out.println("\nBubble Sort - Comparações: " + bubbleSort.getContComparacao() + ", Trocas: " + bubbleSort.getContTroca());
        System.out.println("Fases: " + bubbleSort.getContFases());
 
        // Bubble Sort Otimizado
        Integer[] vetorBubbleSortFlag = vetor.clone();
        BubbleSortFlag bubbleSortFlag = new BubbleSortFlag();
        bubbleSortFlag.sort(vetorBubbleSortFlag);
        System.out.println("\nBubble Sort Flag - Comparações: " + bubbleSortFlag.getContComparacao() + ", Trocas: " + bubbleSortFlag.getContTroca());
        System.out.println("Fases: " + bubbleSortFlag.getContFases());
     
        // Selection Sort
        Integer[] vetorSelection = vetor.clone();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(vetorSelection);
        System.out.println("\nSelection Sort - Comparações: " + selectionSort.getContComparacao() + ", Trocas: " + selectionSort.getContTroca());
        System.out.println("Fases: " + selectionSort.getContFases()); 
    }
}