package edu.usac.olc1.proyecto1;
import AFD_202103718.*;
import Analizador.DefConjuntos;
import AFD_202103718.dbAFD;
import java.util.*;
import Interfaz.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;
import TRANSICIONES_202103718.*;

public class Base {

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

    
    public static void SCanner(String cadena, AFD afd){
        
        String estado = afd.getEstadoI();
            for(char caracter: cadena.toCharArray()){

                boolean encontrado = false;

                for(String[] mapa : afd.getTransiciones().get(estado)){
                    String alfabeto = mapa[0];
                    String sig = mapa[1];

                    if(caracter != alfabeto.toCharArray()[0]){

                        // VERIFICARA SI EXISTE EN ALGUN CONJUNTO DEL HASH
                        boolean llaveExistente = afd.getConjuntos().containsKey(alfabeto);

                        if(llaveExistente){
                            List<String> arrayDeLlave = iterator(afd.getConjuntos(), alfabeto);

                            if(arrayDeLlave.contains(String.valueOf(caracter))){
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

                if (!encontrado){
                    System.out.println("Caracter invalido <"+caracter+">, no se puede hacer una transicion.");
                    break;
                }
            }

            if(!afd.getEstadosA().contains(estado)){
                System.out.println("cadena invalida, no termina en el estado de aceptacion");
            }else{
                System.out.println("cadena valida");
            }
    } 
    
    public static void insert(Map<String, List<String[]>> map, String key, List<String[]> entrada){
        if (map.containsKey(key)){
            map.get(key).addAll(entrada);
        } else {
            map.put(key, entrada);
        }
    }
 
    public static void main(String[] args)
    {
        
        
        
        
        
    }
    
    
    
    
    
}