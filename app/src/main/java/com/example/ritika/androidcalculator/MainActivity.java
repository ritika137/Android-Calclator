package com.example.ritika.androidcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {

    private Button number1;
    private Button number2;
    private Button number3;
    private Button number4;
    private Button number5;
    private Button number6;
    private Button number7;
    private Button number8;
    private Button number9;
    private Button number0;
    private Button add;
    private Button subtract;
    private Button divide;
    private Button multiply;
    private Button equalsto;
    private Button delete;
    private Button dot;
    private int numberOfOperators1;

    private static EditText textboxMain;
    private static EditText textboxSec;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (Button) findViewById(R.id.number1);
        number2 = (Button) findViewById(R.id.number2);
        number3 = (Button) findViewById(R.id.number3);
        number4 = (Button) findViewById(R.id.number4);
        number5 = (Button) findViewById(R.id.number5);
        number6 = (Button) findViewById(R.id.number6);
        number7 = (Button) findViewById(R.id.number7);
        number8 = (Button) findViewById(R.id.number8);
        number9 = (Button) findViewById(R.id.number9);
        number0 = (Button) findViewById(R.id.number0);
        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        equalsto = (Button) findViewById(R.id.equalsto);
        delete = (Button) findViewById(R.id.delete);
        dot = (Button) findViewById(R.id.dot);

        textboxMain = (EditText) findViewById(R.id.TextBox1);
        textboxSec = (EditText) findViewById(R.id.TextBox2);
        textboxMain.setText("");
        textboxSec.setText("");
        textboxMain.setHorizontallyScrolling(true);
        //float size = textboxMain.getTextSize();
        //textboxSec.setText(Float.toString(size));

        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        number0.setOnClickListener(this);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        delete.setOnClickListener(this);
        equalsto.setOnClickListener(this);
        dot.setOnClickListener(this);
        delete.setOnLongClickListener(this);




    }

    @Override
    public void onClick(View v) {

        if(v==number0)
        {
            afterCalculation();
            setTheTextnumber("0");
            textboxSec.setText(finalCalculation());
        }
        else if (v==number1)
        {
            afterCalculation();
            setTheTextnumber("1");
            textboxSec.setText(finalCalculation());
        }
        else if (v==number2)
        {
            afterCalculation();
            setTheTextnumber("2");
            textboxSec.setText(finalCalculation());
        }
        else if (v==number3)
        {
            afterCalculation();
            setTheTextnumber("3");
            textboxSec.setText(finalCalculation());
        }
        else if (v==number4)
        {
            afterCalculation();
            setTheTextnumber("4");
            textboxSec.setText(finalCalculation());
        }
        else if (v==number5)
        {
            afterCalculation();
            setTheTextnumber("5");
            textboxSec.setText(finalCalculation());
        }
        else if (v==number6)
        {
            afterCalculation();
            setTheTextnumber("6");
            textboxSec.setText(finalCalculation());
        }
        else if (v==number7)
        {
            afterCalculation();
            setTheTextnumber("7");
            textboxSec.setText(finalCalculation());
        }
        else if (v==number8)
        {
            afterCalculation();
            setTheTextnumber("8");
            textboxSec.setText(finalCalculation());
        }
        else if (v==number9)
        {
            afterCalculation();
            setTheTextnumber("9");
            textboxSec.setText(finalCalculation());
        }
        else if (v==add)
        {   if(textboxMain.getText().toString().equals("") || textboxMain.getText().toString().equals("-"))
            textboxMain.setText("");
            else
            setTheTextOperator("+");
        }
        else if (v==subtract)
        {
            setTheTextOperator("-");
        }
        else if (v==multiply)
        {   if(textboxMain.getText().toString().equals("") || textboxMain.getText().toString().equals("-"))
            textboxMain.setText("");
        else
            setTheTextOperator("x");
        }
        else if (v==divide)
        {  if(textboxMain.getText().toString().equals("") || textboxMain.getText().toString().equals("-"))
            textboxMain.setText("");
        else
            setTheTextOperator("/");
        }
        else if (v==dot)
        {
            afterCalculation();
            setTheTextnumber(".");
            textboxSec.setText(finalCalculation());
        }
        else if (v==delete)
        {
            String k = textboxMain.getText().toString();
            int length=k.length();

            if(k.equals("") || length==1)
            {textboxMain.setText("");
                textboxSec.setText("");}
            else if (length>1)
            {
                k = k.substring(0,length-1);
                textboxMain.setText(k);
                textboxSec.setText(finalCalculation());
                setSize(k,length);
            }



        }
        else if (v==equalsto)
        {
            if(textboxMain.getText().toString().equals(""))
            {
                textboxMain.setText("");
                textboxSec.setText("");
            }
            else
            {
                textboxMain.setText(finalCalculation());
                textboxSec.setText("");
            }
        }

    }

    private String finalCalculation() {
        String str = textboxMain.getText().toString();
        int len1=str.length();
        setSize(str,len1);
        int flag=0;
        char[] Test1 = str.toCharArray();
        if(Test1[len1-1]=='+' || Test1[len1-1]=='-' || Test1[len1-1]=='x' || Test1[len1-1]=='/') {
            len1 = len1 - 1;
            flag =-1;
        }
        numberOfOperators1=count(Test1,len1);
        String Result = newString(Test1, numberOfOperators1, len1);
        if (numberOfOperators1>0)
            return Result;
        else if (numberOfOperators1==0 && flag==-1 ) //change
        {
            return(str.substring(0, len1));
            //textboxSec.setText("");
            //return "not";
        }
        else
            return "";

    }

    private void setSize(String str, int len1) {
        if(len1<=10)
            textboxMain.setTextSize(56);
        else if (len1>10 && len1<=15)
            textboxMain.setTextSize(40);
        else if (len1>15)
        {
            textboxMain.setTextSize(30);
        }
    }
    /*scrollView.post(new Runnable() {
        @Override
        public void run() {
            textboxMain.scrollView.fullScroll(View.FOCUS_RIGHT);
        }
    });*/
    private void afterCalculation()
    {
           String a = textboxMain.getText().toString();
            int length = a.length();
        int count=0;
        char[] b = a.toCharArray();
        if(length>0)
        if(b[length-1]=='+' || b[length-1]=='-' || b[length-1]=='x' || b[length-1]=='/')
         count=-1;
        if(numberOfOperators1>0 && textboxSec.getText().toString().equals("") && count==0)
            textboxMain.setText("");
    }

    private int count(char[] st, int length) {
        int countOper=0;

        for(int i=0;i<length;i++)
            {
                if(st[i]=='+' || st[i]=='x' || st[i]=='/')
                    countOper++;
                if((i!=0) && (st[i]=='-') )
                    if(st[i-1]!='+' && st[i-1]!='x' && st[i-1]!='/')
                        countOper++;
            }

        return countOper;
    }

    public static String newString(char[] st, int count, int length)
    {
        int flag=0,a=0;
        int k=0;
        int num = 2*count + 1;
        String[] numbers = new String[num];
        for( int i=0;i<length;i++)
        {
            if(((st[i]=='+') || ((i!=0) && st[i]=='-' && (st[i-1]!='x' && st[i-1]!='/'))) || (st[i]=='x') || (st[i]=='/'))
            {
                a++;
                if(a==1)
                {
                    String S="";
                    for(int j=i; j>0; j--)
                    {
                        S +=  Character.toString(st[i-j]);

                    }
                    numbers[0] = S;
                    flag=i;
                    numbers[++k]=Character.toString(st[i]);
                    k++;

                }
                else
                {
                    String S="";
                    for(int j=flag+1 ; j<i ; j++)
                    {
                        S +=  Character.toString(st[j]);
                    }
                    numbers[k] = S;
                    flag=i;
                    numbers[++k]=Character.toString(st[i]);
                    k++;
                }
            }
        }

        String S = "";
        for(int j=flag+1;j<length;j++)
        {
            S +=  Character.toString(st[j]);
        }
        numbers[2*count] = S;
      String Result = evaluate(numbers,count);
        return Result;


    }

    public static String evaluate(String[] s, int count) {
        String num = "";
        Float num1 = new Float("0.0");
        Float num2 = new Float("0.0");
        int length = 2*count+1;
        String Result = null;
        int noOfDivide=0,noOfAdd=0,noOfSubtract=0,noOfMultiply=0;
        for (int i= 0; i< length; i++)
        { switch (s[i])
            {
                case "/" : noOfDivide++;
                           break;
                case "x" : noOfMultiply++;
                           break;
                case "+" : noOfAdd++;
                           break;
                case "-" : if((i!=0) && (s[i-1]!="+" || s[i-1]!="x" || s[i-1]!="/"))
                           noOfSubtract++;
                           break;
                default  : break;
            }}
        while(count>0 && noOfDivide>0)
        {
            for (int i=0; i<length; i++)


            {
                if((s[i].equals("/")))
                {
                    num1= Float.valueOf(s[i-1]);
                    num2= Float.valueOf(s[i+1]);
                    num = Float.toString(num1/num2);
                    count--;
                    noOfDivide--;
                    s[i-1] = num;
                    for(int j =i ; j<length -2 ;j++)
                        s[j]= s[j+2];
                    length= 2*count+1;

                }
            }
        }
        while(count>0 && noOfMultiply>0)
        {
            for (int i=0; i<length; i++)


            {
                if((s[i].equals("x")))
                {
                    num1= Float.valueOf(s[i-1]);
                    num2= Float.valueOf(s[i+1]);
                    num = Float.toString(num1*num2);
                    count--;
                    noOfMultiply--;
                    s[i-1] = num;
                    for(int j =i ; j<length -2 ;j++)
                        s[j]= s[j+2];
                    length= 2*count+1;

                }
            }}



        while(count>0 && noOfSubtract>0)
        {
            for (int i=0; i<length; i++)


            {
                if((s[i].equals("-")))
                {
                    num1= Float.valueOf(s[i-1]);
                    num2= Float.valueOf(s[i+1]);
                    num = Float.toString(num1-num2);
                    count--;
                    noOfSubtract--;
                    s[i-1] = num;
                    for(int j =i ; j<length -2 ;j++)
                        s[j]= s[j+2];
                    i=0;
                    length= 2*count+1;
                }
            }}

        while(count>0 && noOfAdd>0)
        {
            for (int i=0; i<length; i++)


            {
                if(s[i].equals("+"))
                {
                    num1= Float.valueOf(s[i-1]);
                    num2= Float.valueOf(s[i+1]);
                    num = Float.toString(num1+num2);
                    count--;
                    noOfAdd--;
                    s[i-1] = num;
                    for(int j =i ; j<length -2 ;j++)
                        s[j]= s[j+2];
                    i=0;
                    length= 2*count+1;

                }
            }}
        for(int k=0;k<length;k++)
            Result = s[k];
        return Result;
        //textboxMain.setText(Result);


    }


    public void setTheTextnumber(String s)
    {
        String modify;
        modify = textboxMain.getText().toString();
        modify =( modify + s);
        textboxMain.setText(modify);

    }
    public static void setTheTextOperator(String s) {
        String modify;
        modify = textboxMain.getText().toString();
        int length = modify.length();
        char[] check = modify.toCharArray();


        if (s.equals("+"))
            {if (check[length - 1] == '+' || check[length - 1] == '-' || check[length - 1] == '/' || check[length - 1] == 'x') {
                { if( check[length - 2] == '/' || check[length - 2] == 'x')
                {
                    modify = modify.substring(0, length - 2);
                    modify += s;
                    textboxMain.setText(modify);
                }
                    else
                { modify = modify.substring(0, length - 1);
                modify += s;
                textboxMain.setText(modify);}}
            } else {
                modify = (modify + s);
                textboxMain.setText(modify);
            }

        } else if (s.equals("x")) {
            if (check[length - 1] == '+' || check[length - 1] == '-' || check[length - 1] == '/' || check[length - 1] == 'x') {
                { if( check[length - 2] == '/' || check[length - 2] == 'x')
                {
                    modify = modify.substring(0, length - 2);
                    modify += s;
                    textboxMain.setText(modify);
                }
                else
                { modify = modify.substring(0, length - 1);
                    modify += s;
                    textboxMain.setText(modify);}}
            } else {
                modify = (modify + s);
                textboxMain.setText(modify);
            }
        } else if (s.equals("/") ) {
            if (check[length - 1] == '+' || check[length - 1] == '-' || check[length - 1] == '/' || check[length - 1] == 'x') {
                { if( check[length - 2] == '/' || check[length - 2] == 'x')
                {
                    modify = modify.substring(0, length - 2);
                    modify += s;
                    textboxMain.setText(modify);
                }
                else
                { modify = modify.substring(0, length - 1);
                    modify += s;
                    textboxMain.setText(modify);}}
            } else {
                modify = (modify + s);
                textboxMain.setText(modify);
            }
        } else if (s.equals("-")) {
            if ((length!=0) && (check[length - 1] == '+' || check[length - 1] == '-')) {
                modify = modify.substring(0, length - 1);
                modify += s;
                textboxMain.setText(modify);
            }
            else if (textboxMain.getText().toString().equals(""))
                textboxMain.setText("-");
            else {
                modify = (modify + s);
                textboxMain.setText(modify);
            }
        }

    }

    @Override
    public boolean onLongClick(View v) {
        if ( v == delete)
        {   textboxMain.setText("");
        textboxSec.setText("");}
        return true;

    }
}


