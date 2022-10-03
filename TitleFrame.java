import javax.swing.*;

class TitleFrame extends JFrame {

    public TitleFrame() {

        setTitle("MILO");
        setSize(500, 700);


        TitlePanel mainPanel = new TitlePanel();


        add(mainPanel);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}