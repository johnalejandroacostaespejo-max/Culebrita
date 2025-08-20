public class Pruebas_Video2 {

    public static void main(String[] args) {

        // 1. Crea una variable con el resultado de cada operación aritmética.
        var a = 12;
        var b = 3;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        // 2. Crea una variable para cada tipo de operación de asignación.
        var c = 3;
        a = (b / c) * 4;
        System.out.println(a);
        a += 61;
        System.out.println(a);
        a -= 1;
        System.out.println(a);
        a *= 2;
        System.out.println(a);
        a /= 5;
        System.out.println(a);
        // 3. Imprime 3 comparaciones verdaderas con diferentes operadores de comparación.
        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a >= b);
        // 4. Imprime 3 comparaciones falsas con diferentes operadores de comparación.
        System.out.println(a == b);
        System.out.println(a <= b);
        System.out.println(a < b);
        // 5. Utiliza el operador lógico and.
        System.out.println(5 == 5 && 6 > 3);
        System.out.println((5 * 2) == 10 && 2 == 4);
        System.out.println(9 == 8 && 3 > 1);
        System.out.println(1 > 9 && 2 == 5);
        // 6. Utiliza el operador lógico or.
        System.out.println(5 == 5 || 6 > 3);
        System.out.println(5 * 2 == 10 || 2 == 4);
        System.out.println(9 == 8 || 3 > 1);
        System.out.println(1 >= 9 || 2 == 5);
        // 7. Combina ambos operadores lógicos.
        System.out.println(5 == 5 && (6 > 9 || 2 < 9));
        System.out.println((5 * 2 == 10 || 2 == 4) && (9 == 8 || 3 > 1));
        System.out.println((1 >= 9 || 2 == 5) && (5 == 5 || 6 > 3));
        // 8. Añade alguna negación.
        System.out.println(!(5 > 5) && (9 == 9));
        // 9. Imprime 3 ejemplos de uso de operadores unarios.
        System.out.println(--b);
        System.out.println(c++);//agrega 1, pero se muestra en su siguiente uso
        System.out.println(++c);//agrega 1 y se muestra de inmediato
        // 10. Combina operadores aritméticos, de comparación y lógicos.
        System.out.println(((5 + 3) > (2 + 6)) && (8 == 8));
        System.out.println(((5 * 3) < (2 * 6)) || (8 != 8));
        System.out.println(((5 - 3) >= (2 - 6)) && (8 <= 8));
    }
}