import java.io.Serializable;

public abstract class Equipment implements Serializable, Constants{ //, invalidEquipmentException  extends EquipmentAndValues
    private int type;
    private String description;
    private EquipmentAndValues equipment_and_values;//TAXA BASICA DE ALUGUEL

    public Equipment(int id){
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
                //equipment_and_values.setCanHaveLesson(false);
            break;

            case 7:
                equipment_and_values = EquipmentAndValues.SEVEN;
                //equipment_and_values.setCanHaveLesson(false);
            break;

            case 8:
                equipment_and_values = EquipmentAndValues.EIGHT;
                //equipment_and_values.setCanHaveLesson(false);
            break;

            default:
                throw new InvalidEquipmentException(id, "ID de equipamento inválido: ");
        }
        this.type = id;
        this.description = equipment_and_values.getDescription();
    }

    public double getValue(int time){
        return (equipment_and_values.getBasicTax() + (equipment_and_values.getTaxPerHour() * (time / MINUTESPERHOUR) ));
    }

    /*public EquipmentAndValues getEquipmentAndValues(){
        return Equipment_and_values;
    }*/

    public void setCanHaveLesson(boolean lesson){
        equipment_and_values.setCanHaveLesson(lesson);
    }

    public String getDescription(){
        return description;
    }

    public int getType(){
        return type;
    }

    public String toString() {
        StringBuilder equip_str = new StringBuilder();
    
        equip_str.append("Informações do equipamento alugado:\n")
                 .append("Descrição: ").append(getDescription()).append("\n")
                 .append("Taxa Básica: ").append(equipment_and_values.getBasicTax()).append("\n")
                 .append("Taxa por Hora: ").append(equipment_and_values.getTaxPerHour()).append("\n")
                 .append("Possui aula: ").append(equipment_and_values.getCanHaveLesson()).append("\n");
    
        return equip_str.toString();
    }
    
}