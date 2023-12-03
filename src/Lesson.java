public class Lesson extends EquipmentWithLesson{
    double value = 20;
    //Equipment equipment;    

    public Lesson(Equipment equip, boolean bool){
        super(equip.getType());
        //equipment = equip;
        //setCanHaveLesson(bool);
    }

    public double getValue(int time){
        return ( super.getValue(time) + value );
    }
}