import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class calculator extends JFrame implements ActionListener {
	// Create JFrame
	static JFrame f;

	// Create calculator text field
	static JTextField l;

	// Store operater and operands
	String s0, s1, s2;

	calculator() {
		s0 = s1 = s2 = "";
	}

	public static void main(String args[]) {
		f = new JFrame("Calculator");

		try {
			// Set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// Create a object of class
		calculator c = new calculator();
		l = new JTextField(18);
		l.setEditable(false);

		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;

		// Number buttons
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		// Equal button
		beq1 = new JButton("=");

		// Operator buttons
		ba = new JButton("+");
		bs = new JButton("-");
		bd = new JButton("/");
		bm = new JButton("*");
		beq = new JButton("C");

		// Dot button
		be = new JButton(".");

		// Create calculator panel
		JPanel p = new JPanel();

		// Add action listeners
		bm.addActionListener(c);
		bd.addActionListener(c);
		bs.addActionListener(c);
		ba.addActionListener(c);
		b9.addActionListener(c);
		b8.addActionListener(c);
		b7.addActionListener(c);
		b6.addActionListener(c);
		b5.addActionListener(c);
		b4.addActionListener(c);
		b3.addActionListener(c);
		b2.addActionListener(c);
		b1.addActionListener(c);
		b0.addActionListener(c);
		be.addActionListener(c);
		beq.addActionListener(c);
		beq1.addActionListener(c);

		// Add elements to panel
		p.add(l);
		p.add(ba);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(bs);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bm);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bd);
		p.add(be);
		p.add(b0);
		p.add(beq);
		p.add(beq1);

		// Set background color of panel
		p.setBackground(Color.blue);

		// Add panel to frame
		f.add(p);

		f.setSize(200, 220);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();

		// Check if the value is a number
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
				// Check if operand is present then add to second no
				if (!s1.equals(""))
						s2 = s2 + s;
				else
						s0 = s0 + s;

				// Set the value of text
				l.setText(s0 + s1 + s2);
		}

		// If the value is an operator
		else if (s.charAt(0) == 'C') {
				// Clear the one letter
				s0 = s1 = s2 = "";

				// Set the value of text
				l.setText(s0 + s1 + s2);
		} else if (s.charAt(0) == '=') {

				double te;

				// Store the value in 1st
				if (s1.equals("+"))
						te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
						te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
						te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
						te = (Double.parseDouble(s0) * Double.parseDouble(s2));

				// Set the value of text
				l.setText(s0 + s1 + s2 + "=" + te);

				// Convert it to string
				s0 = Double.toString(te);

				s1 = s2 = "";
		} else {
				// If there was no operand
				if (s1.equals("") || s2.equals(""))
						s1 = s;
				// Else evaluate
				else {
						double te;

						// Store the value in 1st
						if (s1.equals("+"))
								te = (Double.parseDouble(s0) + Double.parseDouble(s2));
						else if (s1.equals("-"))
								te = (Double.parseDouble(s0) - Double.parseDouble(s2));
						else if (s1.equals("/"))
								te = (Double.parseDouble(s0) / Double.parseDouble(s2));
						else
								te = (Double.parseDouble(s0) * Double.parseDouble(s2));

						// Convert it to string
						s0 = Double.toString(te);

						// Place the operator
						s1 = s;

						// Make the operand blank
						s2 = "";
				}

				// Set the value of text
				l.setText(s0 + s1 + s2);
		}
	}

}