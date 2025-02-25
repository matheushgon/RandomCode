//Cálculo da integral de e^2x por partes
import java.util.*;

public class integralExp2x{
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
            xi = a + (i*dx);        //pegando o valor de x
            f = Math.exp(2*xi);     //calculando o valor de y
            area = area + (f*dx);   //somando a área total
        }
        System.out.println("Resultado: "+area);     //printando o resultado! :)
    }
}