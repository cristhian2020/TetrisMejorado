/**
 * @author:Antonio Laime Ferrel
           Cristhian Rocha Ferrufino
           Alexander Maurcio Cepedes Molina
 */

import javax.swing.*;
import java.awt.Graphics.*;
import java.awt.event.*;
import java.awt.Image;
public class Tecla extends KeyAdapter 
{
    private boolean pausa=false;
  public Tecla(){
    
    }
    
    
 public void keyPressed(KeyEvent e){
   
     if(e.getKeyCode()==KeyEvent.VK_RIGHT){
          if(Dibujo.comprovarPuntoss()!=2 && Dibujo.comprovarPuntos()!=5)
          Dibujo.figura.moverDerecha();
        }
    
     if(e.getKeyCode()==KeyEvent.VK_LEFT){
          if(Dibujo.comprovarPuntoss()!=3 && Dibujo.comprovarPuntoss()!=5)
           Dibujo.figura.moverIzquierda();
        }
     
      if(e.getKeyCode()==KeyEvent.VK_DOWN){
          if(Dibujo.comprovarPuntos()!=1){
          Dibujo.figura.moverAbajo();
        }
        }
      if(e.getKeyCode()==KeyEvent.VK_UP){
          
         Dibujo.figura.rotar();
        }
        
      if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
         if(pausa){
         Dibujo.tiempo.stop();
         pausa=false;
        }else{
          Dibujo.tiempo.start();
          pausa=true;
        }
         
        }
         
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
          for(int i=0;i<50;i++){
           if(Dibujo.comprovarPuntos()!=1)
            Dibujo.figura.moverAbajo();
        }
        }
  }
    
    
}