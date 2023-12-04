import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class Rental implements Serializable{
    private static final AtomicLong contract_counter = new AtomicLong(1);
    private long contract;
    private int time;   
    private double price;

    private Equipment equip;

    public Rental(int time, Equipment equip){
        this.time = time; 
        this.equip = equip;

        price = equip.getValue(time);
        //this.contract = contract_counter.getAndIncrement();
        //num de contrato gerado automaticamente
    }

    public double totalPrice(){
        return price;
    }

    public String toString(){
        String rental_str = "informações do aluguel:\nNúmero do contrato: " + contract + "\nDuração do aluguel: " + time + "\nPreço total: " + price + "\n\n" + equip.toString();
        return rental_str;
    }
}