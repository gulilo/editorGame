import java.awt.*;
import java.io.Serializable;

public class Map implements Serializable
{
	private Tile[][] tiles;
	private int x, y;

	public Map(int x, int y)
	{
		this.x = x;
		this.y = y;
		tiles = new Tile[x][y];
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				tiles[i][j] = new Tile(new Point(i, j), null);
			}
		}
	}

	public Map(Tile[][] tiles)
	{
		this.x = tiles.length;
		this.y = tiles[0].length;
		this.tiles = new Tile[tiles.length][tiles[0].length];
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[0].length; j++)
			{
				this.tiles[i][j] = new Tile(tiles[i][j]);
			}
		}
	}

	public void setTile(int x, int y, Tile t)
	{
		tiles[x][y] = t;
	}

	public Tile getTile(int x, int y)
	{
		return tiles[x][y];
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
}
