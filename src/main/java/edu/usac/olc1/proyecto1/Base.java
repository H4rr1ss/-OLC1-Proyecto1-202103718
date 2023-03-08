package edu.usac.olc1.proyecto1;

import Interfaz.Menu;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base {

    public static void main(String[] args) {
        String ca = "\"Maradona\"";
        int letra = ca.indexOf("\"",1); 
        String sSubCadena = ca.substring(1,letra);
        
        System.out.println(letra);
        System.out.println(sSubCadena);
        
    }
}

