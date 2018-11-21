import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Taller1 {
    public static void main(String[] args) {
        var rationals = List.of(
                new Rational(1, 4),
                new Rational(1, 8),
                new Rational(3, 4),
                new Rational(7, 8));

        //Obtener todos los números racionales que sean menores a 1/2
        System.out.println("1.- Obtener todos los números racionales que sean menores a 1/2");
        var unMedio = new Rational(1, 2);
        rationals.stream().filter(r -> r.isLessThan(unMedio)).forEach(System.out::println);

        // Sumar todos los racionales
        System.out.println("2.- Sumar todos los racionales");
        var sumTotal = rationals.stream().reduce((r1, r2) -> r1.plus(r2)).get();
        System.out.println("La suma total es: " + sumTotal);

        // Obtener el número racional mayor
        System.out.println("3.- Obtener el número racional mayor");
        var racionalMayor = rationals.stream().max(Comparator.comparing(Rational::toString)).get();
        System.out.println("El número racional mayor es: " + racionalMayor);

        //Sumar todos numeradores y obtener los siguientes datos: número de elementos, la suma de los numeradores,
        //el numerador menor, el mayor y el promedio
        System.out.println("4.- Sumar todos numeradores y obtener los siguientes datos: número de elementos," +
               "la suma de los numeradores, el numerador menor, el mayor y el promedio");

        var numElementos = rationals.size();
        System.out.println("\ta)Número de elementos: " + numElementos);

        // var sumNumeradores = rationals.stream().mapToInt(r -> r.getNumerator()).sum();
        long sumNumeradores = rationals.stream().collect(Collectors.summarizingInt(r -> r.getNumerator())).getSum();
        System.out.println("\tb)La suma de los numeradores: " + sumNumeradores);

        // var menor = rationals.stream().min(Comparator.comparing(Rational::toString)).get().getNumerator();
        long menor = rationals.stream().collect(Collectors.summarizingInt(r -> r.getNumerator())).getMin();
        System.out.println("\tc)El numerador menor: " + menor);

        // var mayor = rationals.stream().max(Comparator.comparing(Rational::toString)).get().getNumerator();
        long mayor = rationals.stream().collect(Collectors.summarizingInt(r -> r.getNumerator())).getMax();
        System.out.println("\td)El numerador mayor: " + mayor);

        double promedio = rationals.stream().collect(Collectors.summarizingInt(r -> r.getNumerator())).getAverage();
        System.out.println("\te)Promedio de los numeradores: " + promedio);
    }
}