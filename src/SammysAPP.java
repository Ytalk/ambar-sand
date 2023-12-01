public class SammysAPP{ // extends Rentables, NumberFormatException

    public static void main(String[]args){
        System.out.println("informe o tempo em minutos o ID e se vai ter aula");

        Rentals rent = new Rentals();
        rent.newRental(1, 60, false);
        new AppInterface();
        System.out.println(rent.pega1());
    }

}