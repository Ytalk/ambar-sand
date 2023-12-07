import javax.swing.JOptionPane;

public class InvalidEquipmentException extends RuntimeException{

    public InvalidEquipmentException(int id, String _class){
        JOptionPane.showMessageDialog(null, _class + id, "EQUIPMENT ERROR", JOptionPane.ERROR_MESSAGE);
    }
}