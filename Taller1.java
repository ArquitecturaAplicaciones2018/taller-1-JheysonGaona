import java.util.List;
import java.util.Comparator;

public class Taller1 {
    public static void main(String[] args) {
        var rationals = List.of(
                new Fraccion(1, 4),
                new Fraccion(1, 8),
                new Fraccion(3, 4),
                new Fraccion(7, 8));

        //Obtener todos los números racionales que sean menores a 1/2
        System.out.println("1.- Obtener todos los números racionales que sean menores a 1/2");
        var unMedio = new Fraccion(1, 2);
        rationals.stream().filter(r -> r.isLessThan(unMedio)).forEach(System.out::print);

        // Sumar todos los racionales
        System.out.println("2.- Sumar todos los racionales");
        var sumTotal = rationals.stream().reduce((r1, r2) -> r1.plus(r2)).get();
        System.out.print("La suma total es: " + sumTotal.simplificar());

        // Obtener el número racional mayor
        System.out.println("3.- Obtener el número racional mayor");
        var racionalMayor = rationals.stream().max(Comparator.comparing(Fraccion::toString)).get();
        System.out.print("El número racional mayor es: " + racionalMayor);

        //Sumar todos numeradores y obtener los siguientes datos: número de elementos, la suma de los numeradores,
        //el numerador menor, el mayor y el promedio
        System.out.println("4.- Sumar todos numeradores y obtener los siguientes datos: número de elementos," +
               "la suma de los numeradores, el numerador menor, el mayor y el promedio");

        var numElementos = rationals.size();
        System.out.println("\ta)Número de elementos: " + numElementos);

        var sumNumeradores = rationals.stream().mapToInt(r -> r.getNumerador()).sum();
        System.out.println("\tb)La suma de los numeradores: " + sumNumeradores);

        var menor = rationals.stream().min(Comparator.comparing(Fraccion::toString)).get().getNumerador();
        System.out.println("\tc)El numerador menor: " + menor);

        var mayor = rationals.stream().max(Comparator.comparing(Fraccion::toString)).get().getNumerador();
        System.out.println("\td)El numerador mayor: " + mayor);

        var promedio = (float)sumNumeradores/numElementos;
        System.out.println("\te)Promedio de los numeradores: " + promedio);
    }
}