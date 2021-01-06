
public class Test {
public static void main(String[] args) {
    Person p1=new Person("Rupam", 1, true);
    Person p2=new Person("Dipen", 2, true);
    Person p3=new Person("Abhilash", 3, true);
    Person p4=new Person("Krishnendu", 4, true);
    Person p5=new Person("Subhankar", 5, true);
    Person p6=new Person("Subrata", 6, true);
    Person p7=new Person("Jamuna", 7, false);
    Person p8=new Person("Urmi", 8, false);
    Person p9=new Person("Tusi", 9, false);
    Person p10=new Person("Bittu", 10, true);

    DoublyLinkedList obj =new DoublyLinkedList();

    obj.insAt(0, p1);
    obj.show();
    obj.insAt(1, p2);
    obj.show();
    obj.insAt(2, p3);
    obj.show();
    obj.insAt(6, p4);
    obj.insAt(3, p5);
    obj.insAt(4, p6);
    obj.show();
    obj.insAt(0, p7);
    obj.show();
    obj.insAt(2, p8);
    obj.show();
    obj.del(3);
    obj.show();
    obj.del(0);
    obj.show();
    obj.insAt(1, p9);
    obj.show();
    obj.del(7);
    obj.show();
    obj.insAt(7, p10);
    obj.show();
}
}