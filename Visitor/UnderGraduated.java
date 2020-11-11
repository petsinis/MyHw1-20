//package myhw1;

/**
 *
 * @author petsi
 */
public class UnderGraduated extends Student{
    
    public void accept(MyVisitor v){
        v.visit(this);
    }
    
    public UnderGraduated(String name, int age, String uni_name) {
        super(name, age, uni_name);
    }
    
    public UnderGraduated(){
        super();
    }
    
    @Override
    public void get_info(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Univesity: "+uni_name);
        System.out.println("Work: Under Graduated Student");
        System.out.println("Lessons: "+lessons.toString());
        System.out.println("Grades: "+grades.toString());
        
    }
}
