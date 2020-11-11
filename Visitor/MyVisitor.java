//package myhw1;

public interface MyVisitor {
    void visit(UniHumanRes H);
    void visit(Teacher T);
    void visit(Student S);
    void visit(PostGraduated P);
    void visit(UnderGraduated U);
}
