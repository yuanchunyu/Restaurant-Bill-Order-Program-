/**
 * Yuan Chunyu Lu Hanqiao
 * CS 201 final project
 * 12/2/2014
 * Sides class
 */


package finalProject;

public class YuanC_LuH_Sides extends YuanC_LuH_Food {

	private String maker;   //represents sides maker
	
	//default constructor
	public YuanC_LuH_Sides() {
		super();
		maker="";
		
	}
	
	//non-default constructor
	public YuanC_LuH_Sides(int number1, String dishName1, String category1, double calories1,String maker1, double price1) {
		super(number1, dishName1, category1, calories1, price1);
	    maker=maker1;

	}

	//mutator
	public String getMaker() {
		return maker;
	}

    //accessor
	public void setMaker(String maker) {
		this.maker = maker;
	}

	//toString
   public String toString()
   {
	   return super.toString()+"\nmaker: "+maker;
   }
   
   //specifie method to demonstrate the polymorphism
   public void showInfomation()
   {
	   System.out.println("\nSide"+"\n\tnumber: "+ super.getNumber() +"\n\tdishName: " + super.getDishName() + "\n\tmaker: "+maker+"\n\tprice : " + super.getPrice()+"$");
   }
   
   //equals 
   public boolean equals(Object a)
   {
	   if(a instanceof YuanC_LuH_Sides)
	   {if(super.equals((YuanC_LuH_Food)a)&&maker.equals(((YuanC_LuH_Sides) a).getMaker()))
		   return true;
	   else 
		   return false;
	   }else 
		   return false;
	   
	}
   //check if can become combo
   public boolean canBecombo(){
   	return super.getPrice() <4;
   }

}