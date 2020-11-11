/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package myhw1;
//import myhw1.MyVisitor;
/**
 *
 * @author petsi
 */
public class PostGraduated extends Student{
    
    public void accept(MyVisitor v){
        v.visit(this);
    }
    
    
    public String degree;
    
    public PostGraduated(String name, int age, String uni_name,String degree) {
        super(name, age, uni_name);
        this.degree=degree;
    }
    
    public PostGraduated(){
        super();
        degree="None";
    }
    
    @Override
    public void get_info(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Univesity: "+uni_name);
        System.out.println("Work: Post Graduated Student");
        System.out.println("Degree: "+degree);
        System.out.println("Lessons: "+lessons.toString());
        System.out.println("Grades: "+grades.toString());
        
    }
    
}
