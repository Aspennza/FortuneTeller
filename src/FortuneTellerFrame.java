import javax.swing.*;

public class FortuneTellerFrame extends JFrame
{
    JPanel titlePnl;
    JPanel fortunesPnl;
    JPanel controlPnl;

    JLabel titleLbl;
    ImageIcon fortuneIcon;

    public FortuneTellerFrame()
    {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
