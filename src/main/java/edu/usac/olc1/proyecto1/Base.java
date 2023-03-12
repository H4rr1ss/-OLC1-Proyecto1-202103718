package edu.usac.olc1.proyecto1;

import Interfaz.Menu;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import TRANSICIONES_202103718.*;

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
        /*Map<String, List<String>> colors = new HashMap<>();
 
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
                
        System.out.println("mapa impreso literalmente: "+parts);
        for (int i = 0; i<parts.length; i++){
            System.out.println(parts[i]);
        }
        System.out.println("-----------------------");
        boolean ve = false;
        for(Map.Entry<String, List<String>> mapa : colors.entrySet()){

            System.out.println(mapa.getValue());
            
            
        }*/

        // PRUEBAS PARA LA REALIZACION DE LA TABLA DE TRANSICIONES´
        
        // STRING OBJ->(STRING, LISTA)        
        List<String> p1 = new ArrayList<String>();
        p1.add("5");
        p1.add("6");
        List<String> p2 = new ArrayList<String>();
        p2.add("5");
        p2.add("6");
        List<String> p3 = new ArrayList<String>();
        p3.add("5");
        p3.add("6");
        List<String> p4 = new ArrayList<String>();
        p4.add("5");
        p4.add("6");
        List<String> p5 = new ArrayList<String>();
        p5.add("7");
        p5.add("8");
        List<String> p6 = new ArrayList<String>();
        p6.add("7");
        p6.add("8");
        List<String> p7 = new ArrayList<String>();
        p7.add("7");
        p7.add("8");
        List<String> p8 = new ArrayList<String>();
        p8.add("-");
                
        elementHash e1 = new elementHash("d", p1);
        elementHash e2 = new elementHash("b", p2);
        elementHash e3 = new elementHash("c", p3);
        elementHash e4 = new elementHash("a", p4);
        elementHash e5 = new elementHash("d", p5);
        elementHash e6 = new elementHash("b", p6);
        elementHash e7 = new elementHash("d", p7);
        elementHash e8 = new elementHash("#", p8);
        
        dbTablaTransicion objT = new dbTablaTransicion();
        objT.PROVISIONAL("1", e1);
        objT.PROVISIONAL("2", e2);
        objT.PROVISIONAL("3", e3);
        objT.PROVISIONAL("4", e4);
        objT.PROVISIONAL("5", e5);
        objT.PROVISIONAL("6", e6);
        objT.PROVISIONAL("7", e7);
        objT.PROVISIONAL("8", e8);
       

       
        //-----------------------------------------------------------------------
        
        String PrimeroRaiz = "1,2,3,4,5,6,";
        
        objT.TablaTransiciones(PrimeroRaiz);

       

/*
System.out.println("RESULTADO  " + ((Object)parts).getClass().getSimpleName());
*/



    }
}

