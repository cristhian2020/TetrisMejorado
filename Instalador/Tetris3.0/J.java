import java.awt.*;
public class J extends Figura
{
    
    public J()
    {
      
       color= new Color(0,0,0);
       
       
       coordenadas[0]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm,Dibujo.limiteSuperior+2*Dibujo.dmy);
       coordenadas[1]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm+(Dibujo.dm),Dibujo.limiteSuperior);
       coordenadas[2]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm+(Dibujo.dm),Dibujo.limiteSuperior+Dibujo.dmy);
       coordenadas[3]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm+(Dibujo.dm),Dibujo.limiteSuperior+2*Dibujo.dmy);
       
       
     
       
    }

    public void rotar(){
     switch(estado()){
       case 4:
          if(!esLimite()){
         
          
          coordenadas[1].setX(coordenadas[1].getX()-Dibujo.dm*3);  coordenadas[1].setY(coordenadas[1].getY()+Dibujo.dmy);
          coordenadas[2].setX(coordenadas[2].getX()-Dibujo.dm*2);  coordenadas[3].setY(coordenadas[3].getY()-Dibujo.dmy);
          coordenadas[3].setX(coordenadas[3].getX()-Dibujo.dm);  
         }
          break;  
       case 1:
           if(!esLimite()){
             
                            
          coordenadas[1].setX(coordenadas[1].getX()+Dibujo.dm);  coordenadas[1].setY(coordenadas[1].getY()+Dibujo.dmy*3);
          coordenadas[3].setX(coordenadas[3].getX()-Dibujo.dm);  coordenadas[2].setY(coordenadas[2].getY()+Dibujo.dmy*2);
                                                          coordenadas[3].setY(coordenadas[3].getY()+Dibujo.dmy);                  
         }
          break;  
          case 2:
          if(!esLimite()){
          
           
          coordenadas[1].setX(coordenadas[1].getX()+Dibujo.dm*3);  coordenadas[1].setY(coordenadas[1].getY()-Dibujo.dmy);
          coordenadas[2].setX(coordenadas[2].getX()+Dibujo.dm*2);  coordenadas[3].setY(coordenadas[3].getY()+Dibujo.dmy);
          coordenadas[3].setX(coordenadas[3].getX()+Dibujo.dm);
         }
          break;
        case 3:
          if(!esLimite()){
          
                             
          coordenadas[1].setX(coordenadas[1].getX()-Dibujo.dm);  coordenadas[1].setY(coordenadas[1].getY()-Dibujo.dmy*3);
          coordenadas[3].setX(coordenadas[3].getX()+Dibujo.dm);  coordenadas[2].setY(coordenadas[2].getY()-Dibujo.dmy*2);
                                                          coordenadas[3].setY(coordenadas[3].getY()-Dibujo.dmy);                    
         }
          break;
        }
        
      
    }
    
    public int estado(){
       int res=0;
        
          
              if(coordenadas[0].getY()-coordenadas[3].getY()>0)
              res=2;
             
              if(coordenadas[0].getY()-coordenadas[3].getY()<0)
              res=4;
              
              if(coordenadas[0].getX()-coordenadas[3].getX()>0)
             res=3;
             
             if(coordenadas[0].getX()-coordenadas[3].getX()<0)         
             res=1;
      return res;
    }
}