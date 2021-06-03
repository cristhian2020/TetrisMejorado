
import java.awt.*;
public class Punto
{
    private int x;
    private int y;
    private Color color;
    public Punto(int X,int Y)
    {
      color=new Color((int)(Math.random()*230),(int)(Math.random()*230),(int)(Math.random()*230));
       x=X;
       y=Y;
       
    }
    public Punto(int X,int Y,int a)
    {
      color=new Color(a,a,a);
       x=X;
       y=Y;
       
    }
    public Color getColor(){
       return color;
    
    }
   public int getX(){
      return x;
    }
    
    public int getY(){
      return y;
    }
    
    public void setX(int a){
      x=a;
    }
    
    public void setY(int b){
      y=b;
    }
    
    public boolean equals(Punto p){
          boolean res=false;
       if(x==p.getX()&& y==p.getY())
         res=true;
       return res;
    }
}
