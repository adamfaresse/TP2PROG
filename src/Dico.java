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

    /*public List<String> list(Trigramme trigramme){
        List<String> list= new ArrayList<String>();
        for (String dic : dico){
            Trigramme t1 = new Trigramme(dic);
            for(String mot : trigramme.trigramme){
                if(t1.trigramme.contains(mot)){
                    list.add(dic);
                }
            }
        }

    }*/

}
