public class StudentDegree {

    private int degree;
    private String studentName;
    public String getClassForDegree(){
        if(this.degree>200 && this.degree<300)
            return "A";
        if(this.degree>=300 && this.degree<400)
            return "B";
        if(this.degree>=400 )
            return "C";
        return "";
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public StudentDegree(int degree, String studentName) {
        this.degree = degree;
        this.studentName = studentName;
    }
}
