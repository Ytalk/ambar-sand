public class EquipmentWithLesson extends Equipment{
    boolean lesson;

    public EquipmentWithLesson(int id){
        super(id);
    }

    /*public String getLesson(){
        if(lesson == true)
            return "sim";
        else
            return "não";
    }*/

    public double getValue(int time){
        return ( super.getValue(time) );
    }
}