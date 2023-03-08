package Analizador;
import java.util.HashMap;

public class DefConjuntos {
    
    private HashMap<String, String> conjuntos = new HashMap<>();
    
    public void add(String NombreConj, String notacion){     
        try{
            for (HashMap.Entry<String, String> entry : conjuntos.entrySet()){
                if(NombreConj.equals(entry.getKey())){
                    System.out.println("Este nombre de conjunto ya existe, <"+NombreConj+">");
                    return;
                }
            }
        }catch(Exception ex){
            System.out.println("Error al Definir un conjunto");
        }
        

        conjuntos.put(NombreConj, notacion);
        System.out.println("Ya se agrego el conjunto correctamente."+ NombreConj+", "+notacion);
    }
    
    public void print(){
        System.out.println("-------------------------------");
        for (HashMap.Entry<String, String> entry : conjuntos.entrySet()){
            System.out.println("Conjunto: "+entry.getKey()+", Valor: "+entry.getValue());
        }
        System.out.println("\n");
    }
    
    public void printA(String entrada){
        System.out.println("AUXILIAR----\n"+entrada);
    }
    
    
}
