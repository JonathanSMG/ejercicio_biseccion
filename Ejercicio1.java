import java.util.function.Function;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Definir la función cuya raíz queremos encontrar

        //f(x)=x3−2x2+4
        Function<Double, Double> function = x -> Math.pow(x, 3) - 2 * Math.pow(x, 2) + 4;

        // Definir el intervalo [a, b] donde se buscará la raíz
        double a = 0.0;
        double b = 2.0;

        // Definir el criterio de parada, por ejemplo, cuando el valor absoluto de la función es menor que una tolerancia
        double epsilon = 0.0001;

        // Realizar hasta un máximo de 3 iteraciones
        for (int i = 1; i <= 3; i++) {
            // Calcular el punto medio del intervalo
            double c = (a + b) / 2;

            // Evaluar la función en el punto medio
            double fc = function.apply(c);

            // Imprimir los resultados de esta iteración
            System.out.printf("Iteración %d: a=%.4f, b=%.4f, c=%.4f, f(c)=%.4f%n", i, a, b, c, fc);

            // Comprobar si se ha encontrado una raíz dentro de la tolerancia
            if (Math.abs(fc) < epsilon) {
                System.out.println("Se encontró una raíz dentro de la tolerancia.");
                break;
            }

            // Actualizar el intervalo [a, b] basado en el cambio de signo
            if (fc * function.apply(a) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
    }
}
