package ambar;

import java.io.Serializable;

/**
 * classe responsável por definir o conteúdo de um equipamento.
 */
public abstract class Equipment implements Serializable, Constants{

    private int type;
    private String description;
    private EquipmentAndValues equipment_and_values;
    private boolean canHaveLesson;


    /**
     * Define uma enum (o equipamento propriamente dito).
     * @param id Determina qual será o equipamento alugado.
     */
    public Equipment(int id){//id responsável por atribuir enum

        switch (id){
            case 1:
                equipment_and_values = EquipmentAndValues.ONE;
            break;

            case 2:
                equipment_and_values = EquipmentAndValues.TWO;
            break;

            case 3:
                equipment_and_values = EquipmentAndValues.THREE;
            break;

            case 4:
                equipment_and_values = EquipmentAndValues.FOUR;
            break;

            case 5:
                equipment_and_values = EquipmentAndValues.FIVE;
            break;

            case 6:
                equipment_and_values = EquipmentAndValues.SIX;
            break;

            case 7:
                equipment_and_values = EquipmentAndValues.SEVEN;
            break;

            case 8:
                equipment_and_values = EquipmentAndValues.EIGHT;
            break;

            default:
                throw new InvalidEquipmentException(id, "Equipamento inválido com ID: ");//lança exceção
        }
        
        this.type = id;
        this.description = equipment_and_values.getDescription();//primeiro campo: nome
    }


    /**
     * Cálcula o valor total do aluguel.
     * @param time Tempo de aluguel em minutos.
     * @return Valor total do aluguel.
     */
    public double getValue(int time){//calculo valor total do aluguel, mas não usa-o diretamente
        return (equipment_and_values.getBasicTax() + (equipment_and_values.getTaxPerHour() * ( (double) time / MINUTESPERHOUR ) ));//sem cast ele considera como int por conta do time
    }


    /**
     * Retorna a enum.
     * @return Enum com as informações principais de um equipamento.
     */
    public EquipmentAndValues getEquipmentAndValues(){
        return equipment_and_values;
    }


    /**
     * Define se terá aula ou não.
     * @param lesson tem aula (true); não tem aula (false).
     */
    public void setCanHaveLesson(boolean lesson){
        canHaveLesson = lesson;
    }


    /**
     * Retorna se tem aula ou não.
     * @return boolean responsável pela aula.
     */
    public boolean getCanHaveLesson(){
        return canHaveLesson;
    }


    /**
     * Retorna String da descrição (nome) do equipamento.
     * @return String do nome do equipamento.
     */
    public String getDescription(){
        return description;
    }


    /**
     * Retorna o tipo (id) do equipamento.
     * @return Int responsável por definir o equipamento (id).
     */
    public int getType(){
        return type;
    }


    /**
     * Retorna String com todas as informações de um equipamento alugado.
     */
    public String toString(){
        StringBuilder equip_str = new StringBuilder();
    
        equip_str.append("Equipamento:\n")
                 .append("Descrição: ").append(getDescription()).append("\n")
                 .append("Taxa Básica: ").append(equipment_and_values.getBasicTax()).append("\n")
                 .append("Taxa por Hora: ").append(equipment_and_values.getTaxPerHour()).append("\n")
                 .append("Possui aula: ").append(getCanHaveLesson() ? "sim" : "não").append("\n");//if else compacto
    
        return equip_str.toString();
    }

}