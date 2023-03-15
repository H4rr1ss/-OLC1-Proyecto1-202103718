package TRANSICIONES_202103718;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dbTablaTransicion {
    private HashMap<String, elementHash> tabla = new HashMap<>();       // TABLA GENERAL
    private Map<String, List<String>> transicionP = new HashMap<>();    // TABLA AZUL
    private List<transicion> listadoF = new ArrayList<transicion>();    // TRANSICIONES AFD
    private List<String> estadosA = new ArrayList<String>();
    private List<List<String>> evaluacionEstados = new ArrayList<List<String>>();
    private int indice = 0;
    private boolean llave = true;
    
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
    
    
    public void returnDatosFinales(){
        for(transicion cadena :listadoF) {
            System.out.println("Tran["+cadena.getEstadoI()+", "+ cadena.getSimbolo()+"] = "+cadena.getSigEvaluar()+" = "+cadena.getEstadoF()+"("+cadena.isAcept()+")");
        }
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private String verificarExistSigPos(List<String> listaSig){// SE COMPARA EL HASH DE TRANSICIONES CON LA LISTA SIGUIENTE Y RETORMA EL ESTADOFINAL
        if(transicionP.isEmpty()){//////////////////////////////////////////////////////////
            return "";
        }
        
        for(Map.Entry<String, List<String>> tablaF : transicionP.entrySet()){
            int contador = 0;

            for(Object cadena :tablaF.getValue().toArray()) {// ARRAY BASE
                
                for(String sig : listaSig){ // LISTA SIGUIENTESS
                    if(cadena.equals(sig)){
                        contador++;//agregar break
                        break;
                    }
                }   
            }
            
                    
            if (listaSig.size() == tablaF.getValue().toArray().length &&  contador == listaSig.size()){
                return tablaF.getKey();
            }
            
        }
        return "";
    }
    
    
    private Boolean aceptacionAux(List<String> listaAceptacion, String estadoF){
        for(String li: listaAceptacion){
            if(li.equals(estadoF)){
                return true;
            }
        }
        return false;
    }
    
    private Boolean aceptacion(List<String> listaSig, String estadoF, String estadoI){
        
        for(Map.Entry<String, elementHash> mapa : tabla.entrySet()){
            if(!mapa.getValue().getSimbolo().equals("#")){
                continue;
            }
            
            //ME DEVUELVE EL NODO EN QUE SE ENCUENTRA "#"  estadosA
            for(String li: listaSig){
                if(li.equals(mapa.getKey())){
                    
                    if(aceptacionAux(estadosA, estadoF)){
                        continue;
                    }
                    estadosA.add(estadoF);
                }
            }

        }
        
        for(String estadosA: estadosA){
            if(estadosA.equals(estadoI)){
                return true;
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
    
    private void eliminados(String eliminar, Map<String, elementHash> hashEvaluar){
        String[] eliminados = eliminar.split(",");
        
        for(int i=0; i < eliminados.length; i++){
            hashEvaluar.remove(eliminados[i]);
        }
    }
    
    private void asignarTablaAzul(Map<String, elementHash> hashEvaluar, String[] S0){
        for(Map.Entry<String, elementHash> mapa : tabla.entrySet()){
            for(int i = 0; i < S0.length; i++){
                if(S0[i].equals(mapa.getKey())){
                    // SE CREA UN NUEVO HASHMAP QUE REPRESENTA LA TABLA COLOR AZUL
                    hashEvaluar.put(S0[i], mapa.getValue());
                }
            }
        }
    }
    
    private String asignarEstadoF(String estado, String EstadoF, List<String> ListaSig){
        if (this.indice !=0){
            estado = verificarExistSigPos(ListaSig);// ACA IRA estadoF = [tablaSig]//////////////////////////////////////////////////////////
        }
        
        if (estado.equals("")){
            //SI ES TRUE ENTONCES
            EstadoF = "S"+String.valueOf(this.indice+1); //REPRESENTA EL ESTADO IGUALADO AL FINAL
            this.indice++;
            return EstadoF;
        }
        EstadoF = estado; //REPRESENTA EL ESTADO IGUALADO AL FINAL
        return EstadoF;
    }
    
    private boolean verificarRelleno(List<String> nodos){
        if (evaluacionEstados.isEmpty()){
            return false;
        }
        
        for(int i = 0; i < evaluacionEstados.size(); i++){
            
            int contador = 0;
            for(int j = 0; j < evaluacionEstados.get(i).size(); j++){
                
                for(int h = 0; h < nodos.size(); h++){
                    if(evaluacionEstados.get(i).get(j).equals(nodos.get(h))){
                        contador++;
                    }
                }
            }
            
            if (evaluacionEstados.get(i).size() == nodos.size() && contador == nodos.size()){
                return true;
            }
        }
        return false;
    }
    
    private String nodoNumeral(){
        String numNodo = "";
        for(Map.Entry<String, elementHash> mapa : tabla.entrySet()){
            if(mapa.getValue().getSimbolo().equals("#")){
                numNodo = mapa.getKey();
            }
        }
        return numNodo;
    }
    
    private void rellenohashEvaluar(Map<String, elementHash> hashEvaluar){
        
        String nodos = "";
        
        for(int i = 0; i< listadoF.size(); i++){
            
            if(!listadoF.get(i).isEvaluacion()){
                
                if (verificarRelleno(listadoF.get(i).getNodos())){
                    listadoF.get(i).setEvaluacion(true);
                    continue;
                }
                listadoF.get(i).setEvaluacion(true);
                evaluacionEstados.add(listadoF.get(i).getNodos());
                int numeral = 0;
                List<String> nodo = new ArrayList<String>();
                
                for(int j = 0; j < listadoF.get(i).getNodos().size(); j++){
                    
                    if (nodoNumeral().equals(listadoF.get(i).getNodos().get(j))){
                        numeral++;
                        nodo.add(listadoF.get(i).getNodos().get(j));
                        continue;
                    }
                    nodos += listadoF.get(i).getNodos().get(j) + ",";
                }
                
                String[] S0 = nodos.split(",");
                System.out.println(S0.length + "numeral: "+ numeral);
                if(S0.length == 1 && S0[0].equals("") && numeral == 1){
                    String EstadoI = finalEstado();
                    transicion objTransiciones = new transicion(EstadoI, "", null, "", true);
                    objTransiciones.setSigEvaluar(nodo);
                    this.listadoF.add(objTransiciones); 
                }
                
                asignarTablaAzul(hashEvaluar,S0);
                return;
            }
        }
    }
    
    private List<String> sigGraphviz(Map<String, elementHash> hashEvaluar){
        List<String> SigPorAnalizar = new ArrayList<String>();
        
        for(Map.Entry<String, elementHash> mapAux : hashEvaluar.entrySet()){
            SigPorAnalizar.add(mapAux.getKey());
        }
        
        return SigPorAnalizar;
    }
    
    // LOGICA FINAL PARA TABLA DE TRANSICIONES
    private void SeleccionNodos(String[] S0){//S0 = 1,2,3,4,5,6
        Map<String, elementHash> hashEvaluar = new HashMap<>();
        asignarTablaAzul(hashEvaluar, S0);
        int indiceI = 0;
        
        while(this.llave){
            
            for(Map.Entry<String, elementHash> mapaBase : tabla.entrySet()){
                
                if (hashEvaluar.isEmpty()){
                    break;
                }
                
                String eliminadosS = "";
                boolean sigNodo = false;
                List<String> ListaSig = new ArrayList<String>();
                List<String> listaF = new ArrayList<String>();
                
                for(Map.Entry<String, elementHash> mapAux : hashEvaluar.entrySet()){

                    if(mapaBase.getKey().equals(mapAux.getKey())){      
                        sigNodo = true;
                        ListaSig = rep(listaF, mapAux.getValue().getSiguientes());// ALMACENA LOS NUEVOS SIGPOS
                        eliminadosS += mapAux.getKey()+",";
                    }
                }
                
                if (!sigNodo){
                    continue;
                }
                List<String> SigPorAnalizar = new ArrayList<String>();
                SigPorAnalizar = sigGraphviz(hashEvaluar);
                eliminados(eliminadosS, hashEvaluar);
                String EstadoF = "";
                String estado = "";
                
                //VERIFICAR SI LA LISTA DE SIGUIENTES YA EXISTE ENTONCES NO SE CREA NUEVO ESTADO
                EstadoF = asignarEstadoF(estado, EstadoF, ListaSig);//////////////////////////////////////////////////////////
                       
                String EstadoI = "S"+String.valueOf(indiceI); //ASIGNA UN ESTADO INICIAL INICIA EN 0
                String simbolo = mapaBase.getValue().getSimbolo();//OBTIENE EL SIMBOLO QUE SE EVALUO
                        
                boolean acept = aceptacion(ListaSig, EstadoF, EstadoI);//VERIFICA SI EL NODO # SE ENCUENTRA EN LOS NODOS SIGPOS
                       
                transicionP.put(EstadoF, ListaSig);
                transicion objTransiciones = new transicion(EstadoI, simbolo, ListaSig, EstadoF, acept);
                //transicion objTransiciones = new transicion(EstadoF, "", "", "", true);
                objTransiciones.setSigEvaluar(SigPorAnalizar);
                
                this.listadoF.add(objTransiciones);
            }
            
            indiceI++;
            // VERIFICARA SI HAY ESTADOS POR CREAR Y SE RELLENARA EL HASHMAP (hashEvaluar)
            rellenohashEvaluar(hashEvaluar);
            
            if(hashEvaluar.isEmpty()){
                this.llave = false;
            }
        }
    }
    
    private String finalEstado(){
        String estado = "";
        int tamaño = this.listadoF.size()-1;
        for(int i = 0; i < this.listadoF.size(); i++){
            
            if(i != tamaño){
                continue;
            }
           
            estado = this.listadoF.get(i).getEstadoF();
        }
        
        return estado;
    }
    
    /*private Boolean auxRe(List<String> li, String estado){
        int contador = 0;
        
        for(String l :li) {
            if(l.equals(estado)){
                contador++;
            }
        }
        if (contador == 1){
            return true;
        }
        return false;
    }*/
    
    
    private String AuxGr(String estadoI, List<String> terminales, List<String> saltar){//ESTO ES PARA LO TERMINALES
        String t = "";
        
        for(String terminal: terminales){
            if(terminal.equals("")){
                continue;
            }
            String agregado = termRepp(terminal, estadoI, saltar);
            
            if(agregado != ""){
                t += agregado;
                continue;
            }
            t += "\t\t\t\t\t<td>--</td>\n";
            
        }
        System.out.println("\n"+t);
        return t;
    }
    
    private Boolean m(List<String> lista, String esI){
        for(String u: lista){
                if(u.equals(esI)){
                    return true;
                }
            }
        return false;
    }
    
    private String termRepp(String terminal, String estadoI, List<String> saltar){     
        String t = "";
        
        for(transicion tr: listadoF){
            if(m(saltar, tr.getEstadoI())){
                continue;
            }

            if(tr.getEstadoI().equals(estadoI) && tr.getSimbolo().equals(terminal)){
                t += "\t\t\t\t\t<td>"+ tr.getEstadoF() +"</td>\n";
                break;
            }
            
            if(!tr.getEstadoI().equals(estadoI)){
                break;
            }
        }
        return t;
    }
    
    private Boolean termRep(List<String> terminales, String simbolo){
        for(String t: terminales){
            if(t.equals(simbolo)){
                return true;
            }
        }
        return false;
    }
    
    private int sizeEncabezado(){
        List<String> rep = new ArrayList<String>();
        
        for(Map.Entry<String, elementHash> t : tabla.entrySet()){
            if(rep.contains(t.getValue().getSimbolo())){
                continue;
            }
            rep.add(t.getValue().getSimbolo());
        }
        
        return rep.size();
    }
    
    
    private String graphviz(){
        List<String> repetidos = new ArrayList<String>();
        
        String t = "";

        t += "digraph H {\n\n";
        t += "\tparent [\n";
        t += "\t\tshape=plaintext\n";
        t += "\t\tlabel=<\n";
        t += "\t\t\t<table border='1' cellborder='1'>\n\n";

        t += "\t\t\t\t<tr>\n";
        t += "\t\t\t\t\t<td bgcolor = \"#EC8E5C\" colspan=\"1\" rowspan= \"2\">Estado</td>\n";
        t += "\t\t\t\t\t<td bgcolor = \"#EC8E5C\" colspan= \""+String.valueOf(sizeEncabezado()-1)+"\">Terminales</td>\n";
        t += "\t\t\t\t</tr>\n\n";

        ////////////////////////////////////////////////////////
        t += "\t\t\t\t<tr>\n";
        
        List<String> terminales = new ArrayList<String>();
        terminales.add("");
        for(transicion objec :listadoF) {
            
            if(termRep(terminales, objec.getSimbolo())){
                continue;
            }
            
            if(objec.getSimbolo().equals(" ")){
                t += "\t\t\t\t\t<td bgcolor = \"#F9D1E0\" >\" \"</td>\n";
                terminales.add(objec.getSimbolo());
                continue;
            }
            
            terminales.add(objec.getSimbolo());
            t += "\t\t\t\t\t<td bgcolor = \"#F9D1E0\" >"+ objec.getSimbolo() +"</td>\n";
        }
        t += "\t\t\t\t</tr>\n\n";

        ////////////////////////////////////////////////////////
        List<String> veri = new ArrayList<String>();
        for(transicion objec1 :listadoF) {
            
            if(repetidos.contains(objec1.getEstadoI())){
                continue;
            }
            
            /*if(auxRe(repetidos, objec1.getEstadoI())){
                continue;
            }*/
            
            repetidos.add(objec1.getEstadoI());
            
            //ESTADO
            t += "\t\t\t\t<tr>\n";
            if(objec1.isAcept()){
                t += "\t\t\t\t\t<td>*"+ objec1.getEstadoI()+ objec1.getSigEvaluar() +"</td>\n";
            }else{
                t += "\t\t\t\t\t<td>"+ objec1.getEstadoI()+ objec1.getSigEvaluar() +"</td>\n";
            }
                        
            t += AuxGr(objec1.getEstadoI(), terminales, veri);
            veri.add(objec1.getEstadoI());
            
            t += "\t\t\t\t</tr>\n\n";
        }
        ////////////////////////////////////////////////////////

        t += "\t\t\t</table>\n";
        t += "\t>];\n\n";

        t += "}";
        return t;
    }
    
    public void TablaTransiciones(String estadoI){
        String[] S0 = estadoI.split(",");// {1,2,3,4,5,6}
        SeleccionNodos(S0);
        System.out.println("\n\n");
        returnDatosFinales();
        System.out.println("\n\n--------GRAPHVIZ--------\n"+graphviz()+"\n");
    }
    
    
}










