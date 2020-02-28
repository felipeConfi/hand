package com.example.suporthand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button IdEncender, IdApagar, IdDesconcetar;
    TextView IdBufferIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IdEncender = (Button) findViewById(R.id.IdEncender);
        IdApagar = (Button) findViewById(R.id.IdApagar);
        IdDesconcetar = (Button) findViewById(R.id.IdDesconectar);
        IdBufferIn = (TextView) findViewById(R.id.IdBufferIn);

        IdEncender.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                //Content
            }
        });

        IdApagar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                //Content
            }
        });
    }
}
