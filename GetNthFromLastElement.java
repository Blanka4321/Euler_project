/*
  This program return the nth from the last element in a singely linked list
  
*/


public class GetNthFromLastElement{
  
     public static void main(String[] args){
     
     int[] datum = new int[] {1,2,3,4,5,6,7,8,9,10,89,100,27};
     Node last = null;
     Node first = null;
     int node_count = 0;
     
     // create linked List
     
     for(int i = 0; i < datum.length; i++){
       
       Node node = new Node(datum[i]);
       
       if(first == null){
         
         first = node;
         last = node;
         
       }
       
       last.next = node;
       last = node;
       
       node_count++;
       
     }
     
     System.out.println(getNthFromEndNode(first, node_count, 4));
     
    
   }
  
    public static void println(Node start){
      
       Node iter = start;
     
       while(iter != null){
         
         System.out.println(iter.getData());
         iter = iter.next;
         
       }
       
       System.out.println();
      
    }
  
  
    public static int getNthFromEndNode(Node start, int node_count, int nth){
      
      Node iter = start;
      int scans = node_count - nth;
      int count = 0;
      Node returnNode;
      
      while(iter != null && count < scans){
        
          count++;
          iter = iter.next;
         
      }
      
      return iter.getData();
      
    }
    
    public static class Node{
      
      private int data;
      private Node next = null;
      
      public Node(int data){
        
        this.data = data;
        
      }
      
      public int getData(){
        
         return data;
         
      }
      
    }
  
}
