public class StringRotationChecker{
    
    public static void main(String args[]){
        
       String a = "watermelon";
       String b = "lonwaterme";
       
       boolean result = isSubstring(a, b);
       
       String message =  result?b + " is a substring of " + a:b + " is not a substring of " + a;
       System.out.println(message);
        
    }
    
    public static boolean isSubstring(String a, String b) {
        
        boolean isSub = true;
        String sub = "";
        String oldSub = "";
        int oldIndex = 0;
        
        for(int i = 0; i < b.length(); i++){
            
            //oldIndex = index;
            oldSub = sub;
            sub = b.substring(0,i);
            
            int index = a.indexOf(sub);
            
            if(index == -1){
                
                sub = oldSub;
                //index = oldIndex;
                break;
            }
            
        }
        
        isSub = a.equals(b.substring(sub.length()) + sub)?true:false;
        return isSub;
        
    }

}
