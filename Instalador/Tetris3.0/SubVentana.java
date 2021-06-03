
import java.util.*;
import javax.swing.*;
import java.awt.*; 
public class SubVentana extends JFrame{    

    public SubVentana(int n,int f,int c){
       // super("true");
        add(new Dibujo(n,c,f));
        setBackground(Color.black);
        setSize(607,703);
       setLocationRelativeTo(null);
       setResizable(false);
       //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setVisible(true);
    }
    
    public SubVentana(ArrayList<Punto> a,int p,int n,int cl,int f,int fe ){
       // super("true");
        add(new Dibujo(a,p,n,cl,f,fe));
        setBackground(Color.black);
        setSize(607,703);
       setLocationRelativeTo(null);
       setResizable(false);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setVisible(true);
    }
}
