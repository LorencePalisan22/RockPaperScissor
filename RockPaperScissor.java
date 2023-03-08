import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RockPaperScissor extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JButton btnRock, btnPaper, btnScissors, btnReset;
    private JLabel lblResult, lblPlayerScore, lblComputerScore;
    private int playerScore, computerScore;

    public RockPaperScissor() {
        super("Rock Paper Scissor");
        // Initialize UI elements
        lblTitle = new JLabel("Rock Paper Scissors");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);

        btnRock = new JButton("Rock");
        btnRock.addActionListener(this);
        
	        
        btnPaper = new JButton("Paper");
        btnPaper.addActionListener(this);

        btnScissors = new JButton("Scissors");
        btnScissors.addActionListener(this);

        btnReset = new JButton("Reset");
        btnReset.addActionListener(this);

        lblResult = new JLabel("");
        lblResult.setFont(new Font("Arial", Font.BOLD, 18));
        lblResult.setHorizontalAlignment(JLabel.CENTER);

        lblPlayerScore = new JLabel("Player Score: 0");
        lblPlayerScore.setFont(new Font("Arial", Font.PLAIN, 14));

        lblComputerScore = new JLabel("Computer Score: 0");
        lblComputerScore.setFont(new Font("Arial", Font.PLAIN, 14));

        // Set layout and add UI elements
        setLayout(new GridLayout(7, 1));
        add(lblTitle);
        add(btnRock);
        
        add(btnPaper);
        add(btnScissors);
        add(lblResult);
        add(lblPlayerScore);
        add(lblComputerScore);
        

        // Set frame properties
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
   

    public void actionPerformed(ActionEvent e) {
        String playerChoice = "";
        Object source = e.getSource();

        if (source == btnRock) {
            playerChoice = "rock";
        } else if (source == btnPaper) {
            playerChoice = "paper";
        } else if (source == btnScissors) {
            playerChoice = "scissors";
        } else if (source == btnReset) {
            playerScore = 0;
            computerScore = 0;
            lblResult.setText("");
            lblPlayerScore.setText("Player Score: 0");
            lblComputerScore.setText("Computer Score: 0");
            return;
        }

        String[] choices = { "rock", "paper", "scissors" };
        int computerIndex = (int)(Math.random() * choices.length);
        String computerChoice = choices[computerIndex];
        String result = "";

        if (playerChoice.equals(computerChoice)) {
            result = "Tie";
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            result = "You Win!";
            playerScore++;
        } else {
            result = "Computer Wins!";
            computerScore++;
        }

        lblResult.setText(result);
        lblPlayerScore.setText("Player Score: " + playerScore);
        lblComputerScore.setText("Computer Score: " + computerScore);
    }

    public static void main(String[] args) {
        new RockPaperScissor();
    }
}