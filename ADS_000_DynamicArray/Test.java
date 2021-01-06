
public class Test {
public static void main(String[] args) {
    DynamicArray obj=new DynamicArray();
    obj.addAt(0, 11);
    obj.addAt(1, 22);
    obj.remove();
    obj.remove();
    obj.remove();
    obj.add(33);
    obj.add(44);
    obj.add(55);
    obj.add(66);
    obj.add(77);
    obj.removeAt(2);
    obj.remove();
    obj.remove();
    obj.remove();
    obj.remove();
}
}