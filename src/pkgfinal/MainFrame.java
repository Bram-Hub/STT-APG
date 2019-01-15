/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.io.*;
       import java.awt.event.*; 
import pkgfinal.Model;

/**
 *
 * @author salamb
 */

public class MainFrame extends javax.swing.JFrame {
    //textfields with argument
Vector<JTextField> arg=new Vector<JTextField>();
//instace of model
Model m=new Model();  
//textfields used to show truth value assignments
Vector<JTextField> printList=new Vector<JTextField>();
//has false only if program can force any more truth values or contradiciton
boolean step=true;
//select .stt file
JFileChooser fileChooser=new JFileChooser();
File source;
//update text files with new truth values
void print(int arg,Value v){
    
            String temp=printList.elementAt(arg).getText();
String temp2=temp.substring(0, v.pos)+String.valueOf(v.value.get())+temp.substring(v.pos+1);
printList.elementAt(arg).setText(temp2);
Pane.repaint();
    System.out.println(" element "+v.op+" arg"+v.arg+" pos ");
    
}
//add a line for an argument
void createLine(){
    //JPanel p= new JPanel();
    JTextField text=new JTextField();
//cambria math
    text.setFont(new Font("monospaced",Font.BOLD, 24));
JTextField ptext=new JTextField();
ptext.setEditable(false);
ptext.setBackground(Color.red);
    ptext.setFont(new Font("monospaced",Font.BOLD, 24));
printList.add(ptext);
    arg.add(text);
  Mpane.add(text)  ;
  Mpane.add(ptext);
    int x=((int)(700));
   int y=((int)(35));
    text.setSize(x, y);
    ptext.setSize(x, y);
    
  text.setLocation( (Mpane.getWidth()-x)/2,(int)(arg.size()*2*y));
  ptext.setLocation( (Mpane.getWidth()-x)/2,(int)(arg.size()*2*y)+y);
  Mpane.setPreferredSize( new Dimension((Mpane.getWidth()-x)/2,(int)(arg.size()*2*y)+4*y));
  //text.setlo
    //text.setAlignmentY((Mpane.getWidth()-x)/2);
    //text.setAlignmentX(arg.size()*2*y+200);
 
   
  // Mpane.revalidate();
    Pane.revalidate();
    //Pane.validate();
}
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }
    //one of the operator buttons were pressed determine which one and print
    //corresponding sign
void addOp(int op){
 String temp="";
 String temp2="";
 String temp3="";
 //or an cond,bicond,not
 if(op ==0){temp2="∨";}
 if(op ==1){temp2="∧";}
 if(op ==2){temp2="→";}
 if(op ==3){temp2="↔";}
 if(op ==4){temp2="¬";}
 int count=0;
     for(int i=0;i<arg.size();i++){
     if(arg.elementAt(i).isFocusOwner()){
     count=arg.elementAt(i).getCaret().getDot();
     temp=arg.elementAt(i).getText();
     temp3=temp.substring(0,count)+temp2+temp.substring(count);
     arg.elementAt(i).setText(temp3);
     
     }
     }


}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Step = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        CondBut = new javax.swing.JButton();
        AndBut = new javax.swing.JButton();
        NotBut = new javax.swing.JButton();
        OrBut = new javax.swing.JButton();
        BiConBut = new javax.swing.JButton();
        Parse = new javax.swing.JToggleButton();
        Pane = new javax.swing.JScrollPane();
        Mpane = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        Delete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Step.setText("Step");
        Step.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StepActionPerformed(evt);
            }
        });

        Add.setText("Add Line");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        CondBut.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        CondBut.setText("→");
        CondBut.setFocusable(false);
        CondBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CondButActionPerformed(evt);
            }
        });

        AndBut.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        AndBut.setText("∧");
        AndBut.setFocusable(false);
        AndBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AndButActionPerformed(evt);
            }
        });

        NotBut.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        NotBut.setText("¬");
        NotBut.setFocusable(false);
        NotBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotButActionPerformed(evt);
            }
        });

        OrBut.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        OrBut.setText("∨");
        OrBut.setFocusable(false);
        OrBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrButActionPerformed(evt);
            }
        });

        BiConBut.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        BiConBut.setText("↔");
        BiConBut.setFocusable(false);
        BiConBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BiConButActionPerformed(evt);
            }
        });

        Parse.setText("Parse");
        Parse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParseActionPerformed(evt);
            }
        });

        Pane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        Pane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout MpaneLayout = new javax.swing.GroupLayout(Mpane);
        Mpane.setLayout(MpaneLayout);
        MpaneLayout.setHorizontalGroup(
            MpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
        );
        MpaneLayout.setVerticalGroup(
            MpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        Pane.setViewportView(Mpane);

        Message.setBackground(new java.awt.Color(153, 255, 255));
        Message.setFont(new java.awt.Font("Cambria Math", 0, 24)); // NOI18N
        Message.setOpaque(true);

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu1.add(Open);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parse, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Step, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CondBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NotBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(AndBut, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OrBut, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BiConBut)
                                .addGap(58, 58, 58)
                                .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Pane, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Step, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CondBut)
                                .addComponent(OrBut, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AndBut, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NotBut, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BiConBut, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(Pane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
     if(!Parse.isSelected()){
     
     createLine();
     }
    }//GEN-LAST:event_AddActionPerformed

    private void CondButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CondButActionPerformed
       if(!Parse.isSelected()){
  addOp(2);
     }
    }//GEN-LAST:event_CondButActionPerformed

    private void AndButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AndButActionPerformed
       if(!Parse.isSelected()){
     
     addOp(1);
     }
    }//GEN-LAST:event_AndButActionPerformed

    private void NotButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotButActionPerformed
       if(!Parse.isSelected()){
     addOp(4);
     
     }
    }//GEN-LAST:event_NotButActionPerformed

    private void OrButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrButActionPerformed
       if(!Parse.isSelected()){
     addOp(0);
     
     }
    }//GEN-LAST:event_OrButActionPerformed

    private void BiConButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BiConButActionPerformed
       if(!Parse.isSelected()){
     addOp(3);
     
     }
    }//GEN-LAST:event_BiConButActionPerformed

    private void ParseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParseActionPerformed
        //set all field to be uneditable
        //set value in input.arg
        //model.run
        
        if(Parse.isSelected()){
            Vector<String> arlist=new Vector<String>();
            arlist.clear();
        for(int i=0;i<arg.size();i++){
            arg.elementAt(i).setText(arg.elementAt(i).getText().replace(" ",""));
        arlist.add(arg.get(i).getText());
        arg.elementAt(i).setEditable(false);
       // arg.elementAt(i).setText(arg.elementAt(i).getText().replace(" ", ""));
        printList.elementAt(i).setText( new String(new char[arg.get(i).getText().length()*2]).replace('\0', ' '));
        }
       
        m.clear();
        m.in.arg=arlist;
        m.in.parse();
        m.in.print();
        m.initialValue();
        for(int i=0;i<arg.size();i++){
        print(m.in.totalTree.elementAt(i).elementAt(0).arg,m.in.totalTree.elementAt(i).elementAt(0));
        
        }
        step=true;
        }else{
         for(int i=0;i<arg.size();i++){
        printList.elementAt(i).setText("");
        arg.elementAt(i).setEditable(true);
        }
        Message.setText("");
        
        }
    }//GEN-LAST:event_ParseActionPerformed

    private void StepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StepActionPerformed
     //  continue forcing vaues as long as parse is selected and  
        // there are still forcible terms left
        if(Parse.isSelected()&&step){
     Result v;
     v=m.solve();
     if(v.v==null){
     Message.setText("no Forcible");step=false;
     }else if(v.contradiction){
         Message.setText("⊥");step=false;
         }else{
         
         print(v.v.arg,v.v);
     }
     
     }
    }//GEN-LAST:event_StepActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
       //delete line
        if(!Parse.isSelected()){
      Mpane.remove( arg.elementAt(arg.size()-1));
       arg.remove(arg.elementAt(arg.size()-1));
       Mpane.remove( printList.elementAt(printList.size()-1));
       printList.remove(printList.elementAt(printList.size()-1));
       
       Pane.repaint();
       }
    }//GEN-LAST:event_DeleteActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
      //choose file reset text
       if(!Parse.isSelected()){
       fileChooser.setVisible(true);
       int ret=fileChooser.showDialog(this, "open");
       if (ret==JFileChooser.OPEN_DIALOG){
      // source=fileChooser.getSelectedFile().getPath();
       source=fileChooser.getSelectedFile();
           fileChooser.setVisible(false);
      
     for(int i=0;i<m.in.arg.size();i++){
       Mpane.remove( arg.elementAt(arg.size()-1));
       arg.remove(arg.elementAt(arg.size()-1));
       Mpane.remove( printList.elementAt(printList.size()-1));
       printList.remove(printList.elementAt(printList.size()-1));}
    m.clear();
     arg.clear();
      printList.clear();
       Pane.repaint();
           m.in.read(source);
       m.in.run();
       
       for(int i=0;i<m.in.arg.size();i++){
       createLine();
       arg.elementAt(i).setText(m.in.arg.elementAt(i));
       }
       Pane.repaint();
       }
        //ch.file.getPath();
       }
      //  chooser.setVisible(true);
//if(!chooser.isShowing())     {   String file=chooser.getSelectedFile().getAbsolutePath();
//        System.out.println("file  "  +file);}
    }//GEN-LAST:event_OpenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
    
     
            }
            
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton AndBut;
    private javax.swing.JButton BiConBut;
    private javax.swing.JButton CondBut;
    private javax.swing.JButton Delete;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel Mpane;
    private javax.swing.JButton NotBut;
    private javax.swing.JMenuItem Open;
    private javax.swing.JButton OrBut;
    private javax.swing.JScrollPane Pane;
    private javax.swing.JToggleButton Parse;
    private javax.swing.JButton Step;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}