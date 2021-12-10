package dproject.Hash;
import java.util.ArrayList;
import java.util.List;

public class HashMap {

    class Container{
        Object id;
        Object name;
        Object surname;

    public void insert(Object id, Object name, Object surname){
    
    this.id=id;
    this.name=name;
    this.surname=surname;
    }
}
    
private Container c;
private List<Container> recordList;

public HashMap(){
    
	this.recordList=new ArrayList<Container>();
	}
	
    public void put(Object id, Object name, Object surname){
        
		this.c=new Container();
		c.insert(id, name, surname);
	
		for(int i=0; i<recordList.size(); i++){
			Container c1=recordList.get(i);
			if(c1.id.equals(id)){
			
				recordList.remove(i);
				break;
			}
		}
		recordList.add(c);
	}
	
	public Object get(Object id){
            
		for(int i=0; i<this.recordList.size(); i++){
			Container con = recordList.get(i);
			if (id.toString()==con.id.toString()) {
				return con.id + " "+con.name+" "+con.surname;
			}
		}
		return null;
	} 
}
