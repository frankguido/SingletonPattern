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
    
    

## EJERCICIOS PROPUESTOS

-   Se han creado estructuras complejas con objetos más pequeños.
    -   Agregue un nuevo atributo a la clase AbstractProduct para definir la tasa de impuesto que tendrá el producto, el impuesto deberá ser calculado y mostrado a nivel de paquete.
    -   Agregues otro atributo a la clase AbstractProduct para definir la cantidad, esta cantidad deberá ser calculada a la hora de mostrar el precio del paquete.
    -   Agregue productos para crear un paquete, podríamos agregar un producto de descuento con precio negativo.
-   Elabore los ejemplos y analice los resultados.


## REFERENCIAS
-   Oscar J Blancarte Iturralde. Introducción a los patrones de diseño_ Un enfoque práctico (Spanish Edition. CreateSpace Independent Publishing Platform (2016)

#

[license]: https://img.shields.io/github/license/rescobedoulasalle/git_github?label=rescobedoulasalle
[license-file]: https://github.com/rescobedoulasalle/git_github/blob/main/LICENSE

[downloads]: https://img.shields.io/github/downloads/rescobedoulasalle/git_github/total?label=Downloads
[releases]: https://github.com/rescobedoulasalle/git_github/releases/

[last-commit]: https://img.shields.io/github/last-commit/rescobedoulasalle/git_github?label=Last%20Commit

[Debian]: https://img.shields.io/badge/Debian-D70A53?style=for-the-badge&logo=debian&logoColor=white
[debian-site]: https://www.debian.org/index.es.html

[Git]: https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white
[git-site]: https://git-scm.com/

[GitHub]: https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white
[github-site]: https://github.com/

[Vim]: https://img.shields.io/badge/VIM-%2311AB00.svg?style=for-the-badge&logo=vim&logoColor=white
[vim-site]: https://www.vim.org/

[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white
[java-site]: https://docs.oracle.com/javase/tutorial/


[![Debian][Debian]][debian-site]
[![Git][Git]][git-site]
[![GitHub][GitHub]][github-site]
[![Vim][Vim]][vim-site]
[![Java][Java]][java-site]

[![License][license]][license-file]
[![Downloads][downloads]][releases]
[![Last Commit][last-commit]][releases]











### Hi there 👋<h2> I'm Shivam</h2>

<img align='right' src="[https://media.giphy.com/media/M9gbBd9nbDrOTu1Mqx/giphy.gif](https://reactiveprogramming.io/books/patterns/img/patterns-articles/singleton-diagram.png)" width="230">

<h3> 👨🏻•💻 About Me </h3>



- 🤔 &nbsp; Exploring new technologies and developing software solutions and quick hacks.

- 🎓 &nbsp; Studying Computer Science and Engineering at IIIT Vadodara and coding stuffs.

- 🌱 &nbsp; Learning about Cloud Tech, Systems Design.

- ✍️ &nbsp; Pursuing Web Development as hobbies/side hustles.



<h3>🛠 Tech Stack</h3>




- 💻 &nbsp; Python | Java | C++ | C | MySQL

- 🌐 &nbsp; HTML | CSS | JavaScript | Bootstrap | ReactJS

<!--
- 🛢 &nbsp; MySQL | MongoDB

- 🔧 &nbsp; Git | Markdown | Selenium | Tidyverse

- 🖥 &nbsp; Illustrator| Photoshop | InDesign

-->



<h3>🛠 To Learn</h3>

- 🔧 &nbsp; AWS | Docker🐳 | Firebase | flask

<hr>



<br/><br/>

[![Shivam's GitHub Stats](https://github-readme-stats.vercel.app/api?username=shivam0110&show_icons=true)](https://github.com/shivam0110)

<br/>

<br/>

<img src="https://github.com/frankguido/SingletonPattern/blob/main/singleton.png?raw=true" width="350" align='right'>

![Top Langs](https://github-readme-stats.vercel.app/api/top-langs/?username=shivam0110&show_icons=true)

<br><br>



<hr>



<h3> 🤝🏻 Connect with Me </h3>

<br>



<p align="center">

<a href="https://shivammalpani.netlify.app/"><img alt="Website" src="https://img.shields.io/badge/shivammalpani.netlify.app-black?style=flat-square&logo=google-chrome"></a>

<a href="https://www.linkedin.com/in/shivam-malpani-47a379198/"><img alt="LinkedIn" src="https://img.shields.io/badge/LinkedIn-Shivam%20Malpani-blue?style=flat-square&logo=linkedin"></a>

<a href="https://www.instagram.com/i__disbalance/"><img alt="Instagram" src="https://img.shields.io/badge/Instagram-i__disbalance-black?style=flat-square&logo=instagram"></a>

<a href="mailto:shivammalpani111@gmail.com"><img alt="Email" src="https://img.shields.io/badge/Email-shivammalpani111@gmail.com-blue?style=flat-square&logo=gmail"></a>

</p>





![Visitor count](https://visitor-badge.laobi.icu/badge?page_id=shivam0110.shivam0110)   <img src="https://media.giphy.com/media/dxn6fRlTIShoeBr69N/giphy.gif" width="30">





<hr>






















<p align="center">
  <img src="https://github.com/frankguido/SingletonPattern/blob/main/singleton.png?raw=true" />
</p>

```js
import SoftwareDeveloper from 'thompsonemerson';

class Bio extends SoftwareDeveloper {
  name     = 'Emerson Thompson';
  title    = 'Software Engineer';
  company  = 'Pipoca Digital | Remote';
  location = 'Fortaleza, CE';
}

class Skills extends SoftwareDeveloper {
  languages  = ['JavaScript', 'PHP'];
  databases  = ['MySQL', 'MongoDB', 'PostgreSQL'];
  frameworks = ['React', 'React Native', 'Angular', 'GraphQL'];
}
```

⭐️ From [thompsonemerson](https://github.com/thompsonemerson)




















# 👋🏻 Hey,
<div align="center">
	<br>
	<img src="https://raw.githubusercontent.com/Aniket965/Aniket965/master/pacman.svg?sanitize=true" width="200" height="200">
</div>

# I am Hrishikesh , HRISHIKESH-CODER . 
## I am a programmer

- <img src="https://media.giphy.com/media/KAq5w47R9rmTuvWOWa/giphy.gif" width=50 height=50>  I know Python and I love to code in Python . I am proficient in Django, a web development framework. I also know a bit of machine learning and AI . <br>
- <img src="https://seeklogo.com/images/J/java-logo-7F8B35BAB3-seeklogo.com.png" width=50 height=50>  I also know Java and like coding in Java . 
- <img src="https://cdn.svgporn.com/logos/aws.svg" width=30 height=30>  I also like AWS, Amazon Web Services<br>
- <img src="https://media0.giphy.com/media/pylpD8AoQCf3CQ1oO2/giphy.gif" width=30 height=30>  I have built some projects and am planning to build some more.<br>

## My Tech Stack

<table>
  <tbody>
    <tr valign="top">
      <td width="25%" align="center">
	      <span><strong>Python</strong></span><br><br><br>
        <img height="100px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Python-logo-notext.svg/1200px-Python-logo-notext.svg.png">
      </td>
      <td width="25%" align="center">
	      <span><strong>AWS</strong></span><br><br><br>
        <img height="64px" src="https://cdn.svgporn.com/logos/aws.svg">
      </td>
      <td width="25%" align="center">
        <span><strong>Java</strong></span><br><br><br>
        <img height="100px" src="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png">
      </td>
      <td width="25%" align="center">
        <span><strong>Django</strong></span><br><br><br>
        <img height="64px" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRlHpEsRq4pIo4vTLAn24qGNwG41dFdXLJwsQ&usqp=CAU">
      </td>
     </tr>
    <tr valign="top">
      <td width="25%" align="center">
        <span><strong>CSS</strong></span><br><br><br>
        <img height="64px" src="https://cdn.svgporn.com/logos/css-3.svg">
      </td>
      <td width="25%" align="center">
        <span><strong>Html 5</strong></span><br><br><br>
        <img height="64px" src="https://cdn.svgporn.com/logos/html-5.svg">
      </td>
      <td width="25%" align="center">
        <span><strong>Git</strong></span><br><br><br>
        <img height="64px" src="https://cdn.svgporn.com/logos/git-icon.svg">
      </td>
      <td width="25%" align="center">
        <span><strong>Vs Code</strong></span><br><br><br>
        <img height="64px" src="https://cdn.svgporn.com/logos/visual-studio-code.svg">
      </td>
    </tr>

  </tbody>
</table>

![Hrishikesh's github stats](https://github-readme-stats.vercel.app/api/?username=hrishikesh-coder&show_icons=true&title_color=fff&icon_color=79ff97&text_color=9f9f9f&bg_color=151515)
<br>

  <a href="https://www.linkedin.com/in/hrishikesh-bhanja-9348a81b2/">
    <img align="left" alt="Jugal Bhatt | Linkedin" width="24px" src="https://github.com/TheDudeThatCode/TheDudeThatCode/blob/master/Assets/Linkedin.svg" />
  </a>
  <a href="mailto:hrishipotter123@gmail.com">
    <img align="left" alt="Jugal Bhatt | Gmail" width="26px" src="https://github.com/TheDudeThatCode/TheDudeThatCode/blob/master/Assets/Gmail.svg" />
  </a>
  
<br>

![VisitorCount](https://profile-counter.glitch.me/hrishikesh-coder/count.svg)

<br><br><br><br>

# THAT'S ME !

⭐️ From [Hrishikesh-coder](https://github.com/Hrishikesh-coder)

