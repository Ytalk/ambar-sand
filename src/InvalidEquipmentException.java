public class InvalidEquipmentException extends RuntimeException{

    public InvalidEquipmentException(int id, String _class){
        super(_class + id);
    }
}