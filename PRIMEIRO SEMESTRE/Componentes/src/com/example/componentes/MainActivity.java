package com.example.componentes;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	Button check, combo, radio, sair, voltar, total;
	CheckBox chkarroz, chkleite, chkfeijao, chkcarne;
	EditText edsalario;
	RadioGroup rgopcoes;
	
	private static final String[] percentual ={"","De 40%","De 45%","De 50%"};
	ArrayAdapter<String> aPercentual;
	Spinner spnsal;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        inicio();
        
    }
    public void inicio(){
        
        setContentView(R.layout.activity_main);
        check = (Button)findViewById(R.id.chk);
        combo = (Button)findViewById(R.id.combo);
        radio = (Button)findViewById(R.id.radio);
        sair = (Button)findViewById(R.id.sair);
        
        check.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				check();
			}
		});
        
      
        
        combo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				combo();
			}
		});
        
        radio.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				radio();
			}
		});
        
        sair.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        	
        
        
    }
    
    public void check(){
    	setContentView(R.layout.check);
    	voltar = (Button) findViewById(R.id.btvoltar);
    	chkarroz = (CheckBox) findViewById(R.id.arroz);
    	chkleite = (CheckBox) findViewById(R.id.leite);
    	chkfeijao = (CheckBox) findViewById(R.id.feijao);
    	chkcarne = (CheckBox) findViewById(R.id.carne);
    	total = (Button) findViewById(R.id.btcompras);
    	
    	total.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double total = 0;
				
				if(chkarroz.isChecked()){
					total += 14.70;
				}
				if(chkleite.isChecked()){
					total+= 2.97;
			}
				if(chkfeijao.isChecked()){
					total+= 7.30;
				}
				if (chkcarne.isChecked()){
					total+=22.45;
				}
				AlertDialog.Builder resultado = new
						AlertDialog.Builder(MainActivity.this);
				resultado.setTitle("Total");
				resultado.setMessage("O valor total da compra: R$"+String.valueOf(total));
				resultado.setNeutralButton("OK", null);
				resultado.show();
			}
		});
    	voltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				inicio();
			}
		});
    }
    public void combo(){
    	setContentView(R.layout.combo);
    	combo =(Button)findViewById(R.id.btcalcular);
    	aPercentual = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_item,percentual);
    	spnsal= (Spinner)findViewById(R.id.spopcoes);
    	spnsal.setAdapter(aPercentual);
    	voltar = (Button)findViewById(R.id.btvoltar);
    	edsalario=(EditText)findViewById(R.id.edsalario);
    	combo.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double sal = 0, ns = 0;
				sal = Double.parseDouble(edsalario.getText().toString());
				switch(spnsal.getSelectedItemPosition()){
				case 1: 
					ns = sal + (sal * 0.40);
				break;
				case 2: 
					ns = sal + (sal * 0.45);
				break;
				case 3: 
					ns = sal + (sal * 0.50);
				break;
				}
				AlertDialog.Builder dialogo = new
				AlertDialog.Builder (MainActivity.this);
				dialogo.setTitle("Novo Salário");
				dialogo.setMessage("Seu novo salário é R$"+String.valueOf(ns));
				dialogo.show();
				
			}
		});
    	voltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				inicio();
			}
		});
    }
    public void radio(){
    	setContentView(R.id.radio);
    	rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);
    	radio = (Button) findViewById(R.id.btcalcular);
    	edsalario = (EditText) findViewById(R.id.edsalario);
    	voltar = (Button) findViewById(R.id.btvoltar);
 
    	radio.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double sal =  Double.parseDouble(edsalario.getText().toString());
				int op =  rgopcoes.getCheckedRadioButtonId();
				double ns = 0;
				
				if(op == R.id.rb40){
					ns = sal * 1.40;
				}
				else if (op == R.id.rb45){
					ns = sal * 1.45;
				}
				else{
					ns = sal * 1.50;
				}
				AlertDialog.Builder dialogo = new
				AlertDialog.Builder (MainActivity.this);
				dialogo.setTitle("Novo Salário");
				dialogo.setMessage("Seu novo salário é R$"+String.valueOf(ns));
				dialogo.show();
				
			}
		});
    	voltar.setOnClickListener (new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				inicio();
			}
		});
    }
    public void sair(){
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
