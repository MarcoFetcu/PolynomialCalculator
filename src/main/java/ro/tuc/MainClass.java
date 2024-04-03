package ro.tuc;

public class MainClass
{
    public static void main(String[] args)
    {

        Polinom p4=new Polinom("5*x^4");
        Polinom p5=new Polinom("1*x^1+4*x^0");


        PolinomOperation operation=new PolinomOperation();

        Polinom p6=operation.addition(p4,p5);
        p6.toString2();

    }
}
