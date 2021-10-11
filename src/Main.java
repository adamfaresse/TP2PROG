package src;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Dico dico = new Dico("/amuhome/f18010428/Bureau/S4/Algo2/TP/TPAlgo2/minidico.txt");

        System.out.println(dico.dico.iterator());
        Algo algo = new Algo("logarytmique","algorithmique");
        System.out.println(algo.calculate());


    }
}

