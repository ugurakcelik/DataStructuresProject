package dproject.BST;
public class BST {
TreeNode root;

    private static int hoop = 0;

    public void insertRecursively(int id, String name, String surname){
        
        root = insertRecursively(id, name, surname, root);
    }
    
    private TreeNode insertRecursively(int id,String name,String surname ,TreeNode tempNode){
        
        if( tempNode == null )
            return new TreeNode(null, id, name, surname, null);
            
        if( id < tempNode.getId())
            tempNode.setLeft(insertRecursively(id, name, surname, tempNode.getLeft()));
        else
            tempNode.setRight(insertRecursively(id, name, surname, tempNode.getRight()));
        
        return tempNode;
    }

    public void deleteResursive(int id){ 
        root = delete_Recursive(root, id);
    } 
   
 
    private TreeNode delete_Recursive(TreeNode root, int id)  { 
   
        if (root == null) 
            return root;

       
        if (id < root.getId())    
            root.setLeft(delete_Recursive(root.getLeft(), id)); 
        else if (id > root.getId()) 
            root.setRight(delete_Recursive(root.getRight(), id));
        else  { 
 
            if (root.getLeft() == null) 
                return root.getRight(); 
            else if (root.getRight() == null) 
                return root.getLeft(); 

            root.setData(minimumElement(root.getRight()));
   
            root.setRight(delete_Recursive(root.getRight(), root.getId()));
        }
        return root; 
    } 
    
    public TreeNode get(int id){
       hoop = 0;
       return root = get_Recursive(root, id);
    }
    
    private TreeNode get_Recursive(TreeNode root, int id){
         hoop++;
         if (root==null || root.getId()==id) 
            return root; 
        if (root.getId() > id) 
            return get_Recursive(root.getLeft(), id); 
        return get_Recursive(root.getRight(), id); 

    }
    
    private static TreeNode minimumElement(TreeNode root) {
		if (root.getLeft() == null)
			return root;
		else {
			return minimumElement(root.getLeft());
		}
	}
    
    public boolean isEmpty() 
    {
        return root == null;
    }
    
    public int getHoop(){
        return hoop;
    }
    
    @Override
    public String toString()
{
    String result = "BST - ";
    return result + toString (root);
} 
    
    public String toString(TreeNode root) {
    String result = "";
    if (root == null)
        return result;
    //Inorder
    result += toString(root.getLeft());
    result += "[" +root.toString() +"]";
    result += toString(root.getRight());
    return result;
    }
    
}
