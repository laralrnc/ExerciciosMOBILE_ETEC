package com.example.bancodedados;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GravaRegistro2Activity extends Activity {
	Button btcadastrar;
	EditText ednome, edtelefone, edemail;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grava_registro2);
		
		btcadastrar = (Button)findViewById(R.id.btcadastrar);
		ednome = (EditText)findViewById(R.id.ednome);
		edtelefone = (EditText)findViewById(R.id.edtelefone);
		edemail = (EditText)findViewById(R.id.edemail);
		
		try{
			
		db = openOrCreateDatabase("Banco_dados", Context.MODE_PRIVATE, null);
		} catch (Exception e){
			MostraMensagem("Erro: "+ e.toString());
		}
	
		btcadastrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String nome = ednome.getText().toString();
				String telefone = edtelefone.getText().toString();
				String email = edemail.getText().toString();
				
				ContentValues valor = new ContentValues();
				valor.put("nome", nome);
				valor.put("telefone", telefone);
				valor.put("email", email);
				
				try{
					db.insert("usuarios", null, valor);
					MostraMensagem("Dados Cadastrados");
					
				}catch (Exception e){
					MostraMensagem("Erro: "+e.toString());
				}
			}
		});
	}
	public void MostraMensagem(String str){
		AlertDialog.Builder mensagem= new
		AlertDialog.Builder(GravaRegistro2Activity.this);
		mensagem.setTitle("Aviso");
		mensagem.setMessage(str);
		mensagem.setNeutralButton("OK", null);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grava_registro2, menu);
		return true;
	}

}
