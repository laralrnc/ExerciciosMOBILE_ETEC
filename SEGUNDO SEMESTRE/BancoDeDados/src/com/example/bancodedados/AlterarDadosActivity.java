package com.example.bancodedados;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
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

public class AlterarDadosActivity extends Activity {

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
		setContentView(R.layout.activity_alterar_dados);
		
	txtnome = (EditText)findViewById(R.id.txtnome);
	txttelefone = (EditText)findViewById(R.id.txttelefone);
	txtemail = (EditText)findViewById(R.id.txtemail);
	txtstatus = (TextView)findViewById(R.id.txtstatus_registro);
	imgprimeiro =(ImageView)findViewById(R.id.imgprimeiro);
	imganterior =(ImageView)findViewById(R.id.imganterior);
	imgproximo =(ImageView)findViewById(R.id.imgproximo);
	imgultimo =(ImageView)findViewById(R.id.imgultimo);
	btalterardados = (Button)findViewById(R.id.btalterardados);
	
	try{
		db=openOrCreateDatabase("banco dados", Context.MODE_PRIVATE,null);
	c=db.query("usuarios", new String[]
			{"numreg","nome","telefone","email"},
	null,null,null,null,null);
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
		
	} catch (Exception e){
		
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
	
	diAlteraInformacoes = new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			// TODO Auto-generated method stub
			String nome =txtnome.getText().toString();
			String telefone =txttelefone.getText().toString();
			String email =txtemail.getText().toString();
		
			try{
				db.execSQL("update ususarios set nome= '" + nome +"',telefone= '" + telefone + "',email = '" + email + "' where numreg = "+numreg);
				MostraMensagem("Dados alterados com sucesso");
			} catch (Exception e){
				MostraMensagem("erro");
			}
}
		
	};
	
	btalterardados.setOnClickListener(new View.OnClickListener(){
		public void onClick(View arg0){
			AlertDialog.Builder dialogo = new
			AlertDialog.Builder(AlterarDadosActivity.this);
			dialogo.setTitle("Confirmar");
			dialogo.setMessage("deseja alterar as informações");
			dialogo.setNeutralButton("não",null);
			dialogo.setNegativeButton("sim",diAlteraInformacoes);
			dialogo.show();
}
	});
}
	public void MostraMensagem (String str){
		AlertDialog.Builder dialogo = new
		AlertDialog.Builder(AlterarDadosActivity.this);
		dialogo.setTitle("aviso");
		dialogo.setMessage(str);
		dialogo.setNeutralButton("ok",null);
	dialogo.show();	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alterar_dados, menu);
		return true;
	}

}
