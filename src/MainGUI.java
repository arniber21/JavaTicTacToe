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
    private JLabel p1wins;
    private JLabel p2wins;
    private JLabel ties;
    int tiecounter = 0;
    int p1wincounter = 0;
    int p2wincounter = 0;
    boolean playersTurn;
    boolean game;
    public MainGUI(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(gui);
        initializeGame();
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
        twoone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSquare(twoone);
            }
        });

        twotwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSquare(twotwo);
            }
        });
        twothree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSquare(twothree);
            }
        });
        threeone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSquare(threeone);
            }
        });
        threetwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSquare(threetwo);
            }
        });
        threethree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSquare(threethree);
            }
        });
    }
    public static void main(String[] args){
        JFrame window = new MainGUI("Tic Tac Toe");
        window.setVisible(true);

    }
    public void setSquare(JButton button){
        if(button.getText() != "X" && button.getText() != "O") {
            if (playersTurn) {
                button.setText("X");
            } else if(!playersTurn) {
                button.setText("O");
            }
            switchPosession();
        }
    }
    public void switchPosession(){
        if(playersTurn){
            playersTurn = false;
            StatusIndicator.setText("Player 2 turn!");
        }
        else{
            playersTurn = true;
            StatusIndicator.setText("Player 1 turn!");
        }
        checkWinner();
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
    public boolean tie(){
        return (oneone.getText() == "X" || oneone.getText() == "O") && (onetwo.getText() == "X" || onetwo.getText() == "O") && (onethree.getText() == "X" || onethree.getText() == "O") &&(twoone.getText() == "X" || twoone.getText() == "O") && (twotwo.getText() == "X" || twotwo.getText() == "O") &&(twothree.getText() == "X" || twothree.getText() == "O") && (threeone.getText() == "X" || threeone.getText() == "O") && (threetwo.getText() == "X" || threetwo.getText() == "O") && (threethree.getText() == "X" || threethree.getText() == "O");
    }
    public void checkWinner(){
        if((firstrow() && oneone.getText() == "X")|| (secondRow() && twoone.getText() == "X") || (thirdRow() && threeone.getText() == "X") || (firstcolumn() && oneone.getText() == "X") || (secondcolumn() && onetwo.getText() == "X") || (thirdcolumn() && onethree.getText() == "X") || (diagonal() && twotwo.getText() == "X")){
            p1wincounter++;
            p1wins.setText("Player 1 wins: " + p1wincounter);
            endGame();
        }
        else if(tie()){
            endGame();
            tiecounter++;
            ties.setText("Ties: " + tiecounter);
        }
        else if ((firstrow() && oneone.getText() == "O")|| (secondRow() && twoone.getText() == "O") || (thirdRow() && threeone.getText() == "O") || (firstcolumn() && oneone.getText() == "O") || (secondcolumn() && onetwo.getText() == "O") || (thirdcolumn() && onethree.getText() == "O") || (diagonal() && twotwo.getText() == "O")){
            p2wincounter++;
            p2wins.setText("Player 2 wins: " + p2wincounter);
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
