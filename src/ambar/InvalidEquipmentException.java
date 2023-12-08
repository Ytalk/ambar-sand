package ambar;

import javax.swing.JOptionPane;

public class InvalidEquipmentException extends RuntimeException{

    int id;
    String message;

    public InvalidEquipmentException(int id, String _class){
        this.id = id;
        message = _class;
    }


    public void showMessage(){
        JOptionPane.showMessageDialog(null, message + id, "EQUIPMENT ERROR", JOptionPane.ERROR_MESSAGE);
    }

}