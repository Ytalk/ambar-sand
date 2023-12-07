public class EquipmentWithoutLesson extends Equipment{

    public EquipmentWithoutLesson(int id){
        super(id);
        setCanHaveLesson(false);
    }


    public double getValue(int time){
        return super.getValue(time);
    }
    
}