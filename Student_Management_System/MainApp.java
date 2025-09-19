import java.util.*;
class Student{
    private int id;
    private String name;
    private int age;
    private String course;
    public Student(int id,String name,int age,String course){
        this.id=id;
        this.name=name;
        this.age=age;
        this.course=course;
    }
    // getters -> need to return
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public String getCourse(){
        return course;
    }
    // setters -> no need to return
    
    
    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }
    public void setCourse(String course){
        this.course=course;
    }

    public void display(){
        System.out.println("id: "+id+", name: "+name+", age: "+age+", course: "+course);
    }
}


class StudentManager{
    private ArrayList<Student> students=new ArrayList<>();
    public void addStudent(Student s){
        students.add(s);
        System.out.println("Student added successfully.");
    }
    public void viewStudents(){
        if(students.isEmpty()){
            System.out.println("No students found.");
            return;
        }
        for(Student s:students){
            s.display();
        }
    }
    public void updateStudents(int id, String name, int age, String course){
        for(Student s:students){
            if(s.getId()==id){
                s.setName(name);
                s.setAge(age);
                s.setCourse(course);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student with id "+id+" not found.");
    }
    public void deleteStudent(int id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.remove(i);
                System.out.println("Student deleted successfully.");
                return;

            }
        }
        System.out.println("Student not found "+id);
    }
}
public class MainApp{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StudentManager sm=new StudentManager();
        while(true){
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("👉 Enter choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:{
                    System.out.println("enter id");
                    int id=sc.nextInt();
                    System.out.println("enter name");
                    String name=sc.next();
                    System.out.println("enter age");    
                    int age=sc.nextInt();
                    System.out.println("enter course");
                    String course=sc.next();
                    // now inserting these values in student object
                    Student s=new Student(id,name,age,course);
                    sm.addStudent(s);
                    break;
                }
                case 2:{
                    sm.viewStudents();
                    break;
                }
                case 3:{
                    System.out.print("Enter ID to Update: ");
                    int id=sc.nextInt();
                    System.out.print("Enter New Name: ");
                    String name=sc.next();
                    System.out.print("Enter New Age: ");
                    int age=sc.nextInt();
                    System.out.print("Enter New Course: ");
                    String course=sc.next();
                    sm.updateStudents(id,name,age,course);
                    break;
                }

                case 4:{
                    System.out.print("Enter ID to Delete: ");
                    int id=sc.nextInt();
                    sm.deleteStudent(id);
                    break;
                }
                case 5:{
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    return;
                }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        }
    }
}