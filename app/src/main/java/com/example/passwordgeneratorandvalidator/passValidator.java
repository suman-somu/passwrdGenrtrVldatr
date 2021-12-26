package com.example.passwordgeneratorandvalidator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class passValidator extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pass_validator);


        Button btnPress = findViewById(R.id.button);
        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //hide all the unrequired Views
                startFunction();
            }
        });
    }

    private void startFunction() {

        EditText txt = findViewById(R.id.editTextTextPersonName2);

        String toCheck = txt.getText().toString();

        boolean b = isValid(toCheck);

        if(b){

            // hide the elements
            Toast.makeText(getApplication(), "correct", Toast.LENGTH_SHORT).show();


        }
        else {
            Toast.makeText(getApplication(), "wrong", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isValid(String p) {



//        Scanner sc= new Scanner(System.in);
//        System.out.println("please enter your password to check");
        String password =p;

        int l= password.length();
        int a=0,b=0,c=0,d=0;
        while(l-->0){

            for(int i=0;i<password.length();i++){
                char ch = password.charAt(i);

                if(ch >= 'a' && ch <= 'z') a++;

                else if(ch >= 'A' && ch <= 'Z') b++;

                else if(ch >= '0' && ch <= '9') c++;

                //check whether character is special or not .
                // 1 - check whether the ascii code of each character,
                //  is in between the special character's ascii values or not
                else d++;

            }

        }

        if(a>0 && b>0 && c>0 && d>0){
            return true;
        }

        return false;


    }

}

