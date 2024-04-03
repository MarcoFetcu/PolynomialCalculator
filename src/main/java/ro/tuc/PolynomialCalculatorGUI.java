package ro.tuc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolynomialCalculatorGUI extends JFrame
{
    private JPanel mainPanel;
    private JLabel TitleLabel;
    private JTextField Polinom1TextField;
    private JTextField Polinom2TextField;
    private JButton Addition;
    private JButton Subtraction;
    private JButton Multiplication;
    private JButton Division;
    private JTextArea ResultTextArea;
    private JLabel Polinom1Label;
    private JLabel Polinom2Label;
    private JButton Derivation;
    private JButton Integration;

    public  PolynomialCalculatorGUI(String title)
    {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        Addition.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Polinom p1= new Polinom(Polinom1TextField.getText());
                Polinom p2= new Polinom(Polinom2TextField.getText());
                if(p1.isValid==false || p2.isValid==false)
                {
                    ResultTextArea.setText("Wrong Input");
                }
                else
                {
                    PolinomOperation op=new  PolinomOperation();
                    Polinom rez= new Polinom();
                    rez=op.addition(p1,p2);
                    ResultTextArea.setText(rez.toString());
                }

            }
        });
        Subtraction.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Polinom p1= new Polinom(Polinom1TextField.getText());
                Polinom p2= new Polinom(Polinom2TextField.getText());
                if(p1.isValid==false || p2.isValid==false)
                {
                    ResultTextArea.setText("Wrong Input");
                }
                else
                {
                    PolinomOperation op=new  PolinomOperation();
                    Polinom rez= new Polinom();
                    rez=op.subtraction(p1,p2);
                    ResultTextArea.setText(rez.toString());
                }

            }
        });
        Multiplication.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Polinom p1= new Polinom(Polinom1TextField.getText());
                Polinom p2= new Polinom(Polinom2TextField.getText());
                if(p1.isValid==false || p2.isValid==false)
                {
                    ResultTextArea.setText("Wrong Input");
                }
                else
                {
                    PolinomOperation op=new  PolinomOperation();
                    Polinom rez= new Polinom();
                    rez=op.multiplication(p1,p2);
                    ResultTextArea.setText(rez.toString());
                }
            }
        });
        Division.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Polinom p1= new Polinom(Polinom1TextField.getText());
                Polinom p2= new Polinom(Polinom2TextField.getText());
                if(p1.isValid==false || p2.isValid==false)
                {
                    ResultTextArea.setText("Wrong Input");
                }
                else
                {
                    PolinomOperation op=new  PolinomOperation();
                    Polinom rez= new Polinom();
                    rez=op.division(p1,p2);
                    ResultTextArea.setText(rez.toString());
                }
            }
        });
        Derivation.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Polinom p1= new Polinom(Polinom1TextField.getText());

                if(p1.isValid==false )
                {
                    ResultTextArea.setText("Wrong Input");
                }
                else
                {
                    PolinomOperation op=new  PolinomOperation();
                    Polinom rez= new Polinom();
                    rez=op.derivation(p1);
                    ResultTextArea.setText(rez.toString());
                }

            }
        });
        Integration.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Polinom p1= new Polinom(Polinom1TextField.getText());

                if(p1.isValid==false )
                {
                    ResultTextArea.setText("Wrong Input");
                }
                else
                {
                    PolinomOperation op=new  PolinomOperation();
                    Polinom rez= new Polinom();
                    rez=op.integration(p1);
                    ResultTextArea.setText(rez.toString());
                }
            }
        });
    }



    public static void main(String[] args)
    {

        JFrame frame=new PolynomialCalculatorGUI("My PolynomialCalculator");
        frame.setVisible(true);
    }
}

