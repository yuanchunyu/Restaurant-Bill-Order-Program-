/**
 * Yuan Chunyu Lu Hanqiao
 * CS 201 final project
 * 12/2/2014
 * ObjectArray class
 */

package finalProject;

public class YuanC_LuH_ObjectArray {
	//instance variables
	private Object[] array;    
	private int index;
	private final int MAX_SIZE = 200;
	private int pointer;
	
	//default constructor
	public YuanC_LuH_ObjectArray() {
		// TODO Auto-generated constructor stub
		array = new Object[MAX_SIZE];
		index = 0;
		pointer = 0;
	}
	// non-default constructor
	public YuanC_LuH_ObjectArray(int size){
		array = new Object[size];
		index = 0;
		pointer = 0;
	}
	
	public YuanC_LuH_ObjectArray(Object[] anArr, int newIndex){
		array = anArr;
		index = newIndex;
		pointer = 0;
		
	}
	//array accessor
	public Object[] getObjectArray(){
		Object[] arr2 = new Object[index];
		for(int i =0;i<arr2.length;i++)
			arr2[i] = array[i];
		return arr2;
	}
	
	//array mutator
	public void setObjectArray(Object[] aObjArr){
		Object[] arr2 = new Object[aObjArr.length];
		for(int i =0;i<arr2.length;i++)
			arr2[i] = aObjArr[i];
		array = arr2;
		moreCapacity();
	}
	//index accessor
	public int getIndex(){
		return index;
	}
	//index mutator
	public void setIndex(int anIndex){
		index = anIndex;
	}
	// get element method
	public Object getObject(int pos){
		return array[pos];
	}
	//get length method
	public int getLength(){
		return array.length;
	}
	// get pointer method
	public int getPointer(){
		return pointer;
	}
	//toString Method
	public String toString(){
		if(index>0){
		String result = "";
		for(int i =0; i<index;i++)
			result += array[i].toString()+"\n\n";
		return result;
		}else
			return "No Order!";
	}
	//equals Method
	public boolean equals(YuanC_LuH_ObjectArray anArr){
		boolean flag1 = false;
		boolean flag2 = false;
		if(index == anArr.getIndex() && 
				array.length == anArr.getObjectArray().length){
			flag1 = true;
			for(int i =0;i<index;i++){
				if(array[i].equals(anArr.getObject(i)))
					flag2 = true;
			}		
		}
		return flag1 && flag2;	
	}
	
	// add method
	public void add(Object obj){
		array[index] = obj;
		index++;
	}
	//delete method
	public void delete(int pos){
		for(int i =pos;i<index;i++)
			array[i] = array[i+1];
		array[index - 1] = null;
		index--;
	}
	//insert method
	public void insert(int pos, Object anObj){
		for(int i = index -1;i>=pos;i--)
			array[i+1] = array[i];
		array[pos] = anObj;
		index++;
	}
	//search for the index of an Object
	public int isThere(Object anObj){
		int num = 0;
		boolean flag = false;
		for(int i =0;i<index;i++){
			if(array[i].equals(anObj)){
				num = i;
				flag = true;
			}
		}
		if(flag)
			return num;
		else
			return -1;
	}
	
	//delete a object
	public void delete(Object obj){
		for(int i =0;i<index;i++)
			if(((Object)array[i]).equals(obj))
				delete(i);
	}
	
	//check if array is full
	public boolean isFull(){
		return index == array.length;
	}
	//check if array is empty
	public boolean isEmpty(){
		return index == 0;
	}
	//clear all data
	public void clear(){
		for(int i =0;i<index;i++)
			array[i] =null;
		index = 0;
	}
	//remove excess allocated memory
	public void trim(){
		Object[] temp = new Object[index];
		for(int i =0;i<index;i++)
			temp[i] = array[i];
		array = temp;
	}
	//allocates more memory
	public void moreCapacity( ){
		Object[] temp = new Object[(int) (20 * index)];
		for(int i =0;i<index;i++)
			temp[i] = array[i];
		array = temp;
	}
	//Newly added method
	//reset method
	public void reset(){
		pointer = 0;
	}
	//hasNext method
	public boolean hasnext(){
		return pointer<index;
	}
	//getNext method
	public Object getNext(){
		Object result = array[pointer];
		pointer++;
		return result;
	}
	
	

}