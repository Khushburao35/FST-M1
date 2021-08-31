package Activity;
import java.util.*;

public class Activity02 {
	public static void main(String[] args) {
		int temp = 0;
		int[] numArr = {10, 77, 10, 54, -11, 10};
		System.out.println("Array: " + Arrays.toString(numArr));

		
		for ( int number : numArr)
		{
			if (number == 10)
			{
				temp += number;
			}
			
		}
		
		if ( temp != 30)
		{
			System.out.println("10's in the array is not equal to 30");
		}
		else
		{
			System.out.println("10's in the array is equal to 30");
		}
		
}
}