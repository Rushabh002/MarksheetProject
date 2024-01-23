package Manage.student.com;
import java.sql.*;
import java.util.Scanner;
import static Manage.student.com.CP.con;

public class Dao {
    public static void addStudentRecord(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Roll no");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Full name");
        String name = validateName(sc);
        System.out.println("Enter Age ");
        int age = validateAge(sc);
        System.out.println("Enter Physics Marks");
        int physics = validateMarks(sc);
        System.out.println("Enter Chemistry Marks");
        int chemistry = validateMarks(sc);
        System.out.println("Enter Maths Marks");
        int maths = validateMarks(sc);
        System.out.println("Enter English Marks");
        int english = validateMarks(sc);
        Students student = new Students(roll,name,age);
        Marksheets marksheets = new Marksheets(physics,chemistry,maths,english);

        try {
            String query = "INSERT INTO students (id,name,age) VALUES (?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,student.getStud_id());
            preparedStatement.setString(2,student.getStud_name());
            preparedStatement.setInt(3,student.getStud_age());
            preparedStatement.executeUpdate();

            String insertmarks = "INSERT INTO marksheet (stud_id,physics,chemistry,maths,english) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement1 = con.prepareStatement(insertmarks);
            preparedStatement1.setInt(1,student.getStud_id());
            preparedStatement1.setInt(2,marksheets.getPhysics());
            preparedStatement1.setInt(3,marksheets.getChemistry());
            preparedStatement1.setInt(4,marksheets.getMaths());
            preparedStatement1.setInt(5,marksheets.getEnglish());
            preparedStatement1.executeUpdate();

            System.out.println("New record added successfully.");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Student with roll no already Exists.");
        }catch (SQLException ex){
            System.out.println("Failed");
        }
    }
    public static void updateStudentName(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Roll no");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter New Name ");
        String name = validateName(sc);

        try {
            String query ="UPDATE students set name = ? where id =?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,roll);
            int row = preparedStatement.executeUpdate();
            if(row>0){
                System.out.println("Name is Updated Sucessfully");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void updateAge(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll no ");
        int roll = sc.nextInt();
        System.out.println("Enter New Age");
        int age = validateAge(sc);

        try {
            String query = "UPDATE students set age =? WHERE id = ?";
            PreparedStatement preparedStatement= con.prepareStatement(query);
            preparedStatement.setInt(1,age);
            preparedStatement.setInt(2,roll);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Age is Updated");
            }
            }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void deleteStudentRecord(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll no to be Deleted");
        int roll = sc.nextInt();


        try {
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,roll);
            int row = preparedStatement.executeUpdate();
            if(row>0){
                System.out.println("Deleted Successfully");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateAllmarks(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Roll no ");
        int roll = sc.nextInt();
        System.out.println("Enter new Physics Marks");
        int physics = validateMarks(sc);
        System.out.println("Enter new Chemistry Marks");
        int chemistry = validateMarks(sc);
        System.out.println("Enter new Maths Marks");
        int maths = validateMarks(sc);
        System.out.println("Enter new English Marks");
        int eng = validateMarks(sc);
        Marksheets marksheets = new Marksheets(physics,chemistry,maths,eng);

        try {
            String query = "UPDATE marksheet set physics =? ,chemistry =?, maths=?,english=? WHERE stud_id = ?";
            PreparedStatement preparedStatement= con.prepareStatement(query);
            preparedStatement.setInt(1,marksheets.getPhysics());
            preparedStatement.setInt(2,marksheets.getChemistry());
            preparedStatement.setInt(3,marksheets.getMaths());
            preparedStatement.setInt(4,marksheets.getEnglish());
            preparedStatement.setInt(5,roll);
            int row = preparedStatement.executeUpdate();
            if(row>0){
                System.out.println("Marks are Updated");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateSubjectMark(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Roll no ");
        int roll = sc.nextInt();
        System.out.println("Choose the subject for which you want to change your marks.");
        System.out.println("Press 1 for Physics");
        System.out.println("Press 2 for Chemistry");
        System.out.println("Press 3 for Maths");
        System.out.println("Press 4 for English");
        int choice = sc.nextInt();
        System.out.println("Enter Marks");
        int marks = validateMarks(sc);;

        switch (choice) {

            case 1:
                String pquery = "Update marksheet set physics = ? where stud_id = ?";
                try(PreparedStatement preparedStatement = con.prepareStatement(pquery)){
                    preparedStatement.setInt(1,marks);
                    preparedStatement.setInt(2,roll);
                    int row = preparedStatement.executeUpdate();
                    if(row>0){
                        System.out.println("Marks are Updated");
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
                break;

            case 2:
                String cquery = "Update marksheet set chemistry = ? where stud_id = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(cquery)){
                    preparedStatement.setInt(1,marks);
                    preparedStatement.setInt(2,roll);
                    int row = preparedStatement.executeUpdate();
                    if(row>0){
                        System.out.println("Marks are Updated");
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
                break;

            case 3:
                String mquery = "Update marksheet set maths = ? where stud_id = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(mquery)){
                    preparedStatement.setInt(1,marks);
                    preparedStatement.setInt(2,roll);
                    int row = preparedStatement.executeUpdate();
                    if(row>0){
                        System.out.println("Marks are Updated");
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
                break;

            case 4:
                String equery = "Update marksheet set english = ? where stud_id = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(equery)){
                    preparedStatement.setInt(1,marks);
                    preparedStatement.setInt(2,roll);
                    int row = preparedStatement.executeUpdate();
                    if(row>0){
                        System.out.println("Marks are Updated");
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
                break;
        }
    }

    public static void addCourseTeacher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Course Id");
        int course_id =sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Course Name");
        String course_name = sc.nextLine();
        System.out.println("Enter Teacher Name");
        String teacher_name = validateName(sc);
        Courses courses = new Courses(course_id,course_name);
        Teachers teachers = new Teachers(teacher_name);

        try {
            String query = "Insert into courses(id,name) VALUES (?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,courses.getCourse_id());
            preparedStatement.setString(2,courses.getCourse_name());
            preparedStatement.executeUpdate();

            String insertteacherquery = "INSERT INTO teachers (course_id,name) VALUES (?,?)";
            PreparedStatement preparedStatement1 = con.prepareStatement(insertteacherquery);
            preparedStatement1.setInt(1,courses.getCourse_id());
            preparedStatement1.setString(2,teachers.getTeacher_name());
            preparedStatement1.executeUpdate();

            System.out.println("Courses And Teacher Details Added Sucessfully");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Course with Course ID already Exists.");
        }catch (SQLException ex){
            System.out.println("Failed");
        }
    }
    public static void updateCourseTeacher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to Update Course Name");
        System.out.println("Press 2 to Update Teacher Name");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Course Id");
        int id = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                System.out.println("Enter New Course Name");
                String name = sc.nextLine();
                try {
                    String updateCourse = "UPDATE courses SET name = ? WHERE id = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(updateCourse);
                    preparedStatement.setString(1,name);
                    preparedStatement.setInt(2,id);
                    int row = preparedStatement.executeUpdate();
                    if (row > 0) {
                        System.out.println("Course Name Updated");
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("Enter New Teacher Name");
                String tname = validateName(sc);
                try {
                    String query = "UPDATE teachers SET name =? WHERE course_id = ?";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1,tname);
                    preparedStatement.setInt(2,id);
                    int row = preparedStatement.executeUpdate();
                    if(row>0){
                        System.out.println("Teacher Name Updated");
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }
    public static void deleteCourseTeacher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Course Id to be Deleted");
        int id = sc.nextInt();
        try {
            String query = "Delete from courses where id =?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            int row =preparedStatement.executeUpdate();
            if(row>0){
                System.out.println("Course And Teacher Are Deleted");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void viewCourseTeacher(){
        try {
            String query = "SELECT courses.id as course_id, courses.name as course_name ,teachers.name as teacher_name from courses join teachers on courses.id = teachers.course_id ORDER BY course_id ASC";
            PreparedStatement preparedStatement=con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("========================================================");
            System.out.printf("| %-53s|\n","                Courses And Teachers");
            System.out.println("--------------------------------------------------------");
            System.out.printf("| %-10s| %-20s| %-19s|\n","Course ID","Course Name","Teacher Name");
            System.out.println("========================================================");
            while(resultSet.next()){
                System.out.printf("| %-10s| %-20s| %-19s|\n",resultSet.getInt("course_id"),resultSet.getString("course_name"),resultSet.getString("teacher_name"));
            }
            System.out.println("========================================================");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void viewStudent(){
        String query = "SELECT *FROM students";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("=================================================");
            System.out.printf("| %-46s|\n","              Students Info");
            System.out.println("-------------------------------------------------");
            System.out.printf("| %-10s|   %-20s| %-10s|\n","Roll No","Name","Age");
            System.out.println("=================================================");
            while(resultSet.next()){
                System.out.printf("| %-10s|   %-20s| %-10s|\n",resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("age"));

            }
            System.out.println("=================================================");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void viewMarksheet() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Roll no");
        int roll = sc.nextInt();
        try {
            String query = "select students.id as student_roll, students.name as student_name,students.age,\n" +
                    "        marksheet.physics,marksheet.chemistry,marksheet.maths,marksheet.english from students\n" +
                    "        join marksheet on students.id = marksheet.stud_id where students.id =? ;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, roll);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int physics = resultSet.getInt("physics");
                int chemistry = resultSet.getInt("chemistry");
                int maths = resultSet.getInt("maths");
                int english = resultSet.getInt("english");
                int total = physics + chemistry + maths + english;
                System.out.println();
                System.out.println();
                System.out.println("\n\n==============================================");
                System.out.println("|                Mark Sheet                  |");
                System.out.println("==============================================");
                System.out.printf("|%-44s|\n", " Student Name: " + resultSet.getString("student_name"));
                System.out.printf("|%-44s|\n", " Roll No: " + resultSet.getInt("student_roll"));
                System.out.printf("|%-44s|\n", " Age: " + resultSet.getInt("age"));
                System.out.println("==============================================");
                System.out.printf("| %-11s| %-11s| %-17s|\n", "Subject", "Marks", "Grade");
                System.out.print("----------------------------------------------\n");
                printwithgrade("Physics", resultSet.getInt("physics"));
                printwithgrade("Chemistry", resultSet.getInt("chemistry"));
                printwithgrade("Maths", resultSet.getInt("maths"));
                printwithgrade("English", resultSet.getInt("english"));
                System.out.println("----------------------------------------------");
                System.out.printf("| %-11s| %-11s| %-17s|\n","Total",total+"/400"," ");
                System.out.println("----------------------------------------------");
                printResult(resultSet.getInt("physics"), resultSet.getInt("chemistry"),
                        resultSet.getInt("maths"), resultSet.getInt("english"));
                System.out.println("==============================================");
                System.out.println();
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void printwithgrade(String subject,int marks){
           String grade = calculategrade(marks);
            System.out.printf("| %-11s| %-11s| %-17s|\n", subject, marks, grade);
        }
        public static String calculategrade(int marks){
            if (marks >= 85) {
                return "A";
            } else if (marks >= 70) {
                return "B";
            } else if (marks >= 50) {
                return "C";
            } else if (marks >= 40) {
                return "D";
            } else {
                return "F";
            }
        }
        public static void printResult(int physics,int chemistry,int maths,int english){
        int total = physics+chemistry+maths+english;
        int result = total/4;
        String r1 =calculateresult(result);
            System.out.printf("| %-11s| %-11s| %-17s|\n","Result",r1," ");
        }
        public static String calculateresult(int result){
        if(result>=33){
            return "Pass";
        }else{
            return "Fail";
        }
    }
    private static String validateName(Scanner sc) {
        String name;
        do {
            name = sc.nextLine().trim();
            if (name.isEmpty() || name.length() > 20) {
                System.out.println("Invalid name. Please enter a valid name (up to 20 characters).");
            }
        } while (name.isEmpty() || name.length() > 20);
        return name;
    }

    private static int validateAge(Scanner sc) {
        int age;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Invalid age. Please enter a valid integer age.");
                sc.next();
            }
            age = sc.nextInt();
            if (age < 0 || age > 100) {
                System.out.println("Invalid age. Please enter a valid age (between 0 and 100).");
            }
        } while (age < 0 || age > 100);
        return age;
    }

    private static int validateMarks(Scanner sc) {
        int marks;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Invalid marks. Please enter a valid integer marks.");
                sc.next(); // Consume the invalid input
            }
            marks = sc.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter a valid marks (between 0 and 100).");
            }
        } while (marks < 0 || marks > 100);
        return marks;
    }
}

