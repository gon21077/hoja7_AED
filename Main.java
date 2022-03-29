
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;



public class Main {
    static BinarySearchTree ingles = new BinarySearchTree();

    static String path = "diccionario.txt";
    static String path1 = "texto.txt";
    static String line = null;
    

    public static void leerArchivo(String pat, ArrayList<String> p){
        try {
            /**
             * Mientras haya un archivo, se lee.
             */
            BufferedReader reader = new BufferedReader(new FileReader(pat));
            while((line = reader.readLine()) != null){
                p.add(line);
            }
        } catch(Exception e){
            System.out.println("Error al leer archivo");
        }
    }
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> b = new ArrayList<>();
        ArrayList<String[]> c = new ArrayList<>();
        ArrayList<String[]> d = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        leerArchivo(path, a);
        for (int i = 0; i<a.size(); i++){
            String x = a.get(i);
            HashMap<String, String> ma = new HashMap<>();
            String[] str = x.split(",");

            String english = str[0];
            String spanish = str[1];
            String french = str[2];

            ma.put("English", english);
            ma.put("Spanish", spanish);
            ma.put("French", french);
            diccionario dic = new diccionario(english, ma);
            
            
            
            ingles.insert(dic);
        }
        List<diccionario> a1 = ingles.depthFirstSearch_InOrder();
        for (int x = 0; x < a1.size(); x++){
            System.out.println("\n"+a1.get(x).getName());
            for (Map.Entry entry : a1.get(x).getHashMap().entrySet())
            {
                System.out.println(entry.getKey() + " | Palabra: " + entry.getValue());
            }
        }

        leerArchivo(path1, b);

        for (int p = 0; p<b.size(); p++){
            String completo = b.get(p);
            String[] preTrad = completo.split("\\s+");
            
           
            c.add(preTrad);
        }



        boolean onFull = true;
        while(onFull){
            Boolean on1 = true;
            int end = 0;
            while(on1){
                int endif = 0;
                System.out.println("Ingrese 1 para continuar o 2 para TERMINAR");
                try{
                    endif = scan.nextInt();
                } catch (Exception e){
                    continue;
                }
                if (endif == 1){
                    break;
                }
                if (endif == 2){
                    onFull = false;
                    end = 1;
                    break;
                } else {
                    System.out.println("Ingrese solo 1 o 2\n");
                    continue;
                }
            }
            if (end == 1){
                break;
            }
            
            

            
            boolean on = true;
            int lenguaje;
            String traduccion = "";
            while (on){
                try {
                    System.out.println("\n\nIngrese 1 para traducir DESDE espanol, ingrese 2 para traducir DESDE frances o ingrese 3 para traducir DESDE ingles: ");
                    lenguaje = scan.nextInt();
                } catch (Exception e){
                    System.out.println("Ingrese solo 1, 2 o 3");
                    continue;
                }
                
                if (lenguaje == 1){
                    traduccion = "Spanish";
                    break;
                } if (lenguaje == 2){
                    traduccion = "French";
                    break;
                } if (lenguaje == 3){
                    traduccion = "English";
                    break;
                }
                
                else {
                    System.out.println("Ingrese solo 1, 2 o 3");
                    continue;
                }
            }
            
            int lenguaje1;
            String traduccion1 = "";
            
            while (on){
                try {
                    System.out.println("\n\nIngrese 1 para traducir HACIA espanol, ingrese 2 para traducir HACIA frances o ingrese 3 para traducir HACIA ingles: ");
                    lenguaje1 = scan.nextInt();
                } catch (Exception e){
                    System.out.println("Ingrese solo 1, 2 o 3");
                    continue;
                }
                
                if (lenguaje1 == 1){
                    traduccion1 = "Spanish";
                    break;
                } if (lenguaje1 == 2){
                    traduccion1 = "French";
                    break;
                } if (lenguaje1 == 3){
                    traduccion1 = "English";
                    break;
                }
                else {
                    System.out.println("Ingrese solo 1, 2 o 3");
                    continue;
                }
            }
            

        

            String FinalTrad = "";

            for (String[] s: c){
                
                for (String t: s){
                    Boolean traducida = false;
                    
                    for (diccionario y: a1){
                        

                        if (y.getHashMap().get(traduccion).equalsIgnoreCase(t)){
                            
                            t = y.getHashMap().get(traduccion1);
                            traducida = true;
                            FinalTrad = FinalTrad+t+" ";
                            continue;
                        } 
                        
                        
                        
                        
                    }
                    if (traducida == false){
                        t = "*"+t+"*";
                        FinalTrad = FinalTrad+t+" ";
                    }
                    
                    
                }
                System.out.println(FinalTrad);
            }
        }

    }
}
