import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

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

    Font titlePnlFont;
    Font fortunePnlFont;
    Font controlPnlFont;

    JLabel titleLbl;
    ImageIcon fortuneIcon;

    JTextArea fortuneTA;
    JScrollPane scroller;

    JButton fortuneBtn;
    ArrayList<String> fortuneOptions;
    Random gen = new Random();
    int fortuneIndex = 0;
    String selectedFortune;
    Integer previousIndex;

    JButton quitBtn;

    int fortuneCount = 0;

    public FortuneTellerFrame()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTitlePnl();
        mainPnl.add(titlePnl, BorderLayout.NORTH);

        createFortunesPnl();
        mainPnl.add(fortunesPnl, BorderLayout.CENTER);

        createControlPnl();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        fortuneOptions = new ArrayList<>();
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
        fortuneOptions.add("In 2 weeks, you will see a toddler's shoe on the side of the road.");
        fortuneOptions.add("In two days, you will see the largest spider you have ever met.");
        fortuneOptions.add("In 1 week, you will meet a very old dog.");
        fortuneOptions.add("In three days, you will find an old piece of produce in the back of your fridge.");

        add(mainPnl);
        setTitle("Fortune Teller");
        setSize(screenWidth * 3/4, screenHeight * 3/4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTitlePnl()
    {
        titlePnl = new JPanel();
        fortuneIcon = new ImageIcon("src/Fortune_Teller_Image.jpg");
        titleLbl = new JLabel("Fortune Teller", fortuneIcon, JLabel.CENTER);
        titlePnlFont = new Font("Serif", Font.BOLD, 36);
        titleLbl.setFont(titlePnlFont);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titlePnl.add(titleLbl);
    }

    private void createFortunesPnl()
    {
        fortunesPnl = new JPanel();
        fortuneTA = new JTextArea(10, 90);
        fortuneTA.setEditable(false);
        fortunePnlFont = new Font("Monospaced", Font.PLAIN, 14);
        fortuneTA.setFont(fortunePnlFont);
        scroller = new JScrollPane(fortuneTA);

        fortunesPnl.add(scroller);
    }

    private void createControlPnl()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 2));

        controlPnlFont = new Font("SansSerif", Font.PLAIN, 16);

        fortuneBtn = new JButton("Read My Fortune!");
        fortuneBtn.setFont(controlPnlFont);

        quitBtn = new JButton("Quit");
        quitBtn.setFont(controlPnlFont);

        controlPnl.add(fortuneBtn);
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
                fortuneCount++;

                fortuneIndex = gen.nextInt(14);

                while (previousIndex != null && previousIndex == fortuneIndex)
                {
                    fortuneIndex = gen.nextInt(14);
                }

                selectedFortune = fortuneOptions.get(fortuneIndex);

                fortuneTA.append(fortuneCount + ") " + selectedFortune + "\n");
                previousIndex = fortuneIndex;
        });

        controlPnl.add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
    }
}
