import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class SelectPanel extends BasicPanel
{
	private ArrayList<ArrayList<SelectTile>> types;

	public SelectPanel(Point loc, Dimension size)
	{
		super(loc,size);

		MapBuild m = new MapBuild();
		types = new ArrayList<ArrayList<SelectTile>>();
		ArrayList<SelectTile> tiles = new ArrayList<SelectTile>();
		ArrayList<ArrayList<BufferedImage>> images = m.getImages();
		int indexi = 0, indexj = 0;
		for(ArrayList<BufferedImage> bi : images)
		{
			for(BufferedImage image : bi)
			{
				if(indexi * MapBuild.IMAGE_SIZE + MapBuild.IMAGE_SIZE > getSize().width)
				{
					indexi = 0;
					indexj++;
				}
				else
				{
					indexi++;
				}

				SelectTile tile = new SelectTile(new Point(indexi * MapBuild.IMAGE_SIZE, indexj * MapBuild.IMAGE_SIZE), image);
				add(tile);
				tiles.add(tile);
			}
			types.add(tiles);
			tiles = new ArrayList<SelectTile>();
		}
	}
}
