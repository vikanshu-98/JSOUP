/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package live;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
 
public class Status{
    public static   String  get() throws IOException{
        StringBuffer ob2=new StringBuffer();
        ob2.append("<html>"+"<body  style='text-align:center;color:red; font-size:10px;'>");
      // ob2.append("<body style=\"color:blue;text-align:center;");
        //System.out.println("this is a static method ");
    String s="https://www.mygov.in/covid-19";
  Document doc=  Jsoup.connect(s).get();
     Elements ele=doc.select(".iblock");
       
        
        ele.forEach((e)->
        {
          String r=  e.select(".icount").text();
         String W   = e.select(".info_label").text();
           // <div class="info_label">Active COVID-19 cases</div>
        // String t=e.select(".info-label").html();
             ob2.append(W).append("  ::  ").append(r).append("<br>").append("<br>");
        });
  ob2.append("</body>"+"</html>");
       
       return ob2.toString();
    }
    public static void main(String[] args) throws IOException {
        System.out.println("this is  Main method ");
   JFrame f1=new JFrame("coronavirus live status");
JLabel l2=new JLabel("LIVE STATUS OF CORONA IN INDIA");
l2.setHorizontalAlignment(SwingConstants.CENTER);
JLabel l1=new JLabel();
JButton b1=new JButton("click here");
//frame size set
f1.setSize(500,500);
//frame layout set
f1.setLayout(new BorderLayout());
f1.add(l2,BorderLayout.NORTH);
f1.add(l1,BorderLayout.CENTER);
f1.add(b1,BorderLayout.SOUTH);
f1.setVisible(true);
b1.addActionListener(( e)->{
    if(e.getSource()==b1)
    {
        try {
            l1.setHorizontalAlignment(SwingConstants.CENTER);
            l1.setText(get());
        } catch (IOException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
});
    }
  
}

 
