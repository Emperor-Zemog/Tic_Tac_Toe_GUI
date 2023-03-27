import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JPanel {
    GridBagConstraints c = new GridBagConstraints();
    JTextArea ta = new JTextArea("", 5, 50);
    JLabel title = new JLabel("Tic Tack Toe");
    JButton reset = new JButton("Reset Board");
    boolean isPlaying = true;

    public Display(){
        super();
        setLayout(new GridBagLayout());
        ta.setLineWrap(true);
        JScrollPane sbrText = new JScrollPane(ta); // Scroll pane for text area
        sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        c.weightx = 1;

        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;

        add(sbrText, c);
        c.weightx = 1;
        c.ipadx=40;

        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 2;
        add(reset,c);
        c.weightx = 1;
        c.ipadx=0;

        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 0;
        add(title, c);
    }
    public void writeText(String outText){
        int past = ta.getText().length();
        if(past==0) {
            ta.setText(outText);
        }else {
            ta.setText(ta.getText()+"\n"+outText);

        }

    }
    public void displayListen(Board batHawk,String player){
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                batHawk.clearBoard();
                isPlaying=true;
                writeText("Game Reset");
                if(player.equals("X"))
                {


                    writeText( "It's Player X's Turn");

                }
                else
                {


                    writeText( "It's Player O's Turn");


                }
            }});

    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
