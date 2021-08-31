package Activity;
public class Activity08 {
	public static void main(String[] a)
	{
		try {
			Activity08.exceptionTest("Will print to console");
			Activity08.exceptionTest(null);
		} catch(Exception e) {
			System.out.println("Catch: " + e.getMessage());
		}
	}

	static void exceptionTest(String s) throws CustomException {
		if(s == null) 
		{
			throw new CustomException("String value is null");
		} else {
			System.out.println(s);
		}
	}
}

class CustomException extends Exception {
	private String message = null;

	//constructor that initializes the message variable
	public CustomException(String message) {
		this.message = message;
	}

	
	//Override annotation for getMessage()
	@Override
	public String getMessage() {
		return message;
	}
}

