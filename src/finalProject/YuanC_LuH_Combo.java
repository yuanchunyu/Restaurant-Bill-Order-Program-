/**
 * Yuan Chunyu Lu Hanqiao
 * CS 201 final project
 * 12/2/2014
 * Combo class
 */


package finalProject;

import java.text.DecimalFormat;

public class YuanC_LuH_Combo {
	
	private YuanC_LuH_Drink yuanC_LuH_Drink;  //represent drink in combo
	private YuanC_LuH_Food yuanC_LuH_Food;   //represent food in combo
	private YuanC_LuH_Sides side;    //represent sides in combo

	//default constructor
	public YuanC_LuH_Combo() {
		// TODO Auto-generated constructor stub
		yuanC_LuH_Drink = new YuanC_LuH_Drink();
		yuanC_LuH_Food = new YuanC_LuH_Food();
		side = new YuanC_LuH_Sides();
	}
	
	//non-default constructor
	public YuanC_LuH_Combo(YuanC_LuH_Drink dri,YuanC_LuH_Food foo,YuanC_LuH_Sides sid){
		yuanC_LuH_Drink = dri;
		yuanC_LuH_Food = foo;
		side = sid;
	}
	
	//mutator
	public YuanC_LuH_Drink getDrink(){
		return yuanC_LuH_Drink;
	}
	
	//asseccor
	public YuanC_LuH_Sides getSides(){
		return side;
	}
	
	//mutator
	public YuanC_LuH_Food getFood(){
		return yuanC_LuH_Food;
	}
	
	//asseccor
	public void setDrink(YuanC_LuH_Drink dri){
		yuanC_LuH_Drink = dri;
	}
	
	//asseccor
	public void setSides(YuanC_LuH_Sides sid){
		side = sid;
	}
	
	//asseccor
	public void setFood(YuanC_LuH_Food foo){
		yuanC_LuH_Food = foo;
	}
	
	//tostring 
	public String toString(){
		return "\nCombo :"+"\n\tNumber "+yuanC_LuH_Food.getNumber()+" Sandwiches "+yuanC_LuH_Food.getDishName()+
				"\n\tNumber "+side.getNumber()+" Sides "+side.getDishName()+
				"\n\tNumber "+yuanC_LuH_Drink.getNumber()+" Drink "+yuanC_LuH_Drink.getDishName()+
				"\n\tPrice "+calPrice()+"$";
				
	}
	
	//print method
	public void print()
	{
		
		System.out.print("\nCombo :"+"\n\tNumber "+yuanC_LuH_Food.getNumber()+" Sandwiches "+yuanC_LuH_Food.getDishName());
		System.out.print("\n\tNumber "+side.getNumber()+" Sides "+side.getDishName());
		System.out.print("\n\tNumber "+yuanC_LuH_Drink.getNumber()+" Drink "+yuanC_LuH_Drink.getDishName());
		System.out.println("\n\tPrice "+calPrice()+"$");
	}
	
	//equals method
	public boolean equals(Object a){
		if(a instanceof YuanC_LuH_Combo)
			return false;
		else {
			YuanC_LuH_Combo b = ((YuanC_LuH_Combo)a);
			return
					yuanC_LuH_Drink.equals(b.getDrink())&&
					side.equals(getSides())&&
					yuanC_LuH_Food.equals(b.getFood());
		}
	}
	

	// calculate the price of the combo
	public String calPrice(){
		DecimalFormat df1 = new DecimalFormat("##.##");
		double temp=0.7*(yuanC_LuH_Food.getPrice()+side.getPrice()+yuanC_LuH_Drink.getPrice());
		return df1.format(temp);
	}
	

}