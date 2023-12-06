public interface Rentables{
    public String newRental(int id, int time, boolean hasLesson);

    //invalidEquipmentException();

    public void saveToFile(String name);

    public String listAll();

    //public int size(); //não implementado para não deixar o código redundante.
}