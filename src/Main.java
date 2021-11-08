package src;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        Dico dico = new Dico("/amuhome/f18010428/Bureau/S4/Algo2/TP/TPAlgo2/dico.txt");
        Trigramme trigramme = new Trigramme("logarytmique");
        //System.out.println(dico.dico);
        Algo algo = new Algo("logarytmique","algorithmique");
        System.out.println(algo.calculate());
        System.out.println(trigramme.trigramme);
        List<String >L = trigramme.ListeL(dico);

        //System.out.println(L);
        HashMap<String,Integer> Occu = trigramme.OccurenceDansL(L);

        //System.out.println(Occu);
        //List<String>Ltrie = trigramme.ListeTriage(L);
        //System.out.println(Ltrie);
        List<String> OccuMax = trigramme.ListeOccuMax(Occu);

        //List<String> OccuMax = trigramme.ListeOccuMax(Occu,Ltrie);
        System.out.println(OccuMax);
        List<String> CinqMeilleur = trigramme.DistanceList(OccuMax);
        System.out.println(CinqMeilleur);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + ((endTime-startTime)/1000) + "s");

    }
}

