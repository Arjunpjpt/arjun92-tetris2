/*
 * TCSS 305
 * 
 * Assignment 6 - Tetris
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.Block;

/**
 * This is a class to setup game board.
 * @author Arjun Prajapati
 * @version November 21, 2017
 */
public class GameBoardPanel extends JPanel implements Observer {
    /**
     * default serial version UID.
     */
    private static final long serialVersionUID = 1L;
    
    /** Width of the game board. */
    private static final int BOARD_WIDTH = 400;
    
    /** Height of the game board. */
    private static final int BOARD_HEIGHT = 700;
    
    /**Row constant.*/
    private static final int ROW_SPACE = 19;
     
    /**Size of the board.*/
    private static final Dimension SIZE = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    
    /**default size of a block.*/
    private static final int BLOCK_SIZE = 35;
    
    /**Hidden row.*/
    private static final int HIDDEN_ROW = 4;
    
    /**Constant for round rectangle.*/
    private static final int ROUND_RECT_CONS = 25;
    
    /**TetrisGUI class.*/
    private TetrisGUI myTetrisGUI;

    /**List of the block.*/
    private ArrayList<Block[]> myList;
    
   
    
    

    
//    private int myScore;
//    /**Declaring score class.*/
//    private Score myScore = new Score(null);

    
    /**Declaring get color class.*/
    private GetColor myColorClass = new GetColor();
   
    /**
     * Constructor for the class.
     * @param theTetrisGUI , gui class
     */
    public GameBoardPanel(final TetrisGUI theTetrisGUI) {
        super();
        
        myTetrisGUI = theTetrisGUI;
        
        initalizePanel();
    }
    /**
     * Initialize the panel.
     */
    public void initalizePanel() {
        final Color backGround = Color.GRAY;
        setBackground(backGround);
        setPreferredSize(SIZE);
    }
    /**
     * to draw the tetris board.
     * @param theGraphics
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        
        final Graphics2D g2d = (Graphics2D) theGraphics;
      
        if (myList != null) {
            for (int i = myList.size() - HIDDEN_ROW; i >= 0; i--) {
                
                for (int j = 0; j < myList.get(i).length; j++) {

                    if (myList.get(i)[j] != null) {
                        final Color color = myColorClass.passColor();
                        theGraphics.setColor(color);
                        
//                        //disco mode
//                        Color s2 = myColorClass.passColor();
//                        Color e1 = myColorClass.passColor();
                        final GradientPaint gradient1 = new GradientPaint(0, 0
                                          , myColorClass.passColor(), 30
                                         , 30, myColorClass.passColor(), true);
                        g2d.setPaint(gradient1);
                        g2d.fillRoundRect(BLOCK_SIZE * j
                                             , (ROW_SPACE - i) * BLOCK_SIZE
                                             , BLOCK_SIZE, BLOCK_SIZE, ROUND_RECT_CONS
                                             , ROUND_RECT_CONS);
                        g2d.setColor(Color.WHITE);
                        
                        
                        
                        g2d.drawRoundRect(BLOCK_SIZE * j , (ROW_SPACE - i) * BLOCK_SIZE
                                             , BLOCK_SIZE, BLOCK_SIZE
                                             , ROUND_RECT_CONS, ROUND_RECT_CONS);
                    } else  {
                        final Color color = Color.BLACK;
                        g2d.setColor(color);
                        g2d.drawRect(BLOCK_SIZE * j
                                             , (ROW_SPACE - i) * BLOCK_SIZE
                                             , BLOCK_SIZE
                                             , BLOCK_SIZE);
    
                    }
                }
                
            }
        }
//        repaint();
    }

//    private void setScore(int theScore) {
//        myScore +=  theScore;
//    }
    @SuppressWarnings("unchecked")
    @Override
    public void update(final Observable theObject, final Object theArg) {
       
        // TODO Auto-generated method stubif (
//        System.out.println(theObject.toString());
        if (theArg instanceof ArrayList) {
            
            myList = (ArrayList<Block[]>) theArg;
            repaint();
        } else if (theArg instanceof Boolean) {
            
            myTetrisGUI.gameOver();
            myTetrisGUI.myEndGameManually.actionPerformed(null);
            
//            myTetrisGUI.getMyTime().stop();
            
            
//            System.out.println(myTetrisGUI.getScore());
            
        }
        
        
    }
    
    
}
