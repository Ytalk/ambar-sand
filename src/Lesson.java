public class Lesson extends EquipmentWithLesson{
    double value = 20;
    //Equipment equipment;    

    public Lesson(Equipment equip){
        super(equip.getType());
        //equipment = equip;
    }

    public double getValue(int time){
        return ( super.getValue(time) + value );
    }
}