package ro.tuc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest
{
    @Test
    public void addTest1()
    {
        Polinom p1=new Polinom("5*x^6+3*x^4");
        Polinom p2=new Polinom("2*x^1+5*x^6-3*x^3");
        PolinomOperation operation=new PolinomOperation();
        Polinom p3=new Polinom();
        p3=operation.addition(p1, p2);
        String s=p3.toString();

        assertEquals(s, "10*x^6 + 3*x^4 + -3*x^3 + 2*x^1");

    }
    @Test
    public void addWrongTest1()
    {
        Polinom p1=new Polinom("5*x^6+3*x^4");
        Polinom p2=new Polinom("2*x^1+5*x^6-3*x^3");
        PolinomOperation operation=new PolinomOperation();
        Polinom p3=new Polinom();
        p3=operation.addition(p1, p2);
        String s=p3.toString();

        assertEquals(s, "10*x^6 + 3*x^4 + 3*x^3 + 2*x^1");

    }

    @Test
    public void subTest1()
    {
        Polinom p1=new Polinom("7*x^4+2*x^2");
        Polinom p2=new Polinom("5*x^4-5*x^6+3*x^2");
        PolinomOperation operation=new PolinomOperation();
        Polinom p3=new Polinom();
        p3=operation.subtraction(p1, p2);
        String s=p3.toString();

        assertEquals(s,"5*x^6 + 2*x^4 + -1*x^2");
    }
    @Test
    public void subWrongTest1()
    {
        Polinom p1=new Polinom("7*x^4+2*x^2");
        Polinom p2=new Polinom("5*x^4-5*x^6+3*x^2");
        PolinomOperation operation=new PolinomOperation();
        Polinom p3=new Polinom();
        p3=operation.subtraction(p1, p2);
        String s=p3.toString();

        assertEquals(s, "-5*x^6 + 2*x^4 + -1*x^2");

    }

    @Test
    public void mulTest1()
    {
        Polinom p1=new Polinom("3*x^3+2*x^2");
        Polinom p2=new Polinom("2*x^1+3*x^2");
        PolinomOperation operation=new PolinomOperation();
        Polinom p3=new Polinom();
        p3=operation.multiplication(p1, p2);
        String s=p3.toString();

        assertEquals(s,"9*x^5 + 12*x^4 + 4*x^3");
    }
    @Test
    public void mulWrongTest1()
    {
        Polinom p1=new Polinom("3*x^3+2*x^2");
        Polinom p2=new Polinom("2*x^1+3*x^2");
        PolinomOperation operation=new PolinomOperation();
        Polinom p3=new Polinom();
        p3=operation.multiplication(p1, p2);
        String s=p3.toString();

        assertEquals(s,"9*x^5 + 12*x^4 + 7*x^3");

    }

    @Test
    public void divTest1()
    {
        Polinom p1=new Polinom("6*x^6+9*x^4");
        Polinom p2=new Polinom("3*x^2");
        PolinomOperation operation=new PolinomOperation();
        Polinom p3=new Polinom();
        p3=operation.division(p1, p2);
        String s=p3.toString();

        assertEquals(s,"2*x^4 + 3*x^2");
    }
    @Test
    public void divTest2()
    {
        Polinom p1=new Polinom("1*x^3+1*x^2");
        Polinom p2=new Polinom("1*x^2+1*x^1-2*x^0");
        PolinomOperation operation=new PolinomOperation();
        Polinom p3=new Polinom();
        p3=operation.division(p1, p2);
        String s=p3.toString();

        assertEquals(s,"2 + 2*x^-1");
    }

    @Test
    public void divWrongTest1()
    {
        Polinom p1=new Polinom("1*x^3+1*x^2");
        Polinom p2=new Polinom("1*x^2+1*x^1-2*x^0");
        PolinomOperation operation=new PolinomOperation();
        Polinom p3=new Polinom();
        p3=operation.division(p1, p2);
        String s=p3.toString();

        assertEquals(s,"2 + 2*x^1");
    }

    @Test
    public void derivTest1()
    {
        Polinom p1=new Polinom("6*x^6+9*x^4");
        PolinomOperation operation=new PolinomOperation();
        Polinom p2=new Polinom();
        p2=operation.derivation(p1);
        String s=p2.toString();

        assertEquals(s,"36*x^5 + 36*x^3");
    }

    @Test
    public void derivWrongTest1()
    {
        Polinom p1=new Polinom("6*x^6+9*x^4");
        PolinomOperation operation=new PolinomOperation();
        Polinom p2=new Polinom();
        p2=operation.derivation(p1);
        String s=p2.toString();

        assertEquals(s,"36*x^5 + 36*x^4");
    }

    @Test
    public void integrTest1()
    {
        Polinom p1=new Polinom("8*x^3+9*x^2");
        PolinomOperation operation=new PolinomOperation();
        Polinom p2=new Polinom();
        p2=operation.integration(p1);
        String s=p2.toString();

        assertEquals(s,"2*x^4 + 3*x^3");
    }

    @Test
    public void integrTest2()
    {
        Polinom p1=new Polinom("4*x^4+5*x^9");
        PolinomOperation operation=new PolinomOperation();
        Polinom p2=new Polinom();
        p2=operation.integration(p1);
        String s=p2.toString();

        assertEquals(s,"0.5*x^10 + 0.8*x^5");
    }

    @Test
    public void integrWrongTest1()
    {
        Polinom p1=new Polinom("4*x^4+5*x^9");
        PolinomOperation operation=new PolinomOperation();
        Polinom p2=new Polinom();
        p2=operation.derivation(p1);
        String s=p2.toString();

        assertEquals(s,"0.5*x^10 + 0.79*x^5");
    }




}
