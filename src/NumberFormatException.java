import javax.swing.JOptionPane;

public class NumberFormatException extends RuntimeException{

    public NumberFormatException(String information, String error_name){
        JOptionPane.showMessageDialog(null, information, error_name, JOptionPane.ERROR_MESSAGE);
    }

}