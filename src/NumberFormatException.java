import javax.swing.JOptionPane;

public class NumberFormatException extends RuntimeException{
    
    String message, error_name;

    public NumberFormatException(String message, String error_name){
        this.message = message;
        this.error_name = error_name;
    }


    public void showMessage(){
        JOptionPane.showMessageDialog(null, message, error_name, JOptionPane.ERROR_MESSAGE);
    }

}