/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package singeton2;

/**
 *
 * @author User
 */
public class Test {

    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        Employee graham = new Employee("Suarez",
                "CEO");
        Employee sara = new Employee("Fernando",
                "Desarrollador");
        Employee tim = new Employee("Kevin",
                "Empleado");
        Employee emma = new Employee("Rosa",
                "Empleado");
        graham.printCurrentAssignment();
        sara.printCurrentAssignment();
        tim.printCurrentAssignment();
        emma.printCurrentAssignment();
    }
}
    

