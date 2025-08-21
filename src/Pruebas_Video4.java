public class Pruebas_Video4 {
    public static void main(String[] args) {

        // 1. Establece la edad de un usuario y muestra si puede votar (mayor o igual a 18).
var age = 17;
        if (age >= 18) {
            System.out.println("El ciudadano puede votar");
        } else if (age < 18) {
            System.out.println("El ciudadano no puede votar");
        } else {
            System.out.println("Edad no válida");
        }

        // 2. Declara dos números y muestra cuál es mayor, o si son iguales.
var ba = 21;
var ca = 22;

        if (ba == ca) {
            System.out.println("Los números son iguales ya que b=" + ba + " y c=" + ca + " son iguales.");
        } else if (ba > ca) {
            System.out.println("El número mayor el la letra b con el valor=" + ba + ", en cuanto la c esta con el valor=" + ca + ".");
        }
        else if (ba < ca) {
            System.out.println("El número mayor el la letra c con el valor=" + ca + ", en cuanto la b esta con el valor=" + ba + ".");
        }

        // 3. Dado un número, verifica si es positivo, negativo o cero.
var note = -5;
        if (note > 0) {
            System.out.println("El número es positivo y su valor es=" + note);
        } else if (note < 0) {
            System.out.println("El número es negativo y su valor es=" + note);
        } else {
            System.out.println("El número es cero");
        }

        // 4. Crea un programa que diga si un número es par o impar.
var number = 105;
        if (number % 2 == 0) {
            System.out.println("El número " + number + " es par.");
        } else {
            System.out.println("El número " + number + " es impar.");
        }
        // 5. Verifica si un número está en el rango de 1 a 100.
var points = 500;
        if (points >= 1 && points <= 100) {
            System.out.println("Los puntos acumulados son " + points + " y están en el rango de 1 a 100.");
        } else {
            System.out.println("Los puntos acumulados son " + points + " y no están en el rango de 1 a 100.");
        }
        // 6. Declara una variable con el día de la semana (1-7) y muestra su nombre con switch.
var dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Número de día no válido, debe ser entre 1 y 7.");
        }

        // 7. Simula un sistema de notas: muestra "Sobresaliente", "Aprobado" o "Suspenso" según la nota (0-100).
var pass = 85;
        if (pass >= 90 && pass <= 100) {
            System.out.println("Sobresaliente");
        } else if (pass >= 60 && pass < 90) {
            System.out.println("Aprobado");
        } else if (pass >= 0 && pass < 60) {
            System.out.println("Suspenso");
        } else {
            System.out.println("Nota no válida, debe estar entre 0 y 100.");
        }

        // 8. Escribe un programa que determine si puedes entrar al cine: debes tener al menos 15 años o ir acompañado.
var ageCine = 14;
        boolean accompanied = true; // Cambia a false si no estás acompañado
        if (ageCine >= 15 || accompanied) {
            System.out.println("Puedes entrar al cine.");
        } else {
            System.out.println("No puedes entrar al cine, debes tener al menos 15 años o ir acompañado.");
        }

        // 9. Crea un programa que diga si una letra es vocal o consonante.
var letter = 'a';
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' ||
            letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U') {
            System.out.println("La letra '" + letter + "' es una vocal.");
        } else if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
            System.out.println("La letra '" + letter + "' es una consonante.");
        } else {
            System.out.println("El carácter '" + letter + "' no es una letra válida.");
        }

        // 10. Usa tres variables a, b, c y muestra cuál es el mayor de las tres.
var a = 10;
var b = 20;
var c = 15;
        if (a >= b && a >= c) {
            System.out.println("El número mayor es a=" + a + " en comparación con b=" + b + " y c=" + c);
        } else if (b >= a && b >= c) {
            System.out.println("El número mayor es b=" + b + " en comparación con a=" + a + " y c=" + c);
        } else {
            System.out.println("El número mayor es c=" + c + " en comparación con a=" + a + " y b=" + b);
        }
/*
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
        }*/
    }
}
