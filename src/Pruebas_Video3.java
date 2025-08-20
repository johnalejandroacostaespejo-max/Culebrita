public class Pruebas_Video3 {
    public static void main(String[] args) {

        // 1. Concatena dos cadenas de texto.
        String name = "AlEjAndrO";
        String surname ="EspEjO";
        String pepito = "EspEjO";
        System.out.println(name + " " + surname);
        // 2. Muestra la longitud de una cadena de texto.
        System.out.println(name.length());
        System.out.println(surname.length());
        // 3. Muestra el primer y último carácter de un string.
        System.out.println(name.charAt(0));
        System.out.println(name.charAt(name.length()-1));
        // 4. Convierte a mayúsculas y minúsculas un string.
        System.out.println(name.toUpperCase());
        System.out.println(surname.toLowerCase());
        // 5. Comprueba si una cadena de texto contiene una palabra concreta.
        System.out.println("Aprendiendo Java con Alejandro".contains("Java"));
        System.out.println("Aprendiendo Java con Alejandro".contains("Python"));
        // 6. Formatea un string con un entero.
        int age = 30;
        System.out.println(String.format("Tengo %s años", age));
        age = 29;
        System.out.println(String.format("%s años han pasado, %s minutos despues de ese momento y %s Cumple años hoy", age, age + 1, name));
        // 7. Elimina los espacios en blanco al principio y final de un string.
        System.out.println("   aprendiendo java con alejandro   ".trim());
        // 8. Sustituye todos los espacios en blanco de un string por un guión (-).
        System.out.println("aprendiendo-java-con-alejandro".replace("a", "e"));
        // 9. Comprueba si dos strings son iguales.
        System.out.println(name.equals(surname));
        System.out.println(surname.equals(pepito));
        // 10. Comprueba si dos strings tienen la misma longitud.
        System.out.println(name.length() == surname.length());
        System.out.println(surname.length() == pepito.length());

    }
}