import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private Ball newball;
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	public WalkingFrame()
	{
		setBounds(100, 100, 600, 400);
		setLayout(null);
		man = new Man(0, 0);
		newball = new Ball(100, 100);
		add(man);
		Timer timer = new Timer(10, this);
		timer.start();
		addKeyListener(new KeyListener()
				{
					@Override
					public void keyPressed(KeyEvent e) 
					{
						if(e.getKeyCode()==e.VK_W)
						{
							man.setDY(-2);
						}
						if(e.getKeyCode()==e.VK_S)
						{
							man.setDY(2);
						}
						if(e.getKeyCode()==e.VK_A)
						{
							man.setDX(-2);
						}
						if(e.getKeyCode()==e.VK_D)
						{
							man.setDX(2);
						}
						if(e.getKeyCode()==e.VK_K)
						{
							Ball newball = new Ball(man.getX(), man.getY());
							balls.add(newball);
							add(newball);
							newball.setLocation(man.getX(), man.getY());
							newball.setDX(6);
						}
					}
					@Override
					public void keyReleased(KeyEvent e) 
					{
						if(e.getKeyCode()==e.VK_W)
						{
							man.setDY(0);
						}
						if(e.getKeyCode()==e.VK_S)
						{
							man.setDY(0);
						}
						if(e.getKeyCode()==e.VK_A)
						{
							man.setDX(0);
						}
						if(e.getKeyCode()==e.VK_D)
						{
							man.setDX(0);
						}
					}
					@Override
					public void keyTyped(KeyEvent e) {
					}
				});
		setVisible(true);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new WalkingFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		man.update();
		for(Ball num : balls)
		{
			num.update();
		}
		repaint();
		for(int i = 0; i < balls.size(); i++)
		{
			if(balls.get(i).getX() > getWidth())
			{
				remove(balls.get(i));
				balls.remove(balls.get(i));
			}
		}
	}
}
