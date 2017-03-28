package Company.ConnectFour.src.connectfour;

/*
 * and open the template in the editor.
 */

import javax.swing.JFrame;

/**
 *
 * @author Jorge
 */

public class ConnectFourGame {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[][] empty = new char[6][7];
        
        for(int i = 0; i < empty.length; i++){
            for(int j = 0; j < empty[0].length; j++){
                empty[i][j] = 'w';
            }
        }
        
        ConnectFourFrame newGame = new ConnectFourFrame(empty);
        newGame.setTitle("Connect Four");
        newGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newGame.setLocationRelativeTo(null);
        newGame.setVisible(true);
    }
}
