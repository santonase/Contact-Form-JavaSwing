package JavaSwing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JTextField nameField, emailField;
    private JRadioButton male, female;
    private JCheckBox checkBox;

    public ContactForm() {
        super("Contact form");
        super.setBounds(200, 200, 350, 200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 2));

        JLabel name = new JLabel("Enter your name:");
        nameField = new JTextField("", 1);

        JLabel email = new JLabel("Enter your email:");
        emailField = new JTextField("", 1);

        container.add(name);
        container.add(nameField);
        container.add(email);
        container.add(emailField);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        male.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(male);
        container.add(female);

        checkBox = new JCheckBox("Agree?", true);
        container.add(checkBox);

        JButton btn = new JButton("Send");
        container.add(btn);

        btn.addActionListener(new ButtonEventManager());


    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();

            String isMale = "Male";
            if(!male.isSelected())
                isMale = "Female";

            boolean isCheck = checkBox.isSelected();

            JOptionPane.showMessageDialog(null,
                    "Your email: " + email + "\nYou: " + isMale + "\nDo you agree? " + isCheck,
                    "Hello, " + name,
                    JOptionPane.PLAIN_MESSAGE);
        }

    }

}
