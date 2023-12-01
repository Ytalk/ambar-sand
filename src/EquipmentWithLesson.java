public class EquipmentWithLesson extends Equipment{

    public EquipmentWithLesson(int id){
        super(id); 
    }

    public double getValue(int time){
        return ( super.getValue(time) );//bah
    }
}