import javax.swing.*;
import java.awt.*;
public class VentanaPrincipal extends JFrame
{
   // private JButton boton1;
    //private JButton boton2;
    public VentanaPrincipal()
    {
         // pantalla.setBackground(Color.green);         
         setSize(350,600);
        setLocationRelativeTo(null);
        setResizable(false);
         add(new Dibujar());
         setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
}
