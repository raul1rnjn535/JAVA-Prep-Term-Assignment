import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckBalancedParenthesis{
	
	static char findClosing(char c) { 
	    if (c == '(') 
	        return ')'; 
	    if (c == '{') 
	        return '}'; 
	    if (c == '[') 
	        return ']'; 
	    return Character.MIN_VALUE; 
	} 
	static boolean checkForBalancedParen(String expr, int in, int n) { 
	    // Base cases 
	    if (n == 0) 
	        return true; 
	    if (n == 1) 
	        return false; 
	    if (expr.charAt(in) == ')' || expr.charAt(in) == '}' || expr.charAt(in) == ']') 
	        return false; 
	  
	    // Search for closing bracket for first opening parenthesis

	    char closing = findClosing(expr.charAt(in)); 
	  
	    /* count is used to handle cases like "[{()}]". We basically need to consider 
	    matching closing bracket.*/ 
	    int i, count = 0; 
	    for (i = 1; i < n; i++)  
	    { 
	        if (expr.charAt(i) == expr.charAt(in)) 
	            count++; 
	        if (expr.charAt(i) == closing)  
	        { 
	            if (count == 0) 
	                break; 
	            count--; 
	        } 
	    } 
	  
	    // If we did not find a closing bracket 
	    if (i == n) 
	        return false; 
	  
	    // If closing bracket was next to open 
	    if (i == 1) 
	        return checkForBalancedParen(expr, in+2, n-2); 
	    // If closing bracket was somewhere 
	    // in middle. 
	    return checkForBalancedParen(expr, 1, i-in-1) && 
	           checkForBalancedParen(expr,(i+1),n-i-1); 
	} 
	public static void main(String[] args)throws java.io.IOException{
		System.out.println("Enter expression: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		if (checkForBalancedParen(input, 0, input.length())) 
	        System.out.println("Input expression is balanced."); 
	    else
	        System.out.println("Input expression is not balanced.");
	}
}
