package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dico {
    public HashSet<String> dico = new HashSet<>();

    public Dico(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner  = new Scanner(file);
        while (scanner.hasNext()){
            dico.add("<"+scanner.next()+">");
        }
    }

    public HashMap<String,ArrayList<String>> Trigramme(){
        HashMap<String,ArrayList<String>> TrigrammeDico = new HashMap<>();
        for(String mot : this.dico){
            Trigramme trigramme = new Trigramme(mot);
            for(String tri : trigramme.trigramme){
                if(!TrigrammeDico.containsKey(tri)){
                    ArrayList<String> newList = new ArrayList<>();
                    newList.add(mot);
                    TrigrammeDico.put(tri,newList);
                }else{
                    TrigrammeDico.get(tri).add(mot);
                }
            }
        }
        return TrigrammeDico;

    }
}
