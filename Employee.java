package singeton2;
//Clase empleado
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
