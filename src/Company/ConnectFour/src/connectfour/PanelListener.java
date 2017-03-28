package Company.ConnectFour.src.connectfour;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Jorge
 */
//import javax.swing.JPanel;

public class PanelListener implements MouseListener{
    ConnectFourPanel currentPnl;
    ConnectFourFrame gameFrame;
    
    int turn;;
    boolean winner;
    
    public PanelListener(ConnectFourFrame board){
        this.gameFrame = board;
        turn = 1;
        winner = false;
  
    }
    
    public void changeTurn(){
        if(turn == 1){
            gameFrame.p1Count++;
            currentPnl.setColor('r');
            turn = 2;
        }
        else{
            gameFrame.p2Count++;
            currentPnl.setColor('b');
            turn = 1;
        }
    }
    
    public void checkForWinner(){
        //check for horizontal winner
        for(int i=0; i<6; i++){
            for(int j=0; j<4; j++){
                if(gameFrame.pnlArray[i][j].getColor() != 'w' &&
                   gameFrame.pnlArray[i][j].getColor()==gameFrame.pnlArray[i][j+1].getColor() && 
                   gameFrame.pnlArray[i][j].getColor()==gameFrame.pnlArray[i][j+2].getColor() &&
                   gameFrame.pnlArray[i][j].getColor()==gameFrame.pnlArray[i][j+3].getColor()){
                    
                        gameFrame.winner = true;
                        gameFrame.pnlArray[i][j].setColor('g');
                            gameFrame.pnlArray[i][j].repaint();
                        gameFrame.pnlArray[i][j+1].setColor('g');
                            gameFrame.pnlArray[i][j+1].repaint();
                        gameFrame.pnlArray[i][j+2].setColor('g');
                            gameFrame.pnlArray[i][j+2].repaint();
                        gameFrame.pnlArray[i][j+3].setColor('g');
                            gameFrame.pnlArray[i][j+3].repaint();

                       // gameFrame.repaint();
                }
            }
        }
        //check for a vertical winner
        for(int j=0; j<7; j++){
            for(int i=0; i<3; i++){
              if(gameFrame.pnlArray[i][j].getColor() != 'w' &&
                 gameFrame.pnlArray[i][j].getColor()==gameFrame.pnlArray[i+1][j].getColor() && 
                 gameFrame.pnlArray[i][j].getColor()==gameFrame.pnlArray[i+2][j].getColor() &&
                 gameFrame.pnlArray[i][j].getColor()==gameFrame.pnlArray[i+3][j].getColor()){
                    
                        gameFrame.winner = true;
                        gameFrame.pnlArray[i][j].setColor('g');
                            gameFrame.pnlArray[i][j].repaint();
                        gameFrame.pnlArray[i+1][j].setColor('g');
                            gameFrame.pnlArray[i+1][j].repaint();
                        gameFrame.pnlArray[i+2][j].setColor('g');
                            gameFrame.pnlArray[i+2][j].repaint();
                        gameFrame.pnlArray[i+3][j].setColor('g');
                            gameFrame.pnlArray[i+3][j].repaint();

                        //gameFrame.repaint();
                }  
            }
        }
        //check for diagonal winner (positive slope)
        for(int i=5; i>2; i--){
            for(int j=0; j<4; j++){
                //j=0 diagonals
               if(gameFrame.pnlArray[i][j].getColor() != 'w' &&
                  gameFrame.pnlArray[i][j].getColor()==gameFrame.pnlArray[i-1][j+1].getColor() && 
                  gameFrame.pnlArray[i][j].getColor()==gameFrame.pnlArray[i-2][j+2].getColor() &&
                  gameFrame.pnlArray[i][j].getColor()==gameFrame.pnlArray[i-3][j+3].getColor()){
                    
                        gameFrame.winner = true;
                        gameFrame.pnlArray[i][j].setColor('g');
                            gameFrame.pnlArray[i][j].repaint();
                        gameFrame.pnlArray[i-1][j+1].setColor('g');
                            gameFrame.pnlArray[i-1][j+1].repaint();
                        gameFrame.pnlArray[i-2][j+2].setColor('g');
                            gameFrame.pnlArray[i-2][j+2].repaint();
                        gameFrame.pnlArray[i-3][j+3].setColor('g');
                            gameFrame.pnlArray[i-3][j+3].repaint();

                        //gameFrame.repaint();
                } 
               if(j==0){
                   //j=1-4 diagonals
                   if(gameFrame.pnlArray[i][j+1].getColor() != 'w' &&
                      gameFrame.pnlArray[i][j+1].getColor()==gameFrame.pnlArray[i-1][j+2].getColor() && 
                      gameFrame.pnlArray[i][j+1].getColor()==gameFrame.pnlArray[i-2][j+3].getColor() &&
                      gameFrame.pnlArray[i][j+1].getColor()==gameFrame.pnlArray[i-3][j+4].getColor()){

                            gameFrame.winner = true;
                            gameFrame.pnlArray[i][j+1].setColor('g');
                                gameFrame.pnlArray[i][j+1].repaint();
                            gameFrame.pnlArray[i-1][j+2].setColor('g');
                                gameFrame.pnlArray[i-1][j+2].repaint();
                            gameFrame.pnlArray[i-2][j+3].setColor('g');
                                gameFrame.pnlArray[i-2][j+3].repaint();
                            gameFrame.pnlArray[i-3][j+4].setColor('g');
                                gameFrame.pnlArray[i-3][j+4].repaint();

                            //gameFrame.repaint();
                    }   
                   //j=2-5 diagonals
                   if(gameFrame.pnlArray[i][j+2].getColor() != 'w' &&
                      gameFrame.pnlArray[i][j+2].getColor()==gameFrame.pnlArray[i-1][j+3].getColor() && 
                      gameFrame.pnlArray[i][j+2].getColor()==gameFrame.pnlArray[i-2][j+4].getColor() &&
                      gameFrame.pnlArray[i][j+2].getColor()==gameFrame.pnlArray[i-3][j+5].getColor()){

                            gameFrame.winner = true;
                            gameFrame.pnlArray[i][j+2].setColor('g');
                                gameFrame.pnlArray[i][j+2].repaint();
                            gameFrame.pnlArray[i-1][j+3].setColor('g');
                                gameFrame.pnlArray[i-1][j+3].repaint();
                            gameFrame.pnlArray[i-2][j+4].setColor('g');
                                gameFrame.pnlArray[i-2][j+4].repaint();
                            gameFrame.pnlArray[i-3][j+5].setColor('g');
                                gameFrame.pnlArray[i-3][j+5].repaint();

                            //gameFrame.repaint();
                    }  
                   //j=3-6 diagonals
                   if(gameFrame.pnlArray[i][j+3].getColor() != 'w' &&
                      gameFrame.pnlArray[i][j+3].getColor()==gameFrame.pnlArray[i-1][j+4].getColor() && 
                      gameFrame.pnlArray[i][j+3].getColor()==gameFrame.pnlArray[i-2][j+5].getColor() &&
                      gameFrame.pnlArray[i][j+3].getColor()==gameFrame.pnlArray[i-3][j+6].getColor()){

                            gameFrame.winner = true;
                            gameFrame.pnlArray[i][j+3].setColor('g');
                                gameFrame.pnlArray[i][j+3].repaint();
                            gameFrame.pnlArray[i-1][j+4].setColor('g');
                                gameFrame.pnlArray[i-1][j+4].repaint();
                            gameFrame.pnlArray[i-2][j+5].setColor('g');
                                gameFrame.pnlArray[i-2][j+5].repaint();
                            gameFrame.pnlArray[i-3][j+6].setColor('g');
                                gameFrame.pnlArray[i-3][j+6].repaint();

                           // gameFrame.repaint();
                   }
               }
            }
        }
        //check for diagonal winner (negative slope)
        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                //j=0-3 diagonal
                if(gameFrame.pnlArray[i][j].getColor() != 'w' &&
                   gameFrame.pnlArray[i][j].getColor() == gameFrame.pnlArray[i+1][j+1].getColor() &&
                   gameFrame.pnlArray[i][j].getColor() == gameFrame.pnlArray[i+2][j+2].getColor() &&
                   gameFrame.pnlArray[i][j].getColor() == gameFrame.pnlArray[i+3][j+3].getColor()){
                    
                        gameFrame.winner = true;
                        gameFrame.pnlArray[i][j].setColor('g');
                            gameFrame.pnlArray[i][j].repaint();
                        gameFrame.pnlArray[i+1][j+1].setColor('g');
                            gameFrame.pnlArray[i+1][j+1].repaint();
                        gameFrame.pnlArray[i+2][j+2].setColor('g');
                            gameFrame.pnlArray[i+2][j+2].repaint();
                        gameFrame.pnlArray[i+3][j+3].setColor('g');
                            gameFrame.pnlArray[i+3][j+3].repaint();

                        //gameFrame.repaint();   
                }
                if(j==0){
                    //j=1-4 diagonal
                    if(gameFrame.pnlArray[i][j+1].getColor() != 'w' &&
                       gameFrame.pnlArray[i][j+1].getColor() == gameFrame.pnlArray[i+1][j+2].getColor() &&
                       gameFrame.pnlArray[i][j+1].getColor() == gameFrame.pnlArray[i+2][j+3].getColor() &&
                       gameFrame.pnlArray[i][j+1].getColor() == gameFrame.pnlArray[i+3][j+4].getColor()){

                          gameFrame.winner = true;
                            gameFrame.pnlArray[i][j+1].setColor('g');
                                gameFrame.pnlArray[i][j+1].repaint();
                            gameFrame.pnlArray[i+1][j+2].setColor('g');
                                gameFrame.pnlArray[i+1][j+2].repaint();
                            gameFrame.pnlArray[i+2][j+3].setColor('g');
                                gameFrame.pnlArray[i+2][j+3].repaint();
                            gameFrame.pnlArray[i+3][j+4].setColor('g');
                                gameFrame.pnlArray[i+3][j+4].repaint();

                            //gameFrame.repaint();   
                    }
                    //j=2-5 diagonal
                    if(gameFrame.pnlArray[i][j+2].getColor() != 'w' &&
                       gameFrame.pnlArray[i][j+2].getColor() == gameFrame.pnlArray[i+1][j+3].getColor() &&
                       gameFrame.pnlArray[i][j+2].getColor() == gameFrame.pnlArray[i+2][j+4].getColor() &&
                       gameFrame.pnlArray[i][j+2].getColor() == gameFrame.pnlArray[i+3][j+5].getColor()){

                            gameFrame.winner = true;
                            gameFrame.pnlArray[i][j+2].setColor('g');
                                gameFrame.pnlArray[i][j+2].repaint();
                            gameFrame.pnlArray[i+1][j+3].setColor('g');
                                gameFrame.pnlArray[i+1][j+3].repaint();
                            gameFrame.pnlArray[i+2][j+4].setColor('g');
                                gameFrame.pnlArray[i+2][j+4].repaint();
                            gameFrame.pnlArray[i+3][j+5].setColor('g');
                                gameFrame.pnlArray[i+3][j+5].repaint();

                            //gameFrame.repaint();   
                    }
                    //j=3-6 diagonal
                    if(gameFrame.pnlArray[i][j+3].getColor() != 'w' &&
                       gameFrame.pnlArray[i][j+3].getColor() == gameFrame.pnlArray[i+1][j+4].getColor() &&
                       gameFrame.pnlArray[i][j+3].getColor() == gameFrame.pnlArray[i+2][j+5].getColor() &&
                       gameFrame.pnlArray[i][j+3].getColor() == gameFrame.pnlArray[i+3][j+6].getColor()){

                           gameFrame.winner = true;
                            gameFrame.pnlArray[i][j+3].setColor('g');
                                gameFrame.pnlArray[i][j+3].repaint();
                            gameFrame.pnlArray[i+1][j+4].setColor('g');
                                gameFrame.pnlArray[i+1][j+4].repaint();
                            gameFrame.pnlArray[i+2][j+5].setColor('g');
                                gameFrame.pnlArray[i+2][j+5].repaint();
                            gameFrame.pnlArray[i+3][j+6].setColor('g');
                                gameFrame.pnlArray[i+3][j+6].repaint();

                            //gameFrame.repaint();   
                    }
                } 
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       
        for(int i = 0; i < gameFrame.pnlArray.length; i++){
            for(int j = 0; j < gameFrame.pnlArray[0].length; j++){
                if(gameFrame.pnlArray[i][j] == e.getSource()){
                    int count = gameFrame.pnlArray[0][j].getCounter();
                    currentPnl = gameFrame.pnlArray[count][j];//(ConnectFourPanel)(e.getSource());//gameFrame.pnlArray[i][j];
                    changeTurn();
                    char color = currentPnl.getColor();
                    
                    gameFrame.pnlArray[count][j].setColor(color);
                    gameFrame.pnlArray[count][j].repaint();
                    count--;
                    gameFrame.pnlArray[0][j].setCounter(count);
                    break;
                    
                }
            }
        }
        checkForWinner();
       //gameFrame.numMoves();
       gameFrame.stats.setP1MoveCount(""+gameFrame.p1Count);
       gameFrame.stats.setP2MoveCount("" + gameFrame.p2Count);
        if(gameFrame.winner){
            if(turn == 1){
                gameFrame.stats.setWinnerLabel("Player 2 Wins!!!");
                gameFrame.p2Wins++;
                gameFrame.stats.setP2WinCount("" + gameFrame.p2Wins);
            }
            if(turn == 2){
                gameFrame.stats.setWinnerLabel("Player 1 Wins!!!");
                gameFrame.p1Wins++;
                gameFrame.stats.setP1WinCount("" + gameFrame.p1Wins);
            }
                
           // System.out.println("we have a winner");
        }
        else
           gameFrame.stats.setWinnerLabel(null);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
  
}
