package src;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        Dico dico = new Dico("dico.txt");
        Faute fautes = new Faute("fautes.txt");
        AlgoTrigramme AlgoTrigramme = new AlgoTrigramme(dico,fautes);
        for(String mot : fautes.faute){
            System.out.println(AlgoTrigramme.calculate(mot));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + ((endTime-startTime)/1000) + "s");
    }
}

