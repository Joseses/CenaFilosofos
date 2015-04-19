import java.util.Scanner;

import static java.lang.Thread.*;

/**
 *
 * @author Beto "El samaritano" Ortiz, RoBerto CholulamaN, José Manuel
 */
public class Mesa {

    Asiento cabeza = null;

    public Mesa(int tam) {
        Asiento temp = new Asiento(); //Sector temporal
        for(int i = 0; i<tam; i++) {
            Tenedor a = new Tenedor();
            if(cabeza!=null) {
                Asiento temporal = new Asiento(i+1, a);
                temporal.setIzquierda(temp);
                temp.setDerecha(temporal);
                temp = temporal;

            } else { //Cola vacía
                Asiento cab = new Asiento(i+1,a);
                cabeza = cab;
                temp = cabeza;
            }
        }
        cabeza.setIzquierda(temp);
        temp.setDerecha(cabeza);
    }

    public static void main(String[] args) {
        Mesa laMesa = new Mesa(5);
        Asiento temporal = laMesa.cabeza;
        for(int x = 0; x<5; x++) {
            temporal.ocupador.start();
            temporal = temporal.getDerecha();
        }
    }
}

class Asiento { //Clase para recorrer como cola circular los filosofos.
    Asiento derecha;
    Asiento izquierda;
    Filosofo ocupador;
    Tenedor derecho;
    Tenedor izquierdo;
    int numero;

    String[] nombres = {"Confucio", "Platón", "Sócrates", "Voltaire", "Descartes"};

    public Asiento (int x, Tenedor derecho) {
        numero = x;
        this.derecho = derecho;
        ocupador = new Filosofo(nombres[x-1], x);
        ocupador.setDerecho(derecho);
    }

    public Asiento() {}

    public void setDerecha(Asiento derecha) {
        this.derecha = derecha;
        this.derecha.ocupador.setIzquierdo(derecho);
    }

    public void setIzquierda(Asiento izquierda) {
        this.izquierda = izquierda;
    }

    public Asiento getDerecha() {
        return derecha;
    }
}

class Tenedor {
    boolean ocupado;
    int ocupador;

    public Tenedor() {
        ocupado = false;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupador(int ocupador) {
        this.ocupador = ocupador;
    }

    public int getOcupador() {
        return ocupador;
    }
}
