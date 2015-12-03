package vaqpack.model;

public class Singleton
{

		    private final static Singleton instance = new Singleton();

		    public static Singleton getInstance() {
		        return instance;
		    }

		    private Vaqpack vaqpack = new Vaqpack();

		    public Vaqpack currentVaqpack() {
		        return vaqpack;
		    }
		
	}
