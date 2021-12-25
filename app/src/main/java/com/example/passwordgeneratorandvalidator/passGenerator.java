package com.example.passwordgeneratorandvalidator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class passGenerator extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pass_generator);


        //hiding the result text view
        TextView t = findViewById(R.id.passwordResult);
        t.setVisibility(View.INVISIBLE);




        //set a on click listener in the button . so that when it pressed the program will get the instruction to start
        Button btnpress = findViewById(R.id.buttonToStart);
        btnpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //hiding the not required views
                Button b= findViewById(R.id.buttonToStart);
                b.setVisibility(View.INVISIBLE);

                TextView t= findViewById(R.id.editTextNumber);
                t.setVisibility(View.INVISIBLE);

                TextView txt = findViewById(R.id.editTextTextPersonName);
                txt.setVisibility(View.INVISIBLE);
                //upto here was the hiding of views



                TextView lengthOfPassword = findViewById(R.id.editTextNumber);
                int len= Integer.parseInt(lengthOfPassword.getText().toString());

                //takes the required length of the password and  generates and prints the password
                startFunction(len);

            }
        });


    }



    private void startFunction(int len){



        //creating the password and storing it in variable password
        String password = "";
        while(password.length() < len){

            int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
//
            switch(randomNum){
                case 0://func for giving a random character between "a-z"
                    String s=randomSmallCharacter();
                    password+=s;
                    break;
                case 1://func to give a random character between "A-Z"
                    String t=randomCapitalCharacter();
                    password+=t;
                    break;
                case 3://func to give random from 0-9
                    String y=randomNumber();
                    password+=y;
                    break;
                case 4://func to give random from all special characters
                    String u=randomSpecialCharacterGenerator();
                    password+=u;
                    break;


            }


        }



        if(isValid(password)){
            TextView result = findViewById(R.id.passwordResult);
            result.setVisibility(View.VISIBLE);
            result.setText(password);
        }else {
            startFunction(len);
        }




    }

    private static String randomNumber() {
//        System.out.println("this is random number");
        int r = ThreadLocalRandom.current().nextInt(0, 10);
        String s= String.valueOf(r);
        return s;

    }

    private static String randomSpecialCharacterGenerator() {
//        System.out.println("this is random special character");

        String s="";

        int randomForSwitch = ThreadLocalRandom.current().nextInt(1, 5);
        switch (randomForSwitch){
            case 1:
                int r = ThreadLocalRandom.current().nextInt(33, 48);
                char c= (char) r;
                s= String.valueOf(c);
                break;
            case 2:
                int rq = ThreadLocalRandom.current().nextInt(58, 65);
                char cq= (char) rq;
                s= String.valueOf(cq);
                break;
            case 3:
                int rw = ThreadLocalRandom.current().nextInt(91, 97);
                char cw= (char) rw;
                s= String.valueOf(cw);
                break;
            case 4:int rr = ThreadLocalRandom.current().nextInt(123, 127);
                char cr= (char) rr;
                s= String.valueOf(cr);
                break;

        }

        return s;
    }

    private static String randomCapitalCharacter() {
//        System.out.println("this is random capital character");
        int r = ThreadLocalRandom.current().nextInt(65, 91);
        char c= (char) r;
        String s= String.valueOf(c);
        return s;
    }

    private static String randomSmallCharacter() {
//        System.out.println("this is random small character");
        int r = ThreadLocalRandom.current().nextInt(97, 122);
        char c= (char) r;
        String s= String.valueOf(c);
        return s;

    }

    private boolean isValid(String p) {



//        Scanner sc= new Scanner(System.in);
//        System.out.println("please enter your password to check");
        String password =p;

        int l= password.length();
        int a=0,b=0,c=0,d=0;
        while(l-->0){

            for(int i=0;i<password.length();i++){
                char ch=password.charAt(i);

                if(ch >= 'a' && ch <= 'z') a++;

                else if(ch >= 'A' && ch <= 'Z') b++;

                else if(ch >= '0' && ch <= '9') c++;

                else d++;

            }

        }

        if(a>0 && b>0 && c>0 && d>0){
            return true;
        }

        return false;


    }


}
