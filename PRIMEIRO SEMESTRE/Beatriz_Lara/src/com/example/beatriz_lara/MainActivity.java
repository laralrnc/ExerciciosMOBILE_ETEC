package com.example.beatriz_lara;

import com.example.beatriz_lara.R;

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
		private static final String[] combo = {"","Cachorro","Gato"};
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
		
		//------>ok//
		
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
			    					 textView.setText("Cachorro: Pqn porte"); //colocar uma foto d cachorro
			    					 img1.setImageResource(R.drawable.cachorropequenopreto);
			    					 
			    					 
			    				 }else if(progressStatus==25){
			    					 img1.setImageResource(R.drawable.gatofilhotepreto); //foto de gato agora
			    					 textView.setText("Gato: Filhotes");
			    					 
			    				 }else if(progressStatus==50){
			    					 img1.setImageResource(R.drawable.cachorrograndemarrom); // foto de cachorro
			    					 textView.setText("Cachorro: Gde porte");
			    					 
			    				 }else if(progressStatus==75){
			    					 img1.setImageResource(R.drawable.gatoadultolaranja); // outra foto de gato
			    					 textView.setText("Gato: Adultos");
			    				 }else if(progressStatus==progressBar.getMax()){
			    					 tela2();
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

public void tela2(){ //aqui é a tela 2, era pra ser a 1 mas eu salvei ao contrario sem querer :p, a 1 é a 2//
setContentView(R.layout.tela2);
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
			cachorro();
			break;
		case 2: 
			gato(); 
			break;
		
			}
	}
});
}

public void gato(){
setContentView(R.layout.tela1);
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
texto2.setText("Gato");
op1.setText("Gato Filhote");
op2.setText("Gato Adulto");
op1.setChecked(false);
op2.setChecked(false);
voltar=(TextView)findViewById(R.id.txtvoltar);

voltar.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		tela2();
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
		chb1.setText("Preto");
		
		chb2.setText("Cinza");
		chb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(chb1.isChecked()){
					chb2.setChecked(false);
					img2.setVisibility(View.VISIBLE);
					img2.setImageResource(R.drawable.gatofilhotepreto);
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
					img2.setImageResource(R.drawable.gatofilhotecinza);
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
		chb1.setText("Preto");
		
		chb2.setText("Laranja");
	
	chb1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(chb1.isChecked()){
				chb2.setChecked(false);
				img2.setVisibility(View.VISIBLE);
				img2.setImageResource(R.drawable.gatoadultopreto);
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
				img2.setImageResource(R.drawable.gatoadultolaranja);
			}else{
				img2.setVisibility(View.INVISIBLE);
			}
		}
	});
	
	
	}
});


}

public void cachorro(){
setContentView(R.layout.tela1);
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
texto2.setText("Cachorro");
op1.setText("Pequeno"); // aqui a gente tem que escolher 3 fotos e montar algo difrenete nelas, sei la, pode ser a raça ou sei la o porte//
op2.setText("Médio");
op3.setText("Grande");
op1.setChecked(false);
op2.setChecked(false);
voltar=(TextView)findViewById(R.id.txtvoltar);

	voltar.setOnClickListener(new View.OnClickListener() {
	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			tela2();
		}
});

op1.setOnClickListener(new View.OnClickListener() { //cachorro pequeno
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		img2.setVisibility(View.INVISIBLE);
		chb1.setVisibility(View.VISIBLE);
		chb2.setVisibility(View.VISIBLE);
		chb1.setChecked(false);
		chb2.setChecked(false);
		chb1.setText("Branco"); //igual o do cachorro,, temos que pegar a mesma raça e colocar dois bichinhos de cor diferente//
		
		chb2.setText("Preto");
						
		chb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(chb1.isChecked()){
					chb2.setChecked(false);
					img2.setVisibility(View.VISIBLE);
					img2.setImageResource(R.drawable.cachorropequenobranco);
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
					img2.setImageResource(R.drawable.cachorropequenopreto);
				}else{
					img2.setVisibility(View.INVISIBLE);
				}
			}
		});				
	}
});

op2.setOnClickListener(new View.OnClickListener() { //porte medio
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		img2.setVisibility(View.INVISIBLE);
		chb1.setVisibility(View.VISIBLE);
		chb2.setVisibility(View.VISIBLE);
		chb1.setChecked(false);
		chb2.setChecked(false);
		chb1.setText("Laranja"); //nao sei o q é isso//
		
		chb2.setText("Branco");
	chb1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(chb1.isChecked()){
				chb2.setChecked(false);
				img2.setVisibility(View.VISIBLE);
				img2.setImageResource(R.drawable.cachorromediolaranja);
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
				img2.setImageResource(R.drawable.cachorromediobranco);
			}else{
				img2.setVisibility(View.INVISIBLE);
			}
		}
	});
	}
	
});
op3.setOnClickListener(new View.OnClickListener() { //porte grande
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		img2.setVisibility(View.INVISIBLE);
		chb1.setVisibility(View.VISIBLE);
		chb2.setVisibility(View.VISIBLE);
		chb1.setChecked(false);
		chb2.setChecked(false);
		chb1.setText("Preta");
		
		chb2.setText("Branca");
	
	chb1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(chb1.isChecked()){
				chb2.setChecked(false);
				img2.setVisibility(View.VISIBLE);
				img2.setImageResource(R.drawable.cachorrograndepreto);
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
				img2.setImageResource(R.drawable.cachorrograndebranco);
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
