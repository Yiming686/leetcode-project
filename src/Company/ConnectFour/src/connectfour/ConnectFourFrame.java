package Company.ConnectFour.src.connectfour;


/**
 *
 * @author Jorge
 */
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConnectFourFrame extends JFrame{
    char[][] gameBoard;
    ConnectFourPanel[][] pnlArray;
    int p1Count, p2Count;
    int p1Wins, p2Wins;
    boolean winner;
    public ConnectFourStatFrame stats;
    
    public ConnectFourFrame(char[][] board){
        stats = new ConnectFourStatFrame(this);
        winner = false;
        p1Count = 0;
        p2Count = 0;
        p1Wins = 0;
        p2Wins = 0;
        stats.setLocation(0, 0);
        stats.setVisible(true);
        
        this.gameBoard = board;
        setSize(700,600);
        pnlArray = new ConnectFourPanel[6][7];
        PanelListener listener = new PanelListener(this);
        JPanel gamePnl = new JPanel(new GridLayout(6,7));
            for(int i = 0; i < gameBoard.length; i++){
                for(int j = 0; j < gameBoard[0].length; j++){
                    ConnectFourPanel eachPanel = new ConnectFourPanel(gameBoard[i][j]);
                    eachPanel.addMouseListener(listener);
                    gamePnl.add(eachPanel);
                    eachPanel.setBounds(eachPanel.getLocation().x, eachPanel.getLocation().y, 100, 100);
                    pnlArray[i][j] = eachPanel;
                }
            }
        this.add(gamePnl);
    }
    public void numMoves(){
        
        
        for(int i=0; i<pnlArray.length; i++){
            for(int j=0; j<pnlArray[0].length; j++){
                if(pnlArray[i][j].getColor() == 'r')
                    p1Count++;
                else if(pnlArray[i][j].getColor() == 'b')
                    p2Count++;
                else
                    continue;
            }
        }
    }
    public void setP1Count(int count){
        p1Count = count;
    }
    public void setP2Count(int count){
        p2Count = count;
    }
    public void setWinner(boolean win){
        winner = win;
    }
}
