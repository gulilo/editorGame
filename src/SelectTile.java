import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;


public class SelectTile extends Tile implements MouseListener
{
	public SelectTile(Point loc, BufferedImage image)
	{
		super(loc, image);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		e.consume();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		e.consume();
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		e.consume();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		MapBuild.setCorrentImage(this.image);
		e.consume();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		e.consume();
	}


}
