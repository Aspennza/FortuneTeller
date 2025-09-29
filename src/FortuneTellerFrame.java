import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * Creates an extension of the JFrame class called FortuneTellerFrame. Allows users to press a button in the GUI
 * to have a random fortune generated for them.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class FortuneTellerFrame extends javax.swing.JFrame
{
    //A JPanel containing all the other JPanels in the program
    JPanel mainPnl;

    //A JPanel containing all the content aligned to the NORTH of the mainPnl
    JPanel titlePnl;

    //A JPanel containing all the content aligned to the CENTER of the mainPnl
    JPanel fortunesPnl;

    //A JPanel containing all the content aligned to the SOUTH of the mainPnl
    JPanel controlPnl;

    //A Font used for all the text in the titlePnl
    Font titlePnlFont;

    //A Font used for all the text in the fortunePnl
    Font fortunePnlFont;

    //A Font used for all the text in the controlPnl
    Font controlPnlFont;

    //A JLabel used to contain all the content in the titlePnl, including text and an ImageIcon
    JLabel titleLbl;

    //An ImageIcon used to store the picture in the titlePnl
    ImageIcon fortuneIcon;

    //A JTextArea used to display the randomized fortunes in the fortunesPnl
    JTextArea fortuneTA;

    //A JScrollPane used to contain fortuneTA
    JScrollPane scroller;

    //A JButton used to generate the randomized fortunes
    JButton fortuneBtn;

    //An ArrayList used to store the list of all the fortunes
    ArrayList<String> fortuneOptions;

    //This Random object allows for the random generation of ArrayList indices for fortunes
    Random gen = new Random();

    //This int stores the current fortune index
    int fortuneIndex = 0;

    //This int stores the index of the previous fortune
    int previousIndex = -1;

    //This int counts the total number of fortunes that have been generated
    int fortuneCount = 0;

    //This button allows the user to quit the GUI program
    JButton quitBtn;

    //This constructor sets the title, size, visibility, and default close operation of FortuneTellerFrame; it also puts the main panel inside the JFrame and the other panels inside the main panel and establishes the fortune options
    public FortuneTellerFrame()
    {
        super("Fortune Teller");

        //This Toolkit is used to find the screen size of the computer running the GUI
        Toolkit kit = Toolkit.getDefaultToolkit();

        //This Dimension stores the screen size
        Dimension screenSize = kit.getScreenSize();

        //This int stores the height of the screen
        int screenHeight = screenSize.height;

        //This int stores the width of the screen
        int screenWidth = screenSize.width;

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);

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

        setSize(screenWidth * 3/4, screenHeight * 3/4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Fortune Teller");
        setVisible(true);
    }

    /**
     * This method establishes the title panel, sets the image and text that will go inside it, and declares the font it will use
     */
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

    /**
     * This method establishes the fortunes panel and its font, as well as the JTextArea and JScrollPane that will go inside it
     */
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

    /**
     * This method establishes the control panel and its font, as well as the buttons and ActionListeners that go inside it
     */
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

        //This algorithm means that when the fortuneBtn is clicked, the program will append a random fortune to the fortuneTA JTextArea
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
                fortuneCount++;

                //This algorithm generates a random ArrayList index until it does not match the previous index
                do {
                    fortuneIndex = gen.nextInt(fortuneOptions.size());
                } while (previousIndex == fortuneIndex);

                fortuneTA.append(fortuneCount + ") " + fortuneOptions.get(fortuneIndex) + "\n");
                previousIndex = fortuneIndex;
        });

        controlPnl.add(quitBtn);

        //This algorithm means that when the quitBtn is clicked, the program will terminate
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
    }
}
