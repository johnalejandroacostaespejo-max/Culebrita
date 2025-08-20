public class Pruebas_Video4 {
    public static void main(String[] args) {
        var age = 50;


        // 1. Establece la edad de un usuario y muestra si puede votar (mayor o igual a 18).

        // 2. Declara dos números y muestra cuál es mayor, o si son iguales.

        // 3. Dado un número, verifica si es positivo, negativo o cero.

        // 4. Crea un programa que diga si un número es par o impar.

        // 5. Verifica si un número está en el rango de 1 a 100.

        // 6. Declara una variable con el día de la semana (1-7) y muestra su nombre con switch.

        // 7. Simula un sistema de notas: muestra "Sobresaliente", "Aprobado" o "Suspenso" según la nota (0-100).

        // 8. Escribe un programa que determine si puedes entrar al cine: debes tener al menos 15 años o ir acompañado.

        // 9. Crea un programa que diga si una letra es vocal o consonante.

        // 10. Usa tres variables a, b, c y muestra cuál es el mayor de las tres.


        if (age <= 39 && age >= 18) {
            System.out.println("Es mayor de edad, ya es legal :V");
        } else if (age >= 40) {
            System.out.println("Cochino!");
        } else if (age == 17) {
            System.out.println("Es menor de edad, si puedes, con protección");
        } else if (age == 16 || age == 15) {
            System.out.println("Es menor de edad, si puedes, pero con precaucion, !te puede demandar!");
        } else {
            System.out.println("Es muy menor de edad, NO PUEDES, no te metas en la carcel");
        }

        switch ("2" + age) {
            case "10":
                System.out.println("Tienes 10 años");
                break;
            case "15":
                System.out.println("Tienes 15 años");
                break;
            case "20":
                System.out.println("Tienes 20 años");
                break;
            default:
                System.out.println("No se tu edad");
        }
    }
}
