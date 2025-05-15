import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner oku = new Scanner(System.in);
        System.out.println("1.sayıyı oku:");
        int sayi1 = oku.nextInt();
        System.out.println("2.sayıyı gir:");
        int sayi2 = oku.nextInt();
        System.out.println(ekokBul2(sayi1, sayi2));

        System.out.println("Recursive Sonuç " + recursiveEkok(sayi1, sayi2, 2));
    }

    static int ekokBul2(int a, int b) {return (a * b) / recursiveEbob(a, b, 2);}


    static int recursiveEbob(int a, int b, int bolen) {
        if (bolen > a || bolen > b)
            return 1;
        else if (a % bolen == 0 && b % bolen == 0)
            return bolen * recursiveEbob(a / bolen, b / bolen, bolen);
        else
            return recursiveEbob(a, b, bolen + 1);
    }



    static int recursiveEkok(int a,int b,int bolen){
        if(bolen>a && bolen>b)
            return 1;
        else if (a%bolen==0 || b%bolen==0){
            int a_new = a%bolen==0?a/bolen:a;
            int b_new = b%bolen==0?b/bolen:b;
            return bolen* recursiveEkok(a_new,b_new,bolen);

        }
        else
            return recursiveEkok(a,b,bolen+1);
    }

}


