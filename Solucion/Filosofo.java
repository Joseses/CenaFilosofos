import java.util.Random;

/**
 
 * @author Beto "El samaritano" Ortiz, RoBerto Cholulaman, José Manuel
 */
public class Filosofo  extends Thread {

    Tenedor derecho = null;
    Tenedor izquierdo = null;
    String nombre;
    int starvationLVL;
    int id;
    int timeMin = 0; //tiempo mínimo de aleatoriedad
    int timeMax = 10; //tiempo máximo de aleatoriedad


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
        while (tengohambre) {
            if (!derecho.isOcupado()&&Mesa.moderador(this)) {
                derecho.setOcupador(id);
                derecho.setOcupado(true);
                System.out.println(nombre + (id) + ": tenedor derecho listo! " + derecho);
                if (!izquierdo.isOcupado()) {
                    izquierdo.setOcupado(true);
                    izquierdo.setOcupador(id);
                    System.out.println(nombre + (id) + ": tenedor izquierdo listo, a comer! " + izquierdo);
                    comer();
                    tengohambre = false;
                }
            } else if (derecho.getOcupador() == id && Mesa.moderador(this)) {
                if (!izquierdo.isOcupado()) {
                    izquierdo.setOcupado(true);
                    izquierdo.setOcupador(id);
                    System.out.println(nombre + (id) + ": tenedor izquierdo listo, a comer! " + izquierdo);
                    comer();
                    tengohambre = false;
                }
            } else {
                isAlive();
                if(derecho.ocupador==id) {
                    derecho.setOcupador(-1);
                    derecho.setOcupado(false);
                }
                if(izquierdo.ocupador==id) {
                    izquierdo.setOcupador(-1);
                    izquierdo.setOcupado(false);
                }

            }
        }
        hacerAlgo();
    }

    public void pensar() throws InterruptedException {
        System.out.println(nombre + (id) + ": estoy pensando...");
        sleep((int) (Math.random() * (timeMax - timeMin + 1) + timeMin));
    }

    public void comer() throws InterruptedException {
        sleep((int) (Math.random() * (timeMax - timeMin + 1) + timeMin));
        derecho.setOcupador(-1);
        izquierdo.setOcupador(-1);
        derecho.setOcupado(false);
        izquierdo.setOcupado(false);
        System.out.println(nombre + (id) + ": estoy satisfecho c:-------------------------------------------");
    }

}
