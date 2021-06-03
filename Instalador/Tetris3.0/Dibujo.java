import java.awt.*;
import javax.swing.*;
import javax.swing.Timer.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Dibujo extends JPanel implements ActionListener

{
    
    static Timer tiempo;
    private int retrazo=1000;
    private boolean abajo=true;
    static int cl=10;
    static int f;

    
    private ArrayList<Figura> figuras;
    static ArrayList<Punto> puntos;
   // private ArrayList<Punto> auxiliar;
   // private ArrayList<Integer> puntosY;
    static int dm=30;
    static int dmy;
    static Figura figura;//=new I();
        
    private int al=1;
    static int puntaje=0;
    static int nivel=0;
    private Dibujo_1 c;
    
    //private Archivo txt;
    
    private double cronometro=0;
    private int segundos=0;
    private int minutos=0;
    
    static int fila=0;
    
    
    static int limiteSuperior;
    static int limiteDerecho;
    static int limiteIzquierdo;
    
      public Dibujo(int n,int cl,int f){
      // txt=new Archivo();
       this.cl=cl;
        this.f=f;
        nivel=n;
        limiteIzquierdo=21;
        dm=300/cl;
        dmy=600/f;
        limiteDerecho=dm*cl+limiteIzquierdo;
        limiteSuperior=661-dmy*f;
      
       puntos=new ArrayList<Punto>();

       figura=new I();
       c=new Dibujo_1();
       setFocusable(true);


      setFocusTraversalKeysEnabled(false);
      setRequestFocusEnabled(true);
      tiempo=new Timer(retrazo,this);
      tiempo.start();
      
      figuras=new ArrayList<Figura>();
      addKeyListener(new Tecla());
      figuras.add(figura);
      añadirPuntos();
      nivel=n;
    }
    public Dibujo(ArrayList<Punto> p,int pt,int ni,int cl,int f,int fe){
      puntos=p;
      puntaje=pt;
      nivel=ni;
      fila=fe;
      this.cl=cl;
      this.f=f;
      limiteIzquierdo=21;
        dm=300/cl;
        dmy=600/f;
        limiteDerecho=dm*cl+limiteIzquierdo;
        limiteSuperior=661-dmy*f;
      
      
      figura=new L();
      //txt=new Archivo();
       //puntos=new ArrayList<Punto>();

       c=new Dibujo_1();
       setFocusable(true);


      setFocusTraversalKeysEnabled(false);
      setRequestFocusEnabled(true);
      tiempo=new Timer(retrazo,this);
      tiempo.start();
      
      figuras=new ArrayList<Figura>();
      addKeyListener(new Tecla());
      figuras.add(figura);
      añadirPuntos();
    }
  public void paint(Graphics g){
     
      g.setColor(Color.white);
      g.fillRect(20,60,dm*cl,601);
      g.setColor(Color.black);
      //Dibujando lineas en Vertical
      for(int i=20;i<=limiteDerecho-1;i=i+dm){
         g.drawLine(i,limiteSuperior-1,i,660);
        }
        
      //Dibujando lineas en Horizontal
      for(int j=limiteSuperior-1;j<=661;j=j+dmy){
          g.drawLine(20,j,limiteDerecho-1,j);
        }
      
      //Dibujando la parte donde se podra ver la siguiente figura
      g.setColor(Color.white);
      g.fillRect(340,20,240,260);
      
      //Dibujando la parte donde estara el puntaje y el nivel
      g.fillRect(340,320,240,340);
      g.setColor(Color.red);
      g.setFont(new Font("forte",Font.PLAIN,25));
      g.drawString("Siguiente Figura",370,40);
      
      //Dibuja la matriz de la figura siguiente
      c.DbSiguiente(g);
      c.DbFgSiguiente(g,al);
      
      //Dibujando los puntos y el nivel
       g.setColor(Color.black);
       g.setFont(new Font("forte",Font.PLAIN,20));
       g.drawString("Tus Puntos:  "+ puntaje ,350,400);
       g.drawString("Tu Nivel: "+nivel,350,500);  
      g.drawString("Filas: "+fila,350,550);
       
       //Tiempo
       cronometro+=retrazo;
       if(cronometro>0&&cronometro<60000){
           segundos=(int)cronometro/1000;      
        }else{
          segundos=(int)cronometro%60000/1000;
          minutos=(int)(cronometro/60000);
        }
       g.drawString(""+minutos+":"+segundos,380,600); 
       
       if(retrazo<100){
         retrazo=100;
        }
       tiempo.setDelay(retrazo);
       
       
       //Titulo del juego
       g.setColor(Color.white);
       g.setFont(new Font("forte",Font.PLAIN,40));
       g.drawString("TETR¡S  " ,100,40);
      

        
       //dibujando tadas las figuras que salieron 
        for(int i=0;i<puntos.size();i++){
          c.figura(g,puntos.get(i));
        }
        


         //Mensaje para cuando se pierde en el juego
       if(gameOver()){
         g.setColor(Color.red);
          g.setFont(new Font("forte",Font.PLAIN,40));
         g.drawString("Game Over!!",70,250);
         tiempo.stop();
        }

    //dibujamos la figura con su color*/
       c.Figura(g,figura);
       //Guardamos los puntos y niveles
      // txt.guardarArchivo(puntos);
      // txt.guardarPuntos(puntaje,nivel,cl,f);
       g.dispose();

    }
     
    public void actionPerformed(ActionEvent e){
    
        
        
        //mientras el booleano "abajo" sea verdadero la figura cambiara de posicion en el eje Y

        if(abajo){
            eliminar();

            if(comprovarPuntos()==1){
             //eliminar();
             figuras.add(figura);
             
            añadirPuntosFigura(figura);
            
           if(nivel>=3&&dm>=30){
           //puntos.clear();
           int dma=dm;
           int dmay=dmy;
           cl=15;
           f=f+5;
           dm=300/cl;
           dmy=600/f;
           limiteDerecho=dm*cl+limiteIzquierdo;
           limiteSuperior=661-dmy*f;
           reducir(dma,dmay);
           //dm=20;cl=15;
           //reducir();
           //dm=20;cl=15;
           añadirPuntos();
           }
           
           if(nivel>=6&&dm>=20){
           //puntos.clear();
           int dma=dm,dmay=dmy;
           cl=20;
           f=f+5;
           dm=300/cl;dmy=600/f;
           limiteDerecho=dm*cl+limiteIzquierdo;
           limiteSuperior=661-dmy*f;
           reducir(dma,dmay);
           //dm=15;cl=20;
           //reducir1();
           añadirPuntos();
           }
           
           if(nivel>=9&&dm>=15){
               int dma=dm,dmay=dmy;
               cl=30;
               f=f+5;
            dm=300/cl;dmy=600/f;
            limiteDerecho=dm*cl+limiteIzquierdo;
           limiteSuperior=661-dmy*f;
              reducir(dma,dmay); 
           //puntos.clear();   
           //dm=10;cl=30;
           añadirPuntos();
           }
           
         
           
           switch(al){
            case 0:
                figura=new L(); 
               
              break;
            case 1:
                 figura=new S();
                
              break;
            case 2:
                figura=new T();
               
                break;
             case 3:
                 figura=new I();
                
                 break;
            case 4:
                 figura=new J();
                
                 break;
            case 5:
                 figura=new O();
                
                 break;
            case 6:
                 figura=new Z();
                
                 break;
            case 7:
                 figura=new C();
                
                 break;
                 
            }
            al=(int)(Math.random()*8); 
          }
         figura.moverAbajo();
          repaint();
        }
    }
    
    public void añadirPuntos(){
      
       for(int i=21;i<=limiteDerecho;i+=dm){
         puntos.add(new Punto(i,661,0));
        }
    }
    public void añadirPuntosFigura(Figura f){
           for(int i=0;i<f.coordenadas.length;i++){
                puntos.add(f.getCoordenadas()[i]);
                
            }
    }
   
    static int   comprovarPuntos(){
       int  res =0;
       
       
         for(int j=0;j<puntos.size();j++){
          for(int i=0;i<4;i++){
              if(figura.getCoordenadas()[i].getY()+dmy==puntos.get(j).getY() && figura.getCoordenadas()[i].getX()==puntos.get(j).getX()){
                 res=1;j=puntos.size();i=4;
                }
            
           }
        }
        
        return res ;                           
    }
    static int   comprovarPuntoss(){
       int  res =0;
       
       
         for(int j=0;j<puntos.size();j++){
          for(int i=0;i<4;i++){
             if(figura.getCoordenadas()[i].getY()==puntos.get(j).getY() && figura.getCoordenadas()[i].getX()+dm==puntos.get(j).getX()
                && figura.getCoordenadas()[i].getY()==puntos.get(j).getY() && figura.getCoordenadas()[i].getX()==puntos.get(j).getX()+dm){
                  
                  res=5;j=puntos.size();i=4;
                }
              if(figura.getCoordenadas()[i].getY()==puntos.get(j).getY() && figura.getCoordenadas()[i].getX()+dm==puntos.get(j).getX()
                ){
                 res=2;j=puntos.size();i=4;
                }
             else 
              if(figura.getCoordenadas()[i].getY()==puntos.get(j).getY() && figura.getCoordenadas()[i].getX()==puntos.get(j).getX()+dm
                ){
                 res=3;j=puntos.size();i=4;
                }
            
           }
        }
        
        return res ;                           
    }
    
   public boolean compararPuntos(Punto p){
    boolean res=false;
         for(int i=0;i<puntos.size();i++){
              if(p.equals(puntos.get(i))){
               res=true;i=puntos.size();
            }
            }
       
    return res;
    }
    
  public void eliminar(){
     for(int i=661-dmy;i>=21;i=i-dmy){
          if(compararPuntos(new Punto(21,i))){
              eliminarFila(i);
             
            }
            
        }
    }
    
  public void  eliminarFila(int x){
      int d=0,b=0;
    for(int i=21;i<=limiteDerecho-dm;i+=dm){
         if(compararPuntos(new Punto(i,x))){
             d++;
         }else{
            i=500;
            }
     }
    if(d==cl){
       
    for(int j=21;j<=321-dm;j+=dm){
       b=buscarInd(new Punto(j,x)) ;//Punto p=new Punto(j,x);
        puntos.remove(b);
        
     }
    retrazo=retrazo-100;
     bajar(x);
     fila++;
     puntaje +=50;
     if(puntaje%100==0)
          nivel++;
     
         
    }
    }  
    
   public int buscarInd(Punto p){
        int res=0;
      for(int i=0;i<puntos.size();i++){
          
         if(p.equals(puntos.get(i))){
              res=i;i=puntos.size();
            }
        }
        return res;
    }
    
    
    public void bajar(int a){
      for(int i=0;i<puntos.size();i++){
           if(puntos.get(i).getY()<a){
             puntos.get(i).setY(puntos.get(i).getY()+dmy);
            }
        }
    }
    
    public boolean gameOver(){
     boolean res=false;
         for(int i=0;i<puntos.size();i++){
             if(puntos.get(i).getY()==limiteSuperior+dmy){
                 res=true;i=puntos.size();
                }
            }
        
     return res;
    }
  public void reducir(int dx,int dy ){
     // auxiliar=puntos;
     for(int i=0;i<puntos.size();i++){
         
         int b=(puntos.get(i).getX()-21)/dx;
         puntos.get(i).setX(puntos.get(i).getX()-b*(dx-dm));
         
        
        int a=0;
        a=(661-puntos.get(i).getY())/dy;
        puntos.get(i).setY(puntos.get(i).getY()+a*(dy-dmy));
         
        }
    }
 
}
