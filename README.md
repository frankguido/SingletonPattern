<div align="center">
<table>
    <theader>
        <tr>
            <th><img src="https://github.com/rescobedoulasalle/git_github/blob/main/ulasalle.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></th>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD LA SALLE</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍAS</span><br />
                <span style="font-weight:bold;">CARRERA PROFESIONAL DE INGENIERÍA DE SOFTWARE</span>
            </th>            
        </tr>
    </theader>
    
</table>
</div>

<div align="center">
<span style="font-weight:bold;">GUÍA DE LABORATORIO</span><br />
</div>

<table>
    <theader>
        <tr><th colspan="2">INFORMACIÓN BÁSICA</th></tr>
    </theader>
<tbody>

<tr><td>TÍTULO DE LA PRÁCTICA:</td><td>Patrón Singleton</td></tr>
<tr><td colspan="2">RECURSOS:
    <ul>
    <li>Oscar J Blancarte Iturralde. Introducción a los patrones de diseño. Un enfoque práctico (Spanish Edition. CreateSpace Independent Publishing Platform (2016)</li>
    </ul>
</td>
</<tr>
<tr><td colspan="2">DOCENTES:
    <ul>
        <li>Richart Smith Escobedo Quispe  - r.escobedo@ulasalle.edu.pe</li>
    </ul>
</td>
</<tr>
</tdbody>
</table>

# Patrón Singleon
#

## OBJETIVOS Y TEMAS

### OBJETIVOS
- Aprender el patrón Singleton.

### TEMAS
-   Definición.
-   Implementación.
-   Ejemplo.
-   Ventajas y Desventajas.


### DEFINICIÓN

-   Patrón Singleton

    -   El singleton es un patrón de diseño muy conocido y muy utilizado. Restringe la creación de instancias de una clase para que solo cree una instancia de la clase 	que lo implementa. Puede ser utilizado de forma global en aplicaciones así que su uso puede ser muy variado, desde acceder a constantes y acumuladores o 	 contadores, hasta la gestión de parámetros de la aplicación.
        El singleton es uno de los patrones más simples, pero más poderosos en el desarrollo de software.}
	
<p align="center">
  <img src="https://github.com/frankguido/SingletonPattern/blob/main/singleton.png?raw=true" />
</p>


<p align="center">
  <img src="https://github.com/frankguido/SingletonPattern/blob/main/singleton2.png?raw=true" />
</p>

### IMPLEMENTACIÓN

-   Para una buena implementacion se recomienda:

    -   Atributo privado estatico de la propia clase.
    -   Ocultar el contructor es decir se debe declarar como privado.
    -   Declarar un método estático para llamar al constructor privado, este método suele llamarse getInstance().
    

    



## EJEMPLO 1 EN LA VIDA REAL

-    Ejemplo

     - No es encillo probar el patrón singleton, es por eso que por medio de la siguiente ilustracion se mostrara su funcionamiento en una empresa en la que existe una sola impresora.     
     
<p align="center">
  <img src="https://github.com/frankguido/SingletonPattern/blob/main/impresora.png?raw=true" />
</p>

Clase Employee.java


    public class Employee {
        //atributos privados
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

Clase Printer.java

    public class Printer {
    
        //privado
        private static Printer printer;
        private int nrOfPages;
        private Printer() {
        }
        //instancia del mismo nombre
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



Clase Test.java

    public class Test {
    
        //diferentes empleados, pero una misma impresora
        public static void main(String[] args) {
            Employee suarez = new Employee("Suarez","CEO");
            Employee fer = new Employee("Fernando", "Desarrollador");
            Employee kev = new Employee("Kevin", "Empleado");
            Employee ros = new Employee("Rosa", "Empleado");
            suarez.printCurrentAssignment();
            fer.printCurrentAssignment();
            kev.printCurrentAssignment();
            ros.printCurrentAssignment();
        }
    }

<p align="center">
  <img src="https://github.com/frankguido/SingletonPattern/blob/main/ejm1.png?raw=true" />
</p>


Como podemos ver se generan diferentes empleados que tienen diferentes roles dentro de una empresa pero que usan una misma impresora siguiendo el orden dado.


## EJEMPLO 2 BASE DE DATOS

Clase DBConnection.java

    //Patronsingleton
    package Singleton;

    import java.sql.Connection;
    import java.sql.DriverManager;


    public class DBConnection {
        //Atributo privado y estatico del mismo tipo
        private static Connection conn = null;
    
        //constructor privado por defecto que no reciba parametros
        private DBConnection(){
        }
    
        //metodo publico estatico que retorna el tipo de la clase Connection que no recibe parametros
        public static Connection getDBConnection(){
            try{
                if(conn == null){
                
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/db_proyecto", "root", "12345678");  
                }
	   
            
            } catch (Exception e){
                e.printStackTrace();
        
            }
            return conn;
        }
  
    }

#



Test.java

    package Singleton;
     /**
     *
     * @author User
     */
    import java.sql.*;
    public class Test {
        public static void main(String [] args){
        
            //instancia connection
            Connection conn = DBConnection.getDBConnection();
        
            //Connection conn2 = DBConnection.getDBConnection();
            try{
                String query = "Select * from propietario ";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next())
                {
                    System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
                }
            }catch (Exception e){
                System.out.println("Error durante la conexion");
            }  
        }   
    }


### VENTAJAS Y DESVENTAJAS

	-    Ventajas:
	
		-     Puede escribirse de forma rápida y sencilla al no tener muchas variables globales.
		-     Se crea exactamente cuándo se necesita, una característica que se denomina lazy loading.
		-     Permite crear un número exacto de instancias.
	-    Desventajas:
	
		-     La disponibilidad global de patrones singleton plantea riesgos si se manejan datos sensibles.
		-     Los fallos de funcionamiento son difíciles de rastrear.
		-     No es recomendable en aplicaciones con muchos usuarios, porque puede reducir el rendimiento del programa.    
    
    




## REFERENCIAS
-   Oscar J Blancarte Iturralde. Introducción a los patrones de diseño_ Un enfoque práctico (Spanish Edition. CreateSpace Independent Publishing Platform (2016)




# THAT'S ME !

⭐️ From [Hrishikesh-coder](https://github.com/Hrishikesh-coder)

