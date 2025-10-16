import java.util.*;

/*********************************************************************
 * 
 * Class Name: 2A
 * Author/s name: Alejandro Aceña Tirado / Javier Villanueva Crespo / Rodrigo Muñoz Martin - A102
 * Release/Creation date: 2025/26
 * Class version: 1.0
 * Class description: This class evaluates postfix expressions for string
 * 
 **********************************************************************/

public class S3Lab {

    /*********************************************************************
     * 
     * Method name: main
     * 
     * Description of the Method: Main method that reads a postfix expression
     * from the user, processes it using a stack, and displays the final result.
     * 
     * Calling arguments: 
     * - String[] args: Command line arguments (not used)
     * 
     * Return value: void
     * 
     **********************************************************************/

    public static void main(String [] args){
        Scanner ENTRADA= new Scanner(System.in);    // Scanner to the user input

        System.out.println("Please, introduce a postfix operation.");
        String postfix= ENTRADA.nextLine();     // Read the input of the user

        String [] elements= postfix.split(" ");     // Split the input by spaces
        Stack<String> stack= new Stack<String>();       // Create the stack

        // Process each element of the postfix expression
        for(int i=0; i<elements.length; i++){

            switch(elements[i]){

                case "+": // Concatenation operator
                    String b = stack.pop(); // Second operand
                    String a = stack.pop(); // First operand
                    String result= a + b; // Concatenate strings
                    stack.push(result);
                    break;

                case "-": // Character removal operator
                    b = stack.pop(); // Characters to remove
                    a = stack.pop(); // Base string
                    result= removeChars(a, b); // Remove characters from b in a
                    stack.push(result);
                    break;

                case "@": // Reverse operator
                    a = stack.pop(); // String to reverse
                    result= inverse(a); // Reverse the string
                    stack.push(result);
                    break;

                case "*": // Intersection operator
                    b = stack.pop(); // Second string
                    a = stack.pop(); // First string
                    result= match(a, b); // Find common characters
                    stack.push(result);
                    break;

                default: // Operand (string)
                    stack.push(elements[i]);
            }
        }

        // Display the final result
        if(!stack.isEmpty()){
            System.out.println("Final result: " + stack.peek());
        } else{
            System.out.println("No elements in the stack.");
        }
    }

    /*********************************************************************
     * 
     * Method name: removeChars
     * 
     * Description of the Method: Removes all characters from string 'a' that
     * appear in string 'b'.
     * 
     * Calling arguments: 
     * - String a: The base string from which characters will be removed
     * - String b: The string containing characters to be removed from a
     * 
     * Return value: String - The resulting string after removing characters
     * 
     **********************************************************************/

    public static String removeChars(String a, String b) {
        String result = "";     // Declarate the result string
        
        // Iterate through each character in string a
        for(int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);   // Current character from a
            boolean match = false;     // Flag to check if character is in b
            
            // Check if current character exists in string b
            for(int j = 0; j < b.length(); j++) {
                char d = b.charAt(j);   // Current character from b
                if(c == d) {
                    match = true;
                    break;
                }
            }
            
            // Add character to result only if not found in b
            if(!match) {
                result = result + c;
            }
        }
        return result;
    }

    /*********************************************************************
     * 
     * Method name: inverse
     * 
     * Description of the Method: Reverses a given string by iterating from
     * the last character to the first.
     * 
     * Calling arguments: 
     * - String a: The string to be reversed
     * 
     * Return value: String - The reversed string
     * 
     **********************************************************************/

    public static String inverse(String a){
        String result="";       // Declarate the result string
        
        // Iterate from last character to first
        for(int i=a.length()-1; i>=0; i--){
            result = result + a.charAt(i);
        }

        return result;
    }

    /*********************************************************************
     * 
     * Method name: match
     * 
     * Description of the Method: Finds and returns all characters from
     * string 'a' that also appear in string 'b', maintaining the order
     * from string 'a'.
     * 
     * Calling arguments: 
     * - String a: The first string
     * - String b: The second string to compare against
     * 
     * Return value: String - A string containing common characters
     * 
     **********************************************************************/
    
    public static String match(String a, String b){
        String result= "";      // Declarate the result string
        
        // Iterate through each character in string a
        for(int i=0; i<a.length(); i++){
            char c= a.charAt(i); // Current character from a

            // Check if character exists in string b
            for(int j=0; j<b.length(); j++){
                char d = b.charAt(j); // Current character from b

                if(c==d){
                    result= result + c; // Add common character to result
                    break;
                }
            }
        }
        return result;
    }
}