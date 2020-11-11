//package myhw1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UniHandler implements InvocationHandler {

    

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        System.out.println("The dynamic proxy handler was called...");
       
        
        if(method.getName().equals("visit")){
        	 
            if(args[0].getClass().toString().endsWith("UniHumanRes")){
                System.out.println("Name: "+((UniHumanRes)(args[0])).name);
                System.out.println("Age: "+((UniHumanRes)(args[0])).age);
                System.out.println("Univesity: "+((UniHumanRes)(args[0])).uni_name);
            }
            else if(args[0].getClass().toString().endsWith("Teacher")){
                System.out.println("Name: "+((Teacher)(args[0])).name);
                System.out.println("Age: "+((Teacher)(args[0])).age);
                System.out.println("Univesity: "+((Teacher)(args[0])).uni_name);
                System.out.println("Work: Teacher");
                System.out.println("Salary: "+((Teacher)(args[0])).salary);
            }
            else if(args[0].getClass().toString().endsWith("Student")){
                System.out.println("Name: "+((Student)(args[0])).name);
                System.out.println("Age: "+((Student)(args[0])).age);
                System.out.println("Univesity: "+((Student)(args[0])).uni_name);
                System.out.println("Work: Student");
                System.out.println("Lessons: "+((Student)(args[0])).lessons.toString());
                System.out.println("Grades: "+((Student)(args[0])).grades.toString());
            }
            else if(args[0].getClass().toString().endsWith("PostGraduated")){
                System.out.println("Name: "+((PostGraduated)(args[0])).name);
                System.out.println("Age: "+((PostGraduated)(args[0])).age);
                System.out.println("Univesity: "+((PostGraduated)(args[0])).uni_name);
                System.out.println("Work: Post Graduated Student");
                System.out.println("Degree: "+((PostGraduated)(args[0])).degree);
                System.out.println("Lessons: "+((PostGraduated)(args[0])).lessons.toString());
                System.out.println("Grades: "+((PostGraduated)(args[0])).grades.toString());
            }
            else if(args[0].getClass().toString().endsWith("UnderGraduated")){
                System.out.println("Name: "+((UnderGraduated)(args[0])).name);
                System.out.println("Age: "+((UnderGraduated)(args[0])).age);
                System.out.println("Univesity: "+((UnderGraduated)(args[0])).uni_name);
                System.out.println("Work: Under Graduated Student");
                System.out.println("Lessons: "+((UnderGraduated)(args[0])).lessons.toString());
                System.out.println("Grades: "+((UnderGraduated)(args[0])).grades.toString());
            }
            else{
                System.out.println("Not supported class..");
            }
        }
        
       
        
        
        return null;
    }




        
        
    }
