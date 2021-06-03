import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import com.sun.jdi.*;
public class Dibujar extends JPanel
{
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private SpinnerModel v1;
    private JSpinner Sniveles;
    public Dibujar()
    {
        setLayout(null);
        
       boton1=new JButton("JUGAR");
       boton1.setBounds(123,200,100,40);
       boton1.setBackground(Color.white);
       boton1.setFont(new Font("Impact",Font.PLAIN,20));
       add(boton1);
       
       boton2=new JButton("SALIR");
       boton2.setBounds(123,520,100,40);
       boton2.setFont(new Font("Impact",Font.PLAIN,20));
       add(boton2);
       
       boton3=new JButton("CONTINUAR");
       boton3.setBounds(103,300,150,40);
       boton3.setBackground(Color.white);
       boton3.setFont(new Font("Impact",Font.PLAIN,20));
       add(boton3);
       
       v1 = new SpinnerNumberModel(0,0,10,1);   
        Sniveles =   new JSpinner(v1);   
        Sniveles.setBounds(163,400,50,30);    
        add(Sniveles);    
        setLayout(null);    
        setVisible(true); 
        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Impact",Font.PLAIN,20));
        label.setSize(183,825); 
        label.setText("Nivel: " );
        add(label); 
        
        SpinnerModel v2 = new SpinnerNumberModel(20,8,25,1);   
        JSpinner sFilas=   new JSpinner(v2);   
        sFilas.setBounds(163,430,50,30);    
        add(sFilas);    
        setLayout(null);    
        setVisible(true); 
        final JLabel l2 = new JLabel();
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setFont(new Font("Impact",Font.PLAIN,20));
        l2.setSize(143,885); 
        l2.setText("Numero De Filas: " );
        add(l2); 
        
        SpinnerModel v3 = new SpinnerNumberModel(10,7,20,1);   
        JSpinner sColumnas=   new JSpinner(v3);   
        sColumnas.setBounds(163,460,50,30);    
        add(sColumnas);    
        setLayout(null);    
        setVisible(true); 
        final JLabel l3 = new JLabel();
        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setFont(new Font("Impact",Font.PLAIN,20));
        l3.setSize(143,945); 
        l3.setText("Numero De Columnas: " );
        add(l3); 
       
        //Permite abrir la clase subVEntentana,al boton se le asigna
        // un evento que permite realizar la apertura de del Frame
        boton1.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent e)
                {
                   SubVentana sv = new SubVentana((int)Sniveles.getValue(),(int)sFilas.getValue(),(int)sColumnas.getValue());
                    sv.setVisible(true); 
                    //setVisible(false);
                    //System.exit(-1); 
                    //this.dispose();
                }
            });
        //Terpermite cerrar la ventana principal y todas las ventanas    
        boton2.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent e)
                {
                    if(e.getSource() == boton2){
                     
                     
                    
                   // Archivo ar=new Archivo();
                  
                   // ar.Menu();
                    Txt tex=new Txt();
                    tex.guardarArchivo();
    
                 }
                    System.exit(0);
                }
            });      
            
            boton3.addActionListener(new ActionListener()
            { 
                public void actionPerformed(ActionEvent e)
                {
                   // Archivo ar=new Archivo();
                    Txt txt=new Txt();
                    txt.abrirArchivo();
                    txt.añadirPuntos();
                    txt.puntos();
                    SubVentana sv = new SubVentana(txt.getLista(),txt.getPuntaje(),txt.getNivel(),txt.getColumna(),txt.getFila(),txt.getFilae());
                    sv.setVisible(true); 
                    //setVisible(false);
                    //System.exit(-1); 
                    //this.dispose();
                }
            });
    }
   public void paintComponent(Graphics g){
     Dimension tama=getSize();
     ImageIcon imagen=new ImageIcon(new ImageIcon(getClass().getResource("fondo1.png")).getImage()); 
     g.drawImage(imagen.getImage(),0,0,tama.width,tama.height,null);
     
     
     g.setColor(Color.black);
     g.setFont(new Font("Impact",Font.PLAIN,60));
     g.drawString("TETRIS",80,90);
       
    }
    
    /*public void paint(Graphics g){
       g.setColor(Color.yellow);
       g.drawString("TETRIS",320,200);
    }*/
}
