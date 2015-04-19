import java.util.Random;

/**
 
 * @author Beto,MaNuel,RoBerto
 */
public class Filosofo  extends Thread
{
    Mesa lamesa;
    int numeroF;
    
    int tenedorIzq;
    int tenedorDer;
    
    char accion;  // comer, pensar, hambre
    Random r = new Random();
    int a,x;
    int numero;
    
    
   public Filosofo(Mesa m, int j,int tiempo)
   {
       lamesa=m;
       numeroF = j;
       tenedorIzq = j-1;
       if(j==lamesa.n){ tenedorDer = 0;}
       else{tenedorDer = j;}
       
       accion = 'p';
       x=tiempo;
      
   }
   
   public void run()
   {
       while(true)
       {
           boolean suyoIzq = false;
           boolean suyoDer= false;
           
           while(accion == 'p')
           {
               System.out.println("Filosofo "+ numeroF + " Piensa");
               a = r.nextInt(x);
               try
               {
                   Thread.sleep(a);
               }
               catch(Exception e){e.printStackTrace();}
               
               accion = 'h';
               System.out.println("Filosofo "+ numeroF + " Tiene hambre");
           }
           while(accion == 'h')
           {
               
               if((lamesa.tenedoresLibres[tenedorDer]))
               {
                   lamesa.tenedoresLibres[tenedorDer] = false;
                   suyoDer = true;
                   System.out.println("Filosofo "+ numeroF + " toma su tenedor derecho "+tenedorDer);
                   
               }
               if((lamesa.tenedoresLibres[tenedorIzq])&& !lamesa.tenedoresLibres[tenedorDer]&& suyoDer)
               {
                   lamesa.tenedoresLibres[tenedorIzq] = false;
                   suyoIzq = true;
                   System.out.println("Filosofo "+ numeroF + " toma su tenedor Izq "+tenedorIzq);
               }
               
               if(!lamesa.tenedoresLibres[tenedorIzq]&& !lamesa.tenedoresLibres[tenedorDer]&& suyoDer && suyoIzq)
               {  accion = 'c';
                    
               }
           }
           while(accion == 'c')
           {
               System.out.println("Fioisofo "+ numeroF + " Come-----------------------------------------------");
               a = r.nextInt(x);
               try
               {
                   Thread.sleep(a);
               }
               catch(Exception e){e.printStackTrace();}
               accion = 'p';
               lamesa.tenedoresLibres[tenedorIzq] = true;
               lamesa.tenedoresLibres[tenedorDer] = true;
               
               
           }
           
           
       }
       
   }
            
}
