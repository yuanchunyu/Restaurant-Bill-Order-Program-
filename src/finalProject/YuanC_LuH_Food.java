/**
 * Yuan Chunyu Lu Hanqiao
 * CS 201 final project
 * 12/2/2014
 * Food  class
 */





package finalProject;

public class YuanC_LuH_Food {
	private String dishName;  //represents food name
	private double calories;  //represents food calories
	private double price;     //represents food price
	private String category;  //represents food category
	private int number;       //represents food number

	// default constructor
	public YuanC_LuH_Food()
	{
		dishName="";
		calories=0.0;
		price=0.0;
		category="";
		number=0;
		
	}
	
	//non-default constructor
	public YuanC_LuH_Food(int number1,String dishName1,String category1,double calories1,double price1)
	{
		number=number1;
		dishName=dishName1;
		category=category1;
		calories=calories1;
		price=price1;
	}
	
	//mutator
	public String getDishName() {
		return dishName;
	}
	
	//accessor
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	
	//mutator
	public double getCalories() {
		return calories;
	}
	
	//accessor
	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	//mutator
	public double getPrice() {
		return price;
	}
	
	//accessor
	public void setPrice(double price) {
		this.price = price;
	}
	
	//mutator
	public String getCategory() {
		return category;
	}
	
	//accessor
	public void setCategory(String category) {
		this.category = category;
	}
	
	//mutator
	public int getNumber() {
		return number;
	}
	
	//accessor
	public void setNumber(int number) {
		this.number = number;
	}
	
	//toString
	public String toString() {
		return  "number: "+ number +"\ndishName: " + dishName + "\ncategory: " + category +"\ncalories: " + calories
				+ "\nprice : " + price+"$";
	}
	
	//specifie method to demonstrate the polymorphism
	public void showInfomation()
	{
		System.out.println("\nMeal"+"\n\tnumber: "+ number +"\n\tdishName: " + dishName +"\n\tprice : " + price+"$");
	}
	
	//equals method
	public boolean equals(Object a)
	{
		if(a instanceof YuanC_LuH_Food)
		{if(number==((YuanC_LuH_Food) a).getNumber()&&dishName.equals(((YuanC_LuH_Food) a).getDishName())&&category.equals(((YuanC_LuH_Food) a).getCategory())&&calories==((YuanC_LuH_Food) a).getCalories()&&price==((YuanC_LuH_Food) a).getPrice())
	        return true;
		else
			return false;
		}else
			return false;
	}
	
	// a method to compare Food by its number
	public int compareToNum(YuanC_LuH_Food a)
	{
		if(number<a.getNumber())
			return -1;
		else if(number>a.getNumber())
			return 1;
		else
			return 0;
	}
	
	// a method to compare Food by its calcories
	public int compareToCal(YuanC_LuH_Food a)
	{
		if(calories<a.getCalories())
			return -1;
		else if(calories>a.getCalories())
			return 1;
		else
			return 0;
	}

	// a method to compare Food by its price 
	public int compareToPri(YuanC_LuH_Food a)
	{
		if(price<a.getPrice())
			return -1;
		else if(price>a.getPrice())
			return 1;
		else
			return 0;
	}
	
	//compareTo method
    public int compareTo(YuanC_LuH_Food a)
    {
    	if(number==a.getNumber())
    	{
    		if(dishName.compareTo(a.getDishName())==0)
    		 {if(price==a.getPrice())
    			 return 0;
    		 else if(price>a.getPrice())
    			 return 1;
    		 else 
    			 return -1;
    			
    		}else if(dishName.compareTo(a.getDishName())>0)
    			return 1;
    		else
    			return -1;
    		
    	}else if(number<a.getNumber())
    		return -1;
    	else 
    		return 1;
    	
    }
    //check if can become combo
    public boolean canBecombo(){
    	return price <5;
    }

}