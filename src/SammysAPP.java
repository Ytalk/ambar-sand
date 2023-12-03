import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

//import javax.swing.*;
import javax.swing.text.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.*;//color

public class SammysAPP extends JFrame{
    
    Rentals rentals = new Rentals();
    int id = 1;
    boolean lesson = false;

    public SammysAPP(){

        setLayout(null);
        setTitle("Sammys APP");//basico
        
        

        //PAINEL RELACIONADO AO TEMPO
        JPanel time_panel = new JPanel(new BorderLayout());
        add(time_panel, BorderLayout.CENTER);
        time_panel.setBackground(new Color(100, 50, 100));
        time_panel.setBounds(200, 100, 400, 40);////////////////////

        JLabel time_label = new JLabel("Tempo de aluguel");
        time_label.setPreferredSize(new Dimension(150, 40));
        time_label.setHorizontalAlignment(SwingConstants.CENTER);
        time_label.setVerticalAlignment(SwingConstants.CENTER);
        time_panel.add(time_label, BorderLayout.WEST);

        JTextArea time_area = new JTextArea();
        time_area.setPreferredSize(new Dimension(250, 40));
        time_panel.add(time_area, BorderLayout.CENTER);


        //PAINEL RELACIONADO AO EQUIPAMENTO
        JPanel equipment_panel = new JPanel(new BorderLayout());
        add(equipment_panel);
        equipment_panel.setBackground(new Color(100, 50, 100));
        equipment_panel.setBounds(200, 200, 400, 40);//////////////////////

        JLabel equipment_label = new JLabel("Equipamento");
        equipment_label.setPreferredSize(new Dimension(150, 40));
        equipment_label.setHorizontalAlignment(SwingConstants.CENTER);
        equipment_label.setVerticalAlignment(SwingConstants.CENTER);
        equipment_panel.add(equipment_label, BorderLayout.WEST);

        String[] types = {"jet ski", "barco pontão", "barco a remo", "canoa", "caiaque", "cadeira de praia", "guarda-sol", "gazebo"};
        JComboBox<String> comboBox = new JComboBox<>(types);
        equipment_panel.add(comboBox, BorderLayout.CENTER);

        comboBox.addActionListener(e -> {
            JComboBox<String> source = (JComboBox<String>) e.getSource();
            id = (source.getSelectedIndex() + 1);
            //System.out.println("Selected Index: " + selectedIndex);
        });



        JCheckBox checkBox = new JCheckBox("incluir aula");
        checkBox.setBounds(500, 275, 100, 40);
        checkBox.setBackground(new Color(100, 50, 100));
        add(checkBox);

        checkBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {

                System.out.println("checkbox on.");
                lesson = true;
            } 
            else if (e.getStateChange() == ItemEvent.DESELECTED) {

                System.out.println("checkbox off.");
                lesson = false;
            }
        });



        JButton Confirm_button = new JButton("Confirmar Aluguel");
        Confirm_button.setBounds(200, 350, 150, 40);
        add(Confirm_button);

        Confirm_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                if(time_area.getText().isEmpty()) {
                    throw new NumberFormatException("tempo de aluguel não informado.", "TIME ERROR");
                }
                else if( time_area.getText().matches("\\d+") == false){
                    throw new NumberFormatException("o tempo de aluguel não pode conter letras", "TIME ERROR");
                }
                else if(Integer.parseInt(time_area.getText()) < 0){
                    throw new NumberFormatException("o tempo de aluguel não pode ser negativo", "TIME ERROR");
                }
                else{
                    int time = Integer.parseInt(time_area.getText());


                    String confirmation_str = rentals.newRental(id, time, lesson);
                    JOptionPane.showMessageDialog(null, confirmation_str, "Compra finalizada!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });




        /*// Cria um JLabel com um ícone
        ImageIcon icon = new ImageIcon("seashore\\src/imagem.jpg");
        JLabel label = new JLabel("Sua mensagem aqui", icon, JLabel.CENTER);

        // Exibe o JOptionPane com o JLabel personalizado*/



        JButton list_button = new JButton("Listar Alugueis");
        list_button.setBounds(450, 350, 150, 40);
        add(list_button);

        list_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rentals.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ainda não há alugueis", "Todos os alugueis", JOptionPane.INFORMATION_MESSAGE);
                } 
                else {
                    ArrayList<String> dataList = new ArrayList<>(rentals.listAll2());
        
                    JDialog listDialog = new JDialog();
                    listDialog.setTitle("Lista de Aluguéis");
                    listDialog.setSize(new Dimension(400, 300));
                    listDialog.setLocationRelativeTo(null);
                    listDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
                    JList<String> list = new JList<>(dataList.toArray(new String[dataList.size()]));
        
                    JScrollPane scrollPane = new JScrollPane(list);
                    listDialog.add(scrollPane);
        
                    listDialog.setVisible(true);
                }
            }
        });



        setPreferredSize(new Dimension(854, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(100, 50, 100));
        setLocationRelativeTo(null);
        setVisible(true);
        pack();


    }

        

    public static void main(String[]args){

        new SammysAPP();
    }

}
