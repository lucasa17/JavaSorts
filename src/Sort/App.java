package Sort;

import java.time.LocalDate;
import java.util.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    /* public static Pessoa[] vetorDePessoas() {
        return new Pessoa[]{
            new Pessoa("João", LocalDate.of(1990, 1, 1)),
            new Pessoa("Ana", LocalDate.of(1992, 2, 2)),
            new Pessoa("Maria", LocalDate.of(1995, 5, 5)),
        };
    }*/
	public static Integer[] carregarArquivo(String nomeArquivo) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
        Integer[] numeros = new Integer[linhas.size()];
        for (int i = 0; i < linhas.size(); i++) {
            numeros[i] = Integer.parseInt(linhas.get(i).trim());
        }
        return numeros;
    }
    public static void main(String[] args) throws IOException {
        //Scanner leia = new Scanner(System.in);
/*
        Pessoa[] vetorPessoas = vetorDePessoas();
        System.out.println("Pessoas antes de Ordenar: " + Arrays.toString(vetorPessoas));

        BubbleSort<Pessoa> bSortPessoa = new BubbleSort<>();
        bSortPessoa.sort(vetorPessoas);
        System.out.println("Pessoa depois de ordenar: "+Arrays.toString(vetorPessoas));
        */
        
        /*Random rand = new Random();
        System.out.println("Tamanho do vetor:");
        int n = leia.nextInt();
        Integer[] vetor = new Integer[n];
        for (int i=0;i<n;i++)
            vetor[i] = rand.nextInt(100);
        */
        Integer[] vetor = carregarArquivo("numeros_aleatorios.txt");

        System.out.println("Antes de ordenar: " + Arrays.toString(vetor));

        BubbleSortFlag<Integer> bsort = new BubbleSortFlag<>();
        bsort.sort(vetor, true);

        System.out.println("Depois de ordenar (BubbleSortFlag): " + Arrays.toString(vetor));
    
        /*
        System.out.println("Vetor ordenado: " + Arrays.toString(vetor));
        System.out.println("Antes de ordenar:"+ Arrays.toString(vetor) );    
        BubbleSort<Integer> bsort = new BubbleSort<>();
        Comparator<Integer> comparaInt = (a,b) -> a.compareTo(b);
        bsort.sort(vetor, true);
       
        System.out.println("Depois de ordenar:"+ 
                         Arrays.toString(vetor) ); 
        */
        
    }
}