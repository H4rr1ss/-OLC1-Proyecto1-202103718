package AFD_202103718;
import AFD_202103718.*;
import java.util.ArrayList;
import java.util.List;

public class dbAFD {
    //LISTA QUE ALMACENARA TODOS LOS AFD DURANTE LA EJECUCION
    public static List<AFD> afds = new ArrayList<AFD>();
    
    
    
    public static void InsertAFD(AFD data){
        afds.add(data);
    }
    
    public static void returnAFD(){
        System.out.println("\n\n-------------------AUTOMATAS-------------------");

        for(AFD afd: afds){
            System.out.println("\nNombre: "+afd.getNombre());
            System.out.println("Transiciones: "+afd.getTransiciones());
            System.out.println("Conjuntos: "+afd.getConjuntos());
        }
    }
    
    public static List<AFD> returnDatosInterfaz(){
        return afds;
    }
    
    
    
}
//dbAFD.InsertAFD(objAFD);