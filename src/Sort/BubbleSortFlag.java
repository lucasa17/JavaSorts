package Sort;

import java.util.*;

public class BubbleSortFlag<T> {
    private int contComparacao = 0;
    private int contTroca = 0;
    private int contFases = 0;

    public int getContComparacao() {
        return contComparacao;
    }

    public int getContTroca() {
        return contTroca;
    }

    public int getContFases() {
        return contFases;
    }

    private void troca(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        contTroca++;
    }   

    public T[] sort(T[] array, Comparator<T> comparator, boolean verbose){
        contComparacao = 0;
        contTroca = 0;
        contFases = 0;

        int n = array.length;
        Scanner leia = new Scanner(System.in);

        for (int fase = 1; fase < n; fase++) {
            boolean trocou = false;
            contFases++;

            if (verbose) {
                System.out.println("Fase:" + fase);
                System.out.println(Arrays.toString(array));
                leia.nextLine(); // pausa
            }

            for (int j = 0; j < n - fase; j++) {
                contComparacao++;
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    troca(array, j, j + 1);
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
            System.out.println("Total de fases: " + contFases);
            System.out.println("Total de comparações: " + contComparacao);
            System.out.println("Total de trocas: " + contTroca);
        }

        return array;
    }

    public T[] sort(T[] array, boolean verbose){
        return sort(array, (a,b) -> ((Comparable<T>) a).compareTo(b), verbose);
    }

    public T[] sort(T[] array){
        return sort(array, false);
    }
}
