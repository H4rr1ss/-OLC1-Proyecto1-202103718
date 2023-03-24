package AFD_202103718;
import AFD_202103718.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbAFD {
    //LISTA QUE ALMACENARA TODOS LOS AFD DURANTE LA EJECUCION
    private static List<AFD> afds = new ArrayList<AFD>();
    private static List<String> listaRespuestaConsola = new ArrayList<String>();
    private static List<String> ListaJsonSalida = new ArrayList<String>();
    private static String salidaDeConsola = "";
    
    
    public static void InsertAFD(AFD data){
        afds.add(data);
    }
    
    public static void cleanReporteJson(){
        ListaJsonSalida.clear();
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
    
    private static List<String> iterator(Map<String, List<String>> conjuntos, String alfabeto){
        int ite = 0;
        for(Map.Entry<String, List<String>> c: conjuntos.entrySet()){
            if(alfabeto.equals(c.getKey())){
                return c.getValue();
            }
             ite++;
        }
        return null;
    }
    
    private static boolean verificarEstadoAceptConSimb(String simbolo, AFD afd, String estado){
        for(String[] veri : afd.getTransiciones().get(estado)){
            String simb = veri[0];
            String sigu = veri[1];
            
            if(simb.equals(simbolo) && afd.getEstadosA().contains(sigu)){
                return true;
            }
        }
        return false;
    }
    
    
    private static boolean veriUltimoEstado (String simbolo, AFD afd, String estado, String sig){
        
        boolean confirmar = true;
        
        if(!verificarEstadoAceptConSimb(simbolo, afd, estado)){
           return false;
        }
         
        if(afd.getEstadosA().contains(sig)){
            confirmar = false;
        }
        
        return confirmar;
    }
    
    public static void validarCadena(String cadena, String nombreBusqueda){
        boolean caracterE = false;
        
        for(AFD afd: afds){
        
            if(!afd.getNombre().equals(nombreBusqueda)){ continue; }
            String estado = afd.getEstadoI();
            int recorridoCadena = 0;
            
            for(char caracter: cadena.toCharArray()){
                String caracterSTR = "";
                recorridoCadena++;
                
                if(caracter == '\\'){ caracterE = true; continue;}
                boolean encontrado = false;

                for(String[] mapa : afd.getTransiciones().get(estado)){
                    String alfabeto = mapa[0];
                    String sig = mapa[1];
                    
                    if(caracterE){
                        String caracterString = "\\"+String.valueOf(caracter);// ---->  \" \' \n
                        caracterSTR = caracterString;
                        
                    }else{caracterSTR = String.valueOf(caracter);}
                    
                    if(cadena.length() == recorridoCadena && veriUltimoEstado(alfabeto, afd, estado, sig)){ continue; }
                    
                    if(!caracterSTR.equals(alfabeto)){
                        
                        boolean llaveExistente = afd.getConjuntos().containsKey(alfabeto);

                        if(llaveExistente){
                            List<String> arrayDeLlave = iterator(afd.getConjuntos(), alfabeto);

                            if(arrayDeLlave.contains(caracterSTR)){
                                estado = sig;
                                encontrado = true;
                                break;
                            }
                        }

                        continue;
                    }

                    estado = sig;
                    encontrado = true;
                    break;
                }
                
                if(caracterE){ caracterE = false; }

                if (!encontrado){
                    ListaJsonSalida.add(cadena+","+nombreBusqueda+","+"Cadena Invalida");
                    salidaDeConsola = "\nCaracter invalido <"+caracter+">, no se puede hacer una transicion.";
                    break;
                }
            }

            if(salidaDeConsola.equals("")){
                if(!afd.getEstadosA().contains(estado)){
                    ListaJsonSalida.add(cadena+","+nombreBusqueda+","+"Cadena Invalida");
                    salidaDeConsola = "\nCadena \""+ cadena+"\" invalida, no termina en el estado de aceptacion";
                    
                }else{ salidaDeConsola = "\nLa expresion: \""+cadena+"\", es valida con la expresion regular "+nombreBusqueda+"."; ListaJsonSalida.add(cadena+","+nombreBusqueda+","+"Cadena Valida");}
            }
            
        
        }
        listaRespuestaConsola.add(salidaDeConsola);
        salidaDeConsola = "";
    }
    
    public static void jsonSalida(String nombre){
        int cont = 0;
        String json = "";
        
        json += "[\n";
        
        for( String cadena: ListaJsonSalida ){
            String[] cadenaSeparada = cadena. split(",");
            String str = cadenaSeparada[0];
            String ER = cadenaSeparada[1];
            String resultado = cadenaSeparada[2];
            String valor = "";
            
            if(str.indexOf("\"") != -1){
                valor = str.replace("\\", "\\\\\\");
            }else{
                valor = str.replace("\\", "\\\\");
            }
            
            if(ListaJsonSalida.size()-1== cont){
                json += "\t{\n";
                json += "\t\t\"Valor\": \""+valor+"\",\n";
                json += "\t\t\"ExpresionRegular\": \""+ER+"\",\n";
                json += "\t\t\"Resultado\": \""+resultado+"\"\n";
                json += "\t}\n";
                continue;
            }
            json += "\t{\n";
            json += "\t\t\"Valor\": \""+valor+"\",\n";
            json += "\t\t\"ExpresionRegular\": \""+ER+"\",\n";
            json += "\t\t\"Resultado\": \""+resultado+"\"\n";
            json += "\t},\n";
            cont++;
        }
        
        json += "]";
        
        int indice = nombre.indexOf("."); 
        String Fcadena = nombre.substring(0,indice);
        File archivo = new File("src/main/java/SALIDAS_202103718/"+Fcadena);
        
        try {
            PrintWriter salida = new PrintWriter(archivo+".json");
            salida.println(json);
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    public static List<String> muestraEnConsola(){
        return listaRespuestaConsola;
    }
    
    public static void cleanList(){
        listaRespuestaConsola.clear();
    }
    
}
//dbAFD.InsertAFD(objAFD);