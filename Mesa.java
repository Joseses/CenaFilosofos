import java.util.Scanner;
import java.util.Random;



/**
 *
 * @author Beto,RoBerto,MaNuel
 */
public class Mesa 
{
 
    public boolean[] tenedoresLibres = new boolean[5];
    int n= 5; //numeros de tenedores/filosofos
    
    public Mesa(int k)
    {
        int val = 1;
        n=k;
        tenedoresLibres = new boolean[n];
        for(int j=0;j<n; j++)
	{
            tenedoresLibres[j] = true;
            
	}
        
    }
    
   
    
    
	
    public static void main(String[] args)
    {
        int numeros;
        int opcion;
        int p1=0,c1=0,c2=0;
        Mesa laMesa;
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame el numero de filosofos(5): ");
        numeros = sc.nextInt();
        laMesa = new Mesa(5);
      
            
        
        
        Filosofo a = new Filosofo(laMesa,1,10);
        Filosofo b = new Filosofo(laMesa,2,10);
        Filosofo c = new Filosofo(laMesa,3,10);
        Filosofo d = new Filosofo(laMesa,4,10);
        Filosofo e = new Filosofo(laMesa,5,10);
        
        
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        
        
    }
    
}
