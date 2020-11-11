/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package myhw1;

import java.lang.reflect.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;
/**
 *
 * @author petsi
 */
public class MyHw1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        // TODO code application logic here
        int choice=-1;
        
        try (Scanner keyboard = new Scanner(System.in)) {
			while(choice<1||choice>5) {
				System.out.println("Pick a choice:");
				System.out.println("1: UniHumanRes");
				System.out.println("2: Teacher");
				System.out.println("3: Student");
				System.out.println("4: UnderGraduated");
				System.out.println("5: PostGraduated1");
				System.out.print("Your Choice:__");
				choice = keyboard.nextInt();
			}
		}
        
        
        System.out.println("Your choice is: "+choice);
        System.out.println("-----------------------------------");
        
        MyVisitor gi = new GetInfo();
        
        UniHumanRes u=new UniHumanRes();
        
        
        if(choice==1){
            UniHumanRes human=new UniHumanRes("Human", 23, "UOA");
            human.accept(gi); //human.get_info();
            
            u=human;
            
            System.out.println("-----------------------------------");
        }
        
        if(choice==2){
        	Teacher teacher=new Teacher("Teacher", 40, "UOA", 2000);
            teacher.accept(gi); //teacher.get_info();
            
            u=teacher;
            
            System.out.println("-----------------------------------");
        }
        
        if(choice==3){
            Student student=new Student("Student", 23, "UOA");
            student.add_lesson("Maths");
            student.insert_grade("Machine Learning", 7);
            student.accept(gi); //student.get_info();

            u=student;
            
            System.out.println("-----------------------------------");
        }
        
        if(choice==4){
            Student under_student=new UnderGraduated("UnderGraduated", 20, "UOA");
            under_student.add_lesson("C++");
            under_student.insert_grade("Java", 5);
            under_student.accept(gi); //under_student.get_info();
            
            u=under_student;
            
            System.out.println("-----------------------------------");
        }
        
        if(choice==5){
            Student post_student=new PostGraduated("PostGraduated", 23, "UOA","Computer Science at AUTH");
            post_student.add_lesson("Optimization");
            post_student.insert_grade("Advanced AI", 6);
            post_student.accept(gi); //post_student.get_info();
            
            u=post_student;
            
            System.out.println("-----------------------------------");
        }
        
        
        System.out.println("Reflection and class loading test.");
        System.out.println("== Object of type UniHumanRes ==");
 
        
        System.out.println("== Dynamic proxy of I that delegates calls to a of type UniHumanRes ==");
        Class[] interfaces = new Class[1];
        interfaces[0] = MyVisitor.class;
        System.out.println("");
        MyVisitor proxy = (MyVisitor)Proxy.newProxyInstance(MyVisitor.class.getClassLoader(),
					    interfaces,new UniHandler() );
        u.accept(proxy);
        
         
    }
    
}












