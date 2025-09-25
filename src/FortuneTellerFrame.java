import javax.swing.*;
import java.awt.*;

//make a list of the changes you still need to implement
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
    JButton quitBtn;

    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTitlePnl();

        createFortunesPnl();
        mainPnl.add(fortunesPnl, BorderLayout.CENTER);

        createControlPnl();

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

    }
}
