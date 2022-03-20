package com.example.bancodedados;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AlterarDados2Activity extends Activity {

	EditText txtnome, txttelefone, txtemail;
	TextView txtstatus;
	SQLiteDatabase db;
	ImageView imgprimeiro, imganterior, imgproximo, imgultimo;
	Button btalterardados;
	int indice, numreg;
	Cursor c;
	DialogInterface.OnClickListener diAlteraInformacoes;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alterar_dados2);
	
		txtnome = (EditText)findViewById(R.id.txtnome);
		txttelefone = (EditText)findViewById(R.id.txttelefone);
		txtemail = (EditText)findViewById(R.id.txtemail);
		txtstatus = (TextView)findViewById(R.id.txtstatus_registro);
		imgprimeiro =(ImageView)findViewById(R.id.imgprimeiro);
		imganterior =(ImageView)findViewById(R.id.imganterior);
		imgproximo =(ImageView)findViewById(R.id.imgproximo);
		imgultimo =(ImageView)findViewById(R.id.imgultimo);
		btalterardados = (Button)findViewById(R.id.btalterardados);
	
		try {
			db=openOrCreateDatabase("banco_dados",Context.MODE_PRIVATE,null);
			c=db.query("usuarios",new String[]{
					"numreg","nome","telefone","email"},null,null,null,null,null);
			if(c.getCount()> 0){
				c.moveToFirst();
				indice =1;
				numreg = c.getInt(0);
				txtnome.setText(c.getString(1));
				txttelefone.setText(c.getString(2));
				txtemail.setText(c.getString(3));
				txtstatus.setText(indice + "/" + c.getCount());
			
			}else{
				txtstatus.setText("nenhum registro");
			}
		}catch (Exception e){
			
		}
		
		imgprimeiro.setOnClickListener(new View.OnClickListener(){
			 public void onClick(View arg0){
				 if(c.getCount()> 0){
						c.moveToFirst();
						indice =1;
						numreg = c.getInt(0);
						txtnome.setText(c.getString(1));
						txttelefone.setText(c.getString(2));
						txtemail.setText(c.getString(3));
						txtstatus.setText(indice + "/" + c.getCount());
					
					}
			 }
			});
			
			imganterior.setOnClickListener(new View.OnClickListener(){
				 public void onClick(View arg0){
					 if(c.getCount()> 0){
						 if(indice>1){
							
							indice --;
							c.moveToPrevious();
							numreg = c.getInt(0);
							txtnome.setText(c.getString(1));
							txttelefone.setText(c.getString(2));
							txtemail.setText(c.getString(3));
							txtstatus.setText(indice + "/" + c.getCount());
						
						}
					 }
				 }
				});
			imgproximo.setOnClickListener(new View.OnClickListener(){
				 public void onClick(View arg0){
					 if(c.getCount()> 0){
						 if(indice!=c.getCount()){
							indice ++;
							c.moveToNext();
							numreg = c.getInt(0);
							txtnome.setText(c.getString(1));
							txttelefone.setText(c.getString(2));
							txtemail.setText(c.getString(3));
							txtstatus.setText(indice + "/" + c.getCount());
						}
					 }
				 }
				});
			
			imgultimo.setOnClickListener(new View.OnClickListener(){
				 public void onClick(View arg0){
					 if(c.getCount()> 0){
						 	indice = c.getCount() ;
							c.moveToLast();
							numreg = c.getInt(0);
							txtnome.setText(c.getString(1));
							txttelefone.setText(c.getString(2));
							txtemail.setText(c.getString(3));
							txtstatus.setText(indice + "/" + c.getCount());
						
						
					 }
				 }
				});
			diAlteraInformacoes=new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			//altera as informações da tabela
			String nome = txtnome.getText().toString();
			String telefone = txttelefone.getText().toString();
			String email = txtemail.getText().toString();
		try {
			ContentValues valor = new ContentValues();
			valor.put("nome", nome);
			valor.put("telefone", telefone);
			valor.put("email", email);
			db.update("usuarios",valor,"numreg=" + numreg,null);
			MostraMensagem("Dados alterados com sucesso");
		} catch (Exception e) {
			// TODO: handle exception
			MostraMensagem("erro:"+e.toString());
		}
		}
	};
	btalterardados.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			AlertDialog.Builder dialogo = new
					AlertDialog.Builder(AlterarDados2Activity.this);
					dialogo.setTitle("CONFIRMAR");
					dialogo.setMessage("DESEJA ALTERAR AS INFORMAÇÕES?");
					dialogo.setPositiveButton("sim",diAlteraInformacoes);
					dialogo.setNegativeButton("NÃO",null);
					dialogo.show();
		}
	});
}
	public void MostraMensagem (String str){
		AlertDialog.Builder dialogo = new
		AlertDialog.Builder(AlterarDados2Activity.this);
		dialogo.setTitle("aviso");
		dialogo.setMessage(str);
		dialogo.setNeutralButton("ok",null);
	dialogo.show();	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alterar_dados2, menu);
		return true;
	}

}
