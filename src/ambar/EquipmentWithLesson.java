package ambar;

public class EquipmentWithLesson extends Equipment{

    public EquipmentWithLesson(int id){
        super(id);
        setCanHaveLesson(true);
    }

    
    public double getValue(int time){
        return super.getValue(time);
    }

}