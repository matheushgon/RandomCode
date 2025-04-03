//f(x) = 4*PI*x*sqrt(16-((x-6)^2))
import java.util.*;

public class integral3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double a, b;
        int n;
        System.out.println("Digite o limite inferior:");
        a = sc.nextDouble();
        System.out.println("Digite o limite superior:");
        b = sc.nextDouble();
        System.out.println("Digite o número de partes:");
        n = sc.nextInt();
        sc.close();
        double dx = (b-a)/n;        //calculando a base dos retângulos
        double xi, f, area = 0;
        for(int i=1; i<=n; i++){
            xi = a + (i*dx);                                                    //pegando o valor de x
            f = 4 * Math.PI * xi * Math.sqrt(16 - Math.pow(xi-6, 2));         //calculando o valor de y
            area = area + (f*dx);                                               //somando a área total
        }
        System.out.println("Resultado: "+area);     //printando o resultado! :)
    }
}