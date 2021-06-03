
import java.awt.*;
public class C extends Figura
{
    
    public C()
    {
        color=new Color(10,100,23);
        
        coordenadas=new Punto[5];
        
       coordenadas[0]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm,Dibujo.limiteSuperior+Dibujo.dmy); 
       coordenadas[1]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm,Dibujo.limiteSuperior);
       coordenadas[2]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm+Dibujo.dm,Dibujo.limiteSuperior);
       coordenadas[3]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm,Dibujo.limiteSuperior+2*Dibujo.dmy);
       coordenadas[4]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm+Dibujo.dm,Dibujo.limiteSuperior+2*Dibujo.dmy);
       
    }

     public int estado(){
       int res=0;

              if(coordenadas[0].getY()-coordenadas[1].getY()>0)
              res=1;
             
              if(coordenadas[0].getY()-coordenadas[1].getY()<0)
              res=3;
              
              if(coordenadas[0].getX()-coordenadas[1].getX()>0)
             res=4;
             
             if(coordenadas[0].getX()-coordenadas[1].getX()<0)         
             res=2;
             
      return res;
    }
    
    public void rotar(){
       switch(estado()){
        case 1:
        if(!esLimite()){
            coordenadas[1].setX(coordenadas[1].getX()+Dibujo.dm);     coordenadas[1].setY(coordenadas[1].getY()+Dibujo.dmy);
            coordenadas[3].setX(coordenadas[3].getX()-Dibujo.dm);     coordenadas[2].setY(coordenadas[2].getY()+2*Dibujo.dmy);
            coordenadas[4].setX(coordenadas[4].getX()-2*Dibujo.dm);   coordenadas[3].setY(coordenadas[3].getY()-Dibujo.dmy);
        }
        
        break;
        case 2:
        if(!esLimite()){
            coordenadas[1].setX(coordenadas[1].getX()-Dibujo.dm);       coordenadas[1].setY(coordenadas[1].getY()+Dibujo.dmy);
            coordenadas[2].setX(coordenadas[2].getX()-2*Dibujo.dm);     coordenadas[3].setY(coordenadas[3].getY()-Dibujo.dmy);
            coordenadas[3].setX(coordenadas[3].getX()+Dibujo.dm);       coordenadas[4].setY(coordenadas[4].getY()-2*Dibujo.dmy);
        }
        
        break;
        case 3:
        if(!esLimite()){
            coordenadas[1].setX(coordenadas[1].getX()-Dibujo.dm);         coordenadas[2].setY(coordenadas[2].getY()-2*Dibujo.dmy);
            coordenadas[3].setX(coordenadas[3].getX()+Dibujo.dm);         coordenadas[3].setY(coordenadas[3].getY()+Dibujo.dmy);
            coordenadas[4].setX(coordenadas[4].getX()+2*Dibujo.dm);       coordenadas[1].setY(coordenadas[1].getY()-Dibujo.dmy);
        }
        
        break;
        case 4:
        if(!esLimite()){
            coordenadas[1].setX(coordenadas[1].getX()+Dibujo.dm);       coordenadas[1].setY(coordenadas[1].getY()-Dibujo.dmy);
            coordenadas[2].setX(coordenadas[2].getX()+2*Dibujo.dm);     coordenadas[3].setY(coordenadas[3].getY()+Dibujo.dmy);
            coordenadas[3].setX(coordenadas[3].getX()-Dibujo.dm);       coordenadas[4].setY(coordenadas[4].getY()+2*Dibujo.dmy);
        }
        
        break;
        }
        
        
    }
}
