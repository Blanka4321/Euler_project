public class AnagramChecker{
    
    public static void main(String args[]){
        
      String a = "tehgwehgwetytyewghhgew";
      String b = "wtehgwehgwetytyewghhge";
      
      boolean result = isAnagram(a,b);
      
      String message = result?"a is an anagram of b":"a isn't an anagram of b";
      System.out.println(message);
        
    }
    
    public static boolean isAnagram(String a, String b){
        
        int[] str_info = new int[256];
        int char_count =  a.length();
        boolean decision = true;
        
        if(a.length() != b.length()){
            
            return false;
        }
        
        for(int i = 0; i < a.length(); i++){
            
            str_info[a.charAt(i)]++;
            
        }
        
        for(int j = 0; j < b.length(); j++){
            
           char c = b.charAt(j);
           
           if(str_info[c] == 0){
               
               return false;
               
           } else {
               
               str_info[c]--;
               char_count--;
           }
           
        }
        
        if(char_count != 0){
            decision = false;
        }
        
        return decision;
    }
}
