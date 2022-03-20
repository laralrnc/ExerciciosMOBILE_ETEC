package com.example.soma_lara;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText numero1 , numero2;
	Button somar, subtrair, dividir, multiplicar;
	TextView texto;
	double val1, val2, res;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        numero1 = (EditText) findViewById(R.id.num1);
        numero2 = (EditText) findViewById(R.id.num2);
        somar = (Button) findViewById(R.id.btn1);
        subtrair = (Button) findViewById(R.id.btn2);
        dividir = (Button) findViewById(R.id.btn3);
        multiplicar = (Button) findViewById(R.id.btn4);
        texto = (TextView) findViewById(R.id.res);
        
        somar.setOnClickListener(new View.OnClickListener()
        {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				val1 = Double.parseDouble(numero1.getText().toString());
				val2 = Double.parseDouble(numero2.getText().toString());
				res = val1 + val2;
				texto.setText(val1 + " + " + val2 + "=" + res);
			}
		});
        subtrair.setOnClickListener(new View.OnClickListener()
        {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				val1 = Double.parseDouble(numero1.getText().toString());
				val2 = Double.parseDouble(numero2.getText().toString());
				res = val1 - val2;
				texto.setText(val1 + " - " + val2 + "=" + res);
			}
		});
        dividir.setOnClickListener(new View.OnClickListener()
        {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				val1 = Double.parseDouble(numero1.getText().toString());
				val2 = Double.parseDouble(numero2.getText().toString());
				res = val1 / val2;
				texto.setText(val1 + " / " + val2 + "=" + res);
			}
		});
        multiplicar.setOnClickListener(new View.OnClickListener()
        {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				val1 = Double.parseDouble(numero1.getText().toString());
				val2 = Double.parseDouble(numero2.getText().toString());
				res = val1 * val2;
				texto.setText(val1 + " X " + val2 + "=" + res);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
