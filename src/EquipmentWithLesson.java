public class EquipmentWithLesson extends Equipment{

    public EquipmentWithLesson(int id){
        super(id);
        setCanHaveLesson(true);
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