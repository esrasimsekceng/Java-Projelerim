import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<StudentDegree> studentDegrees = new ArrayList<>();

        int[] degrees={341,273,278,329,445,402,388,270,243,334,412,393,299,343,317,265};
        String [] studentNames={"Kadir","Gökhan","Hakan","Suzan","Pınar","Mehmet","Ali","Emel","Fırat","James","Jale","Ersin","Deniz","Gözde","Anıl","Burak"};
        //iki listemiz var bunlardan tek listeye dönüştüreceğiz. Sınıf olarak StudentDegree yapacağız

        for (int i=0;i<degrees.length;i++ ){
            studentDegrees.add(new StudentDegree(degrees[i],studentNames[i]));
        }
        Collections.sort(studentDegrees, new Comparator<StudentDegree>() {
            @Override
            public int compare(StudentDegree o1, StudentDegree o2) {
                return o1.getDegree()-o2.getDegree();  // pozitif değer çıktığında yer değiştirir.
            }
        });

        for (int i = 0; i < 3 ; i++) {
            System.out.printf("%2d. ->> %s : %3d   \n",i+1,studentDegrees.get(i).getStudentName(),studentDegrees.get(i).getDegree());
        }
        System.out.println("\nSınıflara gore Öğrenci Sayıları");
        long ASayisi = studentDegrees.stream().filter(o->"A".equals(o.getClassForDegree())).count();
        System.out.printf("A derecesinde olan öğrenci Sayısı: %d \n",ASayisi);
        long BSayisi = studentDegrees.stream().filter(o->"B".equals(o.getClassForDegree())).count();
        System.out.printf("B derecesinde olan öğrenci Sayısı: %d\n",BSayisi);
        long CSayisi = studentDegrees.stream().filter(o->"C".equals(o.getClassForDegree())).count();
        System.out.printf("C derecesinde olan öğrenci Sayısı: %d\n",CSayisi);
    }
}