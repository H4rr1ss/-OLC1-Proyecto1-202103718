# GRAMATICA

### TERMINALES

| NOMBRE |           SIMBOLO         |      NOMBRE      |          SIMBOLO        |
| ------ | ------ | ------ | ------ |
| NCONJ | "CONJ" | PORCENT | "%" |
| LLAVE_A | "{" | S_MAS | "+" |
| DP | ":" | S_UNA | "?" |
| GUION | "-" | LLAVE_C | "}" |
| MAYOR | ">" | STR | \"([a-zA-Z_ ] \| [0-9]\|\\\\ )\\" |
| PC | ";" | SIMB | (\\"n"\|\\\'\|"\\\\""\\"\\") |
| CONCAT | "." | CONJASCII | Simbolos ASCII |
| DISYUN | "\|" | LETMAY | [A-Z] |
| KLEEN | "*" | LETMIN | [a-z] |
| VARIABLE | [a-zA-Z][a-zA-Z_ \| 0-9]* | TILDE | "~" |
| DIG | [0-9]+ | COMA | "," |

### NO TERMINALES


| NOMBRE |          NOMBRE        | NOMBRE |          NOMBRE        |
| ------ | ------ | ------ | ------ |
| INICIO | DEFER | LETRA | ARBOL |
| BODY | TESTER | SIMBOLODUAL | ER |
| AUXCONV | NOTACION | SIMBOLOUNITARIO |  |
| DEFCONJS | NOTACIONCONV | TERMINO |  |

### PRODUCCIONES

~~~
start -> INICIO


INICIO -> BODY

BODY -> LLAVE_A DEFCONJS DEFER PORCENT PORCENT PORCENT PORCENT TESTER LLAVE_C


DEFCONJS -> DEFCONJS NCONJ DP VARIABLE GUION MAYOR NOTACION PC
          | NCONJ DP VARIABLE GUION MAYOR NOTACION PC
          
NOTACION -> CONJASCII
          | LETMIN TILDE LETMIN
          | LETMAY TILDE LETMAY
          | DIG TILDE DIG
          | NOTACIONCONV
          
NOTACIONCONV -> AUXCONV LETRA
              | LETRA
              
AUXCONV -> AUXCONV LETRA COMA
         | LETRA COMA

LETRA -> LETMAY
       | LETMIN
       | DIG
       
        
DEFER -> DEFER VARIABLE GUION MAYOR ER PC
       | VARIABLE GUION MAYOR ER PC
        
ER -> SIMBOLODUAL ER ER
    | ARBOL

ARBOL -> SIMBOLOUNITARIO ER
       | TERMINO
   
SIMBOLOUNITARIO -> KLEEN
                 | S_MAS
                 | S_UNA
     
SIMBOLODUAL -> CONCAT
             | DISYUN
     
TERMINO -> SIMB
         | STR
         | LLAVE_A VARIABLE LLAVE_C


TESTER -> TESTER VARIABLE DP STR PC
        | VARIABLE DP STR PC
~~~