package AwtPrograme;

import java.awt.*;
import java.awt.event.*;

public class ButtonExample {

    public static void main(String[] args) {
        Frame f = new Frame();
        Button b = new Button("Click to Submit");
        Label nameLabel = new Label("Name:");
        TextField name = new TextField("Enter the name");
        nameLabel.setBounds(50, 30, 50, 20);
        name.setBounds(100, 30, 200, 20);
        b.setBounds(50, 160, 100, 30);

        // Father name
        Label fatherNameLabel = new Label("Father Name:");
        TextField fatherName = new TextField("Enter the Father Name");
        fatherNameLabel.setBounds(50, 60, 80, 20);
        fatherName.setBounds(150, 60, 200, 20);

        // Checkbox
        Checkbox checkbox = new Checkbox("Choose the option");
        Checkbox checkbox1 = new Checkbox("Dance");
        checkbox.setBounds(50, 90, 150, 20);
        checkbox1.setBounds(200, 90, 80, 20);

        // Radio Button
        Label genderLabel = new Label("Gender:");
        genderLabel.setBounds(50, 120, 50, 20);
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        Checkbox maleCheckbox = new Checkbox("Male", checkboxGroup, true);
        Checkbox femaleCheckbox = new Checkbox("Female", checkboxGroup, false);
        maleCheckbox.setBounds(100, 120, 50, 20);
        femaleCheckbox.setBounds(150, 120, 60, 20);

        // ActionListener for the button
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nameValue = name.getText();
                String fatherNameValue = fatherName.getText();
                String gender = maleCheckbox.getState() ? "Male" : "Female";
                String hobbies = checkbox.getState() ? "Dance" : "";
                System.out.println("Name: " + nameValue);
                System.out.println("Father's Name: " + fatherNameValue);
                System.out.println("Gender: " + gender);
                System.out.println("Hobbies: " + hobbies);
            }
        });

        f.add(checkbox1);
        f.add(checkbox);
        f.add(nameLabel);
        f.add(name);
        f.add(fatherNameLabel);
        f.add(fatherName);
        f.add(b);
        f.add(genderLabel);
        f.add(maleCheckbox);
        f.add(femaleCheckbox);
        f.setLayout(null);
        f.setSize(400, 250);
        f.setVisible(true);
    }
}
