package ro.tuc;
import java.util.Collections;
import java.util.TreeMap;
public class PolinomOperation
{
    public Polinom addition(Polinom p1,Polinom p2 )
    {
        Polinom aux=new Polinom();
        Monom aux2=new Monom();


        for (Integer i : p1.hMap.keySet())
        {

            aux2.exponent=i;
            aux2.coeficient=p1.hMap.get(i);
            if( p2.hMap.containsKey(i)==true)
            {
                aux2.coeficient+= p2.hMap.get(i);
                aux.insert(aux2);
            }
            else
            {
                aux.insert(aux2);
            }
        }

        for (Integer i : p2.hMap.keySet())
        {
            if(aux.hMap.containsKey(i)==false)
            {
                aux2.exponent=i;
                aux2.coeficient=p2.hMap.get(i);
                aux.insert(aux2);
            }
        }

        return aux;


    }


    public Polinom subtraction(Polinom p1,Polinom p2 )
    {
        Polinom aux=new Polinom();
        Monom aux2=new Monom();


        for (Integer i : p1.hMap.keySet())
        {

            aux2.exponent=i;
            aux2.coeficient=p1.hMap.get(i);
            if( p2.hMap.containsKey(i)==true)
                aux2.coeficient-= p2.hMap.get(i);
            aux.insert(aux2);
        }
        for (Integer i : p2.hMap.keySet())
        {
            if(aux.hMap.containsKey(i)==false)
            {
                aux2.exponent=i;
                aux2.coeficient=p2.hMap.get(i)*-1;
                aux.insert(aux2);
            }
        }

        return aux;

    }


    public Polinom multiplication(Polinom p1,Polinom p2 )
    {
        Polinom aux=new Polinom();
        Monom aux2=new Monom();


        for (Integer i : p1.hMap.keySet())
        {
            for (Integer ii : p2.hMap.keySet())
            {
                aux2.exponent=i+ii;
                aux2.coeficient=p2.hMap.get(ii)*p1.hMap.get(i);
                if(aux.hMap.containsKey(aux2.exponent)==false)
                {
                    aux.insert(aux2);
                }
                else
                {
                    aux2.coeficient+= aux.hMap.get(aux2.exponent);
                    aux.insert(aux2);

                }
            }
        }


        return aux;

    }


    public Polinom division(Polinom p1,Polinom p2 )
    {
        PolinomOperation op=new PolinomOperation();

        Polinom aux=new Polinom();

        Polinom rez=new Polinom();

        Polinom p=new Polinom();

        Monom aux2=new Monom();


        //trick
        TreeMap<Integer, Float> tree1=new TreeMap<Integer, Float>(Collections.reverseOrder());
        tree1.putAll(p1.hMap);

        TreeMap<Integer, Float> tree2=new TreeMap<Integer, Float>(Collections.reverseOrder());
        tree2.putAll(p2.hMap);


        while( tree1.firstKey() >= tree2.firstKey() )
        {

            aux2.coeficient= tree1.get(tree1.firstKey()) / tree2.get(tree2.firstKey());

            aux2.exponent= tree1.firstKey() - tree2.firstKey();

            rez.insert(aux2);

            p=op.multiplication(rez,p2);
            p=p.not();
            p=op.addition(p, p1);

            for (Integer i : p.hMap.keySet())
            {
                if(p.hMap.get(i)!=0)
                    aux.hMap.put(i,p.hMap.get(i));
            }
            p.hMap.clear();
            p.hMap.putAll(aux.hMap);

            p1.hMap.clear();
            p1.hMap.putAll(p.hMap);
            tree1.clear();
            tree1.putAll(p1.hMap);



            if(tree1.isEmpty()==false)
                break;

        }

        if(p1.hMap.isEmpty()==false)
        {
            p2=p2.inv();

            for (Integer i : tree1.keySet())
            {
                for (Integer ii : p2.hMap.keySet())
                {
                    aux2.exponent=i+ii;
                    aux2.coeficient=tree1.get(i)/p2.hMap.get(ii);

                    if(rez.hMap.containsKey(aux2.exponent)==false)
                    {
                        rez.insert(aux2);
                    }
                    else
                    {
                        aux2.coeficient+= rez.hMap.get(aux2.exponent);
                        rez.insert(aux2);
                    }
                }
            }
        }


        p.hMap.clear();
        p.hMap.putAll(rez.hMap);
        rez.hMap.clear();
        for (Integer i : p.hMap.keySet())
        {
            if(p.hMap.get(i)!=0)
                rez.hMap.put(i,p.hMap.get(i));
        }

        return rez;

    }


    public Polinom derivation(Polinom p1 )
    {
        Polinom aux=new Polinom();
        Monom aux2=new Monom();


        for (Integer i : p1.hMap.keySet())
        {
            if(aux.hMap.containsKey(i)==false)
            {
                aux2.exponent=i-1;
                aux2.coeficient=p1.hMap.get(i)*i;
                aux.insert(aux2);
            }
            else
            {
                aux2.coeficient+= aux.hMap.get(aux2.exponent);
                aux.insert(aux2);
            }
        }

        return aux;

    }


    public Polinom integration(Polinom p1 )
    {
        Polinom aux=new Polinom();
        Monom aux2=new Monom();


        for (Integer i : p1.hMap.keySet())
        {
            if(aux.hMap.containsKey(i+1)==false)
            {
                aux2.exponent=i+1;
                aux2.coeficient=(p1.hMap.get(i))/(i+1);
                aux.insert(aux2);
            }
            else
            {
                aux2.coeficient+= aux.hMap.get(aux2.exponent);
                aux.insert(aux2);
            }
        }


        return aux;

    }



}
