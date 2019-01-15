/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author salamb
 */

public abstract class Operator extends Value{
 
Value left=null;
Value right=null;
//Operator(){}
    Operator(char o,int i){
    
        super(o,i);
    
    }
    public boolean isOperator(){return true;}
   
   public boolean  evaluate(){return true;};
 
    
}
