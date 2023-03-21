package AFD_202103718;
import AFD_202103718.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class dbAFD {
    //LISTA QUE ALMACENARA TODOS LOS AFD DURANTE LA EJECUCION
    public static List<AFD> afds = new ArrayList<AFD>();
    public static List<String> listaRespuestaConsola = new ArrayList<String>();
    public static String salidaDeConsola = "";
    
    
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
    
    public static void validarCadena(String cadena, String nombreBusqueda){
        boolean caracterE = false;
        
        for(AFD afd: afds){
        
            if(!afd.getNombre().equals(nombreBusqueda)){
                continue;
            }
            
            String estado = afd.getEstadoI();
            
            for(char caracter: cadena.toCharArray()){
                String caracterSTR = "";
                
                if(caracter == '\\'){
                    caracterE = true;
                    continue;
                }

                boolean encontrado = false;

                for(String[] mapa : afd.getTransiciones().get(estado)){
                    String alfabeto = mapa[0];
                    String sig = mapa[1];

                    if(caracterE){
                        String caracterString = "\\"+String.valueOf(caracter);// ---->  \" \' \n
                        caracterSTR = caracterString;
                    }else{
                        caracterSTR = String.valueOf(caracter);
                    }
                    
                    if(!caracterSTR.equals(alfabeto)){
                        
                        // VERIFICARA SI EXISTE EN ALGUN CONJUNTO DEL HASH
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
                
                if(caracterE){
                    caracterE = false;
                }

                if (!encontrado){
                    salidaDeConsola = "Caracter invalido <"+caracter+">, no se puede hacer una transicion.";
                    System.out.println("Caracter invalido <"+caracter+">, no se puede hacer una transicion.");
                    break;
                }
            }

            if(!afd.getEstadosA().contains(estado)){
                salidaDeConsola = "Cadena invalida, no termina en el estado de aceptacion";
                System.out.println("cadena invalida, no termina en el estado de aceptacion");
            }else{
                salidaDeConsola = "La expresion: \""+cadena+"\", es valida con la expresion regular "+nombreBusqueda+".";
                System.out.println("cadena valida");
            }
        
        }
        listaRespuestaConsola.add(salidaDeConsola);
        salidaDeConsola = "";
    }
    
    public static List<String> muestraEnConsola(){
        return listaRespuestaConsola;
    }
    
}
//dbAFD.InsertAFD(objAFD);