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

public class Checkout 
{
    
    private ArrayList<DessertItem> itemList; //Declare reference 
    
    
    /// <summary>
    /// Creates a Checkout instance with an empty list of DessertItem
    /// <summary>
    public Checkout()
    {
        itemList = new ArrayList<DessertItem>(); //Create the array list
    }
    
    
    /// <summary>
    /// Clears the Checkout to begin checking out a new set of items.
    /// <summary>
    public void clear()
    {
        itemList = new ArrayList<DessertItem>();
    }
    
    
    /// <summary>
    /// Adds a DessertItem to end of the list itemList
    /// <summary>
    /// <param name="d">The DessertItem to add to the list</param>
    public void enterItem(DessertItem d)
    {
        itemList.add(d);
    }
    
    /// <summary>
    /// Method to get the number of items from our current list.
    /// </summary>
    /// <returns> The number of the items in the list </returns>
    public int numberOfItems()
    {
        return itemList.size();
    }
    
    
    /// <summary>
    /// Returns total cost of items in cents
    /// <summary>
    /// <returns> Total cost of items in cents (without tax) </returns>
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
    
    
    /// <summary>
    /// Returns the total tax on items in itemList in cents
    /// <summary>
    /// <returns> The total tax on items in cents </returns>
    public int totalTax()
    {
        double tTax = Math.round((totalCost() * DessertShoppe.TAX_RATE)/100);
        return (int)tTax;
    }
    
    /// <summary>
    /// Creates an amount of space to assure receipt formatting
    /// <summary>
    /// <param name="c">The count of spaces to make</param>
    /// <returns>
    public String makeSpace(int c)
    {
        String s="";
        for (int i=0; i<c; i++)
            s+=" ";
        
        return s;
    }
    
    /// <summary>
    /// Returns a String representing a receipt for the current list of items in the itemList
    /// <summary>
    /// <returns> a String representing a receipt </returns>
    public String toString()
    {
        String receipt = DessertShoppe.STORE_NAME+"\n--------------------\n";       //Print the store name/heading
        
        for (int i=0; i<itemList.size();i++)
        {
            
            DessertItem des = itemList.get(i);      //Get the object from the list
            
            String name = itemList.get(i).getName();        //Get the name of the item from the list.
            
            if (name.length() > DessertShoppe.MAX_ITEM_NAME_SIZE)
                name = name.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE);      //If the name is longer than the max size, parse it to max size
            
            int space = DessertShoppe.MAX_ITEM_NAME_SIZE - name.length();       //Get the white space available from max size to add in later
            
            
            String cost = DessertShoppe.cents2dollarsAndCents(des.getCost());       //Get the cost and convert it to a formatted string.
            
            if (cost.length() > DessertShoppe.COST_WIDTH)       //If the cost is longer than the max size
                    cost = cost.substring(0,DessertShoppe.COST_WIDTH);      //Parse it to max size
            
            if (des instanceof Cookie)      //If the dessert item is a cookie
            {
                Cookie coo = (Cookie) des;      //We can safely cast it to a cookie
                receipt += coo.getNumber()+" @ "+coo.getPricePerDozen()+" /dz\n";       //Then print the number and the price per dozen above the cost
            }
            
            if (des instanceof Sundae)      //If the dessert item is a sundae
            {
                Sundae sun = (Sundae) des;      //Can safely cast to a sundae
                cost = DessertShoppe.cents2dollarsAndCents((sun.getCost()+sun.getToppingCost()));       //Change cost string to add the topping cost
                
                if (cost.length() > DessertShoppe.COST_WIDTH)       //If the cost is larger than the cost width
                    cost = cost.substring(0,DessertShoppe.COST_WIDTH);      //Parse it to max size
                
                receipt += sun.getToppingName()+" Sundae with\n";       //Print the sundae topping name
                receipt += name+makeSpace(space)+"  "+cost+"\n";        //Print the name of the ice cream, with the remaining space and cost
            }
            else
            {
                receipt += name+makeSpace(space)+"  "+cost+"\n";        //Print the name of the dessert item with the remaining space and cost
            }
            
        }
        
        String tax = DessertShoppe.cents2dollarsAndCents(totalTax());       //Not sure if you wanted us to use the cost width here but I did anyways :)
        if (tax.length() > DessertShoppe.COST_WIDTH)
            tax = tax.substring(0,DessertShoppe.COST_WIDTH);
        
        String total = DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax());        //Not sure if you wanted us to use the cost width here but I did anyways :)
        if (total.length() > DessertShoppe.COST_WIDTH)
            total = total.substring(0,DessertShoppe.COST_WIDTH);
        
        receipt += "\nTax                         "+tax;        //print total tax
        receipt += "\nTotal Cost                "+total;        //print total cost
        
        return receipt;         //return the full receipt
    }
     
}
