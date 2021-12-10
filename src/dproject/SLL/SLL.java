package dproject.SLL;

import java.util.HashMap;

public class SLL<AnyType> {
    
    private static int hoop = 0;
    private ListNode<AnyType> theTop;
    private int theSize;
    
    public String top(){
        
        if (theSize == 0)
            throw new RuntimeException("List is empty!");
            
        return theTop.getData(); 
    }
	
    public void push(int id, String name, String surname){
        
        ListNode<AnyType> newNode = new ListNode<>();
        newNode.setData(id, name, surname); 
        newNode.setNext(theTop);  
        theTop = newNode;         
        
        theSize++;
    }

    public String pop(){  
         
        if (theSize == 0)
            throw new RuntimeException("List is empty!");
   
        String returnValue = theTop.getData(); 
        theTop = theTop.getNext();      
        theSize--;                      
        
        return returnValue;
    }
     
    public ListNode delete(int id){
        
        ListNode <AnyType> temp = theTop, prev = null;
        hoop = 0;
        if (temp != null && temp.getId() == id){ 
            theTop = theTop.getNext();
            theSize--;
            return temp; 
        }
         while (temp != null && temp.getId() != id){ 
            prev = temp; 
            temp = temp.getNext();
            hoop++;
        }
         if (temp != null){ 
            prev.setNext(temp.getNext()); 
            theSize--;
            System.out.println(id +" found and deleted"); 
        }
        else{ 
            System.out.println(id + " not found"); 
        } 
        return temp;
    }
    
    public int size(){ 
        
        return theSize;
    }

    public boolean isEmpty(){
        
        return theSize == 0;
    }
    
    public ListNode get(int id){
        
        ListNode <AnyType> temp = theTop, prev = null;
            hoop=0;
     if (temp != null && temp.getId() == id) { 
            return temp; 
        }
         while (temp != null && temp.getId() != id) { 
            prev = temp; 
            temp = temp.getNext();
            hoop++;
        }
         if (temp != null) { 
            return temp;
        }
        return null;
    }
    
    public String distinctNames(){
        
    String str = "";
    ListNode <AnyType> temp = theTop , prev = null;
    if (temp != null)
            str += temp.getName();
    while (temp != null) { 
            prev = temp;
            temp = temp.getNext();
            if(!str.contains(prev.getName()))
                str += " " + prev.getName();
        }
    return str;
    }
    
    public void nameCounter(){
        HashMap<String,Integer> myMap = new HashMap<>();
        String str = "";
    ListNode <AnyType> temp = theTop , prev = null;
    if (temp != null)
            str += temp.getName();
    while (temp != null) { 
            prev = temp;
            temp = temp.getNext();
                str += " " + prev.getName();
        }
       String[] tokens = str.split(" ");

        int count;
                
        for(String token : tokens)
        {
            String word = token.toLowerCase();

            if(myMap.containsKey(word))
            {
                count = myMap.get(word);
                myMap.put(word,count+1);
            }
            else
                myMap.put(word,1);
        }

        System.out.print("Word Counts : ");
        System.out.println(myMap);
    }
    
    public int getHoop(){
        
        return hoop;
    }
    
    @Override
    public String toString(){
        
        String rStr = "List- ";

        ListNode<AnyType> temp = theTop;
        for (int i=0; i<theSize; i++)
        {
            rStr = rStr +"["+ temp.getData() + "] "; 
            temp = temp.getNext();
        }
        return rStr;
    }
}
