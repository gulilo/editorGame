import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class EditorPanel extends JPanel
{
	private EditorTile[][] map; 
	public EditorPanel(Dimension size)
	{
		super();
		setSize(size);
		setLayout(null);
		
		Map m = new Map();
		ArrayList<BufferedImage[]> images = m.getImages();
		EditorTile[][] map = new EditorTile[size.width/Map.IMAGE_SIZE][size.height/Map.IMAGE_SIZE];
		for(int i = 0;i<map.length;i++)
		{
			for(int j = 0;j<map[0].length;j++)
			{
				map[i][j] = new EditorTile(new Point(i*Map.IMAGE_SIZE,j*Map.IMAGE_SIZE),null);
				add(map[i][j]);
			}
		}
		
		
	}
}
