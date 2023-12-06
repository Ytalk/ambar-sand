import javax.swing.JOptionPane;

public class NumberFormatException extends RuntimeException{

    public NumberFormatException(String message, String error_name){
        JOptionPane.showMessageDialog(null, message, error_name, JOptionPane.ERROR_MESSAGE);
    }

}