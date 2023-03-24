/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javahomework1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.util.Random; 


/**
 * @author leishamurthy
 */


//button,layout,title,etc comes from jframe  
//jframe - class, actionlister - interface 
public class Javahomework1 extends JFrame implements ActionListener
{  
    
//declaring class var buttonArray
    JButton[] buttonArray;  
//setting # of buttons in gui 
    int size = 8; 
     
//constructor starts    
    public Javahomework1 (){    
        
        setTitle("button window"); 
        //4 rows, 2 column
        setLayout(new GridLayout(4, 2));        
        //initialize jbutton arr (size 8)
        buttonArray = new JButton[size];  
        
        //create jbutton and add it into the array
        for (int i = 0; i < size; i++) {  
            //adding the name + number (1,2,3) 
            buttonArray[i] = new JButton();   
            //need to set the button color true 
            buttonArray[i].setOpaque(true); 
            //randomize color for background
            buttonArray[i].setBackground(getRandomColor()); 
            //every button gets actionlistener (when clicked, what action it should perform) 
            buttonArray[i].addActionListener(this);      
            //add button to layout 
            add(buttonArray[i]); 

    }
     
        pack();        
        setVisible(true);

    }
    
    //main method 
    //creates the object javahw1
    public static void main(String[] args) {   
        new Javahomework1(); 
    }     
    //generate random red/green/blue and return 
    private Color getRandomColor() { 
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b);
    } 

    //from actionperformed/action listener
    @Override 
 
    public void actionPerformed(ActionEvent e) {  
        //returns button which is clicked
        JButton pressedButton = (JButton) e.getSource(); 
        //if pressed, background is set to blue as default
        pressedButton.setBackground(Color.BLUE); 
        //iterates over all button created 
        for (JButton button : buttonArray) {  
                    //if the button is not pressed, change the background color 
                    if (!button.equals(pressedButton) ) {
                        Color currentColor = button.getBackground(); 
                        //set background color to random color
                        button.setBackground(new Color(255 - currentColor.getRed(), 255 - currentColor.getGreen(), 255 - currentColor.getBlue()));
                    }
        }
    } 
    
    
}

