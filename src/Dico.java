package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Dico {
    public HashSet<String> dico = new HashSet<>();

    public Dico(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner  = new Scanner(file);
        while (scanner.hasNext()){
            dico.add(scanner.next());
        }


    }

}
