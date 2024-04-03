package ro.tuc;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Polinom {

    HashMap<Integer, Float> hMap = new HashMap<>();
    boolean isValid = true;


    Polinom() {
    }


    Polinom(String input) {
        String reg = new String("([-+]?[0-9]+)\\*x\\^([-+]?[0-9]+)");

        String[] terms = input.split("[+-]");


        for (String term : terms) {
            if (!Pattern.matches(reg, term)) {
                isValid = false;
                break;
            }
        }
        /*
        if (isValid == false) {
            System.out.println("Input is wrong");
        }
        */



        if (isValid == true) {
            Pattern ptrn = Pattern.compile(reg);
            Matcher mtch = ptrn.matcher(input);
            Monom aux = new Monom();

            while (mtch.find()) {
                String auxCoef = mtch.group(1);
                String auxExp = mtch.group(2);

                Float coef = Float.parseFloat(auxCoef);
                Integer exp = Integer.valueOf(auxExp);

                aux.coeficient = coef;
                aux.exponent = exp;
                this.hMap.put(exp, coef);
            }
        }
    }


    public Polinom not() {
        Polinom aux = new Polinom();
        Monom aux2 = new Monom();

        for (Integer i : this.hMap.keySet()) {
            aux2.exponent = i;
            aux2.coeficient = this.hMap.get(i) * -1;
            aux.insert(aux2);
        }
        return aux;
    }

    public Polinom inv() {
        Polinom aux = new Polinom();
        Monom aux2 = new Monom();

        for (Integer i : this.hMap.keySet()) {
            aux2.exponent = i * -1;
            aux2.coeficient = this.hMap.get(i);
            aux.insert(aux2);
        }
        return aux;
    }

    public void insert(Monom m) {
        this.hMap.put(m.exponent, m.coeficient);
    }

    public String toString()
    {

        TreeMap<Integer, Float> tree=new TreeMap<Integer, Float>(Collections.reverseOrder());
        tree.putAll(this.hMap);

        Integer aux;
        String rez=new String("");


        boolean ok=true;
        for (Integer i : tree.keySet())
        {

            aux=Math.round(tree.get(i));

            if(tree.get(i)-aux!=0)
            {
                if(ok)
                {
                    if(i==0)
                        rez+=Float.toString(tree.get(i));
                    else if(this.hMap.get(i)==0)
                        rez+='0';
                    else
                        rez+=Float.toString(this.hMap.get(i))+"*x^"+Integer.toString(i);
                    //System.out.print(this.hMap.get(i)+"*x^"+i);
                }

                else
                {
                    if(i==0)
                        rez+=" + "+Float.toString(this.hMap.get(i));
                        //System.out.print(" + "+this.hMap.get(i));
                    else if(this.hMap.get(i)==0)
                        rez+=" +  0";
                        //System.out.print(" + "+0);
                    else
                        rez+=" + "+Float.toString(this.hMap.get(i))+"*x^"+Integer.toString(i);
                    //System.out.print(" + "+this.hMap.get(i)+"*x^"+i);
                }
                ok=false;
            }
            else
            {

                if(ok)
                {
                    if(i==0)
                        rez+=Integer.toString(aux);
                    else if(aux==0)
                        rez+='0';
                    else
                        rez+=Integer.toString(aux)+"*x^"+Integer.toString(i);
                    //System.out.print(aux+"*x^"+i);
                }

                else
                {
                    if(i==0)
                        rez+=" + "+Integer.toString(aux);
                        //System.out.print(" + "+aux);
                    else if(this.hMap.get(i)==0)
                        //System.out.print(" + "+0);
                        rez+=" +  0";
                    else
                        rez+=" + "+Integer.toString(aux)+"*x^"+Integer.toString(i);
                    //	System.out.print(" + "+aux+"*x^"+i);
                }
                ok=false;

            }
        }
        return rez;
    }
    public void toString2() {

        TreeMap<Integer, Float> tree = new TreeMap<Integer, Float>(Collections.reverseOrder());
        tree.putAll(this.hMap);

        Integer aux;


        boolean ok = true;
        for (Integer i : tree.keySet()) {

            aux = Math.round(tree.get(i));

            if (tree.get(i) - aux != 0) {
                if (ok) {
                    if (i == 0)
                        System.out.print(tree.get(i));
                    else if (this.hMap.get(i) == 0)
                        System.out.print(0);
                    else
                        System.out.print(this.hMap.get(i) + "*x^" + i);
                } else {
                    if (i == 0)
                        System.out.print(" + " + this.hMap.get(i));
                    else if (this.hMap.get(i) == 0)
                        System.out.print(" + " + 0);
                    else
                        System.out.print(" + " + this.hMap.get(i) + "*x^" + i);
                }
                ok = false;
            } else {

                if (ok) {
                    if (i == 0)
                        System.out.print(aux);
                    else if (aux == 0)
                        System.out.print(0);
                    else
                        System.out.print(aux + "*x^" + i);
                } else {
                    if (i == 0)
                        System.out.print(" + " + aux);
                    else if (this.hMap.get(i) == 0)
                        System.out.print(" + " + 0);
                    else
                        System.out.print(" + " + aux + "*x^" + i);
                }
                ok = false;

            }
        }

        System.out.println();
    }
}
