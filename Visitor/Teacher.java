//package myhw1;


/**
 *
 * @author petsi
 */
public class Teacher extends UniHumanRes{
    
    public void accept(MyVisitor v){
        v.visit(this);
    }
    
    
    public int salary;

    public Teacher(String name, int age, String uni_name,int salary) {
        super(name, age, uni_name);
        this.salary=salary;
    }
    
    
    public Teacher() {
       super();
       salary=0;
    }
    
    @Override
    public void get_info(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Univesity: "+uni_name);
        System.out.println("Work: Teacher");
        System.out.println("Salary: "+salary);
    }
    
}
