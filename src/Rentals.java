import java.io.Serializable;
import java.util.ArrayList;

public class Rentals implements Serializable, Rentables{
    private ArrayList<Rental> rentals;

    public Rentals(){
        this.rentals = new ArrayList<Rental>();
    }

    public String newRental(int id, int time, boolean hasLesson){

        if(hasLesson == true){
            EquipmentWithLesson equipment_with_lesson = new EquipmentWithLesson(id);
            Lesson less = new Lesson(equipment_with_lesson);
            Rental rental = new Rental(time, less);
            rentals.add(rental);
            return "feito";
        }

        else if(hasLesson ==  false){
            EquipmentWithoutLesson equipment_without_lesson = new EquipmentWithoutLesson(id);
            Rental rental = new Rental(time, equipment_without_lesson);
            rentals.add(rental);
            return "feito";
        }

        else{
            return "erro";
        }
    }

    public double pega1(){
        return rentals.get(0).totalPrice();
    } 

    //invalidEquipmentException-----

    /*public void saveToFile(String name){

    }

    public String listAll(){

    }

    public int size(){

    }*/
}