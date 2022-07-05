/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singeton2;

/**
 *
 * @author User
 */
public class Printer {
    private static Printer printer;
    private int nrOfPages;
    private Printer() {
    }
    public static Printer getInstance() {
        return printer == null ? 
                printer = new Printer() : 
                printer;
    }
    public void print(String text){
        System.out.println(text  +"\n" + "  paginas impresas hoy  " + ++nrOfPages+"\n" 
                 );
    }
}