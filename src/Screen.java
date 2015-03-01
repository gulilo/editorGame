import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Screen extends JFrame
{
	private static final long serialVersionUID = 1L;
	private boolean open;

	public Screen(Point location, Dimension size)
	{
		super();
		open = true;

		setSize(size);
		setLocation(location);
		//setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				close();
			}
		});
		setBackground(Color.GRAY);
		setResizable(false);
	}

	public void open()
	{
		open = true;
		setVisible(true);
	}

	public void close()
	{
		open = false;
		setVisible(false);
		dispose();
	}

	public boolean isOpen()
	{
		return open;
	}
}