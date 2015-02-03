/**
 * Yuan Chunyu Lu Hanqiao
 * CS 201 final project
 * 12/2/2014
 * Menu class 
 * The user can browse the Food list, sort the list and order food in the option of 
 * Menu List , and the user is able to add, delete meal and get the meals 
 * information in the option of Order cart. then after user agree with the order, the 
 * user will get a output txt file which has the information about the order. . User can 
 * order a combo which has food, sides and drink and the price has a discount in 
 * the option of Combo. User can search one food by its Food¡¯s number and Food¡¯s 
 * name.
 */


package finalProject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
public class YuanC_LuH_Menu {
	
	
	private Scanner sca1;               //use to scan the text document
	private YuanC_LuH_ObjectArray arr;      //use to store the data form the text document
	private YuanC_LuH_ObjectArray answer;  //use to store the order data
	private YuanC_LuH_ObjectArray answerCombo;   //use to store data for the combo choose
	private Scanner sca =new Scanner(System.in);  //use this Scanner in the methods to avoid creating Scanner
	
	//default constructor
	public YuanC_LuH_Menu()
	{
		sca1=new Scanner(System.in);
		arr=new YuanC_LuH_ObjectArray();
		answer=new YuanC_LuH_ObjectArray();
		answerCombo=new YuanC_LuH_ObjectArray();
	}
    
	//non-default constructor
	public YuanC_LuH_Menu(Scanner fileName,YuanC_LuH_ObjectArray arr1,YuanC_LuH_ObjectArray answer1,YuanC_LuH_ObjectArray answerCombo1)   //nondefault constructor
	{
		sca1=fileName;
		arr=arr1;
		answer=answer1;
		answerCombo=answerCombo1;
	}

	//mutator
	public Scanner getSca() {
		return sca1;
	}

	//accessor
	public void setSca(Scanner sca) {
		this.sca1 = sca;
	}
	
	//mutator
	public YuanC_LuH_ObjectArray getArray()
	{
		return arr;
	}
	
	//mutator
	public YuanC_LuH_ObjectArray getArray1()
	{
		return answer;
	}
	
	//mutator
	public YuanC_LuH_ObjectArray getArray2()
	{
		return answerCombo;
	}
	
	//accessor to read the text document read the text and store the data 
	public  void setArray() throws IOException{         //get the file
		YuanC_LuH_ObjectArray aArray=new YuanC_LuH_ObjectArray(); //creat a new ObjectArray to store data
		try{
			FileReader file = new FileReader("YuanC_LuH_newFood.txt");
			sca1 = new Scanner(file);
		}catch(FileNotFoundException fnfe){
			System.err.println("Cannot find the input file.");
			fnfe.getStackTrace();
            sca1.close();
			System.exit(0);
		}
		
		String [] tokens;   //use to store data
		String line = "";    //use to read data
		
		
		while(sca1.hasNext()) {        
			line = sca1.nextLine();
			tokens = line.split(",");
			if(tokens.length<6)                       //check if it is food
			{int number=Integer.parseInt(tokens[0]);
			String dishName = tokens[1];
			String category = tokens[2];
			double calories = Double.parseDouble(tokens[3]);
			double price = Double.parseDouble(tokens[4]);
			
			
			YuanC_LuH_Food yuanC_LuH_Food = new YuanC_LuH_Food(number,dishName,category, calories,price);
			
			
			aArray.add(yuanC_LuH_Food);         //add the food to aArray
			}else if(tokens.length==6)
			{
				int number=Integer.parseInt(tokens[0]);   //check if it is side
				String dishName = tokens[1];
				String category = tokens[2];
				double calories = Double.parseDouble(tokens[3]);
				String maker = tokens[4];
				double price = Double.parseDouble(tokens[5]);
				
				YuanC_LuH_Sides side = new YuanC_LuH_Sides(number,dishName,category,calories,maker,price);			
				aArray.add(side);                 //add the side to aArray
			}else
			{
				int number=Integer.parseInt(tokens[0]);
				String dishName = tokens[1];
				String category = tokens[2];
				double calories = Double.parseDouble(tokens[3]);
				String maker = tokens[4];
				int volume=Integer.parseInt(tokens[5]);
				double price = Double.parseDouble(tokens[6]);
				YuanC_LuH_Drink yuanC_LuH_Drink=new YuanC_LuH_Drink(number,dishName,category,calories,maker,volume,price);
				aArray.add(yuanC_LuH_Drink);      //add the drink to aArray
			}
		}
		
	
		arr= aArray;  //make objectArray arr equals the the new Objectaray
	}
	
	//sort the meal by its meal number, this method to be use to operate the the SortByNumber option in the MenuList option in the Menu
	public void sortByNum(){
		Object[] a = arr.getObjectArray();      //creat a object[] to get the arr
		for(int i=0;i<a.length-1;i++){
			int min=i;                       //represent the minimum number
			for(int j=i+1;j<a.length;j++)
			{
				if(((YuanC_LuH_Food)a[min]).compareToNum(((YuanC_LuH_Food)a[j]))>0)   //use compareToNum method in the food to compare the meal number
					min=j;
			}
           if(min!=i)
           {
        	   Object b;
        	   b=a[min];
        	   a[min]=a[i];
        	   a[i]=b;
           }
		}
		arr.clear();   //original arr data is clear
		for(int i=0;i<a.length;i++)
		{
			arr.add(a[i]);
		}
	}
	
	//sort the meal by its meal Calories, this method to be use to operate the the SortByCalories option in the MenuList option in the Menu
	public void sortByCalories(){
		Object[] a = arr.getObjectArray();   //creat a object[] to get the arr
		for(int i=0;i<a.length-1;i++){
			int min=i;        //represent the minimum number
			for(int j=i+1;j<a.length;j++)
			{
				if(((YuanC_LuH_Food)a[min]).compareToCal(((YuanC_LuH_Food)a[j]))>0)   //use compareToCal method in the food to compare the meal calories
					min=j;
			}
           if(min!=i)
           {
        	   Object b;
        	   b=a[min];
        	   a[min]=a[i];
        	   a[i]=b;
           }
		}
		arr.clear();
		for(int i=0;i<a.length;i++)
		{
			arr.add(a[i]);
		}
	}

	//sort the meal by its meal Price, the method is used to operate the sortByPrice option in the MenuList option in the Menu
	public void sortByPrice(){
		Object[] a = arr.getObjectArray();  //creat a object[] to get the arr
		for(int i=0;i<a.length-1;i++){
			int min=i;     //represent the minimum number
			for(int j=i+1;j<a.length;j++)
			{
				if(((YuanC_LuH_Food)a[min]).compareToPri(((YuanC_LuH_Food)a[j]))>0) //use compareToPri method in the food to compare the meal price
					min=j;
			}
           if(min!=i)
           {
        	   Object b;
        	   b=a[min];
        	   a[min]=a[i];
        	   a[i]=b;
           }
		}
		arr.clear();
		for(int i=0;i<a.length;i++)
		{
			arr.add(a[i]);
		}
		}
	
	/**
	 * Menu List option in the Menu  
	 */
	public void menuList()
	{
		boolean check=true;  //use to check the loop. when user order meal, loop ends 
		
		
		do{
		System.out.println();
		System.out.println(" #########MenuList#########");
		System.out.println();
		System.out.println(" Sort meal list to order what you like!");
		System.out.println();
		System.out.println("       1. Sort by Number          ");
		System.out.println("       2. Sort by Calories          ");
		System.out.println("       3. Sort by Price          ");
		System.out.println("       4. Exit to Menu          ");
		
		System.out.println();
		System.out.println("  Please choose one option :");  //prompt user to choose the option  
		
		String in=sca.nextLine(); // store what user enters
		
		
		if(in.length()==1&&Character.isDigit(in.charAt(0)))  //check what the user enters
		{
		int num1=Integer.parseInt(in);     //make the string become int
		if(num1>0&&num1<5)
		{
			switch(num1)
			{
			case 1: sortByNum();   //call sortByNum method
			        System.out.println(arr.toString()+"\n");  //output the data
			        boolean check1=true;
			        System.out.println("Do you want to order meal? 1.Yes  2.No");
			        System.out.println("Please enter your answer's number :");     //prompt the user to order the meal
			    
			      do{
			    	  
			         String in2=sca.nextLine();  // store what user enters
			        
			        if(in2.length()==1&&Character.isDigit(in2.charAt(0)))  //check what the user enters
			        {
			        	int num2=Integer.parseInt(in2);
			        	if(num2>0&&num2<3)
			        	{
			        		switch(num2)
			        		{
			        		case 1:
			        			
			        			orderMeal();    //call the orderMeal method to order the meal
			        			System.out.println("\nOrder again? 1.Yes  2.No");
			        			System.out.println("Please enter your answer's number! ");  //prompt the user to order the meal
			        			break;
			        		default:
			        			 check1=false;
			        		}
			        	}else
			        	{
			        		System.out.println("Your option is wrong! Please enter again! ");   //display the err
			        	}
			        }else
			        {
			        	System.out.println("Your option is wrong! Please enter again! ");
			        }
			     
			      }while(check1);
			   
			        break;
			case 2: sortByCalories();      //call sortByNum method
			        System.out.println(arr.toString()+"\n");   //display the data
			        boolean check2=true;   // store what user enters
			        System.out.println("Do you want to order meal? 1.Yes  2.No");
			        System.out.println("Please enter your answer's number :");    //prompt the user to choose the option
			      
			      do{
			    	  
			      
			         String in2=sca.nextLine();  // store what user enters
			       
			        if(in2.length()==1&&Character.isDigit(in2.charAt(0)))       //check what the user enters
			        {
			        	int num2=Integer.parseInt(in2);
			        	if(num2>0&&num2<3)
			        	{
			        		switch(num2)
			        		{
			        		case 1:
			        			
			        			orderMeal();   //call the orderMeal method to order the meal
			        			System.out.println("\nOrder again? 1.Yes  2.No");
			        			System.out.println("Please enter your answer's number :");
			        			break;
			        		default:
			        			 check2=false;
			        			 
			        		}
			        	}else
			        	{
			        		System.out.println("Your option is wrong! Please enter again! ");   //display the err
			        	}
			        }else
			        {
			        	System.out.println("Your option is wrong! Please enter again! ");
			        }
			        
			      }while(check2);
			      
	                break;
			case 3: sortByPrice();        //call the sortByPrice method
			        System.out.println(arr.toString()+"\n");
			        boolean check3=true;       //use to loop
			        System.out.println("Do you want to order meal? 1.Yes  2.No");   //prompt the user to choose the option
			        System.out.println("Please enter your answer's number :");
			       
			      do{
			        
			         String in2=sca.nextLine();  // store what user enters
			        
			        if(in2.length()==1&&Character.isDigit(in2.charAt(0)))  //check what the user enters
			        {
			        	int num2=Integer.parseInt(in2);  //make string become int
			        	if(num2>0&&num2<3)
			        	{
			        		switch(num2)
			        		{
			        		case 1:
			        			
			        			orderMeal();  //call order method
			        			System.out.println("\nOrder again? 1.Yes  2.No");     //prompt the user to choose the option
			        			System.out.println("Please enter your answer's number :");
			        			break;
			        		default:
			        			 check3=false;
			        		}
			        	}else
			        	{
			        		System.out.println("Your option is wrong! Please enter again! ");
			        	}
			        }else
			        {
			        	System.out.println("Your option is wrong! Please enter again! ");
			        }
			        
			      }while(check3);
			      
	                break;
			default: 
				    check=false;
				   
			}
			
		}else 
		{
			System.out.println("Your option is wrong! Please enter again! ");
		}
		}else
			System.out.println("Your option is wrong! Please enter again! ");
		}while(check);
	
	}
	
	
	//order meal method to add the meal to the answer objectarray
	public void orderMeal()
	{
		
		System.out.println();
		System.out.println("Please enter the meal number:");  //prompt the user to enter the meal number
		boolean checkAns=true;  //user to loop 
		do{
		
		String order=sca.nextLine();   //store what the user enters
		
		if(order.length()==3)
		{
		 int count=0;     //use to help to check number user entered
			for(int i=0;i<3;i++)
			{
				if(Character.isDigit(order.charAt(i)))    //check what the user enters
				{
					count++;
				}
			}
			if(count==3)
			{
				int a=Integer.valueOf(order);
				if((a>99&&a<116)||(a>199&&a<204)||(a>299&&a<304)||(a>399&&a<=405)||(a>499&&a<508))
				{
					int pos=0;
					for(int i=0;i<arr.getIndex();i++)          //search the meal by its number 
					{
						if(((YuanC_LuH_Food)arr.getObject(i)).getNumber()==a)
						{
							pos=i;
						}
					}
					answer.add(arr.getObject(pos));
					System.out.println();
					System.out.println("Order has been added your Order Cart Successfully!");
					checkAns=false;
					
				}else
				{
					System.out.println("Your order is wrong! Please enter again! ");
				}
			}else
			{
				System.out.println("Your order is wrong! Please enter again! ");
			}
		}else
		{
			System.out.println("Your order is wrong! Please enter again! ");
		}
		}while(checkAns);

	}
	
	
	//order Sandwiches in the combo
	public void orderSan(Object[] ar)
	{ boolean checkans=true;  //use to loop
	
	 do{
		System.out.println();
		
		System.out.println();
		System.out.println("Please enter the Food's number firstly:");
		String order=sca.nextLine();  //use to store what the user enters
		
		if(order.length()==3)                            //check what the user enters
		{
		 int count=0;   //use to check 
			for(int i=0;i<3;i++)
			{
				if(Character.isDigit(order.charAt(i)))
				{
					count++;
				}
			}
			if(count==3)
			{
				int a=Integer.valueOf(order);
				if(a>=100&&a<400)
				{
					int pos=-1;
					for(int i=0;i<answerCombo.getIndex();i++)
					{
						if(((YuanC_LuH_Food)answerCombo.getObject(i)).getNumber()==a)
						{
							pos=i;
						}
					}
					
					if(pos!=-1)
					{
					System.out.println();
					ar[1]=answerCombo.getObject(pos);
					System.out.println("You have choosen a food Successfully!");
					checkans=false;
					}else
					{
						System.out.println("Wrong! Please enter again!");
					}
					
				}else
				{
					System.out.println("Your order is wrong! Please enter again! ");
				}
			}else
			{
				System.out.println("Your order is wrong! Please enter again! ");
			}
		}else
		{
			System.out.println("Your order is wrong! Please enter again! ");
		}
	 }while(checkans);
	
	}

	
	//order side in the combo
	public void orderSid(Object[] ar)
	{ boolean checkans=true;  //use to loop
	
	 do{
		 
		System.out.println();	
		System.out.println();
		System.out.println("Please enter the side's number:");
		String order=sca.nextLine();
		if(order.length()==3)                    //check what the user enter
		{
		 int count=0;              //use to check the digital
			for(int i=0;i<3;i++)
			{
				if(Character.isDigit(order.charAt(i)))
				{
					count++;
				}
			}
			if(count==3)
			{
				int a=Integer.valueOf(order);
				if(a>=400&&a<499)    //check what the user enter
				{
					int pos=-1;       //use to get the target 
					for(int i=0;i<answerCombo.getIndex();i++)
					{
						if(((YuanC_LuH_Food)answerCombo.getObject(i)).getNumber()==a)
						{
							pos=i;  //get the target 
						}
					}
					if(pos!=-1)
					{
					System.out.println();
					ar[2]=answerCombo.getObject(pos);
					System.out.println("You have choosen a Side Successfully!");
					checkans=false;
					}else
					{
						System.out.println("Wrong! Please enter again!");
					}
					
				}else
				{
					System.out.println("Wrong! Please enter again! ");
				}
			}else
			{
				System.out.println("Your order is wrong! Please enter again! ");
			}
		}else
		{
			System.out.println("Your order is wrong! Please enter again! ");
		}
	 }while(checkans);
	
	}
	
	
	//order the drink in the combo
	public void orderDrink(Object[] ar)
	{ boolean checkans=true;   //use to loop
	
	 do{
		
		System.out.println();                          
	
		
		System.out.println();
		System.out.println("Please enter the drink's number:"); //prompt the user to enter the drink number
		String order=sca.nextLine();  //store what the user enters
		if(order.length()==3)
		{
		 int count=0;            //use to check the digital
			for(int i=0;i<3;i++)
			{
				if(Character.isDigit(order.charAt(i)))
				{
					count++;
				}
			}
			if(count==3)    //check what the user enters
			{
				int a=Integer.valueOf(order);  //make the string become int
				if(a>=500&&a<508)
				{
					int pos=-1;   //use to check target position
					for(int i=0;i<answerCombo.getIndex();i++)
					{
						if(((YuanC_LuH_Food)answerCombo.getObject(i)).getNumber()==a)
						{
							pos=i;    
						}
					}
					
					if(pos!=-1){
					System.out.println();
					ar[0]=answerCombo.getObject(pos);
					System.out.println("You have choosen a Drink Successfully!");
					checkans=false;
					}else
					{
						System.out.println("Wrong! Please enter again!");
					}
					
				}else
				{
					System.out.println("Your order is wrong! Please enter again! ");
				}
			}else
			{
				System.out.println("Your order is wrong! Please enter again! ");
			}
		}else
		{
			System.out.println("Your order is wrong! Please enter again! ");
		}
	 }while(checkans);
	
	}
	
	/**
	 * Order Combo option to the answerCombo objectarray
	 */
	public void orderCombo()
	{
		System.out.println("     ############OrderCombo############ ");  //
		System.out.println();
		System.out.println("On this page, you can order a combo.");
		System.out.println("Combo includes one meal, one sides and one drink.");
		System.out.println("You can choose one meal from specific meal,  ");
		System.out.println("choose one side from specific side and   ");
		System.out.println("choose one drink from specific drink to get a combo.  ");
		System.out.println("The combo's price is much cheaper than order separately");
	    System.out.println();
	    boolean checkans=true;  //use to loop
	    System.out.println("Do you want to order a combo? 1.Yes  2.Exit to Menu");
	
	do{
		
		String ans3=sca.nextLine();	 //store what the user enters
	if(ans3.length()==1&&Character.isDigit(ans3.charAt(0)))   //check what the user enter
	{ int a=Integer.valueOf(ans3);
	if(a>0&&a<3)
	{
		switch(a){
		case 1:			
			Object[] ar=new Object[3]; //use to store food side and drink to combo 

			sortByNum();  //call sortByNum method
			for(int i=0;i<arr.getIndex();i++)
			{
			  if(((YuanC_LuH_Food) arr.getObject(i)).canBecombo())
			   {
			   answerCombo.add(arr.getObject(i));
			   ((YuanC_LuH_Food) arr.getObject(i)).showInfomation();
			   }
			}
					
			orderSan(ar);     //call orderSan method to choose the Food
			orderSid(ar);     //call orderSid method to choose the side
			orderDrink(ar);   //call orderSan method to choose the drink
			YuanC_LuH_Combo yuanC_LuH_Combo=new YuanC_LuH_Combo(((YuanC_LuH_Drink)ar[0]),((YuanC_LuH_Food)ar[1]),((YuanC_LuH_Sides)ar[2]));
			answer.add(yuanC_LuH_Combo);
			System.out.println();
			System.out.println("One combo has been added your Order Cart Successfully!");
			System.out.println();
			System.out.println("Order a combo again? 1.Yes  2.Exit to Menu");
			break;
		
		default:
			
		    checkans=false;
		}
		
		
	}else
	{
		System.out.println("Your option is wrong! Please enter again! ");
	}
		
	}else 
	{
		System.out.println("Your option is wrong! Please enter again! ");
	}
	

	}while(checkans);
	
	}
	
	
	//search name option method to search meal by its name, and the user can ingore the upper and lower letter when they enter something
	public void searchByName(){
		boolean check2=true;   //use to loop
		
		do{
		
		System.out.println("Please enter a full or part of the dish name:");  //prompt what the user enters
		
		String name = sca.nextLine();  //use to store what the user enters
		
		String result ="";           //use to display latter
		for(int i=0;i<arr.getIndex();i++)   //check the name which the user enters 
		{
			if(((YuanC_LuH_Food)arr.getObject(i)).getDishName().toLowerCase().contains(name.toLowerCase()))
				{
				result += ((YuanC_LuH_Food) arr.getObject(i)).toString()+"\n\n";
				}
				
		}
		if(result.equals("")){
			System.out.println();
			System.out.println("No such dish found.");
			System.out.println();
			
		}
		else{
			System.out.println();
			System.out.println("I found following dishes match:");
			System.out.println();
			System.out.println();
			System.out.println(result+"\n");
		}
		System.out.println("1. SearchByName again 2. Exit to Search Menu ");
	
		System.out.println();
		System.out.println("  Please choose one option :");
		
		
		String in=sca.nextLine();   //store what the user enters
		if(in.length()==1&&Character.isDigit(in.charAt(0)))   //check what the user enters
		{
		int num1=Integer.parseInt(in); //make the string become int
		if(num1>0&&num1<3)
		{
			switch(num1)
			{
			case 1:  break;
			        
			       
			default: 
				    check2=false;
				    
			}
			
		}else 
		{
			System.out.println("Your option is wrong! Please enter again! ");
		}
		}else
			System.out.println("Your option is wrong! Please enter again! ");
		}while(check2);
		
	
	}
		
	//search method to search meal by its number
	public void searchByNum(){		
		boolean check1=true;  //use to loop
		do
		{ 
		System.out.println("Please enter a full or part of the dish number:");     //prompt what the user enters
	
		String num = sca.nextLine();  //store what the user enters 
		
		String result ="";        //use to display latter
		arr.reset();    //make the pointer=0
		while(arr.hasnext()){
			YuanC_LuH_Food temp = (YuanC_LuH_Food)arr.getNext();       //check  and search the number
			if(Integer.toString((temp).getNumber()).contains(num))
				result += temp.toString()+"\n\n";
		}
		if(result.equals("")){
			System.out.println("No such dish found.");
			System.out.println();
	
		}
		else{
			System.out.println("I found following dishes match:");
			System.out.println();
			System.out.println(result+"\n");	
			System.out.println();
		}
		System.out.println("1. SearchByNumber again 2. Exit to Search Menu ");
		
		System.out.println();
		System.out.println("  Please choose one option :");	
		String in=sca.nextLine();  //store what the user enters
	
		if(in.length()==1&&Character.isDigit(in.charAt(0)))
		{
		int num1=Integer.parseInt(in);  //make string become int
		if(num1>0&&num1<3)
		{
			switch(num1)
			{
			case 1: 
			        break;
			default: 
				    check1=false;
				    
			}
			
		}else 
		{
			System.out.println("Your option is wrong! Please enter again! ");
		}
		}else
			System.out.println("Your option is wrong! Please enter again! ");
		}while(check1);			
	}
	
	
	/**
	 * Search option in the Menu
	 */
	public void search()
	{  
		
		boolean check1=true;  //use to loop
		do{		
		System.out.println("   #######Search#######");    //prompt the user to enter
		System.out.println();
		System.out.println("     1. Search by Name          ");
		System.out.println("     2. Search by Number          ");
		System.out.println("     3. Exit to Menu          ");		
		System.out.println();
		System.out.println("  Please choose one option :");
		String in1=sca.nextLine();   //store what the user enters
		
		if(in1.length()==1&&Character.isDigit(in1.charAt(0)))
		{
		int num1=Integer.parseInt(in1);  //make the string become int
		if(num1>0&&num1<4)
		{
			switch(num1)
			{
			case 1: 
				    searchByName();   //call searchByName method to operate the searchByName option in the search
			        break;
			case 2: 
				    searchByNum();    //call searchByNum method to operate the searchByNumber option in the search
				    break;
			default: 
				    check1=false;
				    
			}
			
		}else 
		{
			System.out.println("Your option is wrong! Please enter again! \n");
		}
		}else
			System.out.println("Your option is wrong! Please enter again! \n");
		}while(check1);
	
	}

	//Order Cart option in the Menu, User can delete the order or checkout and the bill
 public void orderCart(){
	boolean check=true;//use to loop
	do{
	System.out.println("  #########Order Cart#########"); //prompt the user to enter
	System.out.println();
	if(answer.getIndex()==0){
		System.out.println("No Order");	
		System.out.println();
		check=false;
	
	}else
	{
		
		System.out.println(" You have "+answer.getIndex()+" Order(s). ");
		System.out.println();
		int count=0;   //represent the order number
		double total=0;  //represent the total price
		answer.reset();
		while(answer.hasnext())   //check if the array has elements and display the data
		{
			Object temp=answer.getNext();  //represent the object element in the array
			count++;
			if(temp instanceof YuanC_LuH_Food )
			{
				System.out.print("\nOrder Number "+count);
				((YuanC_LuH_Food) temp).showInfomation();
				total+=((YuanC_LuH_Food) temp).getPrice();
			}
			if(temp instanceof YuanC_LuH_Combo)
			{
				System.out.print("\nOrder Number "+count);
				((YuanC_LuH_Combo) temp).print();
				double temp1=0.0;
				temp1=Double.valueOf(((YuanC_LuH_Combo) temp).calPrice());
				total+=temp1;
			}
		}
		System.out.println("Total fee "+new DecimalFormat("0.00").format(total)+"$");
		System.out.println();
		System.out.println("1. Check out"+" 2. Delete Order(s) "+"3. Exit to Menu");
		System.out.println("Please enter your option:");
		
		String in=sca.nextLine();   //store what the user enters
		if(in.length()==1&&Character.isDigit(in.charAt(0)))
		{
		int num1=Integer.parseInt(in);  //make the string become int
		if(num1>0&&num1<4)
		{
			switch(num1)
			{
			case 1: 
				    checkOut();
				    answer.clear();  //call the clear method in the Objectarray
				    System.out.println("Order Successfully!");
				    check=false;
			        break;
			case 2: 
				    System.out.println();
				    System.out.println("Please enter you order number :");
				   
				    boolean a=true;         //use to loop
				    do{
				    	String b=sca.nextLine();     //store what the user enters
				    	int count1=0;                   // order number
				    	for(int i=0;i<b.length();i++){
				    		if(Character.isDigit(b.charAt(i)))
				    			count1++;		
				    	}
				    	if(count1==b.length())
				    	{
				    		int temp=Integer.valueOf(b);   //make the string become int
				    		if(temp>0&&temp<=answer.getIndex())
				    		{
				    			answer.delete(temp-1);
				    			a=false;
				    		}else
				    		{
				    			System.out.println("Your option is wrong! Please enter again! \n");
				    		}
				    	}else
				    	{
				    		System.out.println("Your option is wrong! Please enter again! \n");
				    	}
						
				    	
				    }while(a);
				    break;
			default: 
				    check=false;
				   
			}
			
		}else 
		{
			System.out.println("Your option is wrong! Please enter again! \n");
		}
		}else
			System.out.println("Your option is wrong! Please enter again! \n");
	}
	}while(check);	
}
   
   //checkout  method to output the bill
  public void checkOut()
  {	
		BufferedWriter outFile = null;  //use to write the data  to a file
		Object temp1;
		String line="";		//use to write the data  to a file
		int count1=0;     //represents the order number
		double total=0.0;
		try {
			 outFile = new BufferedWriter(new FileWriter("CostTotal.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			outFile.write("Your bill:");
			outFile.newLine(); 
			outFile.newLine(); //write a new line character to output file
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		answer.reset();	//Use of List iterator
		while(answer.hasnext()) {
			temp1 = answer.getNext();	//read a line from input file and store it
			if(temp1 instanceof YuanC_LuH_Food)    //check subclass or superclass
		{  
		   count1++;
			YuanC_LuH_Food a=((YuanC_LuH_Food) temp1);			
			line="Order number "+count1+" "+" Meal: Number "+a.getNumber()+" Name "+a.getDishName()+" Price "+a.getPrice()+"$";
			total+=a.getPrice();
			
		}else
		{ 
			count1++;
			YuanC_LuH_Combo a=((YuanC_LuH_Combo) temp1);			
			line="Order number "+count1+" "+a.toString();
			double temp2=0.0;    
			temp2=Double.valueOf(a.calPrice());
			total+=temp2;      
		}
			try {
				outFile.write(line);
				outFile.newLine();			//write a new line character to output file
				outFile.newLine();	
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
		}
		line="Total Cost "+new DecimalFormat("0.00").format(total)+"$";

			
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //get the time
		String TimeString = time.format(new java.util.Date());  //store the time
		try {
			outFile.write(line);
			outFile.newLine();
			outFile.write("Thank you for your shopping!");
            outFile.newLine();
			outFile.write(TimeString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		try {
			outFile.close();              //close
		} catch (IOException e) {
			e.printStackTrace();
		}  	
}
  
  public void showHelp()   //a method to let user know how to order meal
  {
	  System.out.println("   #######Help#######");  
	  System.out.println();   
	  System.out.println(); 
	  System.out.println( "Menu List: ");
	  System.out.println();
	  System.out.println("We will tell you how to order meal.\n "
	  		           + "First, you need to choose the first option Menu List.\n "
	  		           + "Then You will get three Sort options and exit to menu option.\n"
	  		           + "Take an example. Choose First option Sort by Number.\n"
	  		           + "You can get the menu list sorted by meal number. At the end of \n"
	  		           + "this list. We will ask you if order meal. If you enter 1, we will ask\n"
	  		           + "you to enter the meal number. After you enter the correct number,\n"
	  		           + "the meal order will be sent to your order cart. Then we will ask you\n"
	  		           + "if you want to order again. You can contine to order.\n "
	  		           + "If you don't want to do it. You can choose 2 to exit Menu List option.\n"
	  		           + "Sort by calories is show the menu list sorted by calories.\n "
	  		           + "Sort by Price is show the menu list sorted by price. \n"
	  		           + "You can also order meal in these two option."); 
	  System.out.println(); 
	  System.out.println( "Order Combo: ");
	  System.out.println();
	  System.out.println("We will tell you how to order a combo. \n"
	  		           + "First, you choose the second option Order Combo. Then,\n"
	  		           + "we will show you a brief guide. If you want to order combo, \n"
	  		           + "you can start to order the combo. After do that, we will ask you\n"
	  		           + "if you want to contine to order. You can choose 1 to go on. Or\n"
	  		           + "you choose 2 to exit Menu. ");
	  System.out.println(); 
	  System.out.println( "Search Meal: ");
	  System.out.println();
	  System.out.println("We will tell you how to search the meal you like. \n"
		               + "First, you choose the third option Search Meal. Then,\n"
		               + "we will show you two search options and exit to menu option.\n"
		               + "Take an example. Choose First option Search by Name.\n"
		               + "You will be asked to enter a full or part of the dish name.\n"
		               + "After do that, you will get the result. At the end of the list,\n"
		               + "you can choose 1 to contine to search or choose 2 to exit to the search menu.\n"
		               + "Search by Number is let you to search the meal by meal number.\n");
	  System.out.println(); 
	  System.out.println( "Order Cart");
	  System.out.println(); 
	  System.out.println("We will tell you how to get the bill. \n"
              + "First, you choose the forth option Order Cart. Then,\n"
              + "If you don't have any order, we will show no order and exit to Menu.\n"
              + "If you have order, we will show your order.\n"              
              + "Then you can choose 1 to check out. If you want to delete order, \n"
              + "you can choose 2 and enter order number to delete any order.\n"
              + "If you want to contine to order, you can exit to menu and go on ordering meal or combo.\n");
	  
	  System.out.println();
		boolean check1=true;   //use to loop
		do{
			
		System.out.println("  1. Exit to Menu:");
		String in1=sca.nextLine();  //store what the user enters 
		
		if(in1.length()==1&&Character.isDigit(in1.charAt(0)))
		{
		int num1=Integer.parseInt(in1); //make the string become int
		if(num1==1)
		{
		  check1=false;
		}else
		{
			System.out.println("Wrong! Please enter again:");
		}
		}else
		{
			System.out.println("Wrong! Please enter again:");
		}
		}while(check1);	  
  }

   // the program whole menu 
	public void menu()
	{
		boolean check=true; //use to loop
		
		do{
		System.out.println("   #####~~Menu~~#####");   //prompt the user to enter
		System.out.println();
	    System.out.println("Welcome to CS201 Restaurant!"); 
	    System.out.println();
		System.out.println();
		System.out.println("  0. Help: teach you how to order meals      ");
		System.out.println("  1. Meal List          ");
		System.out.println("  2. Order Combo          ");
		System.out.println("  3. Search Meal          ");
		System.out.println("  4. Order Cart          ");
		System.out.println("  5. Exit to Menu         ");
		
		System.out.println();
		System.out.println("  Please choose one option :");
		String in=sca.nextLine();  //store what the user enters
		
		if(in.length()==1&&Character.isDigit(in.charAt(0)))   //check what the user enter
		{
		int num1=Integer.parseInt(in);  //make the string become int
		if(num1>=0&&num1<6)
		{
			switch(num1)
			{
			case 0: showHelp(); //call showHelp method
			        break;
			case 1: 
				    menuList();   //call menuList method to operate the Menu List option 
			        break;
			case 2: 
				    orderCombo();  //call orderCombo method to operate the Order Combo option 
				    break;
			case 3: 
			        search();   //call search method to operate the Search Meal option 
			        break;
			case 4: 
			        orderCart();  //call orderCart method to operate the Order Cart option 
			        break;
			default: 
				    check=false;
				    System.exit(0);;  //exit the program 
			}
			
		}else 
		{
			System.out.println("Your option is wrong! Please enter again! \n");
		}
		}else
			System.out.println("Your option is wrong! Please enter again! \n");
		}while(check);
		sca.close();  //close the Scanner		
	}
}
