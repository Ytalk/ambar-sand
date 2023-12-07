import java.io.Serializable;

public abstract class Equipment implements Serializable, Constants{

    private int type;
    private String description;
    private EquipmentAndValues equipment_and_values;


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


    public double getValue(int time){//calculo valor total do aluguel, mas não usa diretamente
        return (equipment_and_values.getBasicTax() + (equipment_and_values.getTaxPerHour() * ( (double) time / MINUTESPERHOUR ) ));//sem cast ele considera como int por conta do time
    }


    public EquipmentAndValues getEquipmentAndValues(){
        return equipment_and_values;
    }


    public void setCanHaveLesson(boolean lesson){
        equipment_and_values.setCanHaveLesson(lesson);
    }


    public String getDescription(){
        return description;
    }


    public int getType(){
        return type;
    }


    public String toString(){
        StringBuilder equip_str = new StringBuilder();
    
        equip_str.append("INFORMAÇÕES DE ALUGUEL DO EQUIPAMENTO:\n")
                 .append("Descrição: ").append(getDescription()).append("\n")
                 .append("Taxa Básica: ").append(equipment_and_values.getBasicTax()).append("\n")
                 .append("Taxa por Hora: ").append(equipment_and_values.getTaxPerHour()).append("\n")
                 .append("Possui aula: ").append(equipment_and_values.getCanHaveLesson() ? "sim" : "não").append("\n");//if else compacto
    
        return equip_str.toString();
    }

}