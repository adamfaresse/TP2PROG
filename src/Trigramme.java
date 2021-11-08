package src;

import java.util.*;

public class Trigramme {
    public ArrayList<String>  trigramme = new ArrayList<String>();
    public String GrandM ;
    public List<String> ListTrie = new ArrayList<>();
    public Trigramme(String mot){
        for (int i = 0; i <mot.length()-2 ; i++) {
                this.trigramme.add(mot.charAt(i) + Character.toString(mot.charAt(i + 1)) + mot.charAt(i + 2));

        }
        this.GrandM = mot;
    }

    public HashMap<String,ArrayList<String>> ListeL(HashMap<String,ArrayList<String>> dicoTrigramme){
        HashMap<String,ArrayList<String> >L = new HashMap<>();
        for (String tri : this.trigramme){
            if(dicoTrigramme.containsKey(tri)){
                L.put(tri,dicoTrigramme.get(tri));
            }

        }
        return L;
    }

    public HashMap<String, Integer>  OccurenceDansL(HashMap<String,ArrayList<String>> liste){
        HashMap<String,Integer> ListeLEtOcc = new HashMap<>();
        for(String tri : liste.keySet()){
            for(String mot : liste.get(tri)){
                if(!ListeLEtOcc.containsKey(mot)){
                    ListeLEtOcc.put(mot,1);
                }else{
                    int i = ListeLEtOcc.get(mot)+1;
                    ListeLEtOcc.put(mot,i);
                }
            }
        }
        return ListeLEtOcc;
    }
    public List<String> ListeOccuMax(HashMap<String,Integer> listeMap,HashMap<String,ArrayList<String>> liste){
        LinkedList<String> listeMax = new LinkedList<>();
        List<String> centPremier = new ArrayList<String>();
        int valeur= liste.keySet().size()-1;
        while(valeur>=1){
            if(listeMax.size()<100){

                for (String mot : listeMap.keySet()){
                    if(listeMap.get(mot)==valeur){
                        listeMax.add(mot);
                    }
                }valeur--;
            }
            else{
                for (int i = 0; i <100 ; i++) {
                    centPremier.add(listeMax.get(i));

                }break;
            }
        }
        return centPremier;
    }


    public HashMap<Integer,ArrayList<String>> DistanceList(List<String> listeMax) {
        HashMap<Integer, ArrayList<String>> ListeMotEtDistance = new HashMap<>();
        for (String mot : listeMax) {
            Algo algo = new Algo(mot,this.GrandM);
            if(!ListeMotEtDistance.containsKey(algo.calculate())){
                ArrayList<String> listTemporaire = new ArrayList<>();
                listTemporaire.add(mot);
                ListeMotEtDistance.put(algo.calculate(), listTemporaire);
            }
            if(!ListeMotEtDistance.get(algo.calculate()).contains(mot)){
                ListeMotEtDistance.get(algo.calculate()).add(mot);
            }

        }
        return ListeMotEtDistance;
    }
    public List<String> ListeDesCinq(HashMap<Integer,ArrayList<String>> ListeMotEtDistance){
        List<String> cinqMots = new ArrayList<>();
        int i = 1;
        while(cinqMots.size()<5 && i<10){
            if(ListeMotEtDistance.containsKey(i)){
                for(String mot : ListeMotEtDistance.get(i)){
                    if(cinqMots.size()<5){
                        cinqMots.add(mot);
                    }
                }
            }
            i++;
        }
        return cinqMots;
    }




}
