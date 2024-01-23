package Manage.student.com;

public class Students {

    private int Stud_id ;
    private String Stud_name;
    private int Stud_age;

    public int getStud_id() {
        return Stud_id;
    }

    public void setStud_id(int stud_id) {
        Stud_id = stud_id;
    }

    public String getStud_name() {
        return Stud_name;
    }

    public void setStud_name(String stud_name) {
        Stud_name = stud_name;
    }

    public int getStud_age() {
        return Stud_age;
    }

    public void setStud_age(int stud_age) {
        Stud_age = stud_age;
    }

    public Students(int id, String stud_name, int stud_age) {
        this.Stud_id = id;
        Stud_name = stud_name;
        Stud_age = stud_age;
    }

}
