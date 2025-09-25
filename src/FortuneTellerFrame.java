import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

//make a list of the changes you still need to implement
//Come back to writing fortunes into the ArrayList; return to the Swing GUI 02 video at 30 minutes
//Write JavaDoc
//UML diagrams?

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel fortunesPnl;
    JPanel controlPnl;

    Font fortunePnlFont;

    JLabel titleLbl;
    ImageIcon fortuneIcon;

    JTextArea fortuneTA;
    JScrollPane scroller;

    JButton fortuneBtn;
    ArrayList<String> fortuneOptions;

    JButton quitBtn;

    public FortuneTellerFrame()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth * 3/4, screenHeight * 3/4);
        setLocationRelativeTo(null);

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTitlePnl();

        createFortunesPnl();
        mainPnl.add(fortunesPnl, BorderLayout.CENTER);

        createControlPnl();

        fortuneOptions.add("In the next two days, you will meet a lucky cat.");
        fortuneOptions.add("In one month, you will encounter an ice cream truck.");
        fortuneOptions.add("Within the next 5 months, you will be headbutted by a goat.");
        fortuneOptions.add("In 5 years, you will eat a fortune cookie and receive your fortune.");
        fortuneOptions.add("Three years from now, you will narrowly lose a bid for president of your local PTA.");
        fortuneOptions.add("In 5 minutes, a fly will enter your house.");
        fortuneOptions.add("In 30 seconds, you will continue to experience gravity.");
        fortuneOptions.add("In the next two weeks, you will accidentally acquire a pizza.");
        fortuneOptions.add("In 10 years, you will acquire a pet capybara.");
        fortuneOptions.add("In 9 months, you will understand the meaning of E equals mc squared.");

        add(mainPnl);
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTitlePnl()
    {

    }

    private void createFortunesPnl()
    {
        fortunesPnl = new JPanel();
        fortunePnlFont = new Font("Verdana", Font.PLAIN, 14);
        fortuneTA = new JTextArea(10, 25);
        fortuneTA.setEditable(false);
        fortuneTA.setFont(fortunePnlFont);
        scroller = new JScrollPane(fortuneTA);

        fortunesPnl.add(scroller);
    }

    private void createControlPnl()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 2));

        fortuneBtn = new JButton("Read My Fortune!");
        quitBtn = new JButton("Quit");

        controlPnl.add(fortuneBtn);
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {

        });

        controlPnl.add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
    }
}
