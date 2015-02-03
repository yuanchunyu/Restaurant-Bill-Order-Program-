/**
 * Yuan Chunyu Lu Hanqiao
 * CS 201 final project
 * 12/2/2014
 * Drink  class
 */



package finalProject;

public class YuanC_LuH_Drink extends YuanC_LuH_Sides {

      private int volume;   //represents drink volume

      //default constructor
	public YuanC_LuH_Drink() {
		super();
		volume=0;
	}

	//non-default constructor
	public YuanC_LuH_Drink(int number1, String dishName1, String category1,double calories1, String maker1,int volume1, double price1) {
		super(number1, dishName1, category1, calories1, maker1, price1);
		volume=volume1;
	}

	//mutator
	public int getVolume() {
		return volume;
	}

	//accessor
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	//toString method
   public String toString()
   {
	   return super.toString()+"\nvolume: "+volume+"ml";
   }
   
   //specifie method to demonstrate the polymorphism
   public void showInfomation()
   {
	   System.out.println("\nDrink"+"\n\tnumber: "+ super.getNumber() +"\n\tdishName: " + super.getDishName() + "\n\tmaker: "+super.getMaker()+"\n\tvolume: "+volume+"ml"+"\n\tprice : " + super.getPrice()+"$");
   }

   //equals method
   public boolean equals(Object a) {
	if(a instanceof YuanC_LuH_Food)
	{
	if(super.equals((YuanC_LuH_Food)a)&&
			this.getMaker().equals(((YuanC_LuH_Sides) a).getMaker())&&
			volume==((YuanC_LuH_Drink) a).getVolume())
	  return true;
	else 
	  return false;
	}else
	  return false;
}
 //check if can become combo
   public boolean canBecombo(){
   	return super.getPrice() <2;
   }

}
