package src;

import java.util.*;

public class Trigramme {
    public List<String>  trigramme = new ArrayList<String>();
    public String GrandM ;
    public Trigramme(String mot){
        for (int i = 0; i <mot.length()-2 ; i++) {
                this.trigramme.add(mot.charAt(i) + Character.toString(mot.charAt(i + 1)) + mot.charAt(i + 2));
        }
        this.GrandM = mot;
    }

    public List<String> ListeL(Dico dico){
        List<String >L = new ArrayList<>();
        for (String tri : this.trigramme){
            for (String mot : dico.dico ){
                if (mot.contains(tri)){
                    L.add(mot);
                }
            }
        }
        return L;
    }

    public HashMap<String, Integer> OccurenceDansL(List<String> liste){
        HashMap<String,Integer> ListeLEtOcc = new HashMap<>();

        for (String mot1 : liste){
            int conteur = 0;
            if(!ListeLEtOcc.containsKey(mot1)){
                for (String mot2 : liste){
                    if(mot1.equals(mot2)){
                        conteur++;
                    }
                }
                ListeLEtOcc.put(mot1,conteur);
            }


        }
        return ListeLEtOcc;
    }


    public List<String> ListeTriage(List<String>listeNonTrie){
        List<String > listeTrie = new ArrayList<>();
        for (String mot: listeNonTrie){
            if(!listeTrie.contains(mot)){
                listeTrie.add(mot);
            }
        }
        return listeTrie;
    }
    public List<String> ListeOccuMax(HashMap<String,Integer> listeMap,List<String> listeTrie){
        LinkedList<String> listeMax = new LinkedList<>();
        int valeur= 1;
        boolean bool = false;
        while(!bool){
            bool = true;
            for (String mot : listeTrie){
                listeMap.get(mot);
                if (valeur==listeMap.get(mot)){
                    if(listeMax.size()==100){
                        listeMax.removeFirst();
                    }
                    listeMax.add(mot);
                    bool = false;
                }
            }
            valeur++;

        }
        return listeMax;
    }

    public List<String> DistanceList(List<String> listeMax){
        LinkedList<String> ListeMeilleurMot = new LinkedList<>();
        for(String mot :listeMax){
            int conteur = 0;
            Algo algo = new Algo(mot,this.GrandM);
            int x = algo.calculate();
            for(String mot1 : listeMax){
                Algo algo2 = new Algo(mot1,this.GrandM);
                int y = algo2.calculate();
                if (x <= y) {
                    conteur++;
                }
            }
            if (conteur<5){
                ListeMeilleurMot.add(mot);
            }
        }
        return ListeMeilleurMot;
    }

}
