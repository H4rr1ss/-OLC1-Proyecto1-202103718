package edu.usac.olc1.proyecto1;

import Interfaz.Menu;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base {

    public static void insert(Map<String, List<String>> map, String key, List<String> value) {
        if (map.containsKey(key)){
            map.get(key).addAll(value);
        } else {
            map.put(key, value);
        }
    }
 
    public static void main(String[] args)
    {
        Map<String, List<String>> colors = new HashMap<>();
 
        colors.put("harry", new ArrayList<>(Arrays.asList("trabajador")));
        colors.put("White", new ArrayList<>(Arrays.asList("#FFFFFF", "#ffffff")));
        colors.put("Red", new ArrayList<>(Arrays.asList("#FF0000", "#ff0000")));
 
        insert(colors, "harry", Arrays.asList("albañil"));
        insert(colors, "harry", Arrays.asList("locutor"));
        insert(colors, "White", Arrays.asList("#lol", "#ar"));
        
        System.out.println(colors);
        
        
        String cadenaEntrada = "1,2,3,";
        String[] parts = cadenaEntrada.split(",");
        String part1 = parts[0]; // 123
        String part2 = parts[1]; // 654321
                
        /*for (int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);
        }*/
        System.out.println("mapa impreso literalmente: "+parts);
        for (int i = 0; i<parts.length; i++){
            System.out.println(parts[i]);
        }
        System.out.println("-----------------------");
        boolean ve = false;
        for(Map.Entry<String, List<String>> mapa : colors.entrySet()){

            System.out.println(mapa.getValue());
            
            
        }
        
        /*
        if (mapa.getKey().equals("harry")){
                for (int i = 0; i < mapa.getValue().toArray().length; i++){
                    //System.out.println(mapa.getValue().toArray()[i]);
                    if(mapa.getValue().toArray()[i].equals("trabajador")){
                        ve = true;
                        break;
                    }
                }
                
                break;
            }
        */
        
        System.out.println(ve);
        System.out.println("RESULTADO  " + ((Object)parts).getClass().getSimpleName());
        
    }
}







