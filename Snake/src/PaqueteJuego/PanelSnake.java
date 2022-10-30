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

    
   private Color colorSerpiente= Color.blue; //color del tablero , usando la clase Color 
   private Color puntoComida=Color.RED; //color de la comida(punto) objetivo 
   private  int  maxtam; // maximo tamaño del panel
   private int tam; //tamaño de cada cuadrito del panel (tablero)
   private int cantidad; //cantidad de cuadritos
   private int res;
   private List<int[]> serpiente= new ArrayList<>();//lista de arreglos de enteros en donde guardaremos las coordenadas por donde recorrera la snake
   private int[] comida =new int[2]; //arreglo donde se guardara una coordenada para imprimir la comida
   private String direccion="der"; //variable para indicar la direccion por defecto va a la derecha
   
   
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
       generaComida();
       
   }
   
   //metodo paint servira para ir pintando y renderisando la imagen mientras la 
   //serpiente se mueve
   @Override
   public void paint(Graphics pintor){
       super.paint(pintor);//borramos lo pintado previamente y lo volvemos a pintar
       pintor.setColor(colorSerpiente); //asignamos el color a la serpiente
       //pintando la serpiente
       for(int i=0;i<serpiente.size();i++){//for para pintar cada celda que conformara nuestra serpiente
          pintor.fillRect(res/2+serpiente.get(i)[0]*tam,res/2+serpiente.get(i)[1]*tam,tam-1,tam-1);
       }
       
       //pintando la comida
       pintor.setColor(puntoComida);
       pintor.fillRect(res/2+comida[0]*tam,res/2+comida[1]*tam,tam-1,tam-1);
   }
   public void avance(){ //metodo para que la snake avance
       int [] ultimo=serpiente.get(serpiente.size()-1); //este capturara la cordenadas de cada movimiento del ultimo cuadro(cabeza)
       int agregarx=0;//coordenadas horizontales
       int agregary=0;//coordenadas verticales
       switch(direccion){ //switch para manipular los posibles movimientos de la serpiente
           case "der": agregarx=1; //si el movimiento es a la derecha el movimiento es positivo en las x
           break;
           case "izq": agregarx=-1;//si el movimiento es a la derecha el movimiento es negativo en las x
           break;
           case "arr": agregary=-1;//si el movimiento es a la derecha el movimiento es negativo en las y
           break;
           case "abj": agregary=1;//si el movimiento es a la derecha el movimiento es positivo en las y 
           break;
       }
       
       int[] nuevaposicion={Math.floorMod(ultimo[0]+agregarx,cantidad),
           Math.floorMod(ultimo[1]+agregary,cantidad)}; //es la nueva posicion que tendra el ultimo cuadrito(cabeza)
       serpiente.add(nuevaposicion); //pintamos el nuevo cuadrito para reflejar el movimiento
       serpiente.remove(ultimo);//borramos el cuadrito previo
   }
   
   public void generaComida(){//funcion que generara comida buscando coordenadas que no esten ocupadas por la serpiente de forma aleatoria
       boolean existe=false; //booleano que determinara si una celda o coordenada  ya esta ocupada o no
       int a= (int)(Math.random()*cantidad); //buscara en el eje de las x, Se castea porque se necesitan valores enteros forzosamente
       int b=(int)(Math.random()*cantidad);
       for(int i=0;i<serpiente.size();i++){ //recorremos la serpiente para ver cuales celdas estan ocupadas por la misma
           if(a==0 && b==1){
               existe=true;
               generaComida();
               break;
           }
       }
        
       if(!existe){
           this.comida[0]=a;
           this.comida[1]=b;
       }
   }
}


