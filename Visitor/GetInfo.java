//package myhw1;

class GetInfo implements MyVisitor{

    @Override
    public void visit(UniHumanRes H) {
        System.out.println("Name: "+H.name);
        System.out.println("Age: "+H.age);
        System.out.println("Univesity: "+H.uni_name);
    }

    @Override
    public void visit(Teacher T) {
        System.out.println("Name: "+T.name);
        System.out.println("Age: "+T.age);
        System.out.println("Univesity: "+T.uni_name);
        System.out.println("Work: Teacher");
        System.out.println("Salary: "+T.salary);
    }

    @Override
    public void visit(Student S) {
        System.out.println("Name: "+S.name);
        System.out.println("Age: "+S.age);
        System.out.println("Univesity: "+S.uni_name);
        System.out.println("Work: Student");
        System.out.println("Lessons: "+S.lessons.toString());
        System.out.println("Grades: "+S.grades.toString());
    }

    @Override
    public void visit(PostGraduated P) {
        System.out.println("Name: "+P.name);
        System.out.println("Age: "+P.age);
        System.out.println("Univesity: "+P.uni_name);
        System.out.println("Work: Post Graduated Student");
        System.out.println("Degree: "+P.degree);
        System.out.println("Lessons: "+P.lessons.toString());
        System.out.println("Grades: "+P.grades.toString());
    }

    @Override
    public void visit(UnderGraduated U) {
        System.out.println("Name: "+U.name);
        System.out.println("Age: "+U.age);
        System.out.println("Univesity: "+U.uni_name);
        System.out.println("Work: Under Graduated Student");
        System.out.println("Lessons: "+U.lessons.toString());
        System.out.println("Grades: "+U.grades.toString());
    }
    
}
