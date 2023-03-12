package TRANSICIONES_202103718;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dbTablaTransicion {
    private HashMap<String, elementHash> tabla = new HashMap<>();
    private Map<String, List<String>> transicionP = new HashMap<>();
    private List<transicion> listadoF = new ArrayList<transicion>();
    private int indice = 0;
    
    public void addDatosHash(String nodo, String simbolo, List<String> siguientes){
        elementHash obj = new elementHash(simbolo, siguientes);
        tabla.put(nodo, obj);
    }
    
    
    // SOLO SERVIRA PARA REALIZAR LAS PRUEBAS DE ESTA CLASE
    public void PROVISIONAL(String nodo, elementHash objeto){
        tabla.put(nodo, objeto);
    }
    
    public void returnDatos(){
        for(Map.Entry<String, elementHash> mapa : tabla.entrySet()){
            indice = 2;
            System.out.println(mapa.getKey()+" = "+ mapa.getValue().getSimbolo()+", "+mapa.getValue().getSiguientes());
        }
    }
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private String verificarExistSigPos(List<String> listaSig){// SE COMPARA EL HASH DE TRANSICIONES CON LA LISTA SIGUIENTE Y RETORMA EL ESTADOFINAL
        if(transicionP.isEmpty()){
            return "";
        }
        
        for(Map.Entry<String, List<String>> tablaF : transicionP.entrySet()){
            int contador = 0;

            for(Object cadena :tablaF.getValue().toArray()) {// ARRAY BASE
                
                for(String sig : listaSig){ // LISTA SIGUIENTESS
                    if(cadena.equals(sig)){
                        contador++;
                    }
                }
                
            }
            
            if (contador == tablaF.getValue().toArray().length){
                return tablaF.getKey();
            }
            
        }
        return "";
    }
    
    
    private boolean aceptacion(List<String> sigpos){
        for(Map.Entry<String, elementHash> mapa : tabla.entrySet()){
            if(mapa.getValue().getSimbolo().equals("#")){
                for(int i = 0; i<sigpos.size(); i++){
                    if(sigpos.get(i).equals(mapa.getKey())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private List<String> rep(List<String> listaF, List<String> listaC){
        
        
        if(listaF.isEmpty()){
            for(int i = 0; i<listaC.size(); i++){
                listaF.add(listaC.get(i));
            }
        }else{
            for(int i = 0; i<listaC.size(); i++){
                int data = 0;
                
                for(int j = 0; j<listaF.size(); j++){
                    if(listaC.get(i).equals(listaF.get(j))){
                        data++;
                    }
                }
                if(data == 0){
                    listaF.add(listaC.get(i));
                }
            }
        }
        return listaF;
    }
    
    /*
                        1ra. corrida
                         listaC     listaF
                         [2,3,4]    []
                        
                        2ra. corrida
                         listaC     listaF
                         [5,2,6]    [2,3,4]   
    */
    
    private void eliminados(String eliminar, Map<String, elementHash> hashEvaluar){
        String[] eliminados = eliminar.split(",");
        
        for(int i=0; i < eliminados.length; i++){
            hashEvaluar.remove(eliminados[i]);
        }
    }
    
    
    // LOGICA FINAL PARA TABLA DE TRANSICIONES
    private void SeleccionNodos(String[] S0){//S0 = 1,2,3,4,5,6
        Map<String, elementHash> hashEvaluar = new HashMap<>();
        
        for(Map.Entry<String, elementHash> mapa : tabla.entrySet()){
            for(int i = 0; i < S0.length; i++){
                if(S0[i].equals(mapa.getKey())){
                    // SE CREA UN NUEVO HASHMAP QUE REPRESENTA LA TABLA COLOR AZUL
                    hashEvaluar.put(S0[i], mapa.getValue());
                }
            }
        }
        
        int indiceI = 0;
        boolean llave = true;
        
        while(llave){
            // TERMINARA EL CICLO HASTA QUE LA TABLA AZUL YA HAYA SIDO EVALUADA TOTALMENTE
            if(hashEvaluar.isEmpty()){
                llave = false;
            }
            /*
                SE EMPIEZA A RECORRER LA TABLA CON TODOS LOS ELEMENTOS Y AL MISMO TIEMPO 
                SE RECORRE LA TABLA AZUL PARA EMPEZAR A CREAR LAS TRANSICIONES, TOMANDO
                EN CUENTA SOLO LAS QUE EXISTAN EN LA TABLA 
            */
            for(Map.Entry<String, elementHash> mapaBase : tabla.entrySet()){
                
                String eliminadosS = "";
                List<String> ListaSig = new ArrayList<String>();
                List<String> listaF = new ArrayList<String>();
                
                for(Map.Entry<String, elementHash> mapAux : hashEvaluar.entrySet()){

                    if(mapaBase.getValue().getSimbolo().equals(mapAux.getValue().getSimbolo())){
                        //nodo = obj(simbolo, [siguientes])
                        //me devolverá los arrays de siguientes
                        
                        //CREACION DE LOS ATRIBUTOS PARA EL OBJETO TRANSICION
                        ListaSig = rep(listaF, mapAux.getValue().getSiguientes());// ALMACENA LOS NUEVOS SIGPOS
                        
                        eliminadosS += mapAux.getKey()+",";
                    }
                    
                }
                eliminados(eliminadosS, hashEvaluar);
                
                if (hashEvaluar.isEmpty()){
                    break;
                }
                
                String EstadoF = "";
                String estado = "";
                
                //VERIFICAR SI LA LISTA DE SIGUIENTES YA EXISTE ENTONCES NO SE CREA NUEVO ESTADO
                if (this.indice !=0){
                    estado = verificarExistSigPos(ListaSig);// ACA IRA estadoF = [tablaSig]
                }
                
                if (estado.equals("")){
                    //SI ES TRUE ENTONCES
                    EstadoF = "S"+String.valueOf(this.indice+1); //REPRESENTA EL ESTADO IGUALADO AL FINAL
                    this.indice++;
                }else{
                   EstadoF = estado; //REPRESENTA EL ESTADO IGUALADO AL FINAL
                }
                       
                String EstadoI = "S"+String.valueOf(indiceI); //ASIGNA UN ESTADO INICIAL INICIA EN 0
                String simbolo = mapaBase.getValue().getSimbolo();//OBTIENE EL SIMBOLO QUE SE EVALUO
                        
                boolean acept = aceptacion(ListaSig);//VERIFICA SI EL NODO # SE ENCUENTRA EN LOS NODOS SIGPOS
                       
                transicionP.put(EstadoF, ListaSig);
                transicion objTransiciones = new transicion(EstadoI, simbolo, ListaSig, EstadoF, acept);
                this.listadoF.add(objTransiciones);
            }
            indiceI++;
        }
    }
    
    
    public void TablaTransiciones(String estadoI){
        String[] S0 = estadoI.split(",");// {1,2,3,4,5,6}
        
        // PASO 2
        SeleccionNodos(S0);
        
    }

}

