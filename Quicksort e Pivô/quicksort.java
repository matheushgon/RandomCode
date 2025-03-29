import java.util.*;

public class quicksort{
    static Random rand = new Random();

    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void QuickSortFirstPivot (int[] array ,int esq ,int dir){
        int i = esq, j = dir;
        int pivo = array[esq];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  QuickSortFirstPivot(array, esq, j);
        if (i < dir)  QuickSortFirstPivot(array, i, dir);
    }

    public static void QuickSortLastPivot (int[] array ,int esq ,int dir){
        int i = esq, j = dir;
        int pivo = array[dir];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  QuickSortLastPivot(array, esq, j);
        if (i < dir)  QuickSortLastPivot(array, i, dir);
    }

    public static void QuickSortRandomPivot (int[] array ,int esq ,int dir ){
        int i = esq, j = dir;
        int pivo = array[rand.nextInt(esq,dir)]; //random ente esq e dir
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  QuickSortRandomPivot(array, esq, j);
        if (i < dir)  QuickSortRandomPivot(array, i, dir);
    }

    public static int getMedian(int a, int b, int c) {
        int median = 0;
        if(a<b){
            if(b<c){
                median = b;
            }else{
                if(a<c){
                    median = c;
                }else{
                    median = a;
                }
            }
        }else{
            if(c<b){
                median = b;
            }else{
                if(c<a){
                    median = c;
                }else{
                    median = a;
                }
            }
        }
        return median;
    }

    public static void QuickSortMedianOfThree (int[] array ,int esq ,int dir ){
        int i = esq, j = dir;
        //medianOfThree
        int pivo = array[getMedian(esq, (esq+dir)/2, dir)];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  QuickSortMedianOfThree(array, esq, j);
        if (i < dir)  QuickSortMedianOfThree(array, i, dir);
    }

    public static void main(String[] args){
        //Setup-------------------------------------------------------------------------
        //Ordered arrays
        int[] arrayCemO = new int[100];
        int n = 100;
        for(int i=0; i<n; i++){
            arrayCemO[i] = i;
        }
        int[] arrayMilO = new int[1000];
        int n2 = 1000;
        for(int i=0; i<n2; i++){
            arrayMilO[i] = i;
        }
        int[] arrayDezMilO = new int[10000];
        int n3 = 10000;
        for(int i=0; i<n3; i++){
            arrayDezMilO[i] = i;
        }
        //Almost ordered arrays
        int[] arrayCemA = new int[100];
        for(int i=0; i<n; i++){
            if(i%3==0 && i<n-1){
                arrayCemA[i] = i+1;
                arrayCemA[i+1] = i;
                i++;
            }else{
                arrayCemA[i] = i;
            }
        }
        int[] arrayMilA = new int[1000];
        for(int i=0; i<n2; i++){
            if(i%3==0 && i<n2-1){
                arrayMilA[i] = i+1;
                arrayMilA[i+1] = i;
                i++;
            }else{
                arrayMilA[i] = i;
            }
        }
        int[] arrayDezMilA = new int[10000];
        for(int i=0; i<n3; i++){
            if(i%3==0 && i<n3-1){
                arrayDezMilA[i] = i+1;
                arrayDezMilA[i+1] = i;
                i++;
            }else{
                arrayDezMilA[i] = i;
            }
        }
        //Random arrays
        int[] arrayCemR = new int[100];
        for(int i=0; i<n; i++){
            arrayCemR[i] = rand.nextInt(n);
        }
        int[] arrayMilR = new int[1000];
        for(int i=0; i<n2; i++){
            arrayMilR[i] = rand.nextInt(n2);
        }
        int[] arrayDezMilR = new int[10000];
        for(int i=0; i<n3; i++){
            arrayDezMilR[i] = rand.nextInt(n3);
        }
        //Printing...-------------------------------------------------------------------
        //Quick 1
        System.out.println("QUICKSORT FIRST PIVOT:");
        System.out.println("    ORDERED ARRAY:");
        long timeStamp1 = System.nanoTime();
        QuickSortFirstPivot(arrayCemO, 0, n-1);
        long timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortFirstPivot(arrayMilO, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortFirstPivot(arrayDezMilO, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");
        System.out.println("    ALMOST ORDERED ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortFirstPivot(arrayCemA, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortFirstPivot(arrayMilA, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortFirstPivot(arrayDezMilA, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");
        System.out.println("    RANDOM ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortFirstPivot(arrayCemR, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortFirstPivot(arrayMilR, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortFirstPivot(arrayDezMilR, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");

        //Quick 2
        System.out.println("QUICKSORT LAST PIVOT:");
        System.out.println("    ORDERED ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortLastPivot(arrayCemO, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortLastPivot(arrayMilO, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortLastPivot(arrayDezMilO, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");
        System.out.println("    ALMOST ORDERED ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortLastPivot(arrayCemA, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortLastPivot(arrayMilA, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortLastPivot(arrayDezMilA, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");
        System.out.println("    RANDOM ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortLastPivot(arrayCemR, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortLastPivot(arrayMilR, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortLastPivot(arrayDezMilR, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");

        //Quick 3
        System.out.println("QUICKSORT RANDOM PIVOT:");
        System.out.println("    ORDERED ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortRandomPivot(arrayCemO, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortRandomPivot(arrayMilO, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortRandomPivot(arrayDezMilO, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");
        System.out.println("    ALMOST ORDERED ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortRandomPivot(arrayCemA, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortRandomPivot(arrayMilA, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortRandomPivot(arrayDezMilA, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");
        System.out.println("    RANDOM ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortRandomPivot(arrayCemR, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortRandomPivot(arrayMilR, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortRandomPivot(arrayDezMilR, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");

        //Quick 4
        System.out.println("QUICKSORT MEDIAN OF THREE PIVOT:");
        System.out.println("    ORDERED ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortMedianOfThree(arrayCemO, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortMedianOfThree(arrayMilO, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortMedianOfThree(arrayDezMilO, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");
        System.out.println("    ALMOST ORDERED ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortMedianOfThree(arrayCemA, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortMedianOfThree(arrayMilA, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortMedianOfThree(arrayDezMilA, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");
        System.out.println("    RANDOM ARRAY:");
        timeStamp1 = System.nanoTime();
        QuickSortMedianOfThree(arrayCemR, 0, n-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        100 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortMedianOfThree(arrayMilR, 0, n2-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        1000 elements: "+(timeStamp2-timeStamp1)+"ns");
        timeStamp1 = System.nanoTime();
        QuickSortMedianOfThree(arrayDezMilR, 0, n3-1);
        timeStamp2 = System.nanoTime();
        System.out.println("        10.000 elements: "+(timeStamp2-timeStamp1)+"ns");
    }
}
