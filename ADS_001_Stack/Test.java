public class Test {
public static void main(String[] args) {
    Person p1=new Person("Rupam", 1);
    Person p2 = new Person("Dipen", 2);
    Person p3=new Person("Abhilash", 3);
    Person p4=new Person("Golu", 4);
    Person p5=new Person("Rajdeep", 5);

    MyStack obj=new MyStack(8);
    obj.push(p1);
    obj.show();
    obj.push(p2);
    obj.show();
    obj.pop();
    obj.show();
    obj.push(p3);
    obj.show();
    obj.push(p4);
    obj.show();
    obj.push(p5);
    obj.show();
    obj.pop();
    obj.show();
}
}