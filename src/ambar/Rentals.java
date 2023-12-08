package ambar;

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


    public String newRental(int id, int time, boolean hasLesson) throws InvalidEquipmentException{

        if(hasLesson == true){//Rental instânciado com base em aula true ou false
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

        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("ambar.byte"))){//cria OOS para escrever. FOS abre arquivo para para escrever bytes
            writer.writeObject(rentals);//escreve rentals no arquivo
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!", "Salvamento", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch(IOException e){
            e.printStackTrace();
        }    
    }


    public void loadFile(){//carrega dados para a lista rentals

        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("ambar.byte"))){//cria OIS para ler objetos do arquivo
            rentals.clear();//limpa a lista atual antes de carregar os dados do arquivo ambar
            
            rentals.addAll((ArrayList<Rental>) reader.readObject());//lê os objetos serializados do arquivo e adiciona à lista rentals

            reader.registerValidation(this, 0);//registra o objeto para validação. intância atual "rentals", validação imediata. (implementa a interface, prioridade de validação/ordem/quanto menor mais prioridade)
        } 
        
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Seja bem-vindo ao Ambar Sand!", "Boas-vindas", JOptionPane.INFORMATION_MESSAGE);
        }
        
        catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Não foi possível carregar a lista", JOptionPane.ERROR_MESSAGE);
        }  
    }

    @Override
    public void validateObject() throws InvalidObjectException{//validação personalizada após leitura do objeto. parte da interface OIV

        if(rentals == null){
            throw new InvalidObjectException("A lista de alugueis não foi corretamente carregada!");
        }
    }


    public String listAll(){//método deixado de lado por conta do JList
        StringBuilder rentals_list = new StringBuilder();
        for(Rental rental : rentals){
            rentals_list.append(rental.toString()).append("\n===================================================\n\n");
        }

        return rentals_list.toString();
    }

    //public int size(){  return rentals.size();  }
}