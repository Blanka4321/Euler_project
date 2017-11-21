public class RemoveDuplicatesLinkedList{
    
    public static void main(String args[]){
        
        int[] data = {2,3,4,5,6,7};
        Node start = null;
        Node end   = null;
        
        // create linkedList
        
        for(int i = 0; i < data.length; i++){
            
            Node node = new Node(data[i]);
            
            if(start == null){
                
                start = end = node;
                
            }
            
            end.next = node;
            end = node;
            
        }
        
        print(start);
        
    }
    
    public static void removeDuplicates(Node start){
        
        Node tmp = start;
        Node previous = null;
        Node current = null;
        
        
    }
    
    public static void print(Node start){
      
      Node tmp = start;
      
      while(tmp != null){
          
          System.out.println(tmp.getData());
          tmp = tmp.next;
          
      }
              
    }
    
    public static class Node{
        
        private int data;
        private Node next = null;
        
        public Node(int datum){
            
            data = datum;
            
        }
        
        public int getData(){
            
            return data;
            
        }
        
        
    }
}
