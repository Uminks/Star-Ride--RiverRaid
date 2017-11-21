
package Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que permite leer los datos en tiempo de ejecucion para ser escritos en el archivo.
 */
public class SaveScore {
    
    private PrintWriter escribir;
    private BufferedReader leer;
    private int []vecScore;
    private String []vecNombres;
    
    public SaveScore(String nombreNuevo, int scoreNuevo){
        
        try {
            escribir = new PrintWriter(new BufferedWriter(new FileWriter("top10.txt", true)));           
            escribir.println(nombreNuevo+"-"+scoreNuevo);
            escribir.close();
            
            leer();
            
        } catch (IOException ex) {
            System.out.println("No se pudo registrar en el archivo");
        }
        
    }
    
    private void leer(){
        String linea;
        StringTokenizer token;
        int cont=0;
  
        try {
            leer = new BufferedReader(new FileReader("top10.txt"));           
            while((linea=leer.readLine()) != null){                
                cont++;                               
            }           
            leer.close();
                    
        } catch (IOException ex) {
            System.out.println("No se pudo encontrar el archivo");
        }
        
        vecNombres = new String[cont];
        vecScore = new int[cont];
        
        cont=0;
        try {
            leer = new BufferedReader(new FileReader("top10.txt"));           
            while((linea=leer.readLine()) != null){
                
                token = new StringTokenizer(linea, "-"); 
                
                vecNombres[cont] = token.nextToken();
                vecScore[cont] = Integer.parseInt(token.nextToken());
                cont++;
            }           
            leer.close();
                    
        } catch (IOException ex) {
            System.out.println("No se pudo encontrar el archivo");
        }
        
        aplicarBurbuja();
    }
    
    
    private void aplicarBurbuja(){
        int temp;
        String aux;
        
        for (int i = 0; i < vecScore.length; i++) {
            System.out.println("");
            for (int j = 0; j < vecScore.length-1; j++) {
                
                if(vecScore[j] < vecScore[j+1]){
                    
                    temp = vecScore[j+1];
                    aux = vecNombres[j+1];
                    
                    vecScore[j+1] = vecScore[j];
                    vecNombres[j+1] = vecNombres[j];
                    
                    vecScore[j] = temp;
                    vecNombres[j] = aux;
                }
                
            }
            
        }
        
        
        escribirNuevoArchivo();
        
    }
    
    private void escribirNuevoArchivo(){
        try {
            
            escribir = new PrintWriter(new BufferedWriter(new FileWriter("top10.txt"))); 
            
            for (int i = 0; i < 10; i++) {
                
                escribir.println(vecNombres[i]+"-"+vecScore[i]);
            
            }
                       
            escribir.close();
               
        } catch (IOException ex) {
            System.out.println("No se pudo registrar en el archivo");
        } catch(java.lang.ArrayIndexOutOfBoundsException e){
            escribir.close();
        }
   
    }
    
}
