package com.shrisai.calculator1;

import static com.shrisai.calculator1.R.id.num0;
import static com.shrisai.calculator1.R.id.num6;
import static com.shrisai.calculator1.R.id.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstNum;
    String operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button num0=findViewById(R.id.num0);
        Button num1=findViewById(R.id.num1);
        Button num2=findViewById(R.id.num2);
        Button num3=findViewById(R.id.num3);
        Button num4=findViewById(R.id.num4);
        Button num5=findViewById(R.id.num5);
        Button num6=findViewById(R.id.num6);
        Button num7=findViewById(R.id.num7);
        Button num8=findViewById(R.id.num8);
        Button num9=findViewById(R.id.num9);

        Button on=findViewById(R.id.on);
        Button off=findViewById(R.id.off);
        Button ac=findViewById(R.id.ac);
        Button del=findViewById(R.id.del);
        Button div=findViewById(R.id.div);
        Button times=findViewById(R.id.times);
        Button min=findViewById(R.id.min);
        Button equal=findViewById(R.id.equal);
        Button plus=findViewById(R.id.plus);
        Button point=findViewById(R.id.point);

        TextView Screen=findViewById(R.id.screen);

        ac.setOnClickListener(view -> {
            firstNum=0;
            Screen.setText("0");
        } );

        off.setOnClickListener(view-> Screen.setVisibility(View.GONE));
       on.setOnClickListener( View-> {
           Screen.setVisibility(View.VISIBLE);
           Screen.setText("0");
        });

        ArrayList<Button> nums= new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for(Button b:nums){
            b.setOnClickListener(View ->{
                if(!Screen.getText().toString().equals("0")){
                    Screen.setText(Screen.getText().toString()+b.getText().toString());
                }else{
                    Screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers= new ArrayList<>();
        opers.add(div);
        opers.add(times);
        opers.add(plus);
        opers.add(min);
        for(Button b:opers){
            b.setOnClickListener(view -> {
                firstNum=Double.parseDouble(Screen.getText().toString());
                operations = b.getText().toString();
                Screen.setText("0");
            });
        }
        del.setOnClickListener(view -> {
            String num = Screen.getText().toString();
            if(num.length()>1){
                Screen.setText(num.substring(0,num.length()-1));
            } else if (num.length()==1 && !num.equals("0")) {
                Screen.setText("0");

            }
        });

        point.setOnClickListener(view -> {
            if(!Screen.getText().toString().contains(".")){
                Screen.setText(Screen.getText().toString()+".");

            }
        });

        equal.setOnClickListener(view -> {
            double secondNum =Double.parseDouble(Screen.getText().toString());
            double result;
            switch (operations){
                case"/":
                    result= firstNum/secondNum;
                    break;
                case "x":
                    result= firstNum*secondNum;
                    break;
                case "+":
                    result = firstNum+secondNum;
                    break;

                case"-":
                    result= firstNum-secondNum;
                    break;
                default:
                    result=firstNum+secondNum;
            }
            Screen.setText(String.valueOf(result));
            firstNum=result;

        });

    }
}