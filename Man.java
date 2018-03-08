import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Man extends JComponent
{
	private int dy = 0, dx = 0;
	
	public Man(int x, int y)
	{
		setLocation(x, y);
		setSize(20, 40);
	}
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		Ellipse2D.Double head = new Ellipse2D.Double(4, 0, 10, 10);
		g2.setColor(Color.orange);
		g2.fill(head);
		Rectangle body = new Rectangle(8, 10, 3, 20);
		g2.fill(body);
		Rectangle leftarm = new Rectangle(0, 13, 8, 3);
		g2.fill(leftarm);
		Rectangle rightarm = new Rectangle(10, 13, 8, 3);
		g2.fill(rightarm);
		Rectangle leftleg = new Rectangle(5, 25, 3, 15);
		g2.fill(leftleg);
		Rectangle rightleg = new Rectangle(11, 25, 3, 15);
		g2.fill(rightleg);
	}
	public void setDY(int y)
	{
		dy = y;
	}
	public void setDX(int x)
	{
		dx = x;
	}
	public void update()
	{
		setLocation(getX()+dx, getY()+dy);
	}
	
}