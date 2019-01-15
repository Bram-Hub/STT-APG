/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author salamb
 */
//keep track of node values
public class Boolean {
 //by default all chars are false
    char val;
   Boolean(){val='n';} 
char get(){
    return String.valueOf(val).toUpperCase().charAt(0);
//return val;
}
boolean hasVal(){
    if(val!='n'){return true;}
    else{return false;}

}
boolean getBool(){
    if(val=='t')
    {return true;}
    else{return false;}

}
void setValue(boolean b){
if(b){val='t';}else{val='f';}

}
        
}
