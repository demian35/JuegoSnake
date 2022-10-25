/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteJuego;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author josed
 */
public class PanelSnake extends JPanel{

    
   private Color colorSerpiente= Color.cyan; //color del tablero , usando la clase Color 
   private Color puntoComida=Color.RED; //color de la comida(punto) objetivo 
   private  int  maxtam; // maximo tamaño del panel
   private int tam; //tamaño de cada cuadrito del panel (tablero)
   private int cantidad; //cantidad de cuadritos
   private int res;
   private List<int[]> serpiente= new ArrayList<>();//lista de arreglos de enteros en donde guardaremos las coordenadas por donde recorrera la snake
   private int[] comida; //arreglo donde se guardara una coordenada para imprimir la comida
   
   
   //constructor de nuestro panel recibiremos los atributos del panel
    
   public PanelSnake(int maxtam,int cantidad){
       this.maxtam=maxtam;
       this.cantidad=cantidad; 
       this.tam=maxtam/cantidad;
       this.res=maxtam%cantidad;
       int[] a={cantidad/2-1,cantidad/2-1};//Pares ordenados que marcaran la serpiente
       int[] b={cantidad/2,cantidad/2-1};//Par ordenado que marcara la comida
       serpiente.add(a);
       serpiente.add(b);
   }
   
   //metodo paint servira para ir pintando y renderisando la imagen mientras la 
   //serpiente se mueve
   @Override
   public void paint(Graphics pintor){
       super.paint(pintor);//borramos lo pintado previamente y lo volvemos a pintar
       pintor.setColor(colorSerpiente); //asignamos el color a la serpiente
       for(int i=0;i<serpiente.size();i++){//for para pintar cada arreglito que conformara nuestra serpiente
          pintor.fillRect(res/2+serpiente.get(i)[0]*tam,res/2+serpiente.get(i)[0]*tam,tam-1,tam-1);
       }
       
       
       
   }
}


