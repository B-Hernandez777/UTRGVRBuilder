package vaqpack.model;

public class Context
{
	    private final static Context instance = new Context();

	    public static Context getInstance() {
	        return instance;
	    }

	    private Resume resume = new Resume("");

	    public Resume currentResume() {
	        return resume;
	    }
	
}
