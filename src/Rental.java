import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class Rental implements Serializable{

    private static final AtomicLong contract_counter = new AtomicLong(1);//cria contador para instâncias únicas

    private long contract;
    private int time;
    private double price;
    private Equipment equip;//usado para gerar informações toString e getPrice. e também polimorfismo


    public Rental(int time, Equipment equip){
        this.contract = contract_counter.getAndIncrement();
        this.time = time; 
        price = equip.getValue(time);
        this.equip = equip;
    }


    public double totalPrice(){//valor total do aluguel
        return price;
    }


    public String toString(){
        String rental_str = "INFORMAÇÕES GERAIS DO ALUGUEL:\nNúmero do contrato: " + contract + "\nDuração do aluguel: " + time + "\nPreço total: " + price + "\n\n" + equip.toString();
        return rental_str;
    }
}