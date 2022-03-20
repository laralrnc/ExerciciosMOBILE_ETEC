package com.example.bancodedados;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ConsultarDadosActivity extends Activity {

	TextView txtnome, txttelefone, txtemail, txtstatus_registros;
	SQLiteDatabase db;
	ImageView imgprimeiro, imganterior, imgproximo, imgultimo;
	int indice, numreg;
	Cursor c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consultar_dados);
		
		txtnome = (TextView)findViewById(R.id.txtnome);
		txttelefone = (TextView)findViewById(R.id.txttelefone);
		txtemail = (TextView)findViewById(R.id.txtemail);
		txtstatus_registros = (TextView)findViewById(R.id.txtstatus_registro);
		
		txtnome.setText("");
		txttelefone.setText("");
		txtemail.setText("");
		
		imgprimeiro = (ImageView)findViewById(R.id.imgprimeiro);
		imganterior = (ImageView)findViewById(R.id.imganterior);
		imgproximo = (ImageView)findViewById(R.id.imgproximo);
		imgultimo  = (ImageView)findViewById(R.id.imgultimo);
		
		try {
			
			db = openOrCreateDatabase("banco_dados, Context.MODE_PRIVATE", indice, null);
			
			c = db.query("usuarios", new String []{"nome","telefone","email"}, null, null, null, null, null);
			
			if(c.getCount()>0){
				//irá mover p o primeiro registro
				c.moveToFirst();
				indice = 1;
				txtnome.setText(c.getString(0)); // obtem o nome
				txttelefone.setText(c.getString(0)); // obtem o telefone
				txtemail.setText(c.getString(0)); // obtem o email
				txtstatus_registros.setText(indice + " / " + c.getCount());	
			}else{
				txtstatus_registros.setText("Nenhum Registro");	
			}
			
			imganterior.setOnClickListener(new View.OnClickListener(){
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
				if(c.getCount() > 0);{
				if (indice > 1){
				indice--;
				c.moveToPrevious();
				txtnome.setText(c.getString(0));
				txttelefone.setText(c.getString(1));
				txtemail.setText(c.getString(2));
				txtstatus_registros.setText(indice + " / " + c.getCount());	
				
				
				}
				}
				}
			});
			
			imgproximo.setOnClickListener(new View.OnClickListener(){
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
				if(c.getCount() > 0);{
				if (indice != c.getColumnCount()){
				indice++;
				c.moveToPrevious();
				txtnome.setText(c.getString(0));
				txttelefone.setText(c.getString(1));
				txtemail.setText(c.getString(2));
				txtstatus_registros.setText(indice + " / " + c.getCount());	
				
				
				}
				}
				}
			});
			
			imgultimo.setOnClickListener(new View.OnClickListener(){
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
				if(c.getCount() > 0){
				
				c.moveToLast();
				txtnome.setText(c.getString(0));
				txttelefone.setText(c.getString(1));
				txtemail.setText(c.getString(2));
				txtstatus_registros.setText(indice + " / " + c.getCount());	
				c.getCount();
				
				
				}
				}
				
			});
			
		} catch (Exception e) {
			// TODO: handle exception
			MostraMensagem("Erro:" + e.toString());
		}
	}

		public void MostraMensagem(String str){
			AlertDialog.Builder dialogo = new
			AlertDialog.Builder(ConsultarDadosActivity.this);
			dialogo.setTitle("Aviso");
			dialogo.setMessage(str);
			dialogo.setNeutralButton("OK", null);
			dialogo.show();
			
		}
		
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consultar_dados, menu);
		return true;
	}

}
