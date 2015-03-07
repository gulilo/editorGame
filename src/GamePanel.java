import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GamePanel extends JPanel
{
	private Image background;
	private Player player;

	public GamePanel(Dimension size)
	{
		super();
		setSize(size);
		setLayout(null);
		setBackground(Color.WHITE);

		try
		{
			background = ImageIO.read(new File("background.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		MapBuild m = new MapBuild();

		ArrayList<ArrayList<BufferedImage>> images = m.getImages();
		Tile[][] map = new Tile[size.height / MapBuild.IMAGE_SIZE][size.width / MapBuild.IMAGE_SIZE];
		/*for(int i = 0;i<map[0].length;i++)
		{
			//int index = (int) (Math.random() * images.size());
			BufferedImage[] arr = images.get(0);
			map[map.length/2][i] = new Tile(new Point(i*Map.IMAGE_SIZE,(map.length/2)*Map.IMAGE_SIZE), arr[(int) (Math.random() * arr.length)]);
			add(map[map.length/2][i]);
		}*/

		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				map[i][j] = new Tile(new Point(i * MapBuild.IMAGE_SIZE, j * MapBuild.IMAGE_SIZE), null);
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//g.drawImage(background,0,0,null);
	}
}
