import java.util.Random;

/**
 
 * @author Beto "El samaritano" Ortiz, RoBerto Cholula, José Manuel
 */
public class Filosofo  extends Thread {

    Tenedor derecho = null;
    Tenedor izquierdo = null;
    String nombre;
    int starvationLVL;
    int id;
    boolean turnoComer;
    int timeMin = 1000;
    int timeMax = 3000;


    //---------------------Constructores--------------------//

    public Filosofo(){}

    public Filosofo(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.starvationLVL = 30;
    }


    //----------------Getters and setters-------------------//

    public void setDerecho(Tenedor derecho) {
        this.derecho = derecho;
        System.out.println("Soy " + nombre + " y ocupe el tenedor derecho");
    }

    public void setIzquierdo(Tenedor izquierdo) {
        this.izquierdo = izquierdo;
        System.out.println("Soy " + nombre + " y ocupe el tenedor izquierdo");
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tenedor getDerecho() {
        return derecho;
    }

    public Tenedor getIzquierdo() {
        return izquierdo;
    }

    public int getid() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    //-------------------------------------------------------//

    public void run() {
        try {
            while(true){
                hacerAlgo();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void hacerAlgo() throws InterruptedException {

        pensar();
        System.out.println(nombre + (id) + ": tengo hambre");
        boolean tengohambre = true;
        while(tengohambre) {
            if(!derecho.isOcupado()) {
                derecho.setOcupador(id);
                derecho.setOcupado(true);
                System.out.println(nombre + (id) + ": tenedor derecho listo! " + derecho);
                if(!izquierdo.isOcupado()) {
                    izquierdo.setOcupado(true);
                    izquierdo.setOcupador(id);
                    System.out.println(nombre + (id) + ": tenedor izquierdo listo, a comer! " + izquierdo);
                    comer();
                    tengohambre=false;
                }
            } else if(derecho.getOcupador()==id) {
                if(!izquierdo.isOcupado()) {
                    izquierdo.setOcupado(true);
                    izquierdo.setOcupador(id);
                    System.out.println(nombre + (id) + ": tenedor izquierdo listo, a comer! " + izquierdo);
                    comer();
                    tengohambre=false;
                }

            } else {
                isAlive();
            }

        }
        System.out.println(id + ": " + getState());
        hacerAlgo();
    }

    public void pensar() throws InterruptedException {
        System.out.println(nombre + (id) + ": estoy pensando...");
        System.out.println(id + ": " + getState());
        sleep((int) (Math.random() * (timeMax - timeMin + 1) + timeMin));
    }

    public void comer() throws InterruptedException {
        sleep((int) (Math.random() * (timeMax - timeMin + 1) + timeMin));
        derecho.setOcupador(-1);
        izquierdo.setOcupador(-1);
        derecho.setOcupado(false);
        izquierdo.setOcupado(false);
        System.out.println(nombre + (id) + ": estoy satisfecho c:-------------------------------------------");
        System.out.println(id + ": " + getState());
    }

}
