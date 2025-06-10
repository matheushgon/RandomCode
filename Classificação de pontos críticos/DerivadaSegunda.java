import java.io.*;
import java.util.*;

class DerivadaSegunda{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("combinacoes_xy.txt"));
        int x, y;
        double fx, fy;
            do{
            x = sc.nextInt();
            y = sc.nextInt();
            //pegar fx e fy
            fx = 2*6*(Math.pow(x,5)) - 39*4*(Math.pow(x,3)) + 216*2*x;
            fy = Math.pow(y, 6) + 2*Math.pow(y, 5) - 101*Math.pow(y, 4) + 100*Math.pow(y, 2) + 100*2*y - 101*2*Math.pow(y, 3); 
            //se ambos forem 0 -> ponto crítico!
            /*
            System.out.println("\nfx  = "+fx);
            System.out.println("fy  = "+fy);
            */
            if(fx == 0 && fy == 0){
                double fxx, fyy, fxy, D;
                //fxx, fyy e fxy
                fxx = 2*6*5*Math.pow(x,4) - 39*4*3*Math.pow(x, 2) + 216*2;
                fyy = 6*Math.pow(y,5) + 2*5*Math.pow(y, 4) - 101*4*Math.pow(y, 3) + 100*2*y + 100*2 - 101*2*3*Math.pow(y, 2);
                fxy = 0;
                //D = fxx * fyy - (fxy)²
                D = fxx * fyy - Math.pow(fxy, 2);
                //Classificar
                /*
                System.out.println("fxx = "+fxx);
                System.out.println("fxy = "+fxy);
                System.out.println("fyy = "+fyy);
                System.out.println("D   = "+D);
                */
                if(D>0){
                    if(fxx>0){
                        System.out.println("Ponto de mínimo local");
                    }else if(fxx<0){
                        System.out.println("Ponto de máximo local");
                    }
                } else if (D<0){
                    System.out.println("Ponto de sela");
                }
            }else{
                System.out.println("Classificação inconclusiva");
            }
        }while(sc.hasNext()!=false);
        sc.close();
    }
}