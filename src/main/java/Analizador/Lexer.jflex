package Analizador;
import java_cup.runtime.*;
import ERRORES_202103718.*;
import java.util.LinkedList;

%%

%{
    public static LinkedList<usoER> TablaErr = new LinkedList<usoER>();
    public static String cadena="";
%}

%class Lexer
%cupsym sym
%cup
%public
%unicode
%line
%column
%ignorecase



CONJASCIII = (\!|\"|\#|\$|\%|\&|\'|\(|\)|\)|\*|\+|\,|\-|\.|\/|\:|\;|\<|\=|\>|\?|\@|\[|\\|\]|\^|\_|\`|\{|\||\})
CONJASCII = {CONJASCIII}\~{CONJASCIII}|{CONJASCIII}(\,{CONJASCIII})+


%init{
    yyline = 1;
    yychar = 1;
%init}

%eof{
    System.out.println("--------------------------->");
    System.out.println("ACA TERMINO EL ANALISIS LEXICO");
    
    
 
    for (int i = 0; i < TablaErr.size(); i++) {
        
        System.out.println("Error: <"+TablaErr.get(i).getDescipcion() + ">, linea"+TablaErr.get(i).getLinea()+", colu" + TablaErr.get(i).getColumna());
    }
    
    if (TablaErr.isEmpty()){
        System.out.println("ESTA VACIA, NO HAY ERRORES");
    }else{
        TablaErr.clear();
        cadena = "";
    }
    System.out.println("--------------------------->");

%eof}

%%

(\/\/[^\n\r]* | \<\![^\!\>]*\!\>) {/*Ignore*/}

<YYINITIAL> [a-z] {return new Symbol( sym.LETMIN, yyline, yycolumn, yytext()); }
<YYINITIAL> [A-Z] {return new Symbol( sym.LETMAY, yyline, yycolumn, yytext()); }
<YYINITIAL> [0-9]+ {return new Symbol( sym.DIG, yyline, yycolumn, yytext()); }
<YYINITIAL> {CONJASCII} {return new Symbol( sym.CONJASCII, yyline, yycolumn, yytext()); }
<YYINITIAL> (\\"n"|\\\'|"\\""\"")  {return new Symbol( sym.SIMB, yyline, yycolumn, yytext()); }
<YYINITIAL> \"([a-zA-Z_ ]|[0-9]|\\\"|[\| \# \$ \% \& \' \( \) \' \+ \, \- \. \/ \: \; \< \= \> \? \@ \[ \\ \] \^ \_ \{ \| \} \\])*\.?[0-9]*\" {return new Symbol( sym.STR, yyline, yycolumn, yytext()); }
<YYINITIAL> "CONJ" {return new Symbol(sym.NCONJ, yyline, yycolumn, yytext()); }
<YYINITIAL> [a-zA-Z][a-zA-Z_|0-9]* {return new Symbol( sym.VARIABLE, yyline, yycolumn, yytext()); }
<YYINITIAL> "{" {return new Symbol(sym.LLAVE_A, yyline, yycolumn, yytext()); }
<YYINITIAL> "," {return new Symbol(sym.COMA, yyline, yycolumn, yytext()); }
<YYINITIAL> ":" {return new Symbol(sym.DP, yyline, yycolumn, yytext()); }
<YYINITIAL> "-" {return new Symbol(sym.GUION, yyline, yycolumn, yytext()); }
<YYINITIAL> ">" {return new Symbol(sym.MAYOR, yyline, yycolumn, yytext()); }
<YYINITIAL> ";" {return new Symbol(sym.PC, yyline, yycolumn, yytext()); }
<YYINITIAL> "~" {return new Symbol(sym.TILDE, yyline, yycolumn, yytext()); }
<YYINITIAL> "." {return new Symbol(sym.CONCAT, yyline, yycolumn, yytext()); }
<YYINITIAL> "|" {return new Symbol(sym.DISYUN, yyline, yycolumn, yytext()); }
<YYINITIAL> "*" {return new Symbol(sym.KLEEN, yyline, yycolumn, yytext()); }
<YYINITIAL> "%" {return new Symbol( sym.PORCENT, yyline, yycolumn, yytext()); }
<YYINITIAL> "+" {return new Symbol(sym.S_MAS, yyline, yycolumn, yytext()); }
<YYINITIAL> "?" {return new Symbol(sym.S_UNA, yyline, yycolumn, yytext()); }
<YYINITIAL> "}" {return new Symbol(sym.LLAVE_C, yyline, yycolumn, yytext()); }

<YYINITIAL> [\n\r\t ]+ {  }







<YYINITIAL> [^]             {System.out.println("eesta entrando a los errores del sistema");
                usoER t = new usoER(1, "Error Lexico", yytext(), yyline, yycolumn); 
                System.out.println("ERRORR-------"+yytext()+"-------------");
                TablaErr.add(t); 
                
                // REPORTE DE ERRORES------
                String cadena = "";
                int m = 1;

                for (int i = 0; i < TablaErr.size(); i++) {
                    String ite = String.valueOf(m);
                    cadena += "    <tr>\n        <td>"+ite+"</td>\n"+		"        <td>"+ TablaErr.get(i).getTipoError() + "</td>\n"+		"        <td>"+TablaErr.get(i).getDescipcion()+"</td>\n"+		"        <td>"+TablaErr.get(i).getLinea()+"</td>\n"+		"        <td>"+TablaErr.get(i).getColumna()+"</td>\n    </tr>\n";
                    m++;
                }
                System.out.println("-1-1-1-1-1-");
                t.TablaDeErrores(cadena);
                }


