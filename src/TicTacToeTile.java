
import javax.swing.*;


public class TicTacToeTile extends JButton
{
    private int row;
    private int col;
    ImageIcon xImage = new ImageIcon(getClass().getResource("xImage.png"));
    ImageIcon oImage = new ImageIcon(getClass().getResource("oImage.png"));
    ImageIcon uImage = new ImageIcon(getClass().getResource("uImage.png"));
    boolean claimed= false;
    String claimer="";

    public TicTacToeTile(int row,int col) {
        super();
        this.row = row;
        this.col = col;
        this.setIcon(uImage);
    }
    public void claimX(){
       this.setIcon(xImage);
       claimed= true;
       claimer ="X";
    }
    public void claimO(){
        this.setIcon(oImage);
        claimed = true;
        claimer ="O";
    }
    public void unClaim(){
        this.setIcon(uImage);
        this.claimed=false;
        claimer ="";
    }

    public String getClaimer() {
        return claimer;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void setClaimed() {
        this.claimed = true;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    
    
    
}
