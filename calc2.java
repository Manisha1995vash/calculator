import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import static java.lang.Math.*;

      
class calc2 implements ActionListener, ItemListener
{
JFrame f;
JButton b[]= new JButton[32];
JLabel l;
JTextField tf;
String view[]={"basic","matrixtranspose","matrix sum","matrix sub"};
JComboBox cb;
String a[]={"edit","help","MC","MR","MS","M+","M-","<-","CE","C","+-","SQ","7","8","9","/","%","4","5","6","*","1/X","1","2","3","-","=","0",".","+"};
 int x=0,v=0; String s2[]=new String[3];String no;
calc2(String s)
{ int i,j,k=0,t=-1;
  
  f=new JFrame(s);f.setLayout(null);
  for(i=0; i<3; i++)
  { 
    if(i==0)
    { cb=new JComboBox(view);cb.setBounds(10+(i*60),20,100,20); cb.addItemListener(this);f.add(cb);}
     else
    { t=t+1;b[t]=new JButton(a[k]);
      b[t].addActionListener(this);
      b[t].setBounds(100+(i*60),20,60,20);
      f.add(b[t]);k=k+1;
    }
    }

  tf=new JTextField();
  tf.setBounds(10,50,275,80);
  f.add(tf);
  for(i=0; i<6; i++)
  {if(i==5)
    {for(j=0; j<3; j++)
      {t=t+1;
       b[t]=new JButton(a[k]);
       b[t].addActionListener(this);
       b[t].setBounds(10+(j*55),140+(i*40),55,40);
       f.add(b[t]);k=k+1;}}
   else
    {for(j=0;j<5;j++)
     {t=t+1;
       b[t]=new JButton(a[k]);
       b[t].addActionListener(this);
      b[t].setBounds(10+(j*55),140+(i*40),55,40);
      f.add(b[t]);k=k+1;}
    }
  }
  
 
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   f.setSize(310,440);
  f.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{ int i;
   for(i=1; i<32;i++)
   {  
        if(e.getSource()==b[i])
      { 
        if ((a[i].equals("=")==false))
        {  if((a[i].equals("1")==true)||(a[i].equals("2")==true)||(a[i].equals("3")==true)||(a[i].equals("4")==true)||(a[i].equals("5")==true)||(a[i].equals("6")==true)||(a[i].equals("7")==true)||(a[i].equals("8")==true)||(a[i].equals("9")==true)||(a[i].equals(".")==true)||(a[i].equals("0")==true))
            {  
             tf.setText(tf.getText()+a[i]);
            
            }
           
           else
            {  if(v==0)
                {
                
                  s2[0]=tf.getText();
                  
                  s2[1]=a[i];
                  if (a[i].equals("SQ")==true)
                    { String sqt= squareR(s2[0]);
                           tf.setText(sqt);
                                v=0;
                                }
                   else if (a[i].equals("<-")==true)
                     { String s3= tf.getText();
                               tf.setText(s3.substring(0,s3.length()-1));
                                 v=0;
                                }
                     else if (a[i].equals("C")==true) 
                      {tf.setText("0");
                                v=0;
                                }
                     else if (a[i].equals("CE")==true) 
                       {tf.setText("0");
                                v=0;
                                }
                     else{tf.setText(tf.getText()+a[i]);x=2;v=1;}
                   
                 }
                else
                {      if (a[i].equals("<-")==true)
                     { String s3= tf.getText();
                               tf.setText(s3.substring(0,s3.length()-1));
                                 v=0;
                                }
                     else if (a[i].equals("C")==true) 
                      {tf.setText("0");
                                v=0;
                                }
                     else if (a[i].equals("CE")==true) 
                       {tf.setText("0");
                                v=0;
                                }
                  else {int index=tf.getText().indexOf(s2[1]);
                        String eq=tf.getText();
                        s2[2]=eq.substring(index+1,eq.length());
                        String mid= calculation(s2);
                   
                        tf.setText(mid);
                        x=0;
                        s2[0]=tf.getText(); 
                        x=1; s2[1]=a[i];
                        tf.setText(tf.getText()+a[i]); x=2;
                       }
                 }
             }
                 
         }
        
        else
         { int index1=tf.getText().indexOf(s2[1]);
                  String eq1=tf.getText();
                  s2[2]=eq1.substring(index1+1,eq1.length());
            String ans= calculation(s2);
           tf.setText(ans);
            x=0;
            s2[0]=tf.getText();v=0;
             
          }
      }
    }
}

 public String calculation(String s1[])
{ String z=new String();
  if (s1[1].equals("+")==true)
     { double n1=Double.parseDouble(s1[0]);
        double n2=Double.parseDouble(s1[2]);
          double n= n1+n2;
            z=String.valueOf(n);
        
      }
    if (s1[1].equals("-")==true)
     { double n1=Double.parseDouble(s1[0]);
        double n2=Double.parseDouble(s1[2]);
         double n= n1-n2;
            z=String.valueOf(n);
        
      }
    if (s1[1].equals("*")==true)
     { double n1=Double.parseDouble(s1[0]);
        double n2=Double.parseDouble(s1[2]);
          double n= n1*n2;
            z=String.valueOf(n);
        
      }
    if (s1[1].equals("/")==true)
     { double n1=Double.parseDouble(s1[0]);
        double n2=Double.parseDouble(s1[2]);
          double n= n1/n2;
            z=String.valueOf(n);
        
      }
     if (s1[1].equals("%")==true)
     { double n1=Double.parseDouble(s1[0]);
        double n2=Double.parseDouble(s1[2]);
          double n= n1%n2;
            z=String.valueOf(n);
        
      }
    return z;

}
public  void itemStateChanged(ItemEvent  e)
{
      String item = (String)e.getItem();
    if (e.getStateChange() == ItemEvent.SELECTED) {
      if (item.equals("matrixtranspose")==true) {
        new matrixtranspose("matrixtranspose");
     
      }  if(item.equals("matrix sum")==true)
         {new matrixsum("matrix sum");}
         if(item.equals("matrix sub")==true)
         {new matrixsum("matrix sub");}
      }
      
      
    }
public String squareR(String s4)
 { String z=new String();
   double n1=Double.parseDouble(s4);
         double n=sqrt(n1);
     z=String.valueOf(n);
     return z;}
     
public static void main(String args[])
{new calc2("calculator");
}}
class matrixtranspose implements ActionListener
{ JFrame jfmt;
   JButton jbmt;
   JTextField jtmt[]=new JTextField[9];
   JLabel jlmt;
   
  matrixtranspose(String s4)
 { int i,j,k=-1;
    jfmt=new JFrame(s4);jfmt.setLayout(null);
    jlmt=new JLabel("enter the matrix");
    jlmt.setBounds(40,30,190,40);
    jfmt.add(jlmt);
    for( i=0; i<3; i++)
    { for( j=0; j<3; j++)
      {k=k+1; jtmt[k]=new JTextField();
        jtmt[k].setBounds(40+(j*50),80+(i*50),50,50);
        jfmt.add(jtmt[k]);
       }
     }
     jbmt=new JButton(" transpose");
jbmt.addActionListener(this);
      jbmt.setBounds(100,260,100,40);
     jfmt.add(jbmt);

     jfmt.setSize(220,350);
     jfmt.setVisible(true);
 }
public void actionPerformed(ActionEvent e)
{  int i,j,k=0;
   int a[][]=new int [3][3];
    for( i=0; i<3; i++)
     { for( j=0; j<3; j++)
       {  a[i][j]=Integer.parseInt(jtmt[k].getText());
          k=k+1;
          }
         }k=0;
      for( i=0; i<3; i++)
     { for( j=0; j<3; j++)
       {  jtmt[k].setText(String.valueOf(a[j][i]));
          k=k+1;
          }
         }
    
}

}
class matrixsum implements ActionListener
{ JFrame jfmt;
   JButton jbmt;
   JTextField jtmt[]=new JTextField[27];
   JLabel jlmt,jlmt1;
   
  matrixsum(String s4)
 { int i,j,k=-1;
    jfmt=new JFrame(s4);jfmt.setLayout(null);
    jlmt=new JLabel("enter the matrices");
    jlmt.setBounds(40,30,190,40);
    jfmt.add(jlmt);
    for( i=0; i<3; i++)
    { for( j=0; j<3; j++)
      {k=k+1; jtmt[k]=new JTextField();
        jtmt[k].setBounds(40+(j*50),80+(i*50),50,50);
        jfmt.add(jtmt[k]);
       }
     }
   jlmt1=new JLabel("+");
    jlmt1.setBounds(240,150,40,40);
    jfmt.add(jlmt1);
     for( i=0; i<3; i++)
    { for( j=0; j<3; j++)
      {k=k+1; jtmt[k]=new JTextField();
        jtmt[k].setBounds(290+(j*50),80+(i*50),50,50);
        jfmt.add(jtmt[k]);
       }
     }
     jbmt=new JButton(" sum");
      jbmt.addActionListener(this);
      jbmt.setBounds(450,180,80,30);
     jfmt.add(jbmt);
for( i=0; i<3; i++)
    { for( j=0; j<3; j++)
      {k=k+1; jtmt[k]=new JTextField();
        jtmt[k].setBounds(550+(j*50),80+(i*50),50,50);
        jfmt.add(jtmt[k]);
       }
     }

     jfmt.setSize(800,350);
     jfmt.setVisible(true);
 }
public void actionPerformed(ActionEvent e)
{  int i,j,k=0;
   int a[][]=new int [3][3];int b[][]=new int [3][3];
    for( i=0; i<3; i++)
     { for( j=0; j<3; j++)
       {  a[i][j]=Integer.parseInt(jtmt[k].getText());
          k=k+1;
          }
         }
     for( i=0; i<3; i++)
     { for( j=0; j<3; j++)
       {  b[i][j]=Integer.parseInt(jtmt[k].getText());
          k=k+1;
          }
         }k=18;
      for( i=0; i<3; i++)
     { for( j=0; j<3; j++)
       {  jtmt[k].setText(String.valueOf(a[j][i]+b[i][j]));
          k=k+1;
          }
         }
    
}

}
class matrixsub implements ActionListener
{ JFrame jfmt;
   JButton jbmt;
   JTextField jtmt[]=new JTextField[27];
   JLabel jlmt,jlmt1;
   
  matrixsub(String s4)
 { int i,j,k=-1;
    jfmt=new JFrame(s4);jfmt.setLayout(null);
    jlmt=new JLabel("enter the matrices");
    jlmt.setBounds(40,30,190,40);
    jfmt.add(jlmt);
    for( i=0; i<3; i++)
    { for( j=0; j<3; j++)
      {k=k+1; jtmt[k]=new JTextField();
        jtmt[k].setBounds(40+(j*50),80+(i*50),50,50);
        jfmt.add(jtmt[k]);
       }
     }
   jlmt1=new JLabel("-");
    jlmt1.setBounds(240,150,40,40);
    jfmt.add(jlmt1);
     for( i=0; i<3; i++)
    { for( j=0; j<3; j++)
      {k=k+1; jtmt[k]=new JTextField();
        jtmt[k].setBounds(290+(j*50),80+(i*50),50,50);
        jfmt.add(jtmt[k]);
       }
     }
     jbmt=new JButton(" sub");
      jbmt.addActionListener(this);
      jbmt.setBounds(450,180,80,30);
     jfmt.add(jbmt);
for( i=0; i<3; i++)
    { for( j=0; j<3; j++)
      {k=k+1; jtmt[k]=new JTextField();
        jtmt[k].setBounds(550+(j*50),80+(i*50),50,50);
        jfmt.add(jtmt[k]);
       }
     }

     jfmt.setSize(800,350);
     jfmt.setVisible(true);
 }
public void actionPerformed(ActionEvent e)
{  int i,j,k=0;
   int a[][]=new int [3][3];int b[][]=new int [3][3];
    for( i=0; i<3; i++)
     { for( j=0; j<3; j++)
       {  a[i][j]=Integer.parseInt(jtmt[k].getText());
          k=k+1;
          }
         }
     for( i=0; i<3; i++)
     { for( j=0; j<3; j++)
       {  b[i][j]=Integer.parseInt(jtmt[k].getText());
          k=k+1;
          }
         }k=18;
      for( i=0; i<3; i++)
     { for( j=0; j<3; j++)
       {  jtmt[k].setText(String.valueOf(a[j][i]+b[i][j]));
          k=k+1;
          }
         }
    
}

}





