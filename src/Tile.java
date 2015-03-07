import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel
{
	protected Image image;

	public Tile(Point loc, Image image)
	{
		init(loc, image);
	}

	public Tile(Tile tile)
	{
		init(tile.getLocation(), tile.image);
	}

	private void init(Point loc, Image image)
	{
		setSize(MapBuild.IMAGE_SIZE, MapBuild.IMAGE_SIZE);
		setLocation(loc);
		setLayout(null);

		this.image = image;
	}

	public Image getImage()
	{
		return image;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(image != null)
		{
			g.drawImage(image, 0, 0, null);
		}
	}

}
