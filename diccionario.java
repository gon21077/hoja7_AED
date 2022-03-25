import java.util.HashMap;

public class diccionario implements Comparable<diccionario> {

    private HashMap<String, String> palabras;
    private String ingles;
    
    
    public diccionario(String leng1, HashMap<String, String> palab){
        this.ingles = leng1;
        this.palabras = palab;
    }

    public String getName(){
        return this.ingles;
    }
    public HashMap<String, String> getHashMap(){
        return this.palabras;
    }


    @Override
    public int compareTo(diccionario other) {
        return this.ingles.compareTo(other.ingles);
    }
}
