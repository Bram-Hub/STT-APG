/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;
import java.util.Vector;
import java.util.Scanner;
/**
 *
 * @author salamb
 */
public class Model {
   Input in=new Input();
   //list of all nodes with assign values
   Vector<Value> assigned=new Vector<Value>();
   /*
   {
     {}//each subset is i of[i][]
     {} each element in side is j of[][j]
       }
rows represented by i in [i][] represent L
colums represented b j in [][j] represent R
         0,1
       0[  ]
       1[  ]
       
  
   final boolean[][] orTable = {{false, true},
                                {true, true}};
    final boolean[][] andTable = {{false, false},
                                  {false, true}};
     final boolean[][] conditionalTable = {{true, true},
                                         {false, true}};
   final boolean[][] BiconditionalTable = {{true, false},
                                         {false, true}};
   final boolean[][] notTable = {{true, false},
                                  {true, false}};
   */
   //represent all binary operators
    int[][][] table= new int[][][]  {{{0, 1},
                                {1, 1}},
                                 {{0, 0},
                                  {0, 1}},
                                    {{1, 1},
                                         {0, 1}},
                                         {{1, 0},
                                         {0, 1}},
                                           {{1, 0},
                                           {1, 0}}};
   
  
   //set parent in each node
   //method checkassumption
          //checks whether new value is reit or a based on rule of parent
   //solve
        //step by step
    
    
    //reset model
 void   clear(){
 assigned.clear();
 in.clear();
 }

///check for inconsistency
 //reit truth values
   boolean Reit(Value v, Result res){
    
if(v.isOperator()){
  
    return false;}
for(int i=0;i<in.list.size();i++){
    if(v.op==in.list.elementAt(i).op&&!in.list.elementAt(i).hasVal()){
    in.list.elementAt(i).setValue(v.getBool());
    assigned.add(in.list.elementAt(i));
    //v.check=1;
    res.v=in.list.elementAt(i);
    res.contradiction=false;
   return true;
    }if(v.op==in.list.elementAt(i).op&&in.list.elementAt(i).hasVal()){
   if(v.getBool()!=in.list.elementAt(i).getBool()){
       // v.setValue(in.list.elementAt(i).getBool());
   //v.check=-1;
     res.v=in.list.elementAt(i);
    res.contradiction=true;  
   return false;
   }
    
    
    }
}
return false;
}
   //print to console
   void print(){
        boolean found;
       for(int i=0;i<in.arg.size();i++){
           System.out.println(in.arg.elementAt(i));
       for(int j=0;j<in.arg.elementAt(i).length();j++){
           found=false;
           for(int z=0;z<assigned.size();z++){
           if(assigned.elementAt(z).pos==j&&assigned.elementAt(z).arg==i){
               found=true;
               System.out.print(assigned.elementAt(z).value.val);
               break;
           }
           }
          if(!found){ System.out.print(" ");}
       
       }
           System.out.println(" ");
       }
    
    }
   //determine if a forcible value exits or contradiction
   Result solve(){
Result r=new Result();
Value temp;
boolean found=false;
for(int i=0;i<assigned.size();i++){
    r.reset();
    temp=assigned.elementAt(i);
    if(temp.parent!=null&&temp.parent instanceof Operator){
       if( checkForcible(temp.parent,r)){
           return r;}
       else{if (r.contradiction){return r;}
       
       }}
       r.reset();
       if(temp instanceof Operator){
       if(checkForcible(temp,r)){
       return r;
       }else{if(r.contradiction){return r;}}
       }
       
    r.reset();
    
    if(temp instanceof Literal &&Reit(temp,r)){
    return r;
    }else{
    if (r.contradiction){
    return r;
    }
    }
    
}
r.reset();
return r;
}
//determine if the node is iether null or has same truth value
boolean match(Value v,int table){
    if(v==null){return true;}
 if(!v.hasVal()){return true;}else if(v.getBool()&&table==1||!v.getBool()&&table==0){
 return true;
 }else{
    
    return false;}
}
//checks consistency of matched nodes
int track(int table,int history){
if(history==-1){
    return table;
    
    }else if( history!=table){
    return -100;
    }else if(history==table){
return history;}
return -100;
}
//change truch value of node 
boolean update(Value v,int history){
if(v==null){return false;}

    if(!v.hasVal()&&history!=-100){
        if(history==0){
        v.setValue(false);
        return true;
        }else{v.setValue(true);
        return true;
        }
    }else 
    {
       if(history!=-100){
           System.out.println("error line 181 contradiction not reported pos "+v.pos +
            " arg "+v.arg+" op "+v.op       
                   );
       } 
        return false;}
  
}
//check if truth tables force a value
 boolean checkForcible(Value v, Result res) {

 //Vector<Vector<Boolean>> map=new Vector<Vector<Boolean>>(); 
 
 int tableNumber=0;
 
 
 Operator temp=(Operator)v;
 int count=0;
 int L,M,R;
 L=M=R=-1;
 Value left=null;
 Value right=null;
 if(temp.left!=null){
 left=temp.left;}
 
 right=temp.right;


 if(temp instanceof Or){
 tableNumber=0;
 }
 else if(temp instanceof And){
 tableNumber=1;
 }
 else if(temp instanceof Conditional){
 tableNumber=2;
 }else if(temp instanceof BiConditional){
 tableNumber=3;
 }else{tableNumber=4;}
 
   
 for(int i=0;i<2;i++){
 for(int j=0;j<2;j++){
 //if(L)
     if(match(left,i)&&match(right,j)&&match(temp,table[tableNumber][i][j]))
     {
       count++;

     L=track(i,L);
     M=track(table[tableNumber][i][j],M);
     R=track(j,R);
     
     }
 
 }
 
 }
 if(count==0){
     res.contradiction=true;
     res.v=temp;
     return false;
         }
//one for  each char
if(update(temp,M)){
     assigned.add(temp);
     res.contradiction=false;
     res.v=temp;
     return true;
     }
 if(update(right,R)){
     assigned.add(temp.right);
 res.contradiction=false;
     res.v=right; 
     return true;
 }
 if(update(left,L)){
     assigned.add(temp.left);
     res.contradiction=false;
     res.v=left;
     return true;
     }
 
     System.out.println("Dont know why reach end ln 224 arg"+temp.arg
       +" pos "+temp.pos+" op "+temp.op+" unless all values set"     
             
             );   
 return false;
 
 
 } 
 //intiaize premises main conective to true and conclusion main conective to false
   void initialValue (){
    
for (int i=0;i<in.totalTree.size();i++){
    if(i!=in.totalTree.size()-1){
   in.totalTree.elementAt(i).elementAt(0).setValue(true);
   if(!in.totalTree.elementAt(i).elementAt(0).isOperator()){
   in.list.add(in.totalTree.elementAt(i).elementAt(0));
   }
   assigned.add(in.totalTree.elementAt(i).elementAt(0));
    }else{in.totalTree.elementAt(i).elementAt(0).setValue(false);
    if(!in.totalTree.elementAt(i).elementAt(0).isOperator()){
   in.list.add(in.totalTree.elementAt(i).elementAt(0));
   }
    assigned.add(in.totalTree.elementAt(i).elementAt(0));
    }
}

//print();
}   
   
 public static void main(String args[]) {
     Scanner scan=new Scanner(System.in);
Model m=new Model();
m.in.run();
for(int z=0;z<5;z++){System.out.println("table");
for(int i=0;i<2;i++){
for(int j=0;j<2;j++)
{
    System.out.print(m.table[z][i][j]+" ");

}
    System.out.println(" "); 
    }
    
}
  m.initialValue();
 // m.print();
  String line;
  while(true){
  

    line=scan.nextLine();
      try{
          System.out.println("Iteration");
 m.print();
        //  if(m.solve( true).check==-1){
        //      System.out.println("cotradiction");
         // };
 }catch(Exception e){
          System.out.println(e);
      }
  }
}   
}