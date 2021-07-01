import javax.swing.*;

public class MainGUI extends JFrame{
    private JPanel gui;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    public MainGUI(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(gui);
        this.pack();
    }
    public static void main(String[] args){
        JFrame window = new MainGUI("Tic Tac Toe");
        window.setVisible(true);

    }
}
