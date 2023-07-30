
import java.awt.*;
import java.awt.event.*;
import java.math.*;
import javax.swing.*;
class GuessGame  implements ActionListener{
    public static int count=0,sc=0;
    JFrame f;
    JLabel jl,score,attempts;
    JButton b1;
    Container c;
    JTextField tf1;
    String st;
    int rnum;
    GuessGame()
    {
       rnum=(int)(Math.random()*100+1);
       System.out.println(rnum);
       f=new JFrame("GuessGame");
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setSize(400,400);
       f.setLayout(null);
       f.setVisible(true);
       jl=new JLabel("Guess a number between 1-100");
       jl.setBounds(50,120,200,30);
       tf1=new JTextField();
       tf1.setBounds(50,150,200,30);
       c=f.getContentPane();
       c.add(tf1);
       b1=new JButton("Submit");
       b1.setBounds(90,200,100,30);
       c.add(jl);
       c.add(b1);
       b1.addActionListener(this);
       score=new JLabel("score     : 0");
       score.setBounds(50,230,200,20);
       c.add(score); 
       attempts =new JLabel("attempts : 0");
       attempts.setBounds(50,250,200,20);
       c.add(attempts);
    }
    public static void main(String[] args)
    {
             new GuessGame();
             
    }
    public void actionPerformed(ActionEvent e1)
    {
       String inp=tf1.getText();
       count++;
       attempts.setText("attempts : "+Integer.toString(count));
       int num=Integer.parseInt(inp);
       
       if(num==rnum)
       {
         this.dbox("correct guess...");
         st=Integer.toString(sc=count>0?(100/count):0);
         score.setText("score   : "+st);
       }
       else if(num<rnum)
       {
         this.dbox("your guess is too lower....");
       }
       else
         this.dbox("your guess is too higher....");
    } 
     public void dbox(String msg)
    {
       
       JDialog jd=new JDialog(f,"Result");
       
       jd.setVisible(true);
       jd.setSize(400,200);
       JLabel jdl=new  JLabel(msg);
       jdl.setBounds(20,20,100,30);
       jd.add(jdl);
    }
}
