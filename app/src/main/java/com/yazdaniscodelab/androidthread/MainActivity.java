package com.yazdaniscodelab.androidthread;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.btn_xml);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Thread th=new Thread(){

                    @Override
                    public void run() {

                        try {
                            int wait=0;
                            while (wait<12000){
                                sleep(100);
                                wait+=100;
                            }

                            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                            startActivity(intent);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            MainActivity.this.finish();

                        }catch (InterruptedException e) {
                            // do nothing
                        } finally {

                            MainActivity.this.finish();
                        }
                    }
                };
                th.start();

                Snackbar snackbar=Snackbar.make(btn,"Wait 12se",Snackbar.LENGTH_LONG);

                snackbar.show();

            }
        });

    }
}
