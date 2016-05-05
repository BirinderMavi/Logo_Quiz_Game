package com.example.user.logoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewActivity extends AppCompatActivity {
    private String[] logoNames = {
            "adidas",
            "burger king",
            "dell",
            "fido",
            "kfc",
            "pizza hut",
            "rogers",
            "skype",
            "snapchat",
            "starbucks",
            "taco bell",
            "tim hortons",
            "twitter",
            "watsapp"
    };
    private int[] logoId = {
            R.drawable.adidas,
            R.drawable.burger_king,
            R.drawable.dell,
            R.drawable.fido,
            R.drawable.kfc,
            R.drawable.pizza_hut,
            R.drawable.rogers,
            R.drawable.skype,
            R.drawable.snapchat,
            R.drawable.starbucks,
            R.drawable.taco_bell,
            R.drawable.tim_hortons,
            R.drawable.twitter,
            R.drawable.watsapp
    };
    ImageView imageView;
    List<Integer> logoArray;
    EditText editText;
    int count = 0;
    int logo = 0;
    int loose=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        imageView = (ImageView) findViewById(R.id.imageView2);

        logoArray = new ArrayList<>();
        for (int i = 0; i < 14; i++)
        {
            logoArray.add(i);
        }


        Collections.shuffle(logoArray);

        int a = logoArray.get(0);
        Log.v("id",String.valueOf(a));
        imageView.setImageDrawable(getResources().getDrawable(logoId[a]));
        logo = logoArray.get(count);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                editText = (EditText) findViewById(R.id.user_answer);
                String answer = editText.getText().toString();

                Log.v("Text",answer);
                Log.v("Logo", logoNames[logo]);
                Log.v("id1",String.valueOf(logo));

                if (!answer.equals(logoNames[logo])) {
                    loose = loose + 1;
                    Toast.makeText(NewActivity.this, "Incorrect Answer",Toast.LENGTH_LONG).show();
                }
                if(loose == 2)
                {
                    Toast.makeText(NewActivity.this, "Two Answers Wrong! You Lost!Please try again!",Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(NewActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }
                count = count +1;
                Log.v("count", String.valueOf(count));
                if(count < 5)
                {
                    logo = logoArray.get(count);
                    Log.v("id0", String.valueOf(logo));
                    editText.setText("");
                }
                else
                {
                    if(loose == 2)
                    {
                        Toast.makeText(NewActivity.this, "Two Answers Wrong! You Lost! Please try again!",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(NewActivity.this, "Five Answers Correct! You Won!!",Toast.LENGTH_LONG).show();
                    }

                    Intent myIntent = new Intent(NewActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }


                setImage(imageView);

            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(NewActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText user_answer = (EditText) findViewById(R.id.user_answer);
                user_answer.setText("");
            }
        });
    }

    public void setImage(ImageView imageView){
        imageView.setImageDrawable(getResources().getDrawable(logoId[logo]));
    }

}
