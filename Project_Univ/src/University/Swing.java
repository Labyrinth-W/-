package University;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;

import javax.imageio.ImageIO;

import javax.swing.*;



public class Swing extends JFrame
{	
	static JButton timeTableButton=new JButton("시간표");
	static JButton loginTableButton=new JButton("로그인");
	static JButton backMainButton=new JButton("돌아가기");
	static JButton checkButton=new JButton("확인");
	static JButton webButton=new JButton("웹으로 보기");
	static JButton exitButton=new JButton("종료");
	
	public JPanel main_panel;
	static JLabel timeTableLabelname=new JLabel("이름 : ");
	static JLabel timeTableLabelgrade=new JLabel("학년 : ");
	static JLabel timeTableLabelclass=new JLabel("반 : ");
    
	public JTextField nameField, classField, gradeField;
	
	public static String nam, grad, clas;

	
	static JPanel MainPanel=new JPanel() 
	{
		Image background=new ImageIcon(Swing.class.getResource("../SwingImage/선린배경.jpg")).getImage();
		Image MealSurviceTable=new ImageIcon(Swing.class.getResource("../SwingImage/급식표 임시.png")).getImage();
		
		public void paint(Graphics g) 
		{
			g.drawImage(background, 0, 0, null);
			g.drawImage(MealSurviceTable, 200, 180, null);
		}
	};
	
	static JPanel TimeTablePanel=new JPanel()
	{	
		Image tBackground=new ImageIcon(Swing.class.getResource("../SwingImage/Europe.jpg")).getImage();
		Image TimeTable=new ImageIcon(Swing.class.getResource("../SwingImage/시간표 임시.png")).getImage();
		
		public void paint(Graphics g) 
		{
			g.drawImage(tBackground, 0, 0, null);
			g.drawImage(TimeTable, 200, 100, null);
		}
	};
	
	static JPanel loginTablePanel=new JPanel()
	{	
		Image lBackground=new ImageIcon(Swing.class.getResource("../SwingImage/로그인배경.jpg")).getImage();
		
		public void paint(Graphics g) 
		{
			g.drawImage(lBackground, 0, 0, null);			
		}
	};
	
	
  public Swing()
  {
	  Frame();
	  ScreenMain();
	  ScreenTimeTable();
	  ScreenLoginTable();
	  MouseEv();  
  }

  public void Frame()
  {
  	 	 
  		 setTitle("선린인 [ Sunrin Information ]");
  		 setSize(1280, 720);
  		 setResizable(false);		 
  		 setLocationRelativeTo(null);
  	     setLayout(null);
  	 	 setVisible(true);	
  	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void ScreenMain()
  {
	 	 
      MainPanel.setLayout(null);
      MainPanel.setBounds(0, 0, 1280, 720);  
      
      ButtonSetting();
      backMainButton.setVisible(false);
      webButton.setVisible(false);
        
      add(MainPanel);
      add(backMainButton);
      add(timeTableButton);
      add(loginTableButton);
      add(exitButton);		 
  }
  
  public void ScreenTimeTable()
  {
	  TimeTablePanel.setLayout(null);
      TimeTablePanel.setBounds(0, 0, 1280, 720);
      TimeTablePanel.setVisible(false);
      
      
      add(webButton);
      add(TimeTablePanel);
  }
  
  public void ScreenLoginTable()
  {	     
      loginTablePanel.setLayout(null);
      loginTablePanel.setBounds(0, 0, 1280, 720);
      loginTablePanel.setVisible(false);
    
      timeTableLabelname.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
      timeTableLabelname.setForeground(new Color(190, 200, 235));
      timeTableLabelgrade.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
      timeTableLabelgrade.setForeground(new Color(190, 200, 235));
      timeTableLabelclass.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
      timeTableLabelclass.setForeground(new Color(190, 200, 235));
      
      
		JPanel name_panel = new JPanel();
		name_panel.setBackground(new Color(20,30,66));
		name_panel.add(timeTableLabelname);
		
		nameField = new JTextField(10);
		nameField.setBackground(new Color(119, 131, 240));
		nameField.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
	    nameField.setForeground(Color.white);
		name_panel.add(nameField);
		name_panel.setBounds(400, 150, 250, 50);
		
		JPanel grade_panel = new JPanel();
		grade_panel.setBackground(new Color(35, 79, 152));
		grade_panel.add(timeTableLabelgrade);
		gradeField = new JTextField(10);
		gradeField.setBackground(new Color(119, 131, 240));
		gradeField.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
	    gradeField.setForeground(Color.white);
		grade_panel.add(gradeField);
		grade_panel.setBounds(400, 250, 250, 50);
		
		JPanel class_nm_panel = new JPanel();
		class_nm_panel.setBackground(new Color(55, 135, 198));
		class_nm_panel.add(timeTableLabelclass);
		classField = new JTextField(10);
		classField.setBackground(new Color(119, 131, 240));
		classField.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
	    classField.setForeground(Color.white);
		class_nm_panel.add(classField);
		class_nm_panel.setBounds(400, 350, 250, 50);
		
		add(name_panel);
		add(grade_panel);
		add(class_nm_panel);

		add(checkButton);
		checkButton.addActionListener(null);
 		         
      add(loginTablePanel);
  }
  

public void actionPerformed(ActionEvent e) 
  {
		Object obj = e.getSource();
		if(obj == checkButton) 
		{
			nam = nameField.getText();
			grad = gradeField.getText();
			clas = classField.getText();			
		}
	}
  
  
  public void MouseEv()
  {
	  timeTableButton.addMouseListener(new MouseAdapter()
	  {		  
		  @Override public void mousePressed(MouseEvent e)
		  {
			  MainPanel.setVisible(false);
			  
			  loginTablePanel.setVisible(false);
		     
		      TimeTablePanel.setVisible(true);
		      webButton.setVisible(true);
		      
		      nameField.setVisible(false);
		      gradeField.setVisible(false);
		      classField.setVisible(false);
		      
			  timeTableButton.setVisible(false);
			  loginTableButton.setVisible(false);
			  exitButton.setVisible(false);
			  backMainButton.setVisible(true);
		  }
		 
	  });
	  
	  loginTableButton.addMouseListener(new MouseAdapter()
	  {		  
		  @Override public void mousePressed(MouseEvent e)
		  {
			  MainPanel.setVisible(false);
			 
			  loginTablePanel.setVisible(true);
		     
		      TimeTablePanel.setVisible(false);
			  
		      nameField.setVisible(true);
		      gradeField.setVisible(true);
		      classField.setVisible(true);
		      
		      checkButton.setVisible(true);
			  timeTableButton.setVisible(false);
			  loginTableButton.setVisible(false);
			  exitButton.setVisible(false);
			  backMainButton.setVisible(true);
		  }
		 
	  });
	  
	  backMainButton.addMouseListener(new MouseAdapter()
	  {		  
		  @Override public void mousePressed(MouseEvent e)
		  {
			  MainPanel.setVisible(true);
			 
			  loginTablePanel.setVisible(false);
		     
		      TimeTablePanel.setVisible(false);
		      
		      nameField.setVisible(false);
		      gradeField.setVisible(false);
		      classField.setVisible(false);
		     	      
		      webButton.setVisible(false);
		      checkButton.setVisible(false);
			  timeTableButton.setVisible(true);
			  loginTableButton.setVisible(true);
			  exitButton.setVisible(true);
			  backMainButton.setVisible(false);

		  }
		 
	  });
	  
	  exitButton.addMouseListener(new MouseAdapter()
	  {		  
		  @Override public void mousePressed(MouseEvent e)
		  {
			  System.exit(0);
		  }
		 
	  });
  }

  public void ButtonSetting()
  {
	  // 시간표
	  timeTableButton.setLayout(null);
      timeTableButton.setBounds(200, 5, 150, 20);
      timeTableButton.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
      timeTableButton.setBackground(new Color(106, 227, 244));

      
      // 로그인
      loginTableButton.setLayout(null);
      loginTableButton.setBounds(550, 5, 150, 20);
      loginTableButton.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
      loginTableButton.setBackground(new Color(248, 238, 152));
		 
      
      // 돌아가기
      backMainButton.setLayout(null);
      backMainButton.setBounds(550, 5, 150, 20);
      backMainButton.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
      backMainButton.setForeground(Color.white);
      backMainButton.setBackground(new Color(228, 80, 199));
      
      // 종료
      exitButton.setLayout(null);
      exitButton.setBounds(900, 5, 150, 20);
      exitButton.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
      exitButton.setForeground(Color.white);
      exitButton.setBackground(new Color(239, 80, 84));
      
      //확인
      checkButton.setLayout(null);
      checkButton.setBounds(550, 475, 150, 20);
      checkButton.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
      checkButton.setForeground(Color.green);
      checkButton.setBackground(Color.DARK_GRAY);
      
      //웹으로 보기
      webButton.setLayout(null);
      webButton.setBounds(550, 75, 150, 20);
      webButton.setFont(new Font("Pretendard ExtraBold", Font.PLAIN, 15));
      webButton.setForeground(Color.blue);
      webButton.setBackground(Color.white);
   }
    
  
    public static void main(String[] Args)
    {
  	   new Swing();   
    }
}
