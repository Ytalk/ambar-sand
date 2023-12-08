package ambar;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;

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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.DefaultListCellRenderer;

public class AmbarSandAPP extends JFrame{
    
    Rentals rentals = new Rentals();
    int id = 1;//valor iniciado no estado natural
    boolean lesson;
    
    

    /**
     * Interface gráfica do programa.
     */
    public AmbarSandAPP(){

        rentals.loadFile();//inicia com os dados (se houver)
    


        //MENUBAR
        JMenuBar mb = new JMenuBar();  
        JMenu menu = new JMenu("file");
        JMenuItem salvar = new JMenuItem("salvar");

        menu.add(salvar);
        mb.add(menu);
        add(mb);

        mb.setBackground(new Color (255, 160, 0));
        setJMenuBar(mb);

        salvar.addActionListener(new ActionListener(){//primeira classe anônima
            @Override
            public void actionPerformed(ActionEvent e){
                rentals.saveToFile();
            }
        });

        

        //PAINEL RELACIONADO AO TEMPO
        JPanel time_panel = new JPanel(new BorderLayout());
        add(time_panel);
        time_panel.setBackground(new Color(255, 191, 0));
        time_panel.setBounds(220, 100, 400, 30);//posição e tamanho dos elementos

        JLabel time_label = new JLabel("Tempo de aluguel");
        time_label.setPreferredSize(new Dimension(150, 30));
        time_label.setHorizontalAlignment(SwingConstants.CENTER);
        time_label.setVerticalAlignment(SwingConstants.CENTER);
        time_panel.add(time_label, BorderLayout.WEST);

        JTextArea time_area = new JTextArea();
        time_panel.add(time_area, BorderLayout.CENTER);



        //CHECKBOX DE AULA
        JCheckBox check_box = new JCheckBox("incluir aula");
        check_box.setBounds(530, 250, 90, 30);//posição e tamanho
        check_box.setBackground(new Color(255, 191, 0));
        add(check_box);

        check_box.addItemListener(e -> {//primeira classe anônima compacta
            if(e.getStateChange() == ItemEvent.SELECTED){//usando 'e' para aprender
                lesson = true;
            } 
            else if(e.getStateChange() == ItemEvent.DESELECTED){
                lesson = false;
            }
        });



        //PAINEL RELACIONADO AO EQUIPAMENTO
        JPanel equipment_panel = new JPanel(new BorderLayout());
        add(equipment_panel);
        equipment_panel.setBackground(new Color(255, 191, 0));
        equipment_panel.setBounds(220, 200, 400, 30);//posição e tamanho dos elementos

        JLabel equipment_label = new JLabel("Equipamento");
        equipment_label.setPreferredSize(new Dimension(150, 30));
        equipment_label.setHorizontalAlignment(SwingConstants.CENTER);
        equipment_label.setVerticalAlignment(SwingConstants.CENTER);
        equipment_panel.add(equipment_label, BorderLayout.WEST);

        String[] types = {"jet ski", "barco pontão", "barco a remo", "canoa", "caiaque", "cadeira de praia", "guarda-sol", "gazebo"};
        JComboBox<String> combo_box = new JComboBox<>(types);
        equipment_panel.add(combo_box, BorderLayout.CENTER);

        combo_box.addActionListener(e -> {

            JComboBox<String> temp_combo = (JComboBox<String>) e.getSource();//usando tempóraria apenas para aprender
            id = (temp_combo.getSelectedIndex() + 1);
            String description = (String) temp_combo.getSelectedItem();

            if( ("cadeira de praia".equals(description)) || ("guarda-sol".equals(description)) || ("gazebo".equals(description)) ){//definitivamente sem aula
                check_box.setSelected(false);//desmarca
                check_box.setEnabled(false);//desabilita
            } 
            else{
                check_box.setEnabled(true);//operante
            }
        });



        //ALUGA OU TRATA ERRO
        JButton Confirm_button = new JButton("Confirmar Aluguel");
        Confirm_button.setBounds(220, 300, 136, 30);
        add(Confirm_button);

        Confirm_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                try{
                    if(time_area.getText().isEmpty()){
                        throw new NumberFormatException("Tempo de aluguel não informado!", "TIME ERROR");
                    }
                    else if(!time_area.getText().matches("-?\\d+")){
                        throw new NumberFormatException("Tempo de aluguel não pode conter letras!", "TIME ERROR");
                    }
                    else if (Integer.parseInt(time_area.getText()) < 30){
                        throw new NumberFormatException("Tempo de aluguel não pode ser abaixo de 30 minutos!", "TIME ERROR");
                    }

                    else{

                        try{
                            int time = Integer.parseInt(time_area.getText());

                            String confirmation_str = rentals.newRental(id, time, lesson);

                            JOptionPane.showMessageDialog(null, confirmation_str, "Compra finalizada", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch(InvalidEquipmentException ex){
                            ex.showMessage();
                        }

                    }

                }
                catch(NumberFormatException ex){
                    ex.showMessage();
                }
            }
        });



        //LISTA TODOS OS ALUGUÉIS
        JButton list_button = new JButton("Listar Aluguéis");
        list_button.setBounds(485, 300, 136, 30);//posição e tamanho
        add(list_button);

        list_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(rentals.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Ainda não há alugueis!", "Lista vazia", JOptionPane.INFORMATION_MESSAGE);
                } 
                else{
                    JDialog list_frame = new JDialog();//moldura da lista
                    list_frame.setTitle("Lista de aluguéis");
                    list_frame.setSize(new Dimension(400, 400));
                    list_frame.setLocationRelativeTo(null);
                    list_frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
                    String rentals_txt = rentals.listAll();//String com as informações dos aluguéis
                    
                    JTextArea rentals_list = new JTextArea(rentals_txt);//conteúdo da lista
        
                    JScrollPane scroll = new JScrollPane(rentals_list);
                    list_frame.add(scroll);
                    list_frame.setVisible(true);
                }
            }
        });



        //DETALHES DO FRAME
        setLayout(null);
        setTitle("Ambar Sand");
        setPreferredSize(new Dimension(854, 480));
        getContentPane().setBackground(new Color(255, 191, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();//empacota/organiza
        setLocationRelativeTo(null);//centraliza
        setVisible(true);
    }


    /**
     * Main do Programa.
     */
    public static void main(String[]args){
        new AmbarSandAPP();
    }

}
