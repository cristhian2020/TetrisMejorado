import java.awt.*;
public class O extends Figura
{
    
    public O()
    {

       color= new Color(123,45,200);
       
      coordenadas[0]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm,Dibujo.limiteSuperior);
       coordenadas[1]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm+Dibujo.dm,Dibujo.limiteSuperior);
       coordenadas[2]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm,Dibujo.limiteSuperior+Dibujo.dmy);
       coordenadas[3]=new Punto(21+(Dibujo.cl/2)*Dibujo.dm+Dibujo.dm,Dibujo.limiteSuperior+Dibujo.dmy);
       
       
       
    }

    

}