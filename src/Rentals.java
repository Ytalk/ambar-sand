import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rentals implements Serializable, Rentables{
    private ArrayList<Rental> rentals;

    public Rentals(){
        this.rentals = new ArrayList<>();
    }

    //@Override
    public boolean isEmpty(){
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
            EquipmentWithLesson equipment_with_lesson = new EquipmentWithLesson(id);
            Lesson less = new Lesson(equipment_with_lesson);
            Rental rental = new Rental(time, less);
            rentals.add(rental);
            return rental.toString();
        }
        else{
            EquipmentWithoutLesson equipment_without_lesson = new EquipmentWithoutLesson(id);
            Rental rental = new Rental(time, equipment_without_lesson);
            rentals.add(rental);
            return rental.toString();
        }
        
    }


    public void saveToFile(String name){
    
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("ambar.byte"))) {
            writer.writeObject(rentals);
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

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
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

    /*public int size(){

    }*/
}