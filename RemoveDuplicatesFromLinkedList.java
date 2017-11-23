public class RemoveDuplicatesLinkedList{    
  
  public static void main(String[] args){
    
    int[] data = new int[] {1,1,1,1,1,2,1,2,2,2,2,2,2,2,2,2,2,3,3,5,5,3,3,3,3,2,2,2,3,3,3,3,3,3};
    Node first = null;
    Node last = null;
    
    // create Linkedlist
    
    for(int i = 0; i < data.length; i++){
      
      Node node = new Node(data[i]);
      
      if(first == null){
        
        first = node;
        last = node;
        
      } 
      
      last.next = node;
      last = node;
      
    }
    
    print(first);
    print(removeDuplicates(first));
    
  }
  
  public static Node removeDuplicates(Node head){
    
    int remove_value;
    Node iter = head;
    Node current = null;
    Node previous = null;
    
    while(iter != null){
     
      remove_value = iter.getData();
      previous = iter;
      current = iter.next;
    
      while(current != null){
        
        if(current.getData() == remove_value){
          
           previous.next = current.next;
           //previous = previous.next;
           current = current.next;
           
        } else {
          
           previous = current;
           current = current.next;
          
        }
        
      }
          
       iter = iter.next;
        
    }    
      
    return head;
      
    } 
    
  
  public static void print(Node start){
    
    Node iter = start;
    
    while(iter != null){
      
      System.out.print(iter.getData());
      iter = iter.next;
      
    }
    
    System.out.println();
    
  }
  
  public static class Node {
    
    private int data;  
    private Node next = null;
    
    public Node(int data){
      this.data = data;
    }
    
    public  int getData(){
      return data;
    }
    
  }
  
}
