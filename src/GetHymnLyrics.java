import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GetHymnLyrics {
  public static JTextField tf = new JTextField(3);
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("Get Hymn Lyrics");
    frame.setDefaultCloseOperation(3);
    frame.setSize(404, 77);
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Enter Hymn Number:");
    JButton getLyrics = new JButton("Get Lyrics");
    panel.add(label);
    panel.add(tf);
    panel.add(getLyrics);
    JTextArea ta = new JTextArea();
    ActionListener getLyricListener = new GetLyricsListener();
    getLyrics.addActionListener(getLyricListener);
    frame.getContentPane().add("Center", panel);
    frame.setVisible(true);
  }
}
