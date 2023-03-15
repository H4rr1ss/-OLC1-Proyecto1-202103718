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
        p1.add("3");
        p1.add("4");
        p1.add("5");
        p1.add("6");
        List<String> p2 = new ArrayList<String>();
        p2.add("3");
        p2.add("4");
        p2.add("5");
        p2.add("6");
        List<String> p3 = new ArrayList<String>();
        p3.add("3");
        p3.add("4");
        p3.add("5");
        p3.add("6");
        p3.add("7");
        List<String> p4 = new ArrayList<String>();
        p4.add("3");
        p4.add("4");
        p4.add("5");
        p4.add("6");
        p4.add("7");
        List<String> p5 = new ArrayList<String>();
        p5.add("3");
        p5.add("4");
        p5.add("5");
        p5.add("6");
        p5.add("7");
        List<String> p6 = new ArrayList<String>();
        p6.add("3");
        p6.add("4");
        p6.add("5");
        p6.add("6");
        p6.add("7");
        List<String> p7 = new ArrayList<String>();
        p7.add("8");
        p7.add("9");
        List<String> p8 = new ArrayList<String>();
        p8.add("8");
        p8.add("9");
        p8.add("10");
        List<String> p9 = new ArrayList<String>();
        p9.add("8");
        p9.add("9");
        p9.add("10");
        List<String> p10 = new ArrayList<String>();
        p10.add("11");
        List<String> p11 = new ArrayList<String>();
        p11.add("12");
        List<String> p12 = new ArrayList<String>();
        p12.add("13");
        List<String> p13 = new ArrayList<String>();
        p13.add("14");
        List<String> p14 = new ArrayList<String>();
        p14.add("-");       
        
        elementHash e1 = new elementHash("minuscula", p1);
        elementHash e2 = new elementHash("mayuscula", p2);
        elementHash e3 = new elementHash("simbolos", p3);
        elementHash e4 = new elementHash("minuscula", p4);
        elementHash e5 = new elementHash("mayuscula", p5);
        elementHash e6 = new elementHash("numero", p6);
        elementHash e7 = new elementHash("@", p7);
        elementHash e8 = new elementHash("minuscula", p8);
        elementHash e9 = new elementHash("mayuscula", p9);
        elementHash e10 = new elementHash(".", p10);
        elementHash e11 = new elementHash("c", p11);
        elementHash e12 = new elementHash("o", p12);
        elementHash e13 = new elementHash("m", p13);
        elementHash e14 = new elementHash("#", p14);
        
        dbTablaTransicion objT = new dbTablaTransicion();
        objT.PROVISIONAL("1", e1);
        objT.PROVISIONAL("2", e2);
        objT.PROVISIONAL("3", e3);
        objT.PROVISIONAL("4", e4);
        objT.PROVISIONAL("5", e5);
        objT.PROVISIONAL("6", e6);
        objT.PROVISIONAL("7", e7);
        objT.PROVISIONAL("8", e8);
        objT.PROVISIONAL("9", e9);
        objT.PROVISIONAL("10", e10);
        objT.PROVISIONAL("11", e11);
        objT.PROVISIONAL("12", e12);
        objT.PROVISIONAL("13", e13);
        objT.PROVISIONAL("14", e14);

       
        //-----------------------------------------------------------------------
        
        String PrimeroRaiz = "1,2,";
        
        //objT.returnDatos();
        
        String hola = ",";
        
        String[] S0 = hola.split(",");
        System.out.println("");
        
        objT.TablaTransiciones(PrimeroRaiz);

       

/*
System.out.println("RESULTADO  " + ((Object)parts).getClass().getSimpleName());
*/



    }
}

