import java.util.Scanner;

public class metin {
    public static void main(String[] args) {
        java.util.Stack harfler=new java.util.Stack();
        String metin="";
        String harf="";
        int hedef=0;
        System.out.println("bir metin giriniz:");
        Scanner oku=new Scanner(System.in);
        metin=oku.nextLine();
        for (int i = 0; i < metin.length(); i++) {
            harf=metin.substring(i,i+1);
            harfler.push(harf);

        }
        hedef=harfler.size();
        for (int i = 0; i < hedef; i++) {
            System.out.println(harfler.pop());
        }
    }
    }

