import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AAA {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> createAndShowGUI());
  }

  private static void createAndShowGUI() {
    JFrame frame = new JFrame("CV Builder");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BorderLayout());

    JPanel inputPanel = new JPanel(new GridLayout(7, 2));
    contentPane.add(inputPanel, BorderLayout.CENTER);

    JLabel nameLabel = new JLabel("Full Name:");
    JTextField nameField = new JTextField();
    inputPanel.add(nameLabel);
    inputPanel.add(nameField);

    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField();
    inputPanel.add(emailLabel);
    inputPanel.add(emailField);

    JLabel phoneLabel = new JLabel("Phone:");
    JTextField phoneField = new JTextField();
    inputPanel.add(phoneLabel);
    inputPanel.add(phoneField);

    JLabel educationLabel = new JLabel("Education:");
    JTextField educationField = new JTextField();
    inputPanel.add(educationLabel);
    inputPanel.add(educationField);

    JLabel workExperienceLabel = new JLabel("Work Experience:");
    JTextField workExperienceField = new JTextField();
    inputPanel.add(workExperienceLabel);
    inputPanel.add(workExperienceField);

    JLabel skillsLabel = new JLabel("Skills:");
    JTextField skillsField = new JTextField();
    inputPanel.add(skillsLabel);
    inputPanel.add(skillsField);

    JButton generateCVButton = new JButton("Generate CV");
    contentPane.add(generateCVButton, BorderLayout.SOUTH);

    generateCVButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String education = educationField.getText();
        String workExperience = workExperienceField.getText();
        String skills = skillsField.getText();

        String cv = generateCV(name, email, phone, education, workExperience, skills);
        JTextArea textArea = new JTextArea(cv);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 350));

        JOptionPane.showMessageDialog(frame, scrollPane, "Generated CV", JOptionPane.INFORMATION_MESSAGE);
      }
    });

    frame.setVisible(true);
  }

  private static String generateCV(String name, String email, String phone, String education, String workExperience, String skills) {
    StringBuilder cv = new StringBuilder();

    cv.append("Name: ").append(name).append("\n");
    cv.append("Email: ").append(email).append("\n");
    cv.append("Phone: ").append(phone).append("\n\n");
    cv.append("Education:\n").append(education).append("\n\n");
    cv.append("Work Experience:\n").append(workExperience).append("\n\n");
    cv.append("Skills:\n").append(skills).append("\n");

    return cv.toString();
  }
}

