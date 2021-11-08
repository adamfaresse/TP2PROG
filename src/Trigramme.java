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

    public List<String> ListeL(HashMap<String,ArrayList<String>> dicoTrigramme,Dico dico){
        List<String >L = new ArrayList<>();
        for (String tri : this.trigramme){
            for (String mot : dico.dico ){

                if (dicoTrigramme.get(mot).contains(tri)){
                    L.add(mot);
                }
            }
        }
        return L;
    }

    public HashMap<String, Integer>  OccurenceDansL(List<String> liste){
        HashMap<String,Integer> ListeLEtOcc = new HashMap<>();
        for(String mot : liste){
            int conteur = 0;
            if(!ListeLEtOcc.containsKey(mot)){
                this.ListTrie.add(mot);
                conteur = Collections.frequency(liste,mot);
                ListeLEtOcc.put(mot,conteur);
            }

        }
        /*for (String mot1 : liste){
            int conteur = 0;
            if(!ListeLEtOcc.containsKey(mot1)){
                for (String mot2 : liste){
                    if(mot1.equals(mot2)){
                        conteur++;
                    }
                }
                ListeLEtOcc.put(mot1,conteur);
            }
        }*/
        return ListeLEtOcc;
    }


    /*public List<String> ListeTriage(List<String>listeNonTrie){
        List<String > listeTrie = new ArrayList<>();
        for (String mot: listeNonTrie){
            if(!listeTrie.contains(mot)){
                listeTrie.add(mot);
            }
        }
        return listeTrie;
    }*/
    public List<String> ListeOccuMax(HashMap<String,Integer> listeMap){
        LinkedList<String> listeMax = new LinkedList<>();
        int valeur= 1;
        boolean bool = false;
        while(!bool){
            bool = true;
            for (String mot : this.ListTrie){
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
    /*public List<String> ListeOccuMax(HashMap<String,Integer> listeMap,List<String> ListTrie){
        LinkedList<String> listeMax = new LinkedList<>();
        int valeur= 1;
        boolean bool = false;
        while(!bool){
            bool = true;
            for (String mot : ListTrie){
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
    }*/

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
        while(cinqMots.size()<5){
            if(ListeMotEtDistance.containsKey(i)){
                for(String mot : ListeMotEtDistance.get(i)){
                    if(cinqMots.size()>5){
                        break;
                    }
                    cinqMots.add(mot);

                }
            }
            i++;
        }
        return cinqMots;
    }


}
