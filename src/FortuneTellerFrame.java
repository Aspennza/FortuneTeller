import javax.swing.*;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel fortunesPnl;
    JPanel controlPnl;

    JLabel titleLbl;
    ImageIcon fortuneIcon;

    JTextArea fortuneTA;
    JScrollPane scroller;

    JButton fortuneBtn;
    JButton quitBtn;

    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        createTitlePnl();
        createFortunesPnl();
        createControlPnl();

        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTitlePnl()
    {

    }

    private void createFortunesPnl()
    {

    }

    private void createControlPnl()
    {

    }
}
