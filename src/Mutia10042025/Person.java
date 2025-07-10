/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mutia10042025;

/**
 *
 * @author user
 */
public class Person {
    protected String  name;  	
    protected String address; 
    
	public Person(){ 
            System.out.println("Inside Person:Constructor"); 
            name = "";  	 	
            address = ""; 	 	 
	} 	
        
 	public Person( String name, String address ){  	 	
            this.name = name; 
            this.address = address;  	 
	}
        
	public String getName(){ 
            return name;
	} 
 
 	public String getAddress(){  	 	
            return address;  
	} 
 
 	public void setName( String name ){  	 	
            this.name = name;  
	} 
 
	public void setAddress( String add ){ 
            this.address = add; 	 
	} 

}
