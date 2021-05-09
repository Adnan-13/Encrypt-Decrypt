package SourceCodes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class EncryptDecrypt
{

	private JFrame frmEncrytDecrypt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					EncryptDecrypt window = new EncryptDecrypt();
					window.frmEncrytDecrypt.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EncryptDecrypt()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmEncrytDecrypt = new JFrame();
		frmEncrytDecrypt.setResizable(false);
		frmEncrytDecrypt.setTitle("Encryt Decrypt");
		frmEncrytDecrypt.setBounds(100, 100, 1004, 467);
		frmEncrytDecrypt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEncrytDecrypt.getContentPane().setLayout(null);
		
		JTextArea textAreaInput = new JTextArea();
		textAreaInput.setWrapStyleWord(true);
		textAreaInput.setLineWrap(true);
		textAreaInput.setBounds(29, 42, 405, 227);
		frmEncrytDecrypt.getContentPane().add(textAreaInput);
		
		JTextArea textAreaOutput = new JTextArea();
		textAreaOutput.setEditable(false);
		textAreaOutput.setLineWrap(true);
		textAreaOutput.setBounds(551, 42, 405, 227);
		frmEncrytDecrypt.getContentPane().add(textAreaOutput);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setBounds(140, 11, 156, 25);
		frmEncrytDecrypt.getContentPane().add(lblInput);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOutput.setBounds(700, 11, 156, 25);
		frmEncrytDecrypt.getContentPane().add(lblOutput);
		
		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					String input = textAreaInput.getText();
					
					String output = "";
					
					for(int i = 0; i < input.length(); i++)
					{
					    output += Integer.toHexString((int)input.charAt(i)).toUpperCase() + " ";
					}
					
					textAreaOutput.setText(output);
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, "Invalid Input");
				}
			}
		});
		btnEncrypt.setBounds(258, 321, 176, 64);
		frmEncrytDecrypt.getContentPane().add(btnEncrypt);
		
		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String input = textAreaInput.getText();
					
					String output = "";
					
					StringTokenizer st = new StringTokenizer(input, " ");
					
					String s = "";
					
					while(st.hasMoreTokens())
					{
					    s = st.nextToken();
					    
					    output += (char)Integer.parseInt(s, 16);
					}
					
					textAreaOutput.setText(output);
				}
				catch (NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Invalid Input");
				}
				
			}
		});
		btnDecrypt.setBounds(551, 321, 176, 64);
		frmEncrytDecrypt.getContentPane().add(btnDecrypt);
	}
}
