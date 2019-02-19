import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//Patrick Yoon :)))

public class QuickSortVis extends Canvas {
	public static String input;
	public static JFrame frame;
	public static int i, j = 0;
	public static int scale;
	public static JButton jb;
	
	public static int[] gloArr;
	public static Rectangle[] gloRec;
	
	
	
	
	public static void main(String [] args) {
        
        JFrame enterNum = new JFrame("Quick Sort");
        JPanel jp = new JPanel();
        JLabel jl = new JLabel();
        JTextField myField = new JTextField(50);
        JLabel j2 = new JLabel("Enter Numbers, Separate with Comma");
        jp.add(j2);
        
        enterNum.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp.add(myField);
        
        
	  
	 
	    enterNum.getContentPane().add(jp);
	    enterNum.setVisible(true);
        
        
        myField.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e) {
        				input = myField.getText();
        				jl.setText(input);
        				
        				  String[] nums = input.split(",");
        			        int[] arr = new int[nums.length];
        			        
        			        for(int i =  0; i<arr.length; i++) {
        			        	arr[i] = Integer.parseInt(nums[i]);
        			        }
        			        drawRec(arr);
        			}
        		});
        
        
        jp.add(jl);
        enterNum.add(jp);
        enterNum.setSize(800,100);
        enterNum.setVisible(true);
  
      
	}
	
	public static void drawRec(int[] arr) {
		int width = 800/arr.length;
		
		
		scale = 500/(largest(arr)+2);
		
		Rectangle[] recArr = new Rectangle[arr.length];
		for(int i = 0; i<arr.length; i++) {
			Rectangle r = (new Rectangle());
			
	
			r.setBounds(i*width,500-arr[i]*scale, width, arr[i]*scale);
			recArr[i] = r;
		}
		
			MakeRectangle making = new MakeRectangle(recArr, scale, 0, 0, arr.length-1);
			frame = new JFrame("Rectangles!");
			jb = new JButton("Click");
			JPanel panel = new JPanel();
			panel.add(jb);
			JPanel panel2 = new JPanel();
			panel2.add(making);
			
	
			frame.add(panel, BorderLayout.NORTH);
			frame.add(panel2);
		   
		    frame.pack();
		    frame.setLocationByPlatform(true);
		    frame.setVisible(true);
		    
		   buttonClick(arr, recArr);
	}
	
	public static int largest(int[] arr) 
    { 
        int i; 
          
   
        int max = arr[0]; 
       
       
        for (i = 1; i < arr.length; i++) 
            if (arr[i] > max) 
                max = arr[i]; 
       
        return max; 
    } 
	
	public static void buttonClick(int[] arr, Rectangle[] recArr) {
		gloArr = arr;
		gloRec = recArr;
		i = 0;
		j = 0;
		
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) throws ArrayIndexOutOfBoundsException{
			
				int pivot = gloArr[arr.length-1];
				int pivotIndex = arr.length - 1;
				if(j < pivotIndex) {
					if(gloArr[j]<pivot) {
				
						int temp = gloArr[j];
						Rectangle temp2 = new Rectangle(gloRec[j]);
						double xpos1 = gloRec[j].getX();
						double xpos2 = gloRec[i].getX();
						
						gloArr[j] = gloArr[i];
						gloRec[j] = new Rectangle((int)xpos1, (int)gloRec[i].getY(), (int)gloRec[i].getWidth(),(int)gloRec[i].getHeight());
				
						
						gloArr[i] = temp;
						gloRec[i] = new Rectangle((int)xpos2, (int)temp2.getY(), (int)temp2.getWidth(),(int)temp2.getHeight());
			
						
						i++;
						j++;
					
						MakeRectangle making = new MakeRectangle(gloRec, scale, i, j, pivotIndex);
		
						frame.getContentPane().removeAll();
						JPanel panel = new JPanel();
						panel.add(jb);
						JPanel panel2 = new JPanel();
						panel2.add(making);
						
				
						frame.add(panel, BorderLayout.NORTH);
						frame.add(panel2);
		    	    	frame.revalidate();			
					}
					else if(gloArr[j]>=pivot) {
						j++;
			
						
						MakeRectangle making = new MakeRectangle(recArr, scale, i, j, pivotIndex);
		    	  
						JPanel panel = new JPanel();
						panel.add(jb);
						JPanel panel2 = new JPanel();
						panel2.add(making);
						
				
						frame.add(panel, BorderLayout.NORTH);
						frame.add(panel2);
		    	    	frame.revalidate();
					}
				}
				else if (j== pivotIndex){
					int temp = gloArr[j];
					Rectangle temp2 = new Rectangle(gloRec[j]);
					double xpos1 = gloRec[j].getX();
					double xpos2 = gloRec[i].getX();
					
					gloArr[j] = gloArr[i];
					gloRec[j] = new Rectangle((int)xpos1, (int)gloRec[i].getY(), (int)gloRec[i].getWidth(),(int)gloRec[i].getHeight());
			
					
					gloArr[i] = temp;
					gloRec[i] = new Rectangle((int)xpos2, (int)temp2.getY(), (int)temp2.getWidth(),(int)temp2.getHeight());
		
					pivotIndex = i;
				
					MakeRectangle making = new MakeRectangle(gloRec, scale, i, j, pivotIndex);
					j++;
					frame.getContentPane().removeAll();
					JPanel panel = new JPanel();
					panel.add(jb);
					JPanel panel2 = new JPanel();
					panel2.add(making);
					
			
					frame.add(panel, BorderLayout.NORTH);
					frame.add(panel2);
	    	    	frame.revalidate();			
				}
				else {
					pivotIndex = i;
				
					int[] newArr = new int[pivotIndex];
					int[] newArr2 = new int[arr.length-(pivotIndex+1)];
					for(int k = 0; k<newArr.length; k++) {
						newArr[k] = gloArr[k];
					}
					for(int k = 0; k<newArr2.length; k++) {
						newArr2[k] = gloArr[k+pivotIndex+1];
					}
					i = 0;
					j = 0;
					drawRec(newArr);
					drawRec(newArr2);
				}
				
				
				
			}
		});
	}
	
	

}
