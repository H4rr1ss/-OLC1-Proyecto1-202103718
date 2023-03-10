package TRANSICIONES_202103718;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dbTablaTransicion {
    private HashMap<String, Object> tabla = new HashMap<>();
    private ArrayList<HashMap> listaHashMap = new ArrayList<HashMap>();
    
    public void addDatosHash(String nodo, String simbolo, List<String> siguientes){
        elementHash obj = new elementHash(simbolo, siguientes);
        tabla.put(nodo, obj);
        listaHashMap.add(tabla);
    }
}
