
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial") // to avoid Eclipse warning
public class PointCanvas extends Canvas implements MouseListener {

    protected KdTreeApplet parent;  // access to main applet class

    // constructor
    public PointCanvas(KdTreeApplet app) {
        parent = app;
        setFont(new Font("Arial", Font.PLAIN, 16));
        addMouseListener(this);
    }

    // repaint this canvas
    public void paint(Graphics g) {
        // turn on anti-aliasing for smoother lines
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        KdTree t = parent.tree();
        Dimension d = getSize();  // size of canvas

        if (t == null) {
            g.setColor(Color.black);
            g.drawString("Click to add points", 50, 50);
        } else {
            int x0 = 0;
            int y0 = 0;
            int x1 = d.width;
            int y1 = d.height;
            // calls your code for problem 4:
            KdTreeOps.draw(g, t, 0, x0, y0, x1, y1);
        }
    }

    // handle mouse clicks: add new point to tree
    public void mousePressed(MouseEvent e) {
        Point p = new Point(e.getX(), e.getY());
        //System.out.println("Click" + p.x	+ "," + p.y);
        parent.add(p);
    }

    // also need to provide these since we're implementing MouseListener
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

}

public class BoardCanvas extends Canvas implements MouseListener {
	
	protected BoardApplet parent;
	
	//constructor
	public BoardCanvas(BoardApplet app) {
        parent = app;
        setFont(new Font("Arial", Font.PLAIN, 16));
        addMouseListener(this);
	
	public void paint(Graphics g) {
		new Board();
	}
	
	// creates panel with setup and game play actions	
	public Panel gamePlay() {
		Panel gamePlay = new Panel();
		
		Panel play = new Panel();
		play.setLayout(new FlowLayout());
		Button roll = new Button("roll"));
		Button endTurn = new Button("end turn"));
		Button buy = new Button("buy");
		play.add(roll);
		play.add(endTurn);
		play.add(buy);
		
		Panel setUp = new Panel();
		setUp.setLayout(new FlowLayout());
		Choice numPlayers = new Choice();
		numPlayers.add("2");
		numPlayers.add("3");
		numPlayers.add("4");
		Choice gameDuration = new Choice();
		gameDuration.add("10 rounds");
		gameDuration.add("20 rounds");
		Button newGame = new Button("new game");
		setUp.add(numPlayers);
		setUp.add(gameDuration);
		setUP.add(newGame);
		
		
		gamePlay.setLayout(new GridLayout(1,2));
		gamePlay.add(play);
		gamePlay.add(setUp);
		
		return gamePlay;
	}
	
	//creates panel with the board	
	public Panel gameBoard(){
		Panel gameBoard = new Panel()
		Panel tiles = new Panel();
		tiles.setLayout(new GridLayout(1,11,2,2));
		Panel tiles2 = new Panel();
		tiles.setLayout(new GridLayout(9,1,2,2));
		Label boardCenter = new Label("MIDDOPOLY");
		
		gameBoard.setLayout(new BorderLayout());
		gameBoard.add("North", tiles);
		gameBoard.add("South", tiles);
		gameBoard.add("East", tiles2);
		gameBoard.add("West", tiles2);
		gameBoard.add("Center", boardCenter);
		
		return gameBoard;		
	}
	
	// creates drawing that includes gamePlay and gameBoard panels
	public Board() {
		Panel p1 = new gamePlay();
		Panel p2 = new gameBoard();
		
		this.setLayout(new BorderLayout());
		this.add("North", p1);
		this.add("Center", p2);
	}	
}
