package singeton2;


public class Test {

   
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
    

