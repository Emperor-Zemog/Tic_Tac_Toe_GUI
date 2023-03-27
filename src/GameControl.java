import javax.swing.*;
import java.awt.*;

public class GameControl {

    public static void main(String[] args) {
        boolean playing = true;
        boolean finished = false;

        int moveCnt = 0;
        int row = -1;
        int col = -1;
        final int MOVES_FOR_WIN = 5;
        final int MOVES_FOR_TIE = 7;
        int xWinCount =0;
        int oWinCount=0;
        int tieCount=0;
        String player = "X";
        JFrame nidus = new JFrame("A Game of Tic Tac Toe");
        Board batHawk= new Board();
        Display pearlKite = new Display();
        GameStat redKite = new GameStat();
        GridBagConstraints c = new GridBagConstraints();
        nidus.setLayout(new GridBagLayout());
        c.weightx = 1;
        c.weighty=1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 2;
        nidus.add(redKite, c);
        c.weightx = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;
        nidus.add(batHawk, c);
        c.weightx = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;
        nidus.add(pearlKite, c);
        pearlKite.displayListen(batHawk,player);
        batHawk.boardListen(playing,player,pearlKite,redKite);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // center frame in screen

        nidus.setSize((int) (screenWidth / 1.25), (int) (screenHeight / 1.25));

        nidus.setLocation((int) (screenWidth / 9.5), (int) (screenHeight / 9));

        // Render the Frame
        nidus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nidus.show();
        do // program loop
        {
            //begin a game
            player = "X";

            playing = pearlKite.isPlaying();
            moveCnt = 0;


            do  // game loop
            {
                // get the move
                do
                {
                    System.out.println("yes we are running");



                }while(!batHawk.isGotMove());
                batHawk.setGotMove(false);
                moveCnt++;

                if(moveCnt >= MOVES_FOR_WIN)
                {
                    if(batHawk.isWin(player))
                    {

                        pearlKite.writeText("Player " + player + " wins!");
                        pearlKite.writeText("Press Reset to play again");
                        if(player.equals("X")){
                            redKite.addToXWins();
                        }else if(player.equals("O")){
                            redKite.addToOWins();
                        }
                        playing = false;
                        pearlKite.setPlaying(playing);
                    }
                }
                if(moveCnt >= MOVES_FOR_TIE)
                {
                    if(batHawk.isTie())
                    {
                        pearlKite.writeText("It's a Tie!");
                        pearlKite.writeText("Press Reset to play again");
                        redKite.addToTies();
                        playing = false;
                        pearlKite.setPlaying(playing);
                    }
                }
                if(player.equals("X"))
                {
                    player = "O";
                    //batHawk.setpTurn(player);
                    if(playing==true) {
                        pearlKite.writeText( "Player O's Turn");
                    }
                }
                else
                {
                    player = "X";
                    //batHawk.setpTurn(player);
                    if(playing==true) {
                        pearlKite.writeText( "Player X's Turn");
                    }
                }

            }while(playing);


        }while(!finished);

    }
}
