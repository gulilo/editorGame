import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class EditorTile extends Tile implements MouseListener, Serializable
{
	public EditorTile(Point loc, Image image)
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
		image = MapBuild.getCorrentImage();
		e.consume();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		e.consume();
	}

}
