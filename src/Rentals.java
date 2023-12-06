import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Rentals implements Serializable, Rentables, ObjectInputValidation{
    private ArrayList<Rental> rentals;

    public Rentals(){
        this.rentals = new ArrayList<>();
    }

    public boolean isEmpty(){//como a lista rentals é "interna" esse método precisa ser implementado no Rentals para poder usar isEmpty externamente (main)
        return rentals.isEmpty();
    }

    public String newRental(int id, int time, boolean hasLesson){

        /*try{
            if(id > EquipmentAndValues.values().length){
                throw new invalidEquipmentException(id, "equipamento inválido com o id: ");
            }
        }
        catch(invalidEquipmentException e){
            return "error";
        }
        */

        if(hasLesson == true){
            EquipmentWithLesson equipment_with_lesson = new EquipmentWithLesson(id);//passa o id para instanciar um equipamento especifico do enum
            Lesson less = new Lesson(equipment_with_lesson);//informa que há aula onde lesson é a abstração de equipamento
            Rental rental = new Rental(time, less);
            rentals.add(rental);
            return rental.toString();//retorna string para servir como mensagem no JOptionPane
        }
        else{
            EquipmentWithoutLesson equipment_without_lesson = new EquipmentWithoutLesson(id);//unica mudança é que não tem aula
            Rental rental = new Rental(time, equipment_without_lesson);
            rentals.add(rental);
            return rental.toString();
        }
        
    }


    public void saveToFile(String name){



        /*JFileChooser file_chooser = new JFileChooser();
        file_chooser.setDialogTitle("Specify a directory to save");

        int user_selection = file_chooser.showSaveDialog(null);

        if(user_selection == JFileChooser.APPROVE_OPTION){
            File save_file = file_chooser.getSelectedFile();

            String file_path = save_file.getAbsolutePath();
            if (!file_path.endsWith(".txt")){
                save_file = new File(file_path + ".txt");
            }

            if (user_selection == JFileChooser.APPROVE_OPTION) {
                String pop_path = file_chooser.getSelectedFile().getAbsolutePath();
                JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso em: " + pop_path, "Arquivo salvo com sucesso!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(save_file))){
                writer.write(txt);
                System.out.println("Arquivo salvo com sucesso.");
            } 
            catch (IOException e){
                e.printStackTrace();
            }*/


        
            /*JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Escolha o diretório");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
            int userSelection = fileChooser.showSaveDialog(null);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // O usuário escolheu um diretório, você pode obter o caminho assim:
                String selectedDirectory = fileChooser.getSelectedFile().getPath();
                System.out.println("Diretório selecionado: " + selectedDirectory);
            } else {
                System.out.println("Nenhum diretório selecionado.");
            }*/


    
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("ambar.byte"))) {
            writer.writeObject(rentals);
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Salvamento", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //writer.close();
    }

    public void loadFile(){
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("ambar.byte"))) {
            // Limpa a lista atual antes de carregar os dados do arquivo
            rentals.clear();
            
            // Lê os objetos do arquivo e adiciona à lista
            rentals.addAll((ArrayList<Rental>) reader.readObject());

            reader.registerValidation(this, 0);

        } 
        
        catch (FileNotFoundException e) {
            // Arquivo não encontrado, trata o erro aqui
            JOptionPane.showMessageDialog(null, "seja bem-vindo ao Ambar Sand!", "Boas-vindas", JOptionPane.INFORMATION_MESSAGE);
        }
        
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        // Lógica de validação pós-leitura do objeto
        if (rentals == null) {
            throw new InvalidObjectException("Lista de aluguéis não foi corretamente carregada.");
        }
    }

    public String listAll(){
        StringBuilder rentals_list = new StringBuilder();
        for(Rental rental : rentals){
            rentals_list.append(rental.toString()).append("\n\n");
        }

        return rentals_list.toString();
    }

    public List<String> listAll2(){
        List<String> list = new ArrayList<>();
    
        for (int i = 0; i < rentals.size(); i++){
            list.add(rentals.get(i).toString());
    
            // Adicione uma linha vazia entre os aluguéis, exceto para o último aluguel
            if (i < rentals.size() - 1) {
                list.add("\n=================================================");
            }
        }
    
        return list;
    }

    //public int size(){  return rentals.size();  }
}