//f(x) = 20 / √(25-x²)
import java.util.*;

public class integral5{
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
        for(int i=1; i<n; i++){     //'i=n' foi excluído para evitar resultado infinito
            xi = a + (i*dx);                                //pegando o valor de x
            f = 20/(Math.sqrt(25 - Math.pow(xi, 2)));     //calculando o valor de y
            area = area + (f*dx);                           //somando a área total
        }
        System.out.println("Resultado: "+area);     //printando o resultado! :)
    }
}