import java.awt.*;
import java.util.List;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(){
    }

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        if (denominador != 0) {
            this.denominador = denominador;
        } else {
            throw new IllegalArgumentException("El denominador no puede ser 0");
        }
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    @Override
    public String toString() {
        return String.format("%d/%d\n", numerador, denominador);
    }

    public Fraccion plus(Fraccion n1) {
        return new Fraccion(numerador * n1.getDenominador()
                + denominador * n1.getNumerador(),
                denominador * n1.getDenominador());
    }

    public Fraccion minus(Fraccion n1) {
        return new Fraccion(numerador * n1.getDenominador()
                - denominador * n1.getNumerador(),
                denominador * n1.getDenominador());
    }

    public Fraccion times(Fraccion n1){
        return new Fraccion(numerador * n1.getNumerador(),
                denominador * n1.getDenominador());
    }

    public Fraccion divides(Fraccion n1){
        return new Fraccion(numerador * n1.getDenominador(),
                denominador * n1.getNumerador());
    }

    public boolean isLessThan(Fraccion n1){
        if((float)numerador/denominador < (float)n1.getNumerador()/n1.getDenominador()){
            return true;
        }else{
            return false;
        }
    }

    public Fraccion getGreater(Fraccion n1){
        if((float)numerador/denominador > (float)n1.getNumerador()/n1.getDenominador()){
            return this;
        }else{
            return n1;
        }
    }

    private int maximoComunDivisor(){
        int a = Math.abs(numerador);
        int b = Math.abs(denominador);
        if(b == 0){
            return a;
        }
        int c;
        while(b != 0){
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

    public Fraccion simplificar(){
        int dividir = maximoComunDivisor();
        numerador /= dividir;
        denominador /= dividir;
        return this;
    }
}