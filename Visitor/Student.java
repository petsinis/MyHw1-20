//package myhw1;

import java.util.LinkedList; 
import java.util.HashMap; 

/**
 *
 * @author petsi
 */
public class Student extends UniHumanRes{
    
    public void accept(MyVisitor v){
        v.visit(this);
    }
    
    public LinkedList<String> lessons;
    public HashMap<String, Integer> grades;
    
    
    public Student(String name, int age, String uni_name) {
        super(name, age, uni_name);
        lessons=new LinkedList<>();
        grades=new HashMap<>();
        
    }
    
    public Student() {
       super();
       lessons=new LinkedList<>();
        grades=new HashMap<>();
    }
    
    public void add_lesson(String lesson){
        lessons.add(lesson);
    }
    
    public void insert_grade(String lesson,int grade){
        if(!(lessons.contains(lesson))){
            add_lesson(lesson);
        }
        grades.put(lesson, grade);
    }
    
    @Override
    public void get_info(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Univesity: "+uni_name);
        System.out.println("Work: Student");
        System.out.println("Lessons: "+lessons.toString());
        System.out.println("Grades: "+grades.toString());
        
    }
    
}
