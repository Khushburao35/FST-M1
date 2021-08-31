package Activity;
import java.util.Arrays;

class Activity04 
{
  
    public static void main(String args[]) 
    {
        int[] data = { 6,5,7,4,8,3,9,2,0,1 };
       
        for (int i = 1; i < data.length; i++) 
        {
            int temp = data[i];
            int j = i - 1;
            
            while (j >= 0 && temp < data[j]) {
                data[j + 1] = data[j];
                --j;
            }
            data[j + 1] = temp;
        }
        
        
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}