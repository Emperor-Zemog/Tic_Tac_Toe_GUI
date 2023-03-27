import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicTacToeFrame extends JFrame {

    boolean finished = false;
    boolean playing = true;
    int moveCnt = 0;
    int row = -1;
    int col = -1;
    final int MOVES_FOR_WIN = 5;
    final int MOVES_FOR_TIE = 7;
    int xWinCount =0;
    int oWinCount=0;
    int tieCount=0;
    String player = "X";

    public TicTacToeFrame(){

        super("A Game of Tic Tac Toe");


        //Declaring UI Elements
        TicTacToeTile[][] theGrid={{new TicTacToeTile(0,0),new TicTacToeTile(0,1),new TicTacToeTile(0,2)},{new TicTacToeTile(1,0),new TicTacToeTile(1,1),new TicTacToeTile(1,2)},{new TicTacToeTile(2,0),new TicTacToeTile(2,1),new TicTacToeTile(2,2)}};
        JButton reset = new JButton("Reset Board");


        JPanel gamePanel = new JPanel();

        JPanel statPanel = new JPanel();
        JPanel recordsPanel = new JPanel();
        JLabel title = new JLabel("Tic Tack Toe");
        JLabel xWins = new JLabel("0");
        JLabel oWins = new JLabel("0");
        JLabel ties = new JLabel("0");
        JLabel xWTitle = new JLabel("X Wins");
        JLabel tiesTitle = new JLabel("Ties");
        JLabel oWTitle = new JLabel("O Wins");
        GridBagConstraints c = new GridBagConstraints();

        //format recordsPanel
        recordsPanel.setLayout(new GridBagLayout());
        JTextArea ta = new JTextArea("", 5, 50); // Text area
        ta.setLineWrap(true);
        JScrollPane sbrText = new JScrollPane(ta); // Scroll pane for text area
        sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        c.weightx = 1;

        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;

        recordsPanel.add(sbrText, c);
        c.weightx = 1;
        c.ipadx=40;

        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 2;
        recordsPanel.add(reset,c);
        c.weightx = 1;
        c.ipadx=0;

        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;
        recordsPanel.add(title, c);

        //format gamePanel

        gamePanel.setLayout(new GridBagLayout());
        c.weightx = 0;

        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 0;

        gamePanel.add(theGrid[0][0], c);


        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;

        gamePanel.add(theGrid[1][0], c);


        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;

        gamePanel.add(theGrid[2][0], c);


        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;

        gamePanel.add(theGrid[0][1], c);


        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;

        gamePanel.add(theGrid[1][1], c);


        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 2;

        gamePanel.add(theGrid[2][1], c);


        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 0;

        gamePanel.add(theGrid[0][2], c);


        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 1;

        gamePanel.add(theGrid[1][2], c);


        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 2;

        gamePanel.add(theGrid[2][2], c);


        //format statPanel
        statPanel.setLayout(new GridBagLayout());
        c.weightx = 0;
        c.ipadx = 20;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 0;
        statPanel.add(xWTitle, c);


        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        statPanel.add(xWins, c);


        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;
        statPanel.add(tiesTitle, c);


        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;
        statPanel.add(ties, c);


        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 0;
        statPanel.add(oWTitle, c);


        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 1;
        statPanel.add(oWins, c);

        //adding UI Elements
        setLayout(new GridBagLayout());
        c.weightx = 1;
        c.weighty=1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 2;
        add(statPanel, c);
        c.weightx = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;
        add(gamePanel, c);
        c.weightx = 1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;
        add(recordsPanel, c);

        //button listeners
        for(int r=0; r < 3; r++)
        {
            for(int d=0; d < 3; d++)
            {
                int a =r;
                int b = d;
                theGrid[r][d].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (playing == true && theGrid[a][b].isClaimed()==false) {
                            if (player.equals("X")) {
                                theGrid[a][b].claimX();

                            } else if (player.equals("O")) {
                                theGrid[a][b].claimO();

                            }
                            gameTic(theGrid, ta);
                            if(playing==false){
                               if(isWin("X",theGrid)==true){
                                xWinCount++;
                                xWins.setText(xWinCount+"");

                            }else if(isWin("O",theGrid)==true){
                                oWinCount++;
                                oWins.setText(oWinCount+"");
                            }else if (isTie(theGrid)){
                                tieCount++;
                                ties.setText(tieCount+"");
                            }
                        }

                        } else if (theGrid[a][b].isClaimed()==true) {
                            writeText(ta,"This Tile is already Claimed");

                        }else if (playing==false) {
                            writeText(ta,"The Game is over, press Reset to Play Again");

                        }
                    }
                });
            }
        }
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearBoard(theGrid);
                playing=true;
                writeText(ta,"Game Reset");
                if(player.equals("X"))
                {


                        writeText(ta, "It's Player X's Turn");

                }
                else
                {


                        writeText(ta, "It's Player O's Turn");


                }
            }});




        // formatting the frame
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // center frame in screen

        setSize((int) (screenWidth / 1.25), (int) (screenHeight / 1.25));

        setLocation((int) (screenWidth / 9.5), (int) (screenHeight / 9));

        // Render the Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.show();
    }
    public void gameTic(TicTacToeTile[][] theGrid,JTextArea ta){
        moveCnt++;
        if(moveCnt >= MOVES_FOR_WIN)
        {
            if(isWin(player,theGrid))
            {

                writeText(ta,"Player " + player + " wins!");
                writeText(ta,"Press Reset to play again");
                playing = false;
            }
        }
        if(moveCnt >= MOVES_FOR_TIE)
        {
            if(isTie(theGrid))
            {

                writeText(ta,"It's a Tie!");
                writeText(ta,"Press Reset to play again");
                playing = false;
            }
        }
        if(player.equals("X"))
        {
            player = "O";
            if(playing==true) {
                writeText(ta, "Player O's Turn");
            }
        }
        else
        {
            player = "X";
            if(playing==true) {
                writeText(ta, "Player X's Turn");
            }

        }

    }
    private static void clearBoard(TicTacToeTile[][] theGrid)
    {

        // sets all the board elements to a space
        for(int row=0; row < 3; row++)
        {
            for(int col=0; col < 3; col++)
            {
               theGrid[row][col].unClaim();
            }
        }


    }
    private static boolean isValidMove(int row, int col,TicTacToeTile[][] theGrid)
    {
        boolean retVal = false;
        if(theGrid[row][col].isClaimed())
            retVal = true;

        return retVal;

    }
    private static boolean isWin(String player,TicTacToeTile[][] theGrid)
    {
        if(isColWin(player,theGrid) || isRowWin(player,theGrid) || isDiagnalWin(player,theGrid))
        {
            return true;
        }

        return false;
    }
    private static boolean isColWin(String player,TicTacToeTile[][] theGrid)
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
    private static boolean isRowWin(String player,TicTacToeTile[][] theGrid)
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
    private static boolean isDiagnalWin(String player,TicTacToeTile[][] theGrid)
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
    private static boolean isTie(TicTacToeTile[][] theGrid)
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
    public void writeText(JTextArea ta, String outText){
        int past = ta.getText().length();
        if(past==0) {
            ta.setText(outText);
        }else {
            ta.setText(ta.getText()+"\n"+outText);

        }

    }
}
