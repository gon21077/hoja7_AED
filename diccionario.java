import java.util.HashMap;

public class diccionario implements Comparable<diccionario> {

    private HashMap palabras;
    private String ingles;
    private int count;
    
    
    public diccionario(String leng1, HashMap palab){
        this.ingles = leng1;
        this.palabras = palab;
        this.count = 0;
    }



    @Override
    public int compareTo(diccionario other) {
        return Integer.compare(this.count, other.count);
    }
}
