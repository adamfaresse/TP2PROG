package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlgoTrigramme {
    Dico dico1;
    HashMap<String, ArrayList<String>> DicoTrigramme;
    public AlgoTrigramme(Dico dico, Faute faute){
        this.dico1 = dico;
        this.DicoTrigramme = dico1.Trigramme();
    }
    public List<String> calculate(String mot){
            if(!dico1.dico.contains(mot)) {
                Trigramme trigramme = new Trigramme(mot);
                HashMap<String,ArrayList<String>> L = trigramme.ListeL(this.DicoTrigramme);
                HashMap<String, Integer> Occu = trigramme.OccurenceDansL(L);
                List<String> OccuMax = trigramme.ListeOccuMax(Occu,L);
                HashMap<Integer, ArrayList<String>> DistanceList = trigramme.DistanceList(OccuMax);

                List<String> ListeDesCinq = trigramme.ListeDesCinq(DistanceList);
                return ListeDesCinq;
            }return null;
    }
}
