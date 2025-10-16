package re.studentmanagement.model;

public class Student {
    private String studentId;
    private String studentName;
    private boolean status;

    public Student() {
    }

    public Student(String studentId, String studentName, boolean status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
