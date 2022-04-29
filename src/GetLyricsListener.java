import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetLyricsListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    String hymnNumber = GetHymnLyrics.tf.getText();
    try {
      System.out.println();
      File fXmlFile = new File("data/Songs2.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fXmlFile);
      doc.getDocumentElement().normalize();
      NodeList lyricsList = doc.getElementsByTagName("ROWSONG_SECTIONS");
      NodeList songNames = doc.getElementsByTagName("ROWSONGS");
      String songName = "";
      for (int temp = 0; temp < songNames.getLength(); temp++) {
        Node nNode = songNames.item(temp);
        if (nNode.getNodeType() == 1) {
          Element eElement = (Element) nNode;
          if (eElement.getAttribute("SONG_ID").equals(hymnNumber))
            songName = eElement.getAttribute("SONG_TITLE");
        }
      }
      ArrayList<Element> chosenHymn = new ArrayList<>();
      boolean hasChorus = false;
      String chorus = "";
      for (int j = 0; j < lyricsList.getLength(); j++) {
        Node nNode = lyricsList.item(j);
        if (nNode.getNodeType() == 1) {
          Element eElement = (Element) nNode;
          if (eElement.getAttribute("SONG_ID").equals(hymnNumber))
            chosenHymn.add(eElement);
        }
      }
      for (int i = 0; i < chosenHymn.size(); i++) {
        if (((Element) chosenHymn.get(i)).getAttribute("SECTION_NAME").equals("Refrain")) {
          hasChorus = true;
          chorus = ((Element) chosenHymn.get(i)).getAttribute("SECTION_TEXT");
        }
      }
      String output = String.valueOf(hymnNumber) + " - " + songName + "\n\n";
      for (int k = 0; k < chosenHymn.size(); k++) {
        Element line = chosenHymn.get(k);
        if (!line.getAttribute("SECTION_NAME").equals("Refrain")) {
          output = String.valueOf(output) + line.getAttribute("SECTION_NAME");
          output = String.valueOf(output) + "\n";
          output = String.valueOf(output) + line.getAttribute("SECTION_TEXT");
          if (!hasChorus && k < chosenHymn.size() - 1)
            output = String.valueOf(output) + "\n";
          if (hasChorus) {
            output = String.valueOf(output) + "\nChorus\n";
            output = String.valueOf(output) + chorus;
            if (k < chosenHymn.size() - 1)
              output = String.valueOf(output) + "\n";
          }
        }
      }
      String trimmedOutput = output.trim();
      StringSelection stringSelection = new StringSelection(trimmedOutput);
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(stringSelection, null);
      if (chosenHymn.size() > 0) {
        JOptionPane.showMessageDialog(null,
            "Hymn Lyrics Have Been Copied to Clipboard for use in ProPresenter 6. Please import using Import From Clipboard.");
      } else {
        JOptionPane.showMessageDialog(null, "Sorry, This Hymn is not available.");
      }
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }
}
