
package question;

public class House {
	
	private String name;
	private int x;
	private int y;
	
	/* Create Getters, setters for the House class for each attribute */
	
	public House(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	// setter method for name of house
	public void  setName(String name) {
		this.name = name;
	}	
		
	// getter method for name of house
	public String getName() {
		return name;
	}
		
	// setter method for x coordinate of house
	public void setX(int x) {
		this.x = x;
	}
	
	// setter method for y coordinate of house
	public void setY(int y) {
		this.y = y;
	}
		
	// getter method for x coordinate of house
	public int getX() {
		return x;
	}
	
	// getter method for y coordinate of house
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "House [name=" + name + ", x=" + x + ", y=" + y + "]";
	}	
	

	
	


	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	
	
}

