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
        Employee sua = new Employee("Suarez",
                "CEO");
        Employee fer = new Employee("Fernando",
                "Desarrollador");
        Employee kev = new Employee("Kevin",
                "Empleado");
        Employee tim = new Employee("Rosa",
                "Empleado");
        sua.printCurrentAssignment();
        fer.printCurrentAssignment();
        kev.printCurrentAssignment();
        tim.printCurrentAssignment();
    }
}
    

