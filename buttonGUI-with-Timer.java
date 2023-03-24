/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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
	boolean[] toggle;
	//setting # of buttons in gui 
	int size = 8; 
        private int currentIndex = 0;
        private Timer timer;

	//constructor starts    
	public Javahomework1 (){    

		setTitle("button window"); 
		//4 rows, 2 column
		setLayout(new GridLayout(4, 2));        
		//initialize jbutton arr (size 8)
		buttonArray = new JButton[size];   
        //set toggle to a boolean 
        //same size as buttonArr
		toggle = new boolean[size];

		//create jbutton and add it into the array
		for (int i = 0; i < size; i++) {  
			//adding the name + number (1,2,3) 
			buttonArray[i] = new JButton(); 
            //sets the name of the button to the index value in string format
			buttonArray[i].setName(i+"");
			//need to set the button color true 
			buttonArray[i].setOpaque(true); 
			//randomize color for background
			buttonArray[i].setBackground(getRandomColor()); 
			//every button gets actionlistener (when clicked, what action it should perform) 
			buttonArray[i].addActionListener(this);      
			//add button to layout 
			add(buttonArray[i]);  
            //sets every button to toggle true
			toggle[i]=true;

		} 
        //set timer to 1 second 
		 timer = new Timer(1000, new ActionListener() {
	            @Override 
	            public void actionPerformed(ActionEvent e) {
                        //for each button in buttonArr, set button to random background color every 1 second
	                for (JButton button : buttonArray) { 
                            //integer.parseInt, converts index i to an integer from a string
	                    if (toggle[Integer.parseInt(button.getName())]) { 
	                    	button.setBackground(getRandomColor());
	                    }
	                }
	            }
	        });
	        timer.start();

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

		//iterates over all button created 
		for (JButton button : buttonArray) {  
            //pressed button color will not changed 
			if (!button.equals(pressedButton) ) {
				Color currentColor = button.getBackground();  
                //if toggle is false, the color will not change 
				if(toggle[Integer.parseInt(button.getName())]) 
					button.setBackground(new Color(255 - currentColor.getRed(), 255 - currentColor.getGreen(), 255 - currentColor.getBlue()));
			}
			else
			{
                //changes the toggle value 
				String btnName= button.getName(); 
                //converts str to int
				int btnIndex = Integer.parseInt(btnName); 
                //true -> false, false->true, reverses which val is stored
				toggle[btnIndex]=!toggle[btnIndex];
				
			}

		}
	} 


}

