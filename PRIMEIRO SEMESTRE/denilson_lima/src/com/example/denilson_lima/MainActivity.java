package com.example.denilson_lima;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	//Variaveis ComboBox
	private static final String[] combo = {"","Carro","Moto"};
	ArrayAdapter<String> acombo;
	Spinner spnsal;
	
	ProgressBar progressBar;
	int progressStatus = 0;
	TextView textView, texto2, voltar;
	Handler handler = new Handler();
	Button bt1, continuar, bt10,sair;
	ImageView img1,img2,img3;
	RadioGroup opcoes;
	RadioButton op1,op2,op3;
	CheckBox chb1,chb2;
		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//Configuração para a Barra de Progresso
				progressBar = (ProgressBar) findViewById(R.id.progressBar1);
				textView = (TextView) findViewById(R.id.textView1);
				bt1 = (Button)findViewById(R.id.bt1);
				img1 = (ImageView)findViewById(R.id.imageView1);
				//Comando para ocultar aimagem e a mensagem
				img1.setVisibility(View.INVISIBLE);
				textView.setVisibility(View.INVISIBLE);
				
				bt1.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
								
					  // Iniciar a operação de longa duração em uma discussão de fundo
						img1.setVisibility(View.VISIBLE);
						textView.setVisibility(View.VISIBLE);
					  new Thread(new Runnable() {
					     public void run() {
					    	 for(progressStatus=0;progressStatus<=100;progressStatus++){
					    		 // Atualizar a barra de progresso
					    		 handler.post(new Runnable() {
					    			 public void run() {
					    				 progressBar.setProgress(progressStatus);
					    				 if(progressStatus==0){
					    					 textView.setText("Carro: Ferrari");
					    					 img1.setImageResource(R.drawable.ferrari1);
					    					 
					    					 
					    				 }else if(progressStatus==25){
					    					 img1.setImageResource(R.drawable.honda1);
					    					 textView.setText("Moto: Honda");
					    					 
					    				 }else if(progressStatus==50){
					    					 img1.setImageResource(R.drawable.mclaren1);
					    					 textView.setText("Carro: Mclaren");
					    					 
					    				 }else if(progressStatus==75){
					    					 img1.setImageResource(R.drawable.kawasaki1);
					    					 textView.setText("Moto: Kavasaki");
					    				 }else if(progressStatus==progressBar.getMax()){
					    					 tela1();
					    				 }
					    				 
					    				 }
					    		});
					    		 try {
					    			 // Faz a barra inclementar em 200 milissegundos.
					    			 Thread.sleep(100);
					    		} catch (InterruptedException e) {
					    			e.printStackTrace();
					    		}
					    	}
					     }
					  }).start();
					  }
					});
	}
	
	public void tela1(){
		setContentView(R.layout.tela1);
		continuar = (Button) findViewById(R.id.btcontinuar);
		acombo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, combo);
		spnsal = (Spinner) findViewById(R.id.opcoes);
		spnsal.setAdapter(acombo);
		sair=(Button)findViewById(R.id.btsair);
		
		sair.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		continuar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(spnsal.getSelectedItemPosition()) {
				case 1: 
					carro();
					break;
				case 2: 
					moto(); 
					break;
				
					}
			}
		});
	}
	
	public void carro(){
		setContentView(R.layout.tela2);
		opcoes=(RadioGroup)findViewById(R.id.radioGroup1);
		texto2=(TextView)findViewById(R.id.textView1);
		op1=(RadioButton)findViewById(R.id.radio0);
		op2=(RadioButton)findViewById(R.id.radio1);
		op3=(RadioButton)findViewById(R.id.radio2);
		chb1=(CheckBox)findViewById(R.id.checkBox1);
		chb2=(CheckBox)findViewById(R.id.checkBox2);
		img2=(ImageView)findViewById(R.id.imageView1);
		chb1.setVisibility(View.INVISIBLE);
		chb2.setVisibility(View.INVISIBLE);
		img2.setVisibility(View.INVISIBLE);
		op3.setVisibility(View.INVISIBLE);
		texto2.setText("CARRO");
		op1.setText("Ferrari");
		op2.setText("Mclaren");
		op1.setChecked(false);
		op2.setChecked(false);
		voltar=(TextView)findViewById(R.id.txtvoltar);
		
		voltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tela1();
			}
		});
		
		op1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img2.setVisibility(View.INVISIBLE);
				chb1.setChecked(false);
				chb2.setChecked(false);
				chb1.setVisibility(View.VISIBLE);
				chb2.setVisibility(View.VISIBLE);
				chb1.setText("Vermelha");
				
				chb2.setText("Amarela");
				chb1.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(chb1.isChecked()){
							chb2.setChecked(false);
							img2.setVisibility(View.VISIBLE);
							img2.setImageResource(R.drawable.f1);
						}else{
							img2.setVisibility(View.INVISIBLE);
						}
					}
				});
				
				chb2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(chb2.isChecked()){
							chb1.setChecked(false);
							img2.setVisibility(View.VISIBLE);
							img2.setImageResource(R.drawable.ferrari3);
						}else{
							img2.setVisibility(View.INVISIBLE);
						}
					}
				});
				
				
			}
		});
		
		op2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img2.setVisibility(View.INVISIBLE);
				chb1.setVisibility(View.VISIBLE);
				chb2.setVisibility(View.VISIBLE);
				chb1.setChecked(false);
				chb2.setChecked(false);
				chb1.setText("Branca");
				
				chb2.setText("Amarela");
			
			chb1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(chb1.isChecked()){
						chb2.setChecked(false);
						img2.setVisibility(View.VISIBLE);
						img2.setImageResource(R.drawable.mclaren2);
					}else{
						img2.setVisibility(View.INVISIBLE);
					}
				}
			});
			
			chb2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(chb2.isChecked()){
						chb1.setChecked(false);
						img2.setVisibility(View.VISIBLE);
						img2.setImageResource(R.drawable.mclaren1);
					}else{
						img2.setVisibility(View.INVISIBLE);
					}
				}
			});
			
			
			}
		});
		
		
	}
	
	public void moto(){
		setContentView(R.layout.tela2);
		opcoes=(RadioGroup)findViewById(R.id.radioGroup1);
		texto2=(TextView)findViewById(R.id.textView1);
		op1=(RadioButton)findViewById(R.id.radio0);
		op2=(RadioButton)findViewById(R.id.radio1);
		op3=(RadioButton)findViewById(R.id.radio2);
		chb1=(CheckBox)findViewById(R.id.checkBox1);
		chb2=(CheckBox)findViewById(R.id.checkBox2);
		img2=(ImageView)findViewById(R.id.imageView1);
		chb1.setVisibility(View.INVISIBLE);
		chb2.setVisibility(View.INVISIBLE);
		img2.setVisibility(View.INVISIBLE);
		texto2.setText("Moto");
		op1.setText("Honda");
		op2.setText("Kavasaki");
		op3.setText("BMW");
		op1.setChecked(false);
		op2.setChecked(false);
		voltar=(TextView)findViewById(R.id.txtvoltar);
		
			voltar.setOnClickListener(new View.OnClickListener() {
			
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					tela1();
				}
		});
		
		op1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img2.setVisibility(View.INVISIBLE);
				chb1.setVisibility(View.VISIBLE);
				chb2.setVisibility(View.VISIBLE);
				chb1.setChecked(false);
				chb2.setChecked(false);
				chb1.setText("Vermelha");
				
				chb2.setText("Amarela");
								
				chb1.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(chb1.isChecked()){
							chb2.setChecked(false);
							img2.setVisibility(View.VISIBLE);
							img2.setImageResource(R.drawable.honda1);
						}else{
							img2.setVisibility(View.INVISIBLE);
						}
					}
				});
				
				chb2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(chb2.isChecked()){
							chb1.setChecked(false);
							img2.setVisibility(View.VISIBLE);
							img2.setImageResource(R.drawable.honda2);
						}else{
							img2.setVisibility(View.INVISIBLE);
						}
					}
				});				
			}
		});
		
		op2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img2.setVisibility(View.INVISIBLE);
				chb1.setVisibility(View.VISIBLE);
				chb2.setVisibility(View.VISIBLE);
				chb1.setChecked(false);
				chb2.setChecked(false);
				chb1.setText("Preta");
				
				chb2.setText("Verde");
			chb1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(chb1.isChecked()){
						chb2.setChecked(false);
						img2.setVisibility(View.VISIBLE);
						img2.setImageResource(R.drawable.kawasaki1);
					}else{
						img2.setVisibility(View.INVISIBLE);
					}
				}
			});
			
			chb2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(chb2.isChecked()){
						chb1.setChecked(false);
						img2.setVisibility(View.VISIBLE);
						img2.setImageResource(R.drawable.kawasaki2);
					}else{
						img2.setVisibility(View.INVISIBLE);
					}
				}
			});
			}
			
		});
op3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				img2.setVisibility(View.INVISIBLE);
				chb1.setVisibility(View.VISIBLE);
				chb2.setVisibility(View.VISIBLE);
				chb1.setChecked(false);
				chb2.setChecked(false);
				chb1.setText("Amarela");
				
				chb2.setText("Branca");
			
			chb1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(chb1.isChecked()){
						chb2.setChecked(false);
						img2.setVisibility(View.VISIBLE);
						img2.setImageResource(R.drawable.bmw1);
					}else{
						img2.setVisibility(View.INVISIBLE);
					}
				}
			});
			
			chb2.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(chb2.isChecked()){
						chb1.setChecked(false);
						img2.setVisibility(View.VISIBLE);
						img2.setImageResource(R.drawable.bmw2);
					}else{
						img2.setVisibility(View.INVISIBLE);
					}
				}
			});
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
