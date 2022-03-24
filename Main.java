
import java.util.*;


public class Main {
    BinarySearchTree<diccionario> ingles = new BinarySearchTree();
    BinarySearchTree<diccionario> espanol = new BinarySearchTree();
    BinarySearchTree<diccionario> frances = new BinarySearchTree();
    static String path = "diccionario.txt";
    static String path1 = "texto.txt";
    static String line = null;
    static ArrayList<String> a = new ArrayList<String>();
    Map<String, String> dic = new HashMap<>();

    public static void leerArchivo(String pat){
        try {
            /**
             * Mientras haya un archivo, se lee.
             */
            BufferedReader reader = new BufferedReader(new FileReader(pat));
            while((line = reader.readLine()) != null){
                a.add(line);
            }
        } catch(Exception e){
            System.out.println("Error al leer archivo");
        }
    }
    public static void main(String[] args){
        for (String x: a){
            String[] str = x.split(",");

            String english = str[0];
            String spanish = str[1];
            String french = str[2];

            dic.put

        }

    }
}
