
public class Test {
public static void main(String[] args) {
    Person p1=new Person("Rupam", 1);
    Person p2=new Person("Dipen", 2);
    Person p3=new Person("Abhilash", 13);
    Person p4=new Person("Krishnendu", 41);
    Person p5=new Person("Subhankar", 15);
    Person p6=new Person("Subrata", 16);
    Person p7=new Person("Rajdeep", 18);
    MyQueue obj=new MyQueue(5);
    obj.enQ(p1);
    obj.enQ(p2);
    obj.deQ();
    obj.deQ();
    obj.deQ();
    obj.enQ(p3);
    obj.enQ(p4);
    obj.enQ(p5);
    obj.enQ(p6);
    obj.enQ(p7);
    obj.deQ();
    obj.deQ();
    obj.deQ();
    obj.enQ(p1);
    

}
}