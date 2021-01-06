public class Person {
    public String name;
    public int weight;
    public int index;// it is the value through which graph is represented...
    public Person(String name, int weight, int index){
        this.name=name;
        this.weight=weight;
        this.index=index;
    }
    public String toString(){
        return " "+this.index+" "+this.name+" "+this.weight+" ";
    }
}