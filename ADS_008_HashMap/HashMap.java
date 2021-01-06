class Entry<K,V>{
    K key;
    V value;
    Entry<K, V> next;
    public Entry(K key, V value){
        this.key=key;
        this.value=value;
    }
}
class HashMap<K,V>{
    Entry<K,V> [] ar;
    public HashMap(int capacity){
        ar= new Entry[capacity];
    }
    public int getHashedValue(K key){
        return key.hashCode()%ar.length-1;
    }
    public void put(K key, V value){
        Entry<K, V> entry = new Entry<K,V>(key, value);
        int index=getHashedValue(key);
        if(ar[index]==null){
            ar[index]=entry;
        }
        else{
            entry.next=ar[index].next;
            ar[index].next=entry;
        }   
    }
    public Entry<K,V> get(K key){
        int index=getHashedValue(key);
        Entry n= ar[index];
        Entry temp=null;
        while(n!=null){
            if(n.key==key){
                temp=n;
                break;
            }
            n=n.next;
        }
        if(temp!=null) System.out.println(temp.value);
        else System.out.println("Not Found");
        return temp;
    }
    public Entry remove(K key){
        int index=getHashedValue(key);
        if(ar[index]==null) return null;
        Entry n=ar[index];
        if(n.key==key && n.next==null){
            Entry temp=ar[index];
            ar[index]=null;
            System.out.println(n.value+" deleted");
            return temp;
        }
        else if(n.key==key && n.next!=null){
            Entry temp=null;
            temp=ar[index];
            ar[index]=n.next;
            return temp;
        }
        else{
            Entry parent=n;
            Entry temp=null;
            while(n.key!=key){
                parent=n;
                n=n.next;
            }
            temp=n;
            parent.next=n.next;
            return temp;
        }
    }
    public void show(){
        System.out.println("---------------");
        for(int i=0;i<ar.length;i++){
            if(ar[i]!=null){
                System.out.print("At Index   "+i+"   values are ");
                Entry n=ar[i];
                while(n!=null){
                    System.out.print("{ "+n.key+"-"+n.value+" }"+ " --->");
                    n=n.next;
                }
                System.out.println("");
            }
        }
    }
}