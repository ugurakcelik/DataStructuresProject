package dproject.SLL;
public class ListNode<AnyType> {
    
        private int id;
        private String name;
        private String surname;
        private ListNode<AnyType> next;
        
public void setData(int id, String name, String surname){
    
        this.id = id;
        this.name = name;
        this.surname = surname; 
}

public String getData(){
    
        return id +" " + name +" "+ surname; 
    }

public ListNode<AnyType> getNext(){ 
    
        return next;
    }
public void setNext(ListNode<AnyType> newNext){
    
        next = newNext; 
    }
public Integer getId(){
    
        return id;
    }

public String getName(){
    
    return name;
}

@Override
public String toString() {
       
    return id + " " + name + " " + surname;
    }


}

