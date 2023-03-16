// Class: GraphicsPanel
// Written by: Mr. Swope
// Date: 10/28/15
// Description: This class is the main class for this project.  It extends the Jpanel class and will be drawn on
// 				on the JPanel in the GraphicsMain class.  Your project should have at least one character that moves
//				with the arrow keys and one character that moves with the clock.  Finally, you should detect if the
//				two items intersect and have something happen if they do intersect.
//
// Since you will modify this class you should add comments that describe when and how you modified the class.  

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GraphicsPanel extends JPanel implements MouseListener{
	
	private Timer t;							 // The timer is used to move objects at a consistent time interval.
	
	// The starter code has a single Square object. Replace this object with an ArrayList that can
	// contain any of the three shapes types that you will create.
	private Square square;
	
	// score will be used to keep track of how the user is doing. It's up to you
	// to determine how the score is calculated.
	int score;
	
	public GraphicsPanel(){
        score = 0;
        
		setPreferredSize(new Dimension(800, 480));   // Set these dimensions to the width 
        											 // of your background picture.   
		square = new Square(20, 20, Color.BLUE, 50);
		
        t = new Timer(10, new ClockListener(this));  // t is a timer.  This object will call the ClockListener's
        											 // action performed method every 5 milliseconds once the 
        											 // timer is started. You can change how frequently this
        											 // method is called by changing the first parameter.
        t.start();
        this.setFocusable(true);					 // for mouselistener
		this.addMouseListener(this);
	}
	
	// method: paintComponent
	// description: This method will paint the items onto the graphics panel.  This method is called when the panel is
	//   			first rendered.  It can also be called by this.repaint()
	// parameters: Graphics g - This object is used to draw your images onto the graphics panel.
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font("Arial", 1, 36));
		g2.setColor(Color.red);
		g2.drawString("" + score, 760, 40);
		
		// Instead of drawing just a single square, you should use an enhanced for loop to iterate through your
		// ArrayList and draw all of your shapes.
		square.draw(g2);
	}
	
	// method:clock
	// description: This method is called by the clocklistener every 5 milliseconds.  You should update the coordinates
	//				of one of your characters in this method so that it moves as time changes.  After you update the
	//				coordinates you should repaint the panel.
	public void clock(){
		// Instead of moving just a single square, you should use an enhanced for loop to iterate through your
		// ArrayList and move all of your shapes.
		square.move();
		
		this.repaint();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + " " + e.getY()); // the x and y coordinates for where the mouse was clicked.
		
		// Instead of checking just a single square, you should use an enhanced for loop to iterate through your
		// ArrayList and see if any of the shapes were clicked.
		if(square.contains(e.getX(), e.getY())) {
			//System.out.println("clicked");
			score += square.clicked();
			System.out.println(score);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
