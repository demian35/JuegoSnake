/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteJuego;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author josed
 * Clase del panel donde se a allevar a cabo el juego
 */
public class PanelTablero extends JPanel{
    
   private Color fondo= Color.green; //color del tablero , usando la clase Color 
   private  int  maxtam; // maximo tamaño del panel
   private int tam; //tamaño de cada cuadrito del panel (tablero)
   private int cantidad; //cantidad de cuadritos
   private int res;
   
   //constructor de nuestro panel recibiremos los atributos del panel
    
   public PanelTablero(int maxtam,int cantidad){
       this.maxtam=maxtam;
       this.cantidad=cantidad; 
       this.tam=maxtam/cantidad;
       this.res=maxtam%cantidad;
   }
   
   //metodo paint servira para ir pintando y renderisando la imagen mientras la 
   //serpiente se mueve
   @Override
   public void paint(Graphics pintor){
       super.paint(pintor);//borramos lo pintado previamente y lo volvemos a pintar
       pintor.setColor(fondo); //pintamos el fondo
       //pintaremos los renglones y columnas en el tablero con dos for anidados
       for(int i=0; i<cantidad;i++){//pintamos los renglones horizontales eje x
           for(int j=0; j<cantidad; j++){//pintamos las columnas verticales eje y
               pintor.fillRect(res/2+i*tam, res/2+j*tam, tam-1, tam-1);
           }
       }
   }
}
