import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel{
    TicTacToeTile[][] theGrid={{new TicTacToeTile(0,0),new TicTacToeTile(0,1),new TicTacToeTile(0,2)},{new TicTacToeTile(1,0),new TicTacToeTile(1,1),new TicTacToeTile(1,2)},{new TicTacToeTile(2,0),new TicTacToeTile(2,1),new TicTacToeTile(2,2)}};
    GridBagConstraints c = new GridBagConstraints();
    boolean gotMove = false;
    String pTurn= "X";
    public Board ( ){
        super();
        setLayout(new GridBagLayout());
        c.weightx = 0;

        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 0;

        add(theGrid[0][0], c);


        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;

        add(theGrid[1][0], c);


        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;

        add(theGrid[2][0], c);


        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;

        add(theGrid[0][1], c);


        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;

        add(theGrid[1][1], c);


        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 2;

        add(theGrid[2][1], c);


        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 0;

        add(theGrid[0][2], c);


        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 1;

        add(theGrid[1][2], c);


        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 2;

        add(theGrid[2][2], c);

    }
    public void clearBoard()
    {
        pTurn = "X";
        // sets all the board elements to a space
        for(int row=0; row < 3; row++)
        {
            for(int col=0; col < 3; col++)
            {
                theGrid[row][col].unClaim();
            }
        }


    }
    public boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(theGrid[row][col].isClaimed())
            retVal = true;

        return retVal;

    }
    public boolean isColWin(String player)
    {
        // checks for a col win for specified player
        for(int col=0; col < 3; col++)
        {
            if(theGrid[0][col].getClaimer().equals(player) &&
                    theGrid[1][col].getClaimer().equals(player) &&
                    theGrid[2][col].getClaimer().equals(player))
            {
                return true;
            }
        }
        return false; // no col win
    }
    public boolean isRowWin(String player)
    {
        // checks for a row win for the specified player
        for(int row=0; row < 3; row++)
        {
            if(theGrid[row][0].getClaimer().equals(player) &&
                    theGrid[row][1].getClaimer().equals(player) &&
                    theGrid[row][2].getClaimer().equals(player))
            {
                return true;
            }
        }
        return false; // no row win
    }
    public boolean isDiagnalWin(String player)
    {
        // checks for a diagonal win for the specified player

        if(theGrid[0][0].getClaimer().equals(player) &&
                theGrid[1][1].getClaimer().equals(player) &&
                theGrid[2][2].getClaimer().equals(player) )
        {
            return true;
        }
        if(theGrid[0][2].getClaimer().equals(player) &&
                theGrid[1][1].getClaimer().equals(player) &&
                theGrid[2][0].getClaimer().equals(player) )
        {
            return true;
        }
        return false;
    }
    public boolean isTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;
        // Check all 8 win vectors for an X and O so
        // no win is possible
        // Check for row ties
        for(int row=0; row < 3; row++)
        {
            if(theGrid[row][0].getClaimer().equals("X") ||
                    theGrid[row][1].getClaimer().equals("X") ||
                    theGrid[row][2].getClaimer().equals("X"))
            {
                xFlag = true; // there is an X in this row
            }
            if(theGrid[row][0].getClaimer().equals("O") ||
                    theGrid[row][1].getClaimer().equals("O") ||
                    theGrid[row][2].getClaimer().equals("O"))
            {
                oFlag = true; // there is an O in this row
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a row win
            }

            xFlag = oFlag = false;

        }
        // Now scan the columns
        for(int col=0; col < 3; col++)
        {
            if(theGrid[0][col].getClaimer().equals("X") ||
                    theGrid[1][col].getClaimer().equals("X") ||
                    theGrid[2][col].getClaimer().equals("X"))
            {
                xFlag = true; // there is an X in this col
            }
            if(theGrid[0][col].getClaimer().equals("O") ||
                    theGrid[1][col].getClaimer().equals("O") ||
                    theGrid[2][col].getClaimer().equals("O"))
            {
                oFlag = true; // there is an O in this col
            }

            if(! (xFlag && oFlag) )
            {
                return false; // No tie can still have a col win
            }
        }
        // Now check for the diagonals
        xFlag = oFlag = false;

        if(theGrid[0][0].getClaimer().equals("X") ||
                theGrid[1][1].getClaimer().equals("X") ||
                theGrid[2][2].getClaimer().equals("X") )
        {
            xFlag = true;
        }
        if(theGrid[0][0].getClaimer().equals("O") ||
                theGrid[1][1].getClaimer().equals("O") ||
                theGrid[2][2].getClaimer().equals("O") )
        {
            oFlag = true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }
        xFlag = oFlag = false;

        if(theGrid[0][2].getClaimer().equals("X") ||
                theGrid[1][1].getClaimer().equals("X") ||
                theGrid[2][0].getClaimer().equals("X") )
        {
            xFlag =  true;
        }
        if(theGrid[0][2].getClaimer().equals("O") ||
                theGrid[1][1].getClaimer().equals("O") ||
                theGrid[2][0].getClaimer().equals("O") )
        {
            oFlag =  true;
        }
        if(! (xFlag && oFlag) )
        {
            return false; // No tie can still have a diag win
        }

        // Checked every vector so I know I have a tie
        return true;
    }
    public boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }

        return false;
    }
    public void boardListen(boolean playing, String player, Display pearlKite, GameStat redKite){

        for(int r=0; r < 3; r++)
        {
            for(int d=0; d < 3; d++)
            {
                int a =r;
                int b = d;
                theGrid[r][d].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (pearlKite.isPlaying() == true && theGrid[a][b].isClaimed()==false) {
                            if (pTurn.equals("X")) {
                                theGrid[a][b].claimX();
                                pTurn="O";

                            } else if (pTurn.equals("O")) {
                                theGrid[a][b].claimO();
                                pTurn="X";

                            }
                            gotMove =true;

                        } else if (theGrid[a][b].isClaimed()==true) {
                            pearlKite.writeText("This Tile is already Claimed");

                        }else if (playing==false) {
                            pearlKite.writeText("The Game is over, press Reset to Play Again");

                        }
                    }
                });
            }
        }

    }

    public boolean isGotMove() {
        return gotMove;
    }

    public void setGotMove(boolean gotMove) {
        this.gotMove = gotMove;
    }

    public void setpTurn(String pTurn) {
        this.pTurn = pTurn;
    }

    public String getpTurn() {
        return pTurn;
    }
}
