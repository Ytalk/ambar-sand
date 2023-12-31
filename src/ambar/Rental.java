package ambar;

import java.io.Serializable;
import java.security.SecureRandom;

/**
 * Contém as informações gerais de um alugel.
 */
public class Rental implements Serializable{

    SecureRandom random = new SecureRandom();//inicializa um SecureRandom para os números únicos de contratos

    private long contract;
    private int time;
    private double price;
    private Equipment equip;//usado para gerar informações toString e getPrice. e também polimorfismo


    /**
     * Cria um novo aluguel.
     * @param time Tempo de aluguel em minutos.
     * @param equip Equipamento alugado.
     */
    public Rental(int time, Equipment equip){
        this.contract = random.nextLong();//gera um número random de 64 bits (dúvido que repita)
        this.time = time; 
        price = equip.getValue(time);
        this.equip = equip;
    }


    /**
     * Retorna o valor total do aluguel.
     * @return Valor total do aluguel.
     */
    public double totalPrice(){//Double do valor total do aluguel.
        return price;
    }


    /**
     * Retorna String com todas as informações de um aluguel.
     */
    public String toString(){
        String rental_str = "INFORMAÇÕES GERAIS DO ALUGUEL:\nNúmero do contrato: " + contract + "\nDuração do aluguel (min): " + time + "\nPreço total: " + price + "\n\n" + equip.toString();
        return rental_str;
    }
}