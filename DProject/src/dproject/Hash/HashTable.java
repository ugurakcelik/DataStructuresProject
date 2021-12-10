package dproject.Hash;
public class HashTable {
    
  private static int INITIAL_SIZE = 13;
  private HashEntry[] entries = new HashEntry[13];
    
    public void put(Integer id, String name, String surname) {
        
        int hash = getHash(id);
        final HashEntry hashEntry = new HashEntry(id, name, surname);
        if(entries[hash] == null) {
            entries[hash] = hashEntry;
        }

        else {
            HashEntry temp = entries[hash];
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashEntry;
        }
    }


    public String get(Integer id) {
        
        int hash = getHash(id);
        if(entries[hash] != null) {
            HashEntry temp = entries[hash];

            while( !temp.id.equals(id)
                    && temp.next != null ) {
                temp = temp.next;
            }
            return temp.id + " " +temp.name+" "+temp.surname;
        }

        return null;
    }

    private int getHash(Integer id) {
        
        return id % INITIAL_SIZE;
    }
    
     public void remove(int id) { 
         
        int bucketIndex = getHash(id);
        if (entries[bucketIndex] != null){
        entries[bucketIndex] = null;
        }
        
    } 

    public static class HashEntry {
        
        Integer id;
        String name;
        String surname;

        HashEntry next;

        public HashEntry(Integer id, String name, String surname) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.next = null;
        }

        @Override
        public String toString() {
            return "[" + id + "," + name + "," +surname + "]";
        }
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : entries) {
            if(entry == null) {
                continue;
            }else{
            hashTableStr.append("\nHashTable[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;    
            }
            
            }
        }
        return hashTableStr.toString();
    }    
}
