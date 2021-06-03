import java.awt.*;
import java.util.ArrayList;
public class Dibujo_1
{
    public Dibujo_1()
    {
       
    }
//
   public void DbSiguiente(Graphics g){
       g.setColor(Color.red);
       for(int i=60;i<=240;i+=20){
           g.drawLine(380,i,560,i);
        }
       for(int i=380;i<=560;i+=20){
          g.drawLine(i,60,i,240);
        }
    }
    
   public void  DbFgSiguiente(Graphics g, int al){
       switch(al){
          case 0: 
            DbFigura(g,new L());
           break;
          case 1:
            DbFigura(g,new S());
            break;
          case 2:
            DbFigura(g,new T());
            break;
          case 3:
            DbFigura(g,new I());
            break;
          case 4:
            DbFigura(g,new J());
            break;
          case 5:
            DbFigura(g,new O());
            break;
          case 6:
            DbFigura(g,new Z());
            break;
          case 7:
            DbFigura(g,new C());
            break;
        }
      
    }
    
    //
    public void Figura(Graphics g,Figura f){
        g.setColor(f.getColor());
        for(int i=0;i<f.coordenadas.length;i++){
         //g.fillRect(f.getPosicionX()[i],f.getPosicionY()[i],19,19);
        g.fillRect(f.getCoordenadas()[i].getX(),f.getCoordenadas()[i].getY(),Dibujo.dm-1,Dibujo.dmy-1);
        }

    }
    
    public void figura(Graphics g,Punto p){
      g.setColor(p.getColor());
      
          g.fillRect(p.getX(),p.getY(),Dibujo.dm-1,Dibujo.dmy-1);
        
    }
    
    public void DbFigura(Graphics g,Figura f){
        g.setColor(f.getColor());
        for(int i=0;i<f.coordenadas.length;i++){

         int b=(f.coordenadas[i].getX()-21)/Dibujo.dm;
         f.coordenadas[i].setX(f.coordenadas[i].getX()-b*(Dibujo.dm-20));
         
         int a=((f.coordenadas[i].getY()-61)/Dibujo.dmy);
         f.coordenadas[i].setY(f.coordenadas[i].getY()-a*(Dibujo.dmy-20));
         
         int c=f.coordenadas[0].getY()-121;
         int d=441-f.coordenadas[0].getX();
         g.fillRect(f.getCoordenadas()[i].getX()+d,f.getCoordenadas()[i].getY()-c,19,19);
        }

    }
}
