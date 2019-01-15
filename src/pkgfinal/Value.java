/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author salamb
 */
//node inheritied by Literal and Operators nodes
 
public  class Value {
    Value parent;
  char op;
     int pos;
     int check;
Boolean value;
Boolean assum;
int arg;
void setAssumValue(boolean b){assum.setValue(b);}
boolean hasAssumVal(){return assum.hasVal();}
boolean getAssumBool(){return assum.getBool();}
void setValue(boolean b){value.setValue(b);}
boolean hasVal(){return value.hasVal();}
boolean getBool(){return value.getBool();}
//char getValue(){return value.get();};
char getChar(){return op;};
int getPosition(){return pos;};
public String toString(){return Character.toString(op);}
  public boolean isOperator(){return false;}
    Value(char c,int i){
    op=c;
    pos=i;
    parent=null;
    check=0;
    value=new Boolean();
    assum=new Boolean();
     arg=-1;
    }
    
}
