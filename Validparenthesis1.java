import java.util.*;
class Validparenthesis1 {
    public static boolean match(char a , char b){
        if(a=='(' && b==')'){
            return true;
        }
      else  if(a=='[' && b==']'){
            return true;
        }
        else  if(a=='{' && b=='}'){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        Stack<Character>stack1=new Stack<>();
        boolean b=false;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='['){
            stack1.push(s.charAt(i));
            System.out.println(stack1.peek());
        }
       else  if(s.charAt(i)=='}' || s.charAt(i)==')' || s.charAt(i)==']'){
           if(stack1.empty()){
               b=true;
               break;
              
           }
        //   System.out.println(stack1.pop());
        System.out.println(s.charAt(i));
            if(!match(stack1.pop(),s.charAt(i))){
                b=true;
               break;
            }
        }
    }
    if(!b && stack1.empty()){
        System.out.println("matching");
    }
    else{
         System.out.println(" no matching");
    }
}
}