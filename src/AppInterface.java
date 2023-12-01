import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.*;//color

public class AppInterface extends JFrame{

    public AppInterface(){

                setLayout(null);



        
        JPanel time_panel = new JPanel(new BorderLayout());
        add(time_panel, BorderLayout.CENTER);
        time_panel.setBounds(200, 100, 400, 40);////////////////////

        JLabel time_label = new JLabel("Tempo de aluguel");
        time_label.setPreferredSize(new Dimension(150, 40));
        time_label.setHorizontalAlignment(SwingConstants.CENTER);
        time_label.setVerticalAlignment(SwingConstants.CENTER);
        time_panel.add(time_label, BorderLayout.WEST);

        JTextArea time_field = new JTextArea();
        time_field.setPreferredSize(new Dimension(250, 40));
        time_panel.add(time_field, BorderLayout.CENTER);



        JPanel equipment_panel = new JPanel(new BorderLayout());
        add(equipment_panel);
        equipment_panel.setBounds(200, 200, 400, 40);//////////////////////

        JLabel equipment_label = new JLabel("Equipamento");
        equipment_label.setPreferredSize(new Dimension(150, 40));
        equipment_label.setHorizontalAlignment(SwingConstants.CENTER);
        equipment_label.setVerticalAlignment(SwingConstants.CENTER);
        equipment_panel.add(equipment_label, BorderLayout.WEST);

        String[] options = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        equipment_panel.add(comboBox, BorderLayout.CENTER);



        JButton Confirm_button = new JButton("Confirmar Aluguel");
        Confirm_button.setBounds(200, 350, 150, 40);
        add(Confirm_button);



        JButton list_button = new JButton("Listar Alugueis");
        list_button.setBounds(450, 350, 150, 40);
        add(list_button);



        JCheckBox checkBox1 = new JCheckBox("incluir aula");
        checkBox1.setBounds(500, 275, 100, 40);
        add(checkBox1);


        setTitle("Sammys APP");//basico
        setPreferredSize(new Dimension(854, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(100, 50, 100));
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }
}