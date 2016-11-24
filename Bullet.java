import java.awt.*;
import javax.swing.*;

public class Bullet  {

public static void main(String[] args){
    
      JFrame frame = new JFrame("Bullet Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.add(new Test(4));
        frame.setVisible(true);
        
    
    
}
}
class Test extends JComponent{
    
    private int position=800;
    private int bulletNumber;
    
    public Test(int h){
        
       bulletNumber=h;
     Thread animationThread = new Thread(new Runnable() {
           public void run() {
                while (true) {
                    repaint();
                    try {Thread.sleep(10);} catch (Exception e) {}
                }
           }
    });
    animationThread.start();
    
    }
public void setbulletNum(int h){
    
    bulletNumber=h;
    
}
    
    
public void paintComponent(Graphics g){
    
   
    
    int w=getWidth();
    int h=getHeight();
    
    int bulletH=40;
    int bulletW=10;
    
    int bulletSpeed=5;
    
    int x=position-bulletSpeed;
    int y=h/2;
    
    if(x<bulletW){
        
        x+=800;
    }
    g.setColor(Color.BLACK);
    if(bulletNumber==1){
    g.fillRect(x, y, bulletH, bulletW);
    position=x;
    }
    else if(bulletNumber==2){
    g.fillRect(x, y, bulletH, bulletW);
    g.fillRect(x, h/3, bulletH, bulletW);
    position=x;
    }
    else if (bulletNumber ==3){
        g.fillRect(x,h-2,bulletH,bulletW);
           g.fillRect(x, y, bulletH, bulletW);
    g.fillRect(x, h/3, bulletH, bulletW);
        position=x;
    }
    else{
    g.fillRect(x,0,bulletH,bulletW);
    g.fillRect(x, y, bulletH, bulletW);
    g.fillRect(x, h/3, bulletH, bulletW);
    g.fillRect(x,h/4,bulletH,bulletW);
         position=x;
    }
  
    
    
    
    
}


}
    
    
    
    
    






