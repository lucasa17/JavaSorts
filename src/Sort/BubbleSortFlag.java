package Sort;

import java.util.*;

public class BubbleSortFlag<T> {

    private void troca(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }   

    public T[] sort(T[] array, Comparator<T> comparator, boolean verbose){
        int n = array.length;
        int fases = 0;
        int comparacoes = 0;
        int trocas = 0;

        for (int fase = 1; fase < n; fase++) {
            boolean trocou = false;
            fases++;

            if (verbose) {
                System.out.println("Fase " + fase + ": " + Arrays.toString(array));
            }

            for (int j = 0; j < n - fase; j++) {
                comparacoes++;
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    troca(array, j, j + 1);
                    trocas++;
                    trocou = true;
                }
            }

            if (!trocou) {
                if (verbose) {
                    System.out.println("Nenhuma troca realizada, encerrando na fase " + fase);
                }
                break;
            }
        }

        if (verbose) {
            System.out.println("Total de fases: " + fases);
            System.out.println("Total de comparações: " + comparacoes);
            System.out.println("Total de trocas: " + trocas);
        }

        return array;
    }

    // Versão padrão (sem precisar passar comparator)
    public T[] sort(T[] array, boolean verbose){
        return sort(array, (a,b) -> ((Comparable<T>) a).compareTo(b), verbose);
    }
}
