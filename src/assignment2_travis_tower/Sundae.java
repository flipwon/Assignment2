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
public class Sundae extends IceCream {
    
    private String toppingName;
    private int toppingCost;
    
    public Sundae(String n, int c, String tn, int tc){
        super(n,c);
        toppingName = tn;
        toppingCost = tc;
    }
    
    public String getToppingName()
    {
        return toppingName;
    }
    
    public int getToppingCost()
    {
        return toppingCost;
    }
}
