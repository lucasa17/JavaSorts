package Sort;

import java.util.*;

public class BubbleSort<T> {
    private int contComparacao=0;
    private int contTroca=0;
    private int contFases=0;

    public int getContFases() {
        return contFases;
    }

    public int getContComparacao() {
        return contComparacao;
    }

    public int getContTroca() {
        return contTroca;
    }

    private void troca(T[] array, int i, int j){
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            contTroca++;
    }   

    public T[] sort(T[] array, Comparator<T> comparator){
        contComparacao = 0;  
        contTroca = 0;  
        contFases = 0;
        int n = array.length;
        for(int fase=1;fase<n;fase++){
            contFases++;
            for(int j=0;j<n-fase;j++){
                contComparacao++;
                if(comparator.compare(array[j],array[j+1]) >0){
                    troca(array, j, j+1);
                }
            }
        }
        return array;
    } 
    public T[] sort(T[] array, Comparator<T> comparator, boolean verbose){
        Scanner leia = new Scanner(System.in);
        if(verbose==true){
        int n = array.length;
        for(int fase=1;fase<n;fase++){
            System.out.println("Fase:"+fase); //
           System.out.println( Arrays.toString(array)); // printa vetor
            leia.nextLine(); // pause

            for(int j=0;j<n-fase;j++){
                if(comparator.compare(array[j],array[j+1]) >0){
                    troca(array, j, j+1);
                }
            }
        }
        }
        return array;
    } 
    public T[] sort(T[] array, boolean verbose){
        if(verbose==true)
            return sort(array, (a,b)->((Comparable<T>) a).compareTo(b), verbose);
         else   
            return sort(array, (a,b)->((Comparable<T>) a).compareTo(b));
    }

    public T[] sort(T[] array){
        return sort(array, (a,b)->((Comparable<T>) a).compareTo(b));
    }
}