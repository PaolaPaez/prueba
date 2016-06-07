esto es un comentario para hacer pruebas




/**
 * @(#)a_Lexico.java
 *
 * a_Lexico application
 *
 * @author Erik A.G.G. 
 * @version 1.00 2015/2/1
 */
 import java.io.*;
import java.lang.Integer;
import java.util.*;

public class a_Lexico {
 int mat_Trans[][];
 String PR[];
 public a_Lexico(){
  	 mat_Trans= new int[40][20];
  	PR=new String [8];
  	PR[0]="Inicio";
  	PR[1]="Fin";
  	PR[2]="Escribir";
  	PR[3]="Leer";
  	PR[4]="Si";
  	PR[5]="Sino";
  	PR[6]="Para";
  	PR[7]="Mientras";
  	}
    
public void lee_Matriz() {
    String s,s1,s2;
    int i=1,j=1,tam=0;
 try{
     BufferedReader br = new BufferedReader (new FileReader ("MT2.txt"));
    while((s1 = br.readLine()) != null){
          j=1;
          StringTokenizer st = new StringTokenizer (s1);
          while (st.hasMoreTokens()){
                s2 = st.nextToken();
                mat_Trans[i][j]=Integer.valueOf(s2);
                j++;
                }
          i++;
          }//while
     System.out.println ();
     br.close();
         }catch(Exception e){System.out.print(e);}
	}//LEE_MATRIZ

public int checa(char car){
	String letra = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String digito = "0123456789";
   	String cadena= (new StringBuffer().append(car)).toString();
	//System.out.println (cadena);
	if(letra.contains(cadena)){return 1;}
	else
	if(digito.contains(cadena)){return 2;	}
		else
	if(car=='.'){return 3;}
      else	
	if(car=='<'){return 4;}
      else
    if(car=='>'){return 5;}
      else
    if(car=='+'){return 6;}
      else
    if(car=='-'){return 7;}
      else
    if(car=='/'){return 8;}
      else
    if(car=='*'){return 9;}
      else
    if(car=='('){return 10;}
      else
    if(car==')'){return 11;}
      else
    if(car==','){return 12;}
      else
    if(car==';'){return 13;}
      else
    if(car=='='){return 14;}
      else
    if(car=='"'){return 15;}
      else
    if(car=='\''){return 16;}
      else
    if(car=='['){return 17;}
      else
    if(car==']'){return 18;}
     
       else return 19;      
    
    }

public int esPR(String cadena){
	int ban=0,i=0;
	while(ban!=1&&i<8){
		 if(PR[i].equals(cadena)){
			ban=1;
			}
		 else{i++;}
		}/// while
     if(ban==1){return 1;}
     else return 0;
	 }

public void imprime(String cadena, int estado){
	switch(estado){
		case 3:
			if(esPR(cadena)==1){
			System.out.println ("( PALABRA RESERVADA , "+cadena+" )");
			}
			else
			System.out.println ("( IDENTIFICADOR , "+cadena+" )");
		break;
		case 5:
			System.out.println ("( ENTERO , "+cadena+" )");
		break;
		case 8:
			System.out.println ("( REAL , "+cadena+" )");
		break;
		case 10:
			System.out.println ("( DIFERENTE , "+cadena+" )");
		break;
		case 11:
			System.out.println ("( MENOR IGUAL, "+cadena+" )");
		break;
		case 13:
			System.out.println ("( ASIGNACION , "+cadena+" )");
		break;
		case 14:
			System.out.println ("( MENOR , "+cadena+" )");
		break;
		case 15:
			System.out.println ("( MENOR , "+cadena+" )");
		break;
		case 17:
			System.out.println ("( MAYOR IGUAL , "+cadena+" )");
		break;
		case 18:
			System.out.println ("( MAYOR , "+cadena+" )");
		break;
		case 20:
			System.out.println ("( DIVISION , "+cadena+" )");
		break;
		case 21:
			System.out.println ("( COMENTARIO , "+cadena+" )");
		break;
		case 23:
			System.out.println ("( COMENTARIO MULTILINEA , "+cadena+" )");
		break;
		case 25:
			System.out.println ("( CADENA , "+cadena+" )");
		break;
		case 27:
			System.out.println ("( CARACTER , "+cadena+" )");
		break;
		case 30:
			System.out.println ("( ARREGLO , "+cadena+" )");
		break;
		case 33:
			System.out.println ("( ESTRUCTURA DE SECUENCIA , "+cadena+" )");
		break;
		case 34:
			System.out.println ("( SUMA , "+cadena+" )");
		break;
		case 35:
			System.out.println ("( RESTA , "+cadena+" )");
		break;
		case 36:
			System.out.println ("( MULTIPLICACION , "+cadena+" )");
		break;
		case 37:
			System.out.println ("( COMA , "+cadena+" )");
		break;
		case 38:
			System.out.println ("( PUNTO Y COMA , "+cadena+" )");
		break;
		case 39:
			System.out.println ("( IGUAL , "+cadena+" )");
		break;
		default:
			break;
		}//switch
	     }

	public void lee_Pseudo() {
 String s,s1,s2="";char a;
    int i=1,j=0,tam=0,linea=1,col=0,estado=1,ban=0,ban2=0,ban3=0;
  try{
      BufferedReader br = new BufferedReader (new FileReader ("entrada.txt"));
      String cadena="";
      while((s1 = br.readLine()) != null&&ban2!=1){ j=0;ban=0;s2="";estado=1;
           tam=s1.length();
           while(j<tam&&ban2!=1){ban=0;s2="";estado=1;
      
           while(j<tam&&ban!=1&&ban2!=1){ 
           a=s1.charAt(j);
           col=checa(s1.charAt(j));
           estado=mat_Trans[estado][col];
         
           if(mat_Trans[estado][col]==0){System.out.println ("error en linea"+linea);ban2=1;}
           else
           if(mat_Trans[estado][col]==-1){
           if(s2.length()>=1){
           cadena= (new StringBuffer().append(a)).toString();
           s2=s2.concat(cadena);
           imprime(s2 , estado);
           estado=1;
           s2="";
           ban=1;
           }
        else{
         cadena= (new StringBuffer().append(a)).toString();
         imprime(cadena , estado);
         estado=1;
         s2="";
         ban=1;
        }
        }
        else  
        if(mat_Trans[estado][col]==-2){
            imprime(s2,estado);
          	estado=1;
            s2="";
            j=j-1;
            ban=1;
           }
           else
           	if(mat_Trans[estado][col]==-3){
            imprime("<",estado);	
          	estado=1;
            s2="";
            j=j-2;
            ban=1;
           }//IF
           	else
            cadena= (new StringBuffer().append(a)).toString();
            s2=s2.concat(cadena);
           j++;
        if(j==tam){
        col=checa('$');
        estado=mat_Trans[estado][col];
        imprime(s2,estado);	
        	}//if
          }
        }//// while
        linea++;
          }
     br.close();
         }catch(Exception e){System.out.print(e);}
	}//LEE PSEUDO

 public static void main(String[] args) {
    	a_Lexico obj = new a_Lexico();
        obj.lee_Matriz();
        obj.lee_Pseudo();
       
       }
       }

  /*     System.out.println ("    MATRIZ DE TRANSICION    ");
        for(i=1;i<=32;i++){
         	System.out.println ();
           for(j=1;j<=20;j++){
             System.out.print (" "+mat_Trans[i][j]);
           }
         }*/