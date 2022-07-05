/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singeton2;

/**
 *
 * @author User
 */
public class Employee {
    private final String name;
    private final String role;
    
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
        
    }
    public void printCurrentAssignment(){
        Printer printer = Printer.getInstance();
        printer.print( name + " " + role + " ");
    }
}
