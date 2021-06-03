import javax.swing.*;
import java.io.*;
import java.util.*;
public class Txt
{
   private JFileChooser fc;
   private File archivo;

   private int p;
   private int n;
   private int cl;
   private int fl;
   private int fe;
   
   private ArrayList<Integer> x;
   private ArrayList<Integer>  y;
   private ArrayList<Punto>  lista;
    public Txt()
    {
        fc=new JFileChooser();
       // archivo=new File("");
       // fc.showOpenDialog(null);
       lista=new ArrayList<>();
     x=new ArrayList<>();
     y=new ArrayList<>();
    }

    public void abrirArchivo(){
     fc.showOpenDialog(null);
     archivo=fc.getSelectedFile();
     
          int i=0;
      try{
        Scanner sc=new Scanner(archivo);
        while(sc.hasNext()){
         if(i%2==0){
             x.add(Integer.parseInt(sc.next()));
             
             i++;
         }else{
           y.add(Integer.parseInt(sc.next()));

            i++;
            }
        }
        }catch(Exception e){
        }
        
    }
    
    public void guardarArchivo(){
        fc.showSaveDialog(null);
        archivo = new File(fc.getSelectedFile()+".txt");
        try{
    BufferedWriter salida = new BufferedWriter(new FileWriter(archivo));//archivo
    // Formatter guardar=new Formatter("listaPuntos.txt");
      //guardar.toString();
     //guardar.close();
     for(int i=0;i<Dibujo.puntos.size();i++){
       salida.write(""+Dibujo.puntos.get(i).getX()+" "+Dibujo.puntos.get(i).getY());
       salida.newLine();
     }
     salida.write(""+Dibujo.puntaje+" "+Dibujo.nivel+" "+Dibujo.cl+" "+Dibujo.f+" "+Dibujo.fila);
     
    salida.close();
    }catch(Exception e){}
    
    }
    public void puntos(){
        int c=0;
     for(int i=y.size()-1;i>y.size()-3;i--){
         if(c==0)
          { fl=y.get(i);cl=x.get(i);c++;} 
          else
           {n=y.get(i);p=x.get(i);}
          
        }
        fe=x.get(x.size()-1) ;
        
    }
    public void añadirPuntos(){
    
     for(int i=0;i<y.size()-2;i++){
        lista.add(new Punto(x.get(i),y.get(i)));
        }
    }
    
    
    public ArrayList<Punto> getLista(){
      return lista;
    }
    public int getPuntaje(){
        return p;
    }
    public int getNivel(){
        return n;
    }
    public int getColumna(){
        return cl;
    }
    public int getFila(){
        return fl;
    }
    public int getFilae(){
      return fe;
    }
    
}
