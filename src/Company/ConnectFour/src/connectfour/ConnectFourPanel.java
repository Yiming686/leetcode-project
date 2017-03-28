package Company.ConnectFour.src.connectfour;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge
 */
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ConnectFourPanel extends JPanel{
    char color;
    int counter;
    
    public ConnectFourPanel(char color){
        this.color = color;
        setSize(100,100);
        setBackground(Color.yellow);
        counter = 5;
    }
    
    public void setCounter(int counter){
        this.counter = counter;
    }
    
    public int getCounter(){
        return counter;
    }
    
    public void setColor(char color){
        this.color = color;
    }
    
    public char getColor(){
        return this.color;
    }
  
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        int diameter = 80;
        int xLoc = 10;
        int yLoc = 10;
        
        if(this.color == 'w')
            g.setColor(Color.white);
        else if(this.color == 'r')
            g.setColor(Color.red);
        else if(this.color == 'g')
            g.setColor(Color.green);
        else
            g.setColor(Color.black);
        
        g.fillOval(xLoc, yLoc, diameter, diameter);
    }
}
