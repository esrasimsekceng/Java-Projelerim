public class Main {
    public static void main(String[] args) {
        int [] dizi={4,6,7,8};
        int n=dizi.length;
        System.out.println("elemanlar çarpımı:"+ recursiveDiziCarpim(dizi,n) );
    }
    public static int recursiveDiziCarpim(int[] dizi,int n){
        if (n==1)
            return dizi[0];
        return (recursiveDiziCarpim(dizi,n-1))*dizi[n-1];
    }
}