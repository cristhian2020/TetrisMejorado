
/**
 * @author:Antonio Laime Ferrel
           Cristhian Rocha Ferrufino
           Alexander Maurcio Cepedes Molina
 */
import java.awt.*;
public class Figura
{
    protected Punto[] coordenadas;
    
    protected Color color;
    public Figura()
    {
        coordenadas=new Punto[4];
             
    }

   
    
    public Color getColor(){
      return color;
    }
    
   
    
    public void moverDerecha(){
        
     if(coordenadas[0].getX()+Dibujo.dm!=Dibujo.limiteDerecho&&coordenadas[1].getX()+Dibujo.dm!=Dibujo.limiteDerecho&&coordenadas[2].getX()+Dibujo.dm!=Dibujo.limiteDerecho&&coordenadas[3].getX()+Dibujo.dm!=Dibujo.limiteDerecho){
        for(int i=0;i<coordenadas.length;i++){
           coordenadas[i].setX(coordenadas[i].getX()+Dibujo.dm);
        }
        }
    }
    
    public void moverIzquierda(){
        
      if(coordenadas[0].getX()!=21&&coordenadas[1].getX()!=21&&coordenadas[2].getX()!=21&&coordenadas[3].getX()!=21){
        for(int i=0;i<coordenadas.length;i++){
           coordenadas[i].setX(coordenadas[i].getX()-Dibujo.dm);
        }
        }
     
    }  
    
    public void moverAbajo(){
        
      if(coordenadas[0].getY()!=661&&coordenadas[1].getY()!=661&&coordenadas[2].getY()!=661&&coordenadas[3].getY()!=661){
        for(int i=0;i<coordenadas.length;i++){
           coordenadas[i].setY(coordenadas[i].getY()+Dibujo.dmy);
        }
        }
     
    }  
    
    
     
    public void rotar(){}
    
    public Punto[] getCoordenadas(){
       return coordenadas;
    }
    
     public boolean esLimite(){
      boolean res=false;
      for(int i=0;i<coordenadas.length;i++){
          if(coordenadas[i].getX()==21 ||coordenadas[i].getX()==Dibujo.limiteDerecho){
           res=true;i=5;
          
        }
    }
    return res;
  }
}
