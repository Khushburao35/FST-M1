package Activity;
import java.util.ArrayList;

public class Activity09 {

	public static void main(String[] args) {

		ArrayList <String> MyList = new ArrayList<String>();
		
		MyList.add("one");
		MyList.add("two");
		MyList.add("five");
		MyList.add(2, "three");
		MyList.add(3, "four");
		
		for(String s:MyList)
		{
			System.out.print(s+"\t");
		}
		
		MyList.remove(1); 	//will remove two.
		MyList.set(3,"CCC");
		System.out.println("\n Get : "+ MyList.get(3));
		
		for(String s:MyList)
		{
			System.out.print(s+ "\t ");
		}
		
		System.out.println("\n New Size: "+ MyList.size());
		

	}

}
