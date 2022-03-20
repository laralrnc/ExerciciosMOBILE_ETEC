package com.example.lara_componentes;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	Button check, combo, radio, sair,voltar,total;
	CheckBox chkarroz, chkleite, chkfeijao, chkcarne;
	EditText edsalario;
	RadioGroup rgopcoes;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicio ();
    }
    
    public void inicio(){
        setContentView(R.layout.activity_main);
        check = (Button)findViewById(R.id.chk);
       combo = (Button)findViewById(R.id.combo);
        radio = (Button)findViewById(R.id.radio);
       sair = (Button)findViewById(R.id.sair);
       
   
        
       check.setOnClickListener(new View.OnClickListener(){
    	   @Override
    	   public void onClick(View arg0){
    		   check();
    	   }
       });
       
       combo.setOnClickListener(new View.OnClickListener(){
    	   @Override
    	   public void onClick(View arg0){
    		   combo();
    	   }
       });
 
       radio.setOnClickListener(new View.OnClickListener(){
    	   @Override
    	   public void onClick(View arg0){
    		   radio();
    	   }
       });
       
       sair.setOnClickListener(new View.OnClickListener(){
    	   @Override
    	   public void onClick(View arg0){
    	   }
       });
    }
    public void check(){
    	setContentView(R.layout.check);
    	voltar = (Button) findViewById(R.id.btvoltar);    
    	chkarroz = (CheckBox) findViewById(R.id.arroz); 
    	chkfeijao = (CheckBox) findViewById(R.id.feijao); 
    	chkleite = (CheckBox) findViewById(R.id.leite); 
    	chkcarne = (CheckBox) findViewById(R.id.carne); 
    	total =(Button)findViewById(R.id.btncompras);
    	total.setOnClickListener(new View.OnClickListener() {
@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double total = 0;
				if(chkarroz.isChecked()){
					total +=14.70;
					if(chkleite.isChecked()){
						total += 2.97;	
						if(chkfeijao.isChecked()){
							total +=7.30;
							}
						if(chkcarne.isChecked()){
							total +=7.30;
							}
						AlertDialog.Builder resultado = new
						AlertDialog.Builder(MainActivity.this);
						resultado.setTitle("Total");
						resultado.setMessage("O valor da compra"+String.valueOf(total));
						resultado.setNeutralButton("OK", null);
						resultado.show();
					}	
					});
    	volta.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		})
    	
    	
			
		
}
    
    	}
    public void combo(){
    }
    public void radio(){
    	setContentView(R.layout.radio);
    	rgopcoes= (RadioGroup) findViewById(R.id.rgopcoes);
    	radio=(Button)findViewById(R.id.btcalcular);
    	edsalario=(EditText)findViewById(R.id.edsalario);
    	voltar= (Button)findViewById(R.id.btvoltar);
    	
    }
       

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
       });
}}
    
