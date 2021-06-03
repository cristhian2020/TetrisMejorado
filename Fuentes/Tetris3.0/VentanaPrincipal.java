/**
 * @author:Antonio Laime Ferrel
           Cristhian Rocha Ferrufino
           Alexander Maurcio Cepedes Molina
 */

import javax.swing.*;
import java.awt.*;
public class VentanaPrincipal extends JFrame
{   
    public VentanaPrincipal()
    {
             
         setSize(350,600);
        setLocationRelativeTo(null);
        setResizable(false);
         add(new Dibujar());
         setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
}
