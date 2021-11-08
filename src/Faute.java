package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Faute {
    public ArrayList<String> faute = new ArrayList<>();
    public Faute(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            faute.add("<" + scanner.next() + ">");
        }
    }
}