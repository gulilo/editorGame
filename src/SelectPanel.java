import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;


public class SelectPanel extends JPanel
{
	private ArrayList<ArrayList<SelectTile>> types; 
	public SelectPanel(Dimension size)
	{
		super();
		setSize(size);
		setLayout(null);
		
		Map m = new Map();
		types = new ArrayList<ArrayList<SelectTile>>();
		ArrayList<SelectTile> tiles = new ArrayList<SelectTile>();
		ArrayList<BufferedImage[]> images = m.getImages();
		int indexi = 0,indexj = 0;
		for(BufferedImage[] bi: images)
		{
			for(BufferedImage image :bi)
			{
				if(indexi* Map.IMAGE_SIZE+Map.IMAGE_SIZE>getSize().width)
				{
					indexi = 0;
					indexj++;
				}
				else
				{
					indexi++;
				}
				
				SelectTile tile = new SelectTile(new Point(indexi*Map.IMAGE_SIZE,indexj*Map.IMAGE_SIZE),image);
				add(tile);
				tiles.add(tile);
			}
			types.add(tiles);
			tiles = new ArrayList<SelectTile>();
		}
	}
}
