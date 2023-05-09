import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Chatbot extends JFrame 
{
	private JTextArea ca= new JTextArea();
	private JTextField cf= new JTextField();
	private JButton b = new JButton();
	private JLabel l = new JLabel();
	
	Chatbot(){
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(800,800);
		f.getContentPane().setBackground(Color.cyan);
		f.setTitle("ChatBot");
		f.add(ca);
		f.add(cf);
		ca.setSize(700,700);
		ca.setLocation(1,1);
		ca.setBackground(Color.black);
		cf.setSize(600,20);
		cf.setLocation(1,720);
		f.add(b);
		l.setText("SEND");
		b.add(l);
		b.setSize(100,20);
		b.setLocation(600,720);
		ca.setForeground(Color.green);
		replyMeth("hi I am LibraGenie Your vitual librarian ");
		replyMeth("if you would like to issue / return a book type 'issue' / 'return' ");
		replyMeth("if you would like to add a book or enter student details type 'addbook' / 'addstudent' ");
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==b)
				{
					String text= cf.getText().toLowerCase();
					ca.setForeground(Color.green);
					ca.append("YOU-->"+text+"\n");
					cf.setText("");
					
					if(text.contains("hi"))
                                        {
                                            replyMeth("hi I am LibraGenie Your vitual librarian ");
		                            replyMeth("if you would like to issue / return a book type 'issue' / 'return' ");
		                            replyMeth("if you would like to add a book or enter student details type 'addbook' / 'addstudent' "); 
                                            replyMeth("If you would like to search for a book please type 'search'");
                                        }
                                        
					else if(text.contains("issue"))
                                        {
						new IssueBook().setVisible(true);
                                                replyMeth("here you can issue a book");
                                        }
					else if(text.contains("return"))
                                        {
						new ReturnBook().setVisible(true);
                                                replyMeth("here you can return a book");
                                        }
					else if(text.contains("addbook"))
                                        {
						new AddBook().setVisible(true);
                                                replyMeth("here you can add a new book to the library");
                                        }
					else if(text.contains("addstudent"))
                                        {
						new AddStudent().setVisible(true);
                                                replyMeth("here you can create a new student record");
                                        }
					else if(text.contains("search"))
                                        {
                                                new IssueBook().setVisible(true);
						replyMeth("Here please type the book_id of the book you are looking for");
                                        }
					else 
						replyMeth("I Can't Understand");
				}
				
			}
		});
		
	}
	public void replyMeth(String s) {
		ca.append("Libragenie-->"+s+"\n");
	}
			
}

public class ChatbotDemo {

	public static void main(String[] args) {
		new Chatbot().setVisible(true);

	}

}