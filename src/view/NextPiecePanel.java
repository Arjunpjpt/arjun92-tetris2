/*
 * TCSS 305
 * 
 * Assignment 6 - Tetris
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import model.Point;
import model.TetrisPiece;

/**
 * This is a class to setup game board.
 * @author Arjun Prajapati
 * @version December 1, 2017
 */
public class NextPiecePanel extends JPanel implements Observer {
    /**
     * default serial version UID.
     */
    private static final long serialVersionUID = 1L;
    
    /**Block Size.*/
    private static final int BLOCK_SIZE = 20;
    
    /**Default move x axis align.*/
    private static final int MOVE_X = 40;

    /**Default move y axis align.*/
    private static final int MOVE_Y = 30;
    
    /**Frame width.*/
    private static final int PANEL_WIDTH = 200;
    
    /**Frame height.*/
    private static final int PANEL_HEIGHT = 200;
    
    /**Default dimension for the panel.*/
    private static final Dimension SIZE = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
    

    
    /**Object of a class.*/
    private TetrisPiece myNextPiece;
    

    /**
     * Constructor to initialize the panel.
     * 
     */
    public NextPiecePanel() {
        super();
        
        final TitledBorder border = new TitledBorder("Next Piece");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        setBorder(border);
        initalizePanel();
    }
    
    /**
     * Initializing the Panel.
     */
    public void initalizePanel() {
        setBackground(Color.RED);
        setPreferredSize(SIZE);
    }
    
    
    @Override
    protected void paintComponent(final Graphics theG) {
        
        // TODO Auto-generated method stub
        super.paintComponent(theG);
        
        if (myNextPiece != null) {
            for (Point p:myNextPiece.getPoints()) {
                if (myNextPiece.toString().equals("I")) {
                    theG.setColor(Color.BLACK);
                    theG.fillRect((p.x() * BLOCK_SIZE) + ((PANEL_WIDTH / 2) - MOVE_X)
                                , ((BLOCK_SIZE * myNextPiece.getHeight()) 
                                                - (BLOCK_SIZE * p.y())) + ((PANEL_HEIGHT / 2))
                                , BLOCK_SIZE
                                , BLOCK_SIZE);
                    theG.setColor(Color.WHITE);
                    theG.drawRect((p.x() * BLOCK_SIZE) + ((PANEL_WIDTH / 2) - MOVE_X)
                               , ((BLOCK_SIZE * myNextPiece.getHeight()) 
                                               -  (BLOCK_SIZE * p.y())) + ((PANEL_HEIGHT / 2))
                               , BLOCK_SIZE
                               , BLOCK_SIZE);
                    
                } else if (myNextPiece.toString().equals("O")) {
//                    System.out.println(myNextPiece);
                    theG.setColor(Color.BLACK);
                    theG.fillRect((p.x() * BLOCK_SIZE) + ((PANEL_WIDTH / 2) - MOVE_X)
                             , ((BLOCK_SIZE * myNextPiece.getHeight()) 
                                             - (BLOCK_SIZE * p.y())) 
                             + ((PANEL_HEIGHT / 2) - MOVE_Y) 
                             , BLOCK_SIZE
                             , BLOCK_SIZE);
                    theG.setColor(Color.WHITE);
                    theG.drawRect((p.x() * BLOCK_SIZE) + ((PANEL_WIDTH / 2) - MOVE_X)
                           , ((BLOCK_SIZE * myNextPiece.getHeight()) 
                                           - (BLOCK_SIZE * p.y())) + ((PANEL_HEIGHT / 2) 
                                                           - MOVE_Y) 
                           , BLOCK_SIZE
                           , BLOCK_SIZE);
                } else {
                    theG.setColor(Color.BLACK);
                    theG.fillRect((p.x() * BLOCK_SIZE) 
                                  + ((PANEL_WIDTH / 2) - MOVE_Y)
                                 , ((BLOCK_SIZE * myNextPiece.getHeight()) 
                                                 - (BLOCK_SIZE * p.y())) + ((PANEL_HEIGHT / 2) 
                                                                 - MOVE_Y) 
                                 , BLOCK_SIZE
                                 , BLOCK_SIZE);
                    theG.setColor(Color.WHITE);
                    theG.drawRect((p.x() * BLOCK_SIZE) 
                                  + ((PANEL_WIDTH / 2) - MOVE_Y)
                               , ((BLOCK_SIZE * myNextPiece.getHeight()) 
                                               - (BLOCK_SIZE * p.y())) + ((PANEL_HEIGHT / 2) 
                                                               - MOVE_Y) 
                               , BLOCK_SIZE
                               , BLOCK_SIZE);
                }
            }
            repaint();
        }
        
       
    }
    @Override
    public void update(final Observable theObject, final Object theArg) {

//        System.out.println(theObject.toString());
        if (theArg instanceof TetrisPiece) {
//            KeyControl ct = new KeyControl();
//            System.out.println(ct.getLeftKey());
            myNextPiece = (TetrisPiece) theArg;

//System.out.println("next piece is  " +arg);
        
        }
    }
}
