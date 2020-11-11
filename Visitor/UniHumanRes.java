//package myhw1;

//import myhw1.MyVisitor;



/**
 *
 * @author petsi
 */
public class UniHumanRes {
    
    public void accept(MyVisitor v){
        v.visit(this);
    }
    
    public String name;
    public int age;
    public String uni_name;
    
    public UniHumanRes(String name,int age,String uni_name) {
        this.name=name;
        this.age=age;
        this.uni_name=uni_name;
    }
    
    public UniHumanRes() {
       name="None";
       age=0;
       uni_name="None";
    }
    
    public void get_info(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Univesity: "+uni_name);
    }
    
}
