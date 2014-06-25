package javaProyectos.uabcs;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener,Operaciones{
	private JButton btn7,btn8,btn9,btnDiv,btn4,btn5,btn6,btnMul,btn1,btn2,btn3,btnSuma,btnResta,btnIgual,btnPunto,btnCero;		
	private StringListener textListener;	
	private String num="";		
	String arreglo[]= new String[15];
	private int i=0;	

	public Toolbar() {
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btnDiv = new JButton("/");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btnMul = new JButton("*");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btnSuma = new JButton("+");
		btnResta = new JButton("-");
		btnCero = new JButton("0");
		btnPunto = new JButton(".");
		btnIgual = new JButton("=");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));		
		setLayout(new GridLayout(4,4,5,5));
		
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);	
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btnResta.addActionListener(this);
		btnSuma.addActionListener(this);
		btnDiv.addActionListener(this);
		btnMul.addActionListener(this);
		btnPunto.addActionListener(this);
		btnIgual.addActionListener(this);
		btnCero.addActionListener(this);
		
		add(btn7);
		add(btn8);
		add(btn9);
		add(btnDiv);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btnMul);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btnSuma);
		add(btnCero);
		add(btnPunto);
		add(btnIgual);
		add(btnResta);		
	}
	
	//recibe una interfaz como parametro
	public void setStringListener(StringListener Listener) {
		this.textListener = Listener;
	}	
	public void actionPerformed(ActionEvent e) {	
		
		//permite saber que boton se clickeo
		JButton clicked = (JButton)e.getSource();
		if(clicked == btn7){				
			if(textListener != null){
				textListener.textEmitted("7");
				 num += ("7");
			}
		}
	    if(clicked == btn8){			
			if(textListener != null){
				textListener.textEmitted("8");
				num += ("8");
			}
		}
	    if(clicked == btn9){
	    	if(textListener != null){
	    		textListener.textEmitted("9");  
	    		num += ("9");
	    	}	
	    }
	    if(clicked == btn4){
	    	if(textListener != null){
	    		textListener.textEmitted("4"); 
	    		num += ("4");
	    	}
	    }
	    if(clicked == btn5){
	    	if(textListener != null){
	    		textListener.textEmitted("5");  
	    		num += ("5");
	    	}
	    }
	    if(clicked == btn6){
	    	if(textListener != null){
	    		textListener.textEmitted("6");  
	    		num += ("6");
	    	}
	    }
	    if(clicked == btn1){
	    	if(textListener != null){
	    		textListener.textEmitted("1"); 
	    		num += ("1");
	    	}
	    }
	    if(clicked == btn2){
	    	if(textListener != null){
	    		textListener.textEmitted("2");  
	    		num += ("2");
	    	}
	    }
	    if(clicked == btn3){
	    	if(textListener != null){
	    		textListener.textEmitted("3"); 
	    		num += ("3");
	    	}
	    }    	    
	    if(clicked == btnPunto){
	    	if(textListener != null){
	    		textListener.textEmitted(".");    
	    		num += (".");
	    	}
	    }
	    
	    if(clicked == btnMul){
	    	if(textListener != null){
	    		textListener.textEmitted("*");
	    		arreglo[i]=num;
		    	i++;
		    	arreglo[i]="*";	    	
		    	i++;
		    	num="";
	    	}
	    }
	    if(clicked == btnDiv){
	    	if(textListener != null){
	    		textListener.textEmitted("/");
	    		arreglo[i]=num;
		    	i++;
		    	arreglo[i]="/";	    	
		    	i++;
		    	num="";
	    	}
	    }
	    if(clicked == btnSuma){
	    	if(textListener != null){
	    		textListener.textEmitted("+");
	    		arreglo[i]=num;
		    	i++;
		    	arreglo[i]="+";	    	
		    	i++;
		    	num="";
	    	}
	    }
	    if(clicked == btnResta){
	    	if(textListener != null){
	    		textListener.textEmitted("-"); 
	    		arreglo[i]=num;
		    	i++;
		    	arreglo[i]="-";	    	
		    	i++;
		    	num="";
	    	}
	    }
	    if(clicked == btnCero){
	    	if(textListener != null){
	    		textListener.textEmitted("0");  
	    		num += ("0");
	    	}
	    }	    
	    if(clicked == btnIgual){
	    	arreglo[i]=num;
	    	String operador;	
	    	int resultado=0;
	    	
	    	i=0;
	    	while(i<arreglo.length){		    	
		    	double num1=0.0;
		    	double num2=0.0;
			    //revela la posicion del operador en el arreglo			    	
	    		int i2=1;
	    		int iPor=0,iDiv=0,iMas=0,iMenos=0;		    	
		    	
	    		while(iPor<arreglo.length && arreglo[iPor]!="*")
	    			iPor++;
	    		while(iDiv<arreglo.length && arreglo[iDiv]!="/")
	    			iDiv++;
	    		while(iMas<arreglo.length && arreglo[iMas]!="+")
	    			iMas++;
	    		while(iMenos<arreglo.length && arreglo[iMenos]!="-")
	    			iMenos++;
	    		
	    		if(iPor<iDiv){
	    			i=iPor;
	    			operador="*";
	    		}
	    		else
	    			if(iPor>iDiv){
	    				i=iDiv;
	    				operador="/";
	    			}
	    			else
	    				if(iMas<iMenos){
	    					i=iMas;
	    					operador="+";
	    				}
	    				else{
	    					i=iMenos;
	    					operador="-";
	    				}	    		
	    		if(i<arreglo.length)
			    	while(arreglo[i+i2]==null){
			    		i2++;
			    	}	   	
		    	
		    	//si i < al tamaño del arreglo quiere dedir que encontro un operador
		    	if(i<arreglo.length && i!=0){
		    		//segun sea al caso del operaodor entra		    		
		    		switch(arreglo[i])
		    		{
		    			case "*":						
		    				num1=Double.parseDouble(arreglo[i-1]); 			 
							num2=Double.parseDouble(arreglo[i+i2]); 
							arreglo[i-1]=null;
							arreglo[i+i2]=null;
							arreglo[i]=null;
							arreglo[i+i2]=String.valueOf(multiplicacion(num1, num2));
							iPor=0;	
							resultado=i+i2;
							break;
		    			case "/":	  				
		    				num1=Double.parseDouble(arreglo[i-1]);
							num2=Double.parseDouble(arreglo[i+i2]); 
							arreglo[i-1]=null;
							arreglo[i+i2]=null;
							arreglo[i]=null;
							arreglo[i+i2]=String.valueOf(division(num1, num2));							
							iDiv=0;
							resultado=i+i2;
							break;
		    			case "+":
		    				
		    				num1=Double.parseDouble(arreglo[i-1]);	    				
							num2=Double.parseDouble(arreglo[i+i2]); 
							
							arreglo[i-1]=null;
							arreglo[i+i2]=null;
							arreglo[i]=null;
							arreglo[i+i2]=String.valueOf(suma(num1, num2));	
							
							iMas=0;
							resultado=i+i2;
							break;
		    			case "-":
		    				
		    				num1=Double.parseDouble(arreglo[i-1]);		    				
							num2=Double.parseDouble(arreglo[i+i2]); 
						
							arreglo[i-1]=null;
							arreglo[i+i2]=null;
							arreglo[i]=null;
							arreglo[i+i2]=String.valueOf(resta(num1, num2));								
							iMenos=0;					
							resultado=i+i2;
							break;
		    		}		    		
		    	}
	    	}	
	    	if(textListener != null){
	    		textListener.textEmitted("\n = ");
	    		textListener.textEmitted(arreglo[resultado]);  
	    	}
	  	 }	    
	}
	@Override
	public double suma(double num1, double num2) {
		// TODO Auto-generated method stub
		return num1+num2;
	}
	@Override
	public double resta(double num1, double num2) {
		// TODO Auto-generated method stub
		return num1-num2;
	}
	@Override
	public double multiplicacion(double num1, double num2) {
		// TODO Auto-generated method stub
		return num1*num2;
	}
	@Override
	public double division(double num1, double num2) {
		// TODO Auto-generated method stub
		return num1/num2;
	}
	
	
}

