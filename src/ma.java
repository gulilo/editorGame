import java.awt.*;

public class ma
{
	public static void main(String[] arr)
	{
		Point location = new Point(100, 100);
		Dimension size = new Dimension(1000, 500);
		Screen mainWindow = new Screen(location, size);

		EditorPanel p = new EditorPanel(size);
		mainWindow.add(p);
		mainWindow.open();

		Point selectLocation = new Point(size.width + location.x, location.y);
		Dimension selectSize = new Dimension(100, size.height);
		Screen selectWindow = new Screen(selectLocation, selectSize);

		selectWindow.add(new SelectPanel(selectSize));
		selectWindow.open();

		while(mainWindow.isOpen())
		{
			mainWindow.repaint();
			try
			{
				Thread.sleep(10);
			}
			catch(InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
