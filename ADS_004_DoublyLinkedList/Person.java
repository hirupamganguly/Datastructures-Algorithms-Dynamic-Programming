class Person{
    String name;
    int roll;
    boolean male;
    public Person(String name, int roll, boolean male){

        this.name=name;
        this.roll=roll;
        this.male=male;
    }
    public String toString(){
        // toString method is called when we try to print the Object
        // basically we override toString method to our need,
        // so when we want to print the object then instead of hashvalue 
        // we get this kind of String representation
        return "NAME: "+this.name+" ROLL: "+this.roll+" MALE: "+this.male;
    }
}