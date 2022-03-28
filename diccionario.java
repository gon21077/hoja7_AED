import java.util.HashMap;

public class diccionario implements Comparable<diccionario> {

    private HashMap<String, String> palabras;
    private String ingles;
    
    /**
     * @param leng1
     * @param palab
     */
    public diccionario(String leng1, HashMap<String, String> palab){ ///Diccionario
        this.ingles = leng1; 
        this.palabras = palab;
    }

    /**
     * @return ingles
     */
    public String getName(){
        return this.ingles;
    }
    /**
     * @return HashMap Palabras
     */
    public HashMap<String, String> getHashMap(){ /// HashMap Palabras
        return this.palabras;
    }


    @Override
    public int compareTo(diccionario other) { ///Compara las palabras.
        return this.ingles.compareTo(other.ingles);
    }
}
