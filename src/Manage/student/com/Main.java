package Manage.student.com;
import java.util.Scanner;
import static Manage.student.com.Dao.*;
import static Manage.student.com.CP.Closedatabase;
import static Manage.student.com.CP.CreateC;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println("Welcome to Marksheet Generation System");
        System.out.println();
        try {
            CreateC();
            boolean exit =false;
            while(!exit){

                System.out.println("PRESS 1 TO ADD STUDENT RECORD");
                System.out.println("PRESS 2 TO UPDATE STUDENT NAME");
                System.out.println("PRESS 3 TO UPDATE STUDENT AGE");
                System.out.println("PRESS 4 TO DELETE STUDENT RECORD");
                System.out.println("PRESS 5 TO UPDATE STUDENTS ALL MARKS");
                System.out.println("PRESS 6 TO UPDATE STUDENT MARK OF PARTICULAR SUBJECT");
                System.out.println("PRESS 7 TO ADD COURSE AND TEACHER DETAILS");
                System.out.println("PRESS 8 TO UPDATE COURSE AND TEACHER DETAILS");
                System.out.println("PRESS 9 TO DELETE COURSE AND TEACHER");
                System.out.println("PRESS 10 TO VIEW ALL COURSES AND TEACHERS DETAILS");
                System.out.println("PRESS 11 TO VIEW ALL STUDENTS");
                System.out.println("PRESS 12 TO VIEW MARKS SHEET");
                System.out.println("PRESS 13 TO EXIT");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                System.out.println();
                switch (choice){

                    case 1:
                        addStudentRecord();
                        break;
                    case 2:
                        updateStudentName();
                        break;
                    case 3:
                        updateAge();
                        break;
                    case 4:
                        deleteStudentRecord();
                        break;
                    case 5:
                        updateAllmarks();
                        break;
                    case 6:
                        updateSubjectMark();
                        break;
                    case 7:
                        addCourseTeacher();
                        break;
                    case 8:
                        updateCourseTeacher();
                        break;
                    case 9:
                        deleteCourseTeacher();
                        break;
                    case 10:
                        viewCourseTeacher();
                        break;
                    case 11:
                        viewStudent();
                        break;
                    case 12:
                        viewMarksheet();
                        break;
                    case 13:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid Input BYE");
                        exit=true;
                        sc.close();
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            Closedatabase();
        }
    }
}