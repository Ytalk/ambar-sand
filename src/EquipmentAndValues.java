import java.io.Serializable;

public enum EquipmentAndValues implements Serializable{

    ONE("jet ski", 50.0, 30.0),//com aula?
    TWO("barco pontão", 40.0, 30.0),
    THREE("barco a remo", 15.0, 20.0),
    FOUR("canoa", 12.0, 20.0),
    FIVE("caiaque", 10.0, 20.0),
    
    SIX("cadeira de praia", 2.0, 5.0),//definitivamente sem aula
    SEVEN("guarda-sol", 1.0, 5.0),
    EIGHT("gazebo", 3.0, 7.0);


    private String description;
    private double basicTax;
    private double taxPerHour;

    private boolean canHaveLesson;


    EquipmentAndValues(String desc, double tax, double perHour){
        description = desc;
        basicTax = tax;
        taxPerHour = perHour;
    }


    public String getDescription(){
        return description;
    }
    

    public double getBasicTax(){
        return basicTax;
    }


    public double getTaxPerHour(){
        return taxPerHour;
    }


    public boolean getCanHaveLesson(){
        return canHaveLesson;
    }


    public void setCanHaveLesson(boolean lesson){
        canHaveLesson = lesson;
    }
    
}