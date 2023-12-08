package ambar;

/**
 * Classe responsável por definir a estrutura da classe Rentals (Rentables).
 */
public interface Rentables{

    public String newRental(int id, int time, boolean hasLesson) throws InvalidEquipmentException;//declara que pode lançar exceção

    public void saveToFile();

    public String listAll();

    //public int size(); //não implementado para não deixar o código redundante.
    
}