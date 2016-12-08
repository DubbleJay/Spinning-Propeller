import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class propeller {
   
   int num = 0, num2 = 90, num3 = 180, num4 = 270; 
   JButton changeColor, changeDirection, blinkButton;
   JFrame frame;
   int direction = 0, speed = 12;
   Color shade = Color.red;
   boolean running = true, blinking = false;
   
   public static void main(String[] args){
      
      propeller thoma = new propeller();
      thoma.go();
  
   }//end main method
   
   public void go(){
      
      frame = new JFrame();
      frame.setLayout(new BorderLayout());
      JPanel p = new JPanel(new GridLayout(1, 0, 4, 4));
      changeColor = getButton("Change Color");
      changeColor.addActionListener(new changeColor());
      changeDirection = getButton("Change Direction");
      changeDirection.addActionListener(new changeDirection());
      blinkButton = getButton("Blink");
      blinkButton.addActionListener(new blinkClick());
      JButton faster = getButton("Speed Up");
      faster.addActionListener(new speedUp());
      JButton slower = getButton("Slow Down");
      slower.addActionListener(new slowDown());
      JButton stopButton = getButton("Stop");
      stopButton.addActionListener(new stop());
      JButton goButton = getButton("Go");
      goButton.addActionListener(new getItGoing());
      p.add(changeColor);
      p.add(changeDirection);
      p.add(faster);
      p.add(slower);
      p.add(blinkButton);
      //p.add(goButton);
      //p.add(stopButton);
      frame.setSize(1100, 800);
      drawShit canvas = new drawShit();
      frame.add(canvas, BorderLayout.CENTER);
      frame.add(p, BorderLayout.SOUTH);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      
      while(running == true){
      
         if(direction == 0){
         num--;
         num2--;
         num3--;
         num4--;
         }
         
         
         if(direction == 1){
         num++;
         num2++;
         num3++;
         num4++;
         }
         
         
         if(direction == 2){
         num--;
         num2++;
         num3--;
         num4++;
         }
         
         
         if(direction == 3){
         num++;
         num2--;
         num3++;
         num4--;
         }
         
         canvas.repaint();
            
            try{
               Thread.sleep(speed);
            }  catch(Exception ex){}
            
         //System.out.println(speed);
      }//end while loop 
   }
   
   public JButton getButton(String name){
      JButton button = new JButton(name);
      Font font = new Font("ar christy", Font.BOLD, 20);
      if(!name.equals("Stop") && !name.equals("Go")){
         button.setForeground(Color.blue);
         button.setBackground(Color.yellow);
      }
      if(name.equals("Stop")) {
         button.setForeground(Color.white);
         button.setBackground(Color.red);
      }
      
       if(name.equals("Go")) {
         button.setForeground(Color.white);
         button.setBackground(Color.GREEN.darker());
      }
      button.setFont(font);
      return button;
   }
   class changeDirection implements ActionListener {
      public void  actionPerformed(ActionEvent event){
         direction = (int)(Math.random() * 4);
      
      }
   }
   
   class changeColor implements ActionListener {
      public void  actionPerformed(ActionEvent event){
         int red = (int)(Math.random() * 256);
         int green = (int)(Math.random() * 256);
         int blue = (int)(Math.random() * 256);
      
         shade = new Color(red, green, blue);
         blinking = false;
      
      }
   }
   
   class speedUp implements ActionListener {
      public void  actionPerformed(ActionEvent event){
         speed--;
      
      }
   }
   
    class slowDown implements ActionListener {
      public void  actionPerformed(ActionEvent event){
         speed++;
      
      }
   }
   
   class blinkClick implements ActionListener {
      public void  actionPerformed(ActionEvent event){
         if(blinking == false)
            blinking = true;
         
         else
            blinking = false;
      }
   }
   
   class getItGoing implements ActionListener {
      public void  actionPerformed(ActionEvent event){
         running = true;
      
      }
   }
   class stop implements ActionListener {
      public void  actionPerformed(ActionEvent event){
         running = false;
      
      }
   }
   

   class drawShit extends JPanel {
    
      
      
   
    public void paintComponent(Graphics g){
      
      g.setColor(Color.black);
      g.fillRect(0, 0, this.getWidth(), this.getHeight());
      
      int xCenter = getWidth() / 2;
      int yCenter = getHeight() / 2;
      int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
      int x = xCenter - radius;
      int y = yCenter - radius;
      
      
      int red = (int)(Math.random() * 256);
      int green = (int)(Math.random() * 256);
      int blue = (int)(Math.random() * 256);
      
      Color blinkColor = new Color(red, green, blue);
      
      if(blinking == false)
         g.setColor(shade);
      
      else
         g.setColor(blinkColor);
         
      g.fillArc(x, y, 2 * radius, 2 * radius, num4, 30);
      g.fillArc(x, y, 2 * radius, 2 * radius, num3, 30);
      g.fillArc(x, y, 2 * radius, 2 * radius, num2, 30);
      g.fillArc(x, y, 2 * radius, 2 * radius, num, 30);
      
      
   
   }
}
}

