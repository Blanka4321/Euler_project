public class SpaceReplacement{
    
    public static void main(String args[]){
        
       String test_string = "This is a test string where the spaces will e replace by (%20)";
       String ammended_string = replace(test_string, ' ', "%20");
       // ammended_string.replace()
       System.out.println(ammended_string);
        
    }
    
    public static String replace(String str, char token, String replacement){
        
        StringBuilder s = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++){
            
            char c = str.charAt(i);
            
            if(c == token){
                
                s.append(replacement);
                
            } else {
                
                s.append(c);
                
            }
        }
        
        return s.toString();
    }
    
}
