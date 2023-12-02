import java.io.Serializable;

public class Rental implements Serializable{
    private long contract;
    private int time;   
    private double price;

    private Equipment equip;

    public Rental(int time, Equipment equip){
        this.time = time; 
        this.equip = equip;

        price = equip.getValue(time);
        //num de contrato gerado automaticamente
    }

    public double totalPrice(){
        return price;
    }

    public String toString(){
        String rental_str = "informações do aluguel:\nDuração do aluguel: " + time + "\nPreço total: " + price + "\n\n" + equip.toString();
        return rental_str;
    }
}