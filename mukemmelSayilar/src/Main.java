public class Main {
    public static void main(String[] args) {
        //6-->1,2,3--->1+2+3=6
        int number=6;
        int toplam=0;
        for (int i =1;i<number; i++) {
            if (number%i==0){
                toplam=toplam+i;
            }
        }
        if (toplam==number){
            System.out.println("mükemmel sayıdır");
        }
        else{
            System.out.println("mükemmel sayı değildir");
        }

    }
}