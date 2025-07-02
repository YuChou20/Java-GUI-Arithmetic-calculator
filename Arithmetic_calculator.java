import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;
class Mystack<Item> implements Iterable<Item> {
		private int n;
		private Node first;

		private class Node {
			private Item item;
			private Node next;
		}

		public Mystack() {
			first = null;
			n = 0;
		}

		public boolean isEmpty() {
			return first == null;
		}

		public void push(Item item) {
			Node oldFirst = first;
			first = new Node();
			first.item = item;
			first.next = oldFirst;
			n++;
		}

		public Item pop() {
			if (isEmpty()) throw new NoSuchElementException("Stack underflow");
			Item item = first.item;
			first = first.next;
			n--;
			return item;
		}

		public int size() {
			return n;
		}

		public String toString() {
			StringBuilder str = new StringBuilder();
			for (Item item : this) {
				str.append(item);
				str.append(' ');
			}
			return str.toString();
		}

		public Iterator<Item> iterator() {
			return new ListIterator();
		}

		private class ListIterator implements Iterator<Item> {
			private Node current = first;
			public boolean hasNext() {
				return current != null;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
			public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}

public class Arithmetic_calculator{
	 public static double getValue(String exp) {
        Mystack<Double> operands = new Mystack<Double>();
		String str;
        while(exp.length() != 0) {
			str = exp.substring(0,exp.indexOf(" ")+1).trim();
			exp = exp.substring(exp.indexOf(" ")+1,exp.length());
            if (str.trim().equals("")) {
                continue;
            }
            switch (str) {
                case "+":
                case "-":
                case "*":
                case "/":
                    double right = operands.pop();
                    double left = operands.pop();
                    double value = 0;
                    switch(str) {
                        case "+":
                            value = left + right;
                            break;
                        case "-":
                            value = left - right;
                            break;
                        case "*":
                            value = left * right;
                            break;
                        case "/":
                            value = left / right;
                            break;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                default:
                    operands.push(Double.parseDouble(str));
                    break;  
            }
        }
        return operands.pop();
    }
	
    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostFix(String expression){
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <expression.length() - 1 ; i++) {
            char c = expression.charAt(i);
            if(precedence(c) > 0 && expression.charAt(i + 1) == ' '){
                while(stack.isEmpty() == false && precedence(stack.peek())>= precedence(c)){
                    result += " " + stack.pop();
                }
                stack.push(c);
            }else if(c == ')'){
                char x = stack.pop();
                while(x != '('){
                    result += " " + x;
                    x = stack.pop();
                }
            }else if(c =='('){
                stack.push(c);
            }else{
                result += c;
            }
        }
        for (int i = 0; i <= stack.size() ; i++) {
            result += " " + stack.pop();
        }
        return result;
    }
	
	static void addconponent(){
		result.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,30));
		opt.setFont(new Font("Serief",Font.ITALIC+Font.BOLD,30));
		but0.setBounds(110,380,100,60); 
		but1.setBounds(10,320,100,60); 
		but2.setBounds(110,320,100,60); 
		but3.setBounds(210,320,100,60);
		but4.setBounds(10,260,100,60); 
		but5.setBounds(110,260,100,60);  		
		but6.setBounds(210,260,100,60);
		but7.setBounds(10,200,100,60);
		but8.setBounds(110,200,100,60);
		but9.setBounds(210,200,100,60);
		buteq.setBounds(310,380,100,60);
		butadd.setBounds(310,320,100,60);
		butsub.setBounds(310,260,100,60);
		butmul.setBounds(310,200,100,60);
		butdiv.setBounds(310,140,100,60);
		butdel.setBounds(160,140,150,60);
		butclr.setBounds(10,140,150,60);
		result.setBounds(50,80,330,60);
		butneg.setBounds(10,380,100,60);
		butdot.setBounds(210,380,100,60);
		opt.setBounds(20,80,40,60);
		history.setBounds(50,60,330,20);
		frm.add(but0);
		frm.add(but1);
		frm.add(but2);
		frm.add(but3);
		frm.add(but4);
		frm.add(but5);
		frm.add(but6);
		frm.add(but7);
		frm.add(but8);
		frm.add(but9);
		frm.add(buteq);
		frm.add(butadd);
		frm.add(butsub);
		frm.add(butmul);
		frm.add(butdiv);
		frm.add(butdel);
		frm.add(butclr);
		frm.add(result);
		frm.add(butneg);
		frm.add(butdot);
		frm.add(opt);
		frm.add(history);
	}
	
	static void addListener(){
		but0.addActionListener(act);
		but1.addActionListener(act);
		but2.addActionListener(act);
		but3.addActionListener(act);
		but4.addActionListener(act);
		but5.addActionListener(act);
		but6.addActionListener(act);
		but7.addActionListener(act);
		but8.addActionListener(act);
		but9.addActionListener(act);
		butadd.addActionListener(act);
		butsub.addActionListener(act);
		butmul.addActionListener(act);
		butdiv.addActionListener(act);
		butdel.addActionListener(act);
		butclr.addActionListener(act);
		buteq.addActionListener(act);
		butneg.addActionListener(act);
		butdot.addActionListener(act);
	}
	
	static Frame frm = new Frame("Calculator");
	static Button but0 = new Button("0");
	static Button but1 = new Button("1");
	static Button but2 = new Button("2");
	static Button but3 = new Button("3");
	static Button but4 = new Button("4");
	static Button but5 = new Button("5");
	static Button but6 = new Button("6");
	static Button but7 = new Button("7");
	static Button but8 = new Button("8");
	static Button but9 = new Button("9");
	static Button buteq = new Button("=");
	static Button butadd = new Button("+");
	static Button butsub = new Button("-");
	static Button butmul = new Button("*");
	static Button butdiv = new Button("/");
	static Button butclr = new Button("C");
	static Button butdel = new Button("Del");
	static Button butneg = new Button("+ / -");
	static Button butdot = new Button(".");
	static Label  result = new Label("0",Label.RIGHT); 
	static Label opt = new Label("",Label.LEFT); 
	static Label history = new Label("",Label.RIGHT);
	static ActLis act = new ActLis();
	static double temp2 = 0 ;
	static int	mode = 0,lastBut = 0;
	public static void main(String agrs[]){
		frm.setLayout(null);
		frm.setResizable(false);
		frm.setLocation(450,150);      
		frm.setSize(420,450);
		frm.setVisible(true);
		addconponent();
		addListener();
		frm.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent event) {System.exit(0);
			}
		}
	    );
	}
	static class ActLis implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         Button btn=(Button) e.getSource();
		 int buttemp = lastBut;
		 lastBut = 0;
		 if (btn == but0){
			 if (result.getText().charAt(0) != '0' || result.getText().length() > 1){			
				result.setText(result.getText() + "0");
			 }
		 }
		 else if (btn == but1){
			 if (result.getText().charAt(0) != '0' || result.getText().length() > 1 ){
				result.setText(result.getText() + "1");
			 }
			 else{
				 result.setText("1");
			 }
		 }
		 else if (btn == but2){
			 if (result.getText().charAt(0) != '0' || result.getText().length() > 1){
				result.setText(result.getText() + "2");
			 }
			 else{
				 result.setText("2");
			 }
		 }
		 else if (btn == but3){
			 if (result.getText().charAt(0) != '0' || result.getText().length() > 1){
				result.setText(result.getText() + "3");
			 }
			 else{
				 result.setText("3");
			 }
		 }
		 else if (btn == but4){
			if (result.getText().charAt(0) != '0' || result.getText().length() > 1){
				result.setText(result.getText() + "4");
			 }
			 else{
				 result.setText("4");
			 }
		 }
		 else if (btn == but5){
			 if (result.getText().charAt(0) != '0' || result.getText().length() > 1){
				result.setText(result.getText() + "5");
			 }
			 else{
				 result.setText("5");
			 }
		 }
		 else if (btn == but6){
			if (result.getText().charAt(0) != '0' || result.getText().length() > 1){
				result.setText(result.getText() + "6");
			 }
			 else{
				 result.setText("6");
			 }
		 }
		 else if (btn == but7){
			 if (result.getText().charAt(0) != '0' || result.getText().length() > 1){
				result.setText(result.getText() + "7");
			 }
			 else{
				 result.setText("7");
			 }
		 }
		else if (btn == but8){
			if (result.getText().charAt(0) != '0' || result.getText().length() > 1){
				result.setText(result.getText() + "8");
			}
			else{
				result.setText("8");
			}
		}
		else if (btn == but9){
			if (result.getText().charAt(0) != '0' || result.getText().length() > 1){
				result.setText(result.getText() + "9");
			}
			else{
				result.setText("9");
			}
		}
		else if (btn == butdel){
			String temp = result.getText();
			if(temp.length() > 1 ){
				if (temp.charAt(0) == '-' && temp.length() == 2){
					result.setText("0");
				}
				else{
					result.setText( result.getText().substring(0,temp.length() -1));
				}
			}else{
				result.setText("0");
			}
		}
		else if (btn == butclr){
			opt.setText("");
			result.setText("0");
			history.setText("");
			temp2 = 0;
		}
		else if (btn == buteq){
			if (mode == 0){
				String optm = opt.getText();
				opt.setText("");
				temp2 = Double.parseDouble(result.getText());
				mode = 1;
				if ( temp2 % 1 == 0){
					if (temp2 >= 0){
						history.setText(history.getText() + " " + (int)temp2 + " = " );
					}
					else{
						history.setText(history.getText() + " ( " + (int)temp2 + " ) = " );
					}
				}
				else{
					if ( temp2 >= 0 ){
						history.setText(history.getText() + " " + temp2 + " = " );
					}
					else{
						history.setText(history.getText() + " ( " + temp2 + " ) = " );
					}
				}
				double ans = getValue(infixToPostFix(history.getText().substring(0,history.getText().length()-2)) + " " );
				if ( ans %1 == 0 ){
						long res = (int)(ans);
						result.setText(Long.toString(res));
				}
				else{
					result.setText(Double.toString(ans));
				}
				temp2 = 0;
			}
		}else if(btn == butneg){
			if (result.getText().charAt(0) != '-'){
				if (!(result.getText().length() == 1 && result.getText().charAt(0) == '0')){
					result.setText("-"+result.getText());
				}
			}
			else{
				result.setText(result.getText().substring(1,result.getText().length()));
			}
		}
		else if(btn == butdot){
			if ( result.getText().indexOf(".") < 0){
				result.setText(result.getText() + ".");
			}
		}
		else {
			String optm = opt.getText();
			temp2 = Double.parseDouble(result.getText());
			if (btn == butadd){
				opt.setText("+");
			}
			else if (btn == butsub){
				opt.setText("-");
			}
			else if (btn == butmul){
				opt.setText("*");
			}
			else if (btn == butdiv){
				opt.setText("/");
			}
			result.setText("0");
			optm = opt.getText();
			if (mode == 1){
				mode = 0;
				history.setText("");
			}
			if (buttemp == 0){
				if(history.getText().length() != 0){
					if ( temp2 % 1 == 0){
						if ( temp2 > 0){
							history.setText(history.getText() + " " + (int)temp2 + " " + optm );
						}
						else{
							history.setText(history.getText() + " ( " + (int)temp2 + " ) " + optm );
						}
					}
					else{
						if ( temp2 > 0){
							history.setText(history.getText() + " " + temp2 + " " + optm );
						}else{
							history.setText(history.getText() + " ( " + temp2 + " ) " + optm );
						}
					}
				}
				else{
					if ( temp2 % 1 == 0){
						if ( temp2 > 0){
							history.setText((int)temp2 + " " + optm);
						}
						else{
							history.setText("( " + (int)temp2 + " ) " + optm);
						}
					}
					else{
						if ( temp2 > 0 ){
							history.setText(temp2 + " " + optm);
						}
						else{
							history.setText("( " + temp2 + " ) " + optm);
						}
					}
				}		
			}
			else{
				history.setText(history.getText().substring(0,history.getText().length() -1) + optm );
			}
			lastBut = 1;
		}
      }
   }
}