package com.example.calcy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.icu.util.IslamicCalendar;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView mtxt,atxt,link;
    TextView c,pr,division,b7,b8,b9,mult,b4,b5,b6,sub,b1,b2,b3,add,b0,dot,answer;
    ImageView back;
    ImageView themeBtn,canselBtn;
    boolean thDay;
    LinearLayout l2,al,devL;
    RelativeLayout mainL;
    CardView dcard,developercard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        themeBtn = (ImageView)findViewById(R.id.themeBtn);
        canselBtn = (ImageView)findViewById(R.id.canselBtn);
        mainL = (RelativeLayout)findViewById(R.id.mainL);
        dcard = (CardView)findViewById(R.id.dcard);
        developercard = (CardView)findViewById(R.id.developercard);


        al = (LinearLayout)findViewById(R.id.al);
        l2 = (LinearLayout)findViewById(R.id.l2);
        devL = (LinearLayout)findViewById(R.id.devL);

        mtxt = (TextView) findViewById(R.id.mtxt);
        atxt = (TextView) findViewById(R.id.atxt);
        link = (TextView) findViewById(R.id.link);

        c = (TextView)findViewById(R.id.c);
        pr = (TextView)findViewById(R.id.pr);
        back = (ImageView)findViewById(R.id.back1);
        division = (TextView)findViewById(R.id.division);
        b7 = (TextView)findViewById(R.id.b7);
        b8 = (TextView)findViewById(R.id.b8);
        b9 = (TextView)findViewById(R.id.b9);
        mult = (TextView)findViewById(R.id.mult);
        b4 = (TextView)findViewById(R.id.b4);
        b5 = (TextView)findViewById(R.id.b5);
        b6 = (TextView)findViewById(R.id.b6);
        sub = (TextView)findViewById(R.id.sub);
        b1 = (TextView)findViewById(R.id.b1);
        b2 = (TextView)findViewById(R.id.b2);
        b3 = (TextView)findViewById(R.id.b3);
        add = (TextView)findViewById(R.id.addi);
        b0 = (TextView)findViewById(R.id.b0);
        dot = (TextView)findViewById(R.id.dot);
        answer = (TextView)findViewById(R.id.answer);


        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://garejakirit.ml"));
                startActivity(intent);
            }
        });
        developercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                devL.setVisibility(View.VISIBLE);
            }
        });

        canselBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                devL.setVisibility(View.GONE);
            }
        });

        thDay =  false;

        themeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thDay == false){
                    nightTheme();
                    themeBtn.setImageResource(R.drawable.night);
                    thDay = true;
                }else {
                    dayTheme();
                    themeBtn.setImageResource(R.drawable.day);
                    thDay = false;
                }
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtxt.setText("");
                atxt.setText("");
            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("%");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mtxt.getText().toString().equalsIgnoreCase("")){
                    if(mtxt.getText().toString().length() == 1){
                        atxt.setText("");
                        mtxt.setText("");
                    }
                    else {
                        back();
                        solve();
                    }
                }
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("/");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("7");
                solve();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("8");
                solve();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("9");
                solve();
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("*");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("4");
                solve();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("5");
                solve();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("6");
                solve();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("-");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("1");
                solve();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("2");
                solve();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("3");
                solve();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("+");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis("0");
                solve();
            }

        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis(".");
            }
        });
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve2();
            }
        });









    }

    private void dayTheme() {
        mainL.setBackgroundColor(Color.WHITE);
        l2.setBackgroundColor(Color.WHITE);
        al.setBackgroundColor(Color.WHITE);
        dcard.setBackgroundColor(Color.WHITE);

        c.setTextColor(Color.BLACK);
        pr.setTextColor(Color.BLACK);
        back.setImageTintList(ColorStateList.valueOf(Color.BLACK));
        division.setTextColor(Color.BLACK);
        b7.setTextColor(Color.BLACK);
        b8.setTextColor(Color.BLACK);
        b9.setTextColor(Color.BLACK);
        b4.setTextColor(Color.BLACK);
        b5.setTextColor(Color.BLACK);
        b6.setTextColor(Color.BLACK);
        b1.setTextColor(Color.BLACK);
        b2.setTextColor(Color.BLACK);
        b3.setTextColor(Color.BLACK);
        add.setTextColor(Color.BLACK);
        sub.setTextColor(Color.BLACK);
        mult.setTextColor(Color.BLACK);
        mtxt.setTextColor(Color.BLACK);
        atxt.setTextColor(Color.BLACK);
        b0.setTextColor(Color.BLACK);
        dot.setTextColor(Color.BLACK);
        answer.setTextColor(Color.BLACK);

    }

    @SuppressLint("ResourceAsColor")
    private void nightTheme() {

        mainL.setBackgroundColor(Color.BLACK);
        l2.setBackgroundColor(Color.BLACK);
        al.setBackgroundColor(Color.BLACK);
        dcard.setBackgroundColor(Color.BLACK);

        c.setTextColor(Color.RED);
        pr.setTextColor(Color.BLUE);
        back.setImageTintList(ColorStateList.valueOf(Color.BLUE));
        division.setTextColor(Color.BLUE);
        b7.setTextColor(Color.WHITE);
        b8.setTextColor(Color.WHITE);
        b9.setTextColor(Color.WHITE);
        b4.setTextColor(Color.WHITE);
        b5.setTextColor(Color.WHITE);
        b6.setTextColor(Color.WHITE);
        b1.setTextColor(Color.WHITE);
        b2.setTextColor(Color.WHITE);
        b3.setTextColor(Color.WHITE);
        add.setTextColor(Color.BLUE);
        sub.setTextColor(Color.BLUE);
        mult.setTextColor(Color.BLUE);
        mtxt.setTextColor(Color.WHITE);
        atxt.setTextColor(Color.WHITE);
        b0.setTextColor(Color.WHITE);
        dot.setTextColor(Color.WHITE);
        answer.setTextColor(Color.BLUE);

    }

    private void solve() {
        String txt = mtxt.getText().toString();
        Double r  = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            r = (double)engine.eval(txt);
        } catch (ScriptException e) {
            //Toast.makeText(this, "Invalid Innput", Toast.LENGTH_SHORT).show();
        }
        if (r != null){
            atxt.setText(""+r);
        }
    }

    private void solve2() {
        String txt = mtxt.getText().toString();
        Double r  = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            r = (double)engine.eval(txt);
        } catch (ScriptException e) {
            //Toast.makeText(this, "Invalid Innput", Toast.LENGTH_SHORT).show();
        }
        if (r != null){
            mtxt.setText(""+r);
            atxt.setText("");
        }
    }

    private void back() {
        String x = mtxt.getText().toString();
        StringBuffer sb = new StringBuffer(x);
            String na = String.valueOf(sb.deleteCharAt(sb.length()-1));
            mtxt.setText(na);
    }

    private void dis(String i) {
        String pt = mtxt.getText().toString();
        mtxt.setText(pt+i);
    }
}