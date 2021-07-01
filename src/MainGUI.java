import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{
    private JPanel gui;
    private JButton oneone;
    private JButton onetwo;
    private JButton onethree;
    private JButton twothree;
    private JButton twotwo;
    private JButton twoone;
    private JButton threethree;
    private JButton threetwo;
    private JButton threeone;
    private JLabel StatusIndicator;
    boolean playersTurn;
    boolean game;
    public MainGUI(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(gui);
        this.pack();
        oneone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSquare(oneone);
            }
        });
        onetwo.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
               setSquare(onetwo);
           }
        });
        onethree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSquare(onethree);
            }
        });
    }
    public static void main(String[] args){
        JFrame window = new MainGUI("Tic Tac Toe");
        window.setVisible(true);

    }
    public void setSquare(JButton button){
        if(button.getText() == "") {
            if (playersTurn) {
                button.setText("X");
            } else {
                button.setText("O");
            }
            switchPosession();
        }
    }
    public void switchPosession(){
        if(playersTurn){
            playersTurn = false;
        }
        else{
            playersTurn = true;
        }
    }
    public void initializeGame(){
        playersTurn = true;
        game = true;
    }
    public boolean firstrow(){
        return oneone.getText() == "X" && onetwo.getText() =="X" && onethree.getText()=="X" || oneone.getText() == "O" && onetwo.getText() =="O" && onethree.getText()=="O";
    }
    public boolean secondRow(){
        return twoone.getText() == "X" && twotwo.getText() =="X" && twothree.getText() == "X" || twoone.getText() == "O" && twotwo.getText() =="O" && twothree.getText() == "O";
    }
    public boolean thirdRow(){
        return threeone.getText() == "X" && threetwo.getText() == "X" && threethree.getText() == "X" || threeone.getText() == "O" && threetwo.getText() == "O" && threethree.getText() == "O";
    }
    public boolean firstcolumn(){
        return oneone.getText() == "X" && twoone.getText() =="X" && threeone.getText() == "X" || oneone.getText() == "O" && twoone.getText() =="O" && threeone.getText() == "O";
    }
    public boolean secondcolumn(){
        return onetwo.getText() == "X" && twotwo.getText() =="X" && threetwo.getText() == "X" || onetwo.getText() == "O" && twotwo.getText() =="O" && threetwo.getText() == "O";
    }
    public boolean thirdcolumn(){
        return onethree.getText() == "X" && twothree.getText() =="X" && threethree.getText() == "X" || onethree.getText() == "O" && twothree.getText() =="O" && threethree.getText() == "O";
    }
    public boolean diagonal(){
        return oneone.getText() == "X" && twotwo.getText() == "X" && threethree.getText() == "X" || oneone.getText() == "O" && twotwo.getText() =="O" && threethree.getText() == "O" || onethree.getText() == "X" && twotwo.getText() == "X" && threeone.getText() == "X" || onethree.getText() == "O" && twotwo.getText() == "O" && threeone.getText() == "O";
    }
    public void checkWinner(){
        if(firstrow() || secondRow() || thirdRow() || firstcolumn() || secondcolumn() || thirdcolumn() || diagonal()){
            endGame();
        }
    }
    public void endGame(){
        reset();
    }
    public void reset(){
        playersTurn = true;
        oneone.setText("");
        onetwo.setText("");
        onethree.setText("");
        twoone.setText("");
        twotwo.setText("");
        twothree.setText("");
        threeone.setText("");
        threetwo.setText("");
        threethree.setText("");
    }
}
