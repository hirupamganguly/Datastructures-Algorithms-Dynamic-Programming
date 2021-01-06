
public class Test {
public static void main(String[] args) {
    Person p1=new Person("Rupam", 1);
    Person p2=new Person("DIPEN", 2);
    Person p3=new Person("Krish", 3);
    Person p4=new Person("Abhi", 5);
    Person p5=new Person("Suv", 6);
    Person p6=new Person("Sub", 88);
    Person p7=new Person("RAjdeep", 112);

    Cq obj=new Cq(5);
    obj.enQ(p1);
    obj.deQ();
    obj.deQ();
    obj.enQ(p2);
    obj.enQ(p3);
    obj.enQ(p4);
    obj.enQ(p5);
    obj.enQ(p6);
    obj.enQ(p7);
    obj.deQ();
    obj.deQ();
    obj.deQ();
    obj.deQ();
    obj.deQ();
    obj.deQ();
    obj.deQ();
    obj.deQ();
    obj.enQ(p5);
    obj.enQ(p6);
    obj.enQ(p7);

}
}