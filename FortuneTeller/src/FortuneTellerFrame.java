import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl;
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    ImageIcon icon;
    JLabel titleLbl;

    JTextArea displayTA;
    JScrollPane scroller;

    JButton fortBtn;
    JButton quitBtn;

    int fortCnt = -1;

    Random rnd =new Random();

    ArrayList<String> fortunes;

    public FortuneTellerFrame()
    {
        fortunes = new ArrayList<>();
        fortunes.add("Fortune 1: you will have a good day");
        fortunes.add("Fortune 2: you will have a bad day");
        fortunes.add("Fortune 3: you will have a fun day");
        fortunes.add("Fortune 4: you will fall over today");
        fortunes.add("Fortune 5: you will learn a new trick");
        fortunes.add("Fortune 6: you will get a new dog today");
        fortunes.add("Fortune 7: you will get stronger");
        fortunes.add("Fortune 8: you will get weaker");
        fortunes.add("Fortune 9: it will rain on you");
        fortunes.add("Fortune 10: you will have a bad hair day");
        fortunes.add("Fortune 11: you will find a penny");
        fortunes.add("Fortune 12: you will find 110 dollars");

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(400,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*A JLabel with text “Fortune Teller” (or something similar!) and an ImageIcon.
    Find an appropriate non-commercial Fortune Teller image for your ImageIcon.
    (The JLabel has a constructor that takes a String and the ImageIcon.
     Figure out from the Swing API or the content in Canvas how to display the text
     either above or below the ImageIcon.) Select a font face that works with your image and set
      the size to a larger value (try 36 and 48).  Note that you have to add the image file to
       your IntelliJ project directory. */
    private void createTopPanel()
    {
        topPnl = new JPanel();
        icon= new ImageIcon("src/imgicon.png");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);

        topPnl.add(titleLbl);


    }

    private void createMiddlePanel()
    {
        middlePnl = new JPanel();
        displayTA = new JTextArea(10,25);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        middlePnl.add(scroller);

    }

    private void createBottomPanel()
    {

        bottomPnl =new JPanel();
        bottomPnl.setLayout(new GridLayout(1,2));

        fortBtn = new JButton("Read My Fortune!");
        fortBtn.addActionListener((ActionEvent ae) ->
        {
            int r;
            do {
                r = rnd.nextInt(fortunes.size());
            } while (r == fortCnt);  // Ensure it's not the same as the last one
            fortCnt = r;  // Update the last index

            String fortune = fortunes.get(r);
            displayTA.append(fortune + "\n");
        });
        quitBtn= new JButton("Quit");

        bottomPnl.add(fortBtn);
        bottomPnl.add(quitBtn);

        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

    }

}
