import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args)  throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		
		//Pushing element on the top of the stack
		
		for(int i = 0; i<k; i++) {			
			int e = Integer.parseInt(br.readLine());
			
			if(e!=0) {stk.push(e);}
			else {stk.pop();	}
		}
			int sum =0;
			for(int n : stk) {
				sum += n;
			}	
			System.out.println(sum);
		}
	}