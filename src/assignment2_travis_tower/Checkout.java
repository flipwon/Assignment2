/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_travis_tower;

/**
 *
 * @author flipp
 */
import java.util.ArrayList;

public class Checkout {
    
    
    ////////
    private ArrayList<DessertItem> itemList;
    
    
    ////////
    public Checkout(){
       
        itemList = new ArrayList<DessertItem>();
    }
    
    
    ////////
    public void clear()
    {
        itemList = new ArrayList<DessertItem>();
    }
    
    
    /////////
    public void enterItem(DessertItem d)
    {
        itemList.add(d);
    }
    
    
    /////////
    public int numberOfItems()
    {
        return itemList.size();
    }
    
    
    //////
    public int totalCost()
    {
        int myCost = 0;
        
        for (int i=0; i<itemList.size();i++)           
        {
            DessertItem des = itemList.get(i);
            
            if (des instanceof Sundae)
            {
                Sundae sun = (Sundae) des;
                myCost += sun.getToppingCost();
            }
            
            myCost += itemList.get(i).getCost();
        }
            
        return myCost;
 
    }
    
    
    //////
    public int totalTax()
    {
        double tTax = Math.round((totalCost() * DessertShoppe.TAX_RATE)/100);
        return (int)tTax;
    }
    
    //////
    public String makeSpace(int c)
    {
        String s="";
        for (int i=0; i<c; i++)
            s+=" ";
        
        return s;
    }
    
    ////////
    public String toString()
    {
        String receipt = DessertShoppe.STORE_NAME+"\n--------------------\n";
        
        for (int i=0; i<itemList.size();i++)
        {
            
            DessertItem des = itemList.get(i);
            
            String name = itemList.get(i).getName();
            
            if (name.length() > DessertShoppe.MAX_ITEM_NAME_SIZE)
                name = name.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE); //If the name is longer than the max size, parse it to max size
            
            int space = DessertShoppe.MAX_ITEM_NAME_SIZE - name.length(); //Get the white space available from max size to add in later
            
            
            String cost = DessertShoppe.cents2dollarsAndCents(des.getCost()); //Get the cost and convert it to a formatted string.
            
            if (cost.length() > DessertShoppe.COST_WIDTH) 
                    cost = cost.substring(0,DessertShoppe.COST_WIDTH);
            
            if (des instanceof Cookie) //If the dessert item is a cookie
            {
                Cookie coo = (Cookie) des; //Can safely cast to a cookie
                receipt += coo.getNumber()+" @ "+coo.getPricePerDozen()+" /dz\n"; //we print the number and the price per dozen above the cost
            }
            
            if (des instanceof Sundae) //If the dessert item is a sundae
            {
                Sundae sun = (Sundae) des; //Can safely cast to a sundae
                cost = DessertShoppe.cents2dollarsAndCents((sun.getCost()+sun.getToppingCost())); //Change cost string to add the topping cost
                
                if (cost.length() > DessertShoppe.COST_WIDTH) 
                    cost = cost.substring(0,DessertShoppe.COST_WIDTH);
                
                receipt += sun.getToppingName()+" Sundae with\n";
                receipt += name+makeSpace(space)+"  "+cost+"\n";
            }
            else
            {
                receipt += name+makeSpace(space)+"  "+cost+"\n";
            }
            
        }
        
        String tax = DessertShoppe.cents2dollarsAndCents(totalTax()); //Not sure if you wanted us to use the cost width here but I did anyways :)
        if (tax.length() > DessertShoppe.COST_WIDTH)
            tax = tax.substring(0,DessertShoppe.COST_WIDTH);
        
        String total = DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax()); //Not sure if you wanted us to use the cost width here but I did anyways :)
        if (total.length() > DessertShoppe.COST_WIDTH)
            total = total.substring(0,DessertShoppe.COST_WIDTH);
        
        receipt += "\nTax                         "+tax;
        receipt += "\nTotal Cost                "+total;
        
        return receipt;
    }
    

    
}
