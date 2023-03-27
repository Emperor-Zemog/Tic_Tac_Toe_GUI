import javax.swing.*;
import java.awt.*;

public class GameStat extends JPanel {
    GridBagConstraints c = new GridBagConstraints();
    JLabel xWins = new JLabel("0");
    JLabel oWins = new JLabel("0");
    JLabel ties = new JLabel("0");
    JLabel xWTitle = new JLabel("X Wins");
    JLabel tiesTitle = new JLabel("Ties");
    JLabel oWTitle = new JLabel("O Wins");
    int xWinCount =0;
    int oWinCount=0;
    int tieCount=0;
    public GameStat(){
        super();
        setLayout(new GridBagLayout());
        c.weightx = 0;
        c.ipadx = 20;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 0;
        add(xWTitle, c);


        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        add(xWins, c);


        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;
        add(tiesTitle, c);


        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;
        add(ties, c);


        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 0;
        add(oWTitle, c);


        c.ipady = 0;
        c.gridx = 2;
        c.gridy = 1;
        add(oWins, c);

    }
    public void addToXWins(){
        xWinCount++;
        xWins.setText(xWinCount+"");
    }
    public void addToOWins(){
        oWinCount++;
        oWins.setText(oWinCount+"");
    }
    public void addToTies(){
        tieCount++;
        ties.setText(tieCount+"");
    }

    public int getoWinCount() {
        return oWinCount;
    }

    public int getTieCount() {
        return tieCount;
    }

    public int getxWinCount() {
        return xWinCount;
    }
}
