/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgfinal;
import java.io.*;
import java.util.Vector;
/**
 *
 * @author salamb
 */

public class Input {
    //argument text
  Vector<String> arg=new Vector<String>();
  //each vector value represents a tree first node is root
  Vector<Vector<Value>> totalTree=new Vector<Vector<Value>>();
  //list of all literals
  Vector<Value> list=new Vector<Value>();
  //reset all variables
  void clear(){
  arg.clear();
  totalTree.clear();
  list.clear();
  }
  // remove ()surounding show expression
  String removeParen(String temp){
  int count=0;
  boolean remove=false;
 String reduced;
      for (int j=0;j<temp.length();j++){
 if(j==temp.length()-1&&count>=1&&temp.charAt(0)=='('){
 remove=true;
 break;
 }

  if(temp.charAt(j)=='('){count++;}
  else if(temp.charAt(j)==')'){count--;}
 
  if(count==0){return temp;}
  }
     
    if(remove){reduced=temp.substring(1,temp.length()-1)  ;
    return removeParen(reduced);
    }
  return temp;
  }
  
  //recusively read in text and create tree
 Value parser(int arg,String temp,Vector<Value> tree, boolean firstIter,int position){
  int count=0;
  int oper=0;
  
  //default to not acutally be used
  Value term=null;
  String main=removeParen(temp);
  int relativePosition=0;
  position=position+((temp.length()-main.length())/2);
  for (int j=0;j<main.length();j++){
  relativePosition=j;
  if(main.charAt(j)=='('){count++;}
  else if(main.charAt(j)==')'){count--;}
 
  if(count==0){
  
      if(main.charAt(j)=='→'){
      term=new Conditional(j+position);
      term.arg=arg;
     // tree.add(term);
      oper++;
      break;
      }
      else if(main.charAt(j)=='¬'){
      term=new Not(j+position);
     term.arg=arg;
      // tree.add(term); 
      oper++;
       break;
      }
      else if(main.charAt(j)=='∧'){
      term=new And(j+position);
     term.arg=arg;
      // tree.add(term);
      oper++;
       break;
      }
      else if(main.charAt(j)=='∨'){
     
       term=new Or(j+position);
     term.arg=arg;
       // tree.add(term);
      oper++;
       break;
      }
      else if(main.charAt(j)=='↔'){
      term=new BiConditional(j+position);
     term.arg=arg;
      // tree.add(term);
      oper++;
       break;
      }else{
     term=new Literal(main.charAt(j),j+position);
      term.arg=arg;
      }
   
  }
  }
  if(oper==0){
      list.add(term);
      if(firstIter){
      tree.add(term);}
      return term;}
 
else{
      
  Operator term2= (Operator)term;
 if(term2.op=='¬'){ 
     tree.add(term2);
     term2.right=parser(arg,main.substring(relativePosition+1, main.length()),tree,false,term2.pos+1);
 term2.right.parent=term2;
 
 }
 else{
     tree.add(term2);
  term2.right=parser(arg,main.substring(relativePosition+1, main.length()),tree,false,term2.pos+1);
 term2.right.parent=term2;
 //    term2.left=parser(arg,main.substring(0, relativePosition),tree,false,(temp.length()-main.length())/2);
     term2.left=parser(arg,main.substring(0, relativePosition),tree,false,term2.pos-relativePosition);
 
 term2.left.parent=term2;
 
 }
 
 return term2;
  }
  }
  
 
  
  
  
  
  
  //parse all line of argument
  void parse(){
  for (int i=0;i<arg.size();i++){
  String temp=arg.elementAt(i);
      Vector<Value> tree=new Vector<Value>() ;
      totalTree.add(tree);
      //parser(temp,tree,true);
      parser(i,temp,tree,true,0);
  
  }
  
  
  } 
  //read in file selected by file chooser
  boolean read(File file){
      clear();
   String filePath = new File("").getAbsolutePath();
        System.out.println("file path "+filePath);
        BufferedReader in;
        //InputStreamReader in;
String temp="";
        try{
//in=new BufferedReader(new FileReader(filePath+"/src/pkgfinal/#1.stt"));
         //   in=new BufferedReader(new FileReader(file.getAbsolutePath()));
 in=new BufferedReader(new InputStreamReader(
                      new FileInputStream(file.getAbsolutePath()), "UTF8"));

            temp= in.readLine();      
while(temp!=null&&!(temp.isEmpty()))
    {
      
      temp=temp.replace(" ", "");
       arg.add(temp);
 temp= in.readLine();
       //  System.out.println(temp);
          
      }   
        
        }
        catch(Exception e){
            System.out.println("exception " +e.toString());
       return false;
        }
   
        
    return true;
   
   
   };
  String space(int i){
  String p="";
      for(int j=0;j<i;j++){
      
      p+=" ";
      
  
  }return p;
  }
//print to console
  void print(){
       for (int j=0;j<totalTree.size();j++){
           Vector<Value> tree=totalTree.elementAt(j);
  for (int i=0;i<tree.size();i++){
      if(tree.elementAt(i).isOperator()){
      Operator t1=(Operator)tree.elementAt(i);
      
          System.out.println("node "+t1+ " pos "+t1.pos+ " arg "+t1.arg+ " children left "+t1.left+ " right "+t1.right );
      }else{
       System.out.println("node "+tree.elementAt(i)+ " arg "+tree.elementAt(i).arg);
      
      }
  
  }
       }
  } 
  
  void run(){try{

//read();
parse();
print();}

catch(Exception e){
    System.out.println(e);
}}
   public static void main(String args[]) {
Input test=new Input();
try{
//test.read();
test.parse();
test.print();
}
catch(Exception e){
    System.out.println(e);
}

}

}