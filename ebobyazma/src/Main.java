import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        int ebob = recursiveEbob(24,12,2);
        System.out.println("ebob: "+ ebob);
    }
    static int recursiveEbob(int a,int b,int bolen){
        if(bolen>a || bolen>b)
            return 1;
        else if (a%bolen==0 && b%bolen==0)
            return bolen* recursiveEbob(a/bolen,b/bolen,bolen);
        else
            return recursiveEbob(a,b,bolen+1);
    }
}
/*
ebob en büyük ortak bölen

18 24          1. tur
9  12 2
3  4  3
3  4  1
1 1
  */