package View;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TotalView {

  public WindowFrame frame = new WindowFrame();
  public BasicPenal basicPenal = new BasicPenal();
  public FoodPenal foodPenal;
  private JLabel petSpeechLabel;
  private JTextArea petSpeechTextArea;

  public TotalView() {

    frame.getContentPane().add(basicPenal, BorderLayout.SOUTH);
    this.frame.pack();
    this.frame.setVisible(true);
    frame.myAddMouseListener();

    //宠物对话框初始化
    petSpeechLabel = new JLabel();
    petSpeechLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    petSpeechLabel.setHorizontalAlignment(JLabel.CENTER);
    petSpeechLabel.setVerticalAlignment(JLabel.TOP);
    petSpeechLabel.setBounds(20, 200, 200, 30);
    frame.add(petSpeechLabel);

  }

  public BasicPenal getBasicPenal() {
    return basicPenal;
  }
  public void showSpeach(String speach) {
    //System.out.println(speach);
    petSpeechLabel.setText(speach);
  }
}
