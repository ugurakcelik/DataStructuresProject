package dproject.BST;
public class TreeNode {
    
    private TreeNode left;
    private int id;
    private String name;
    private String surname;
    private TreeNode right;
    
public TreeNode(TreeNode l, int id, String name, String surname, TreeNode r){
    
        this.left = null;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.right = null;
    }

    public TreeNode getLeft(){
        
        return left; 
    }
    
    public int getId(){ 
        
        return id; 
    }

    public TreeNode getRight(){
        
        return right; 
    }

    public void setLeft(TreeNode newLeft){
        
        left = newLeft; 
    }
    
    public void setData(TreeNode newData){ 
   
        left = newData; 
    }
    
    public TreeNode getData(){ 
        
        return left; 
    }

    public void setRight(TreeNode newRight){
        
        right = newRight; 
    }


@Override
public String toString(){
    
    if(name == null){
        return null;
    }else{
        return id + " " + name +" " +surname;    
    }

            
    }
}
