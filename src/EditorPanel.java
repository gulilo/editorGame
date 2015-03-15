import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EditorPanel extends BasicPanel
{
	private Map map;
	public static EditorAPI API;

	public EditorPanel(Point loc, Dimension size)
	{
		super(loc, size);
		API = new EditorAPI(this);

		map = new Map(size.width / MapBuild.IMAGE_SIZE, size.height / MapBuild.IMAGE_SIZE);

		MapBuild m = new MapBuild();
		ArrayList<ArrayList<BufferedImage>> images = m.getImages();
		EditorTile[][] map = new EditorTile[size.width / MapBuild.IMAGE_SIZE][size.height / MapBuild.IMAGE_SIZE];
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				map[i][j] = new EditorTile(new Point(i * MapBuild.IMAGE_SIZE, j * MapBuild.IMAGE_SIZE), null);
				add(map[i][j]);
			}
		}
	}

	public Map getMap()
	{
		return map;
	}
}
