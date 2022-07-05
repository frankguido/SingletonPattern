package singeton2;

//Clase impresora
public class Printer {
    
    private static Printer printer;
    
    //atributo privado
    private int nrOfPages;
    private Printer() {
    }
    
    //metodo publico estatico que retorna el tipo de la clase Connection que no recibe parametros
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
