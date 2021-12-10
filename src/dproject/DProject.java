package dproject;
import dproject.BST.BST;
import dproject.Hash.HashMap;
import dproject.Hash.HashTable;
import dproject.SLL.SLL;
import java.util.Scanner;

public class DProject {
        static BST myBST = new BST();
        static SLL<Object> myList = new SLL<>();
        static HashTable hashTable = new HashTable();
        private static final Scanner sc = new Scanner(System.in);
        
    public static void main(String[] args){
        
        initMenu();

}
    private static void initMenu(){
        System.out.print("------------------\n"
                           +"0.Exit \n"
                           +"1.Add student\n"
                           +"2.Delete student\n"
                           +"3.Find student\n"
                           +"4.List all students\n"
                           +"5.List distinct names\n"
                           +"6.List name counts\n"
                           +"7.About\n"
                           +"Enter your selection:\n"
                           +"------------------\n");
        operations(sc.nextInt());
    }
    private static void operations(int userSelection){
        
      switch(userSelection){
        
        case 0:{    System.out.println("Y/N"); String x = sc.next();
                    if(x.equals("Y") || x.equals("y")){
                        System.out.println("Exiting...");  System.exit(0); break;}
                    else{
                        initMenu();
                        break;
                    }
        }
                    
        case 1: {
            
            System.out.print("Id :");
            int id = sc.nextInt();
            System.out.print("Name :");
            String name = sc.next();
            System.out.print("Surname :");
            String surname = sc.next();
            myList.push(id, name, surname);
            myBST.insertRecursively(id, name, surname);
            hashTable.put(id, name, surname);
            initMenu();
            break;
        }
        
        case 2:{
            
            System.out.print("Id :");
            int id = sc.nextInt();
            myList.delete(id);
            myBST.deleteResursive(id);
            hashTable.remove(id);
            initMenu();
            break;
        }
        case 3:{
            
            System.out.print("Id :");
            int id = sc.nextInt();
            {
                long startTime = System.currentTimeMillis();
                System.out.println("---List---");
                System.out.println(myList.get(id));
                long endTime = System.currentTimeMillis();
                System.out.println("List Search Time :" + ((double)(endTime-startTime) +" ms."));
                System.out.println("List Hoop : " +myList.getHoop());}
            {
                long startTime = System.currentTimeMillis();
                System.out.println("---BST---");
                System.out.println(myBST.get(id));
                long endTime = System.currentTimeMillis();
                System.out.println("BST Search Time :" + ((double)(endTime-startTime) +" ms."));
                System.out.println("BST Hoop : " +myBST.getHoop());}
            {
                long startTime = System.currentTimeMillis();
                System.out.println("---Hash Table---");
                System.out.println(hashTable.get(id));
                long endTime = System.currentTimeMillis();
                System.out.println("Hash Table Search Time :" + ((double)(endTime-startTime) +" ms."));}
            initMenu();
            break;
        }
        case 4:{
            System.out.println("------------------\n"+
                                "1.For List\n"
                              + "2.For Binary Search Tree\n"
                              + "3.For Hash Table\n");
            int choose = sc.nextInt();
            switch(choose){
                
                case 1:System.out.println(myList);break;
                case 2:System.out.println(myBST);break;
                case 3:System.out.println(hashTable);break;
                default:System.out.println("Out of range...");break;

                }
            initMenu();
            break;
        }
        case 5:{
            
            System.out.println(myList.distinctNames());
            initMenu();
            break;
        }
        case 6:{
            
            myList.nameCounter();
            initMenu();
            break;
        }
        
        case 7: System.out.println("Author : Ugur Akcelik"); initMenu(); break;
        default: System.out.println("Out of range!\nTry Again."); initMenu(); break;
       }
    }
}

