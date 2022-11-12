import java.awt.*;
import java.awt.event.*;
import java.awt.Color;


public class view extends Frame{

    public Canvas[] grid;
    public int size;

    view(int sideLength, color[] colors){

        size = sideLength * sideLength;
        grid = new Canvas[size];

        this.setSize(1000,1000);
        this.addWindowListener(new Listener());


        for(int i = 0; i < size; i++){
            grid[i] = new Canvas();
            grid[i].setSize(1000/sideLength, 1000/sideLength);
            grid[i].setBackground(new Color(colors[i].r, colors[i].g, colors[i].b));

            grid[i].setVisible(true);
            this.add(grid[i]);
        }

        this.setLayout(new GridLayout(sideLength, sideLength));

        this.setVisible(true);
    }

    public void updateView(color[] colors){
        
        for(int i = 0; i < size; i++){
            grid[i].setBackground(new Color(colors[i].r, colors[i].g, colors[i].b));
        }
    }


    class Listener implements WindowListener{
        public void windowActivated (WindowEvent arg0) {    
        }    
        
        public void windowClosed (WindowEvent arg0) {  
        }    
        
        public void windowClosing (WindowEvent arg0) { 
            dispose();    
        }    
        
        public void windowDeactivated (WindowEvent arg0) {  
        }    
        
        public void windowDeiconified (WindowEvent arg0) {  
        }    
        
        public void windowIconified(WindowEvent arg0) {    
        }    
        
        public void windowOpened(WindowEvent arg0) {    
        }    
    }

}
