package Manage.student.com;

public class Marksheets {

    private int physics;
    private int chemistry;
    private int maths;
    private int english;

    public int getPhysics() {
        return physics;
    }

    public int setPhysics(int physics) {
        this.physics = physics;
        return physics;
    }

    public int getChemistry() {
        return chemistry;
    }

    public int setChemistry(int chemistry) {
        this.chemistry = chemistry;
        return chemistry;
    }

    public int getMaths() {
        return maths;
    }

    public int setMaths(int maths) {
        this.maths = maths;
        return maths;
    }

    public int getEnglish() {
        return english;
    }

    public int setEnglish(int english) {
        this.english = english;
        return english;
    }

    public Marksheets(int physics, int chemistry, int maths, int english) {
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
        this.english = english;
    }
}
