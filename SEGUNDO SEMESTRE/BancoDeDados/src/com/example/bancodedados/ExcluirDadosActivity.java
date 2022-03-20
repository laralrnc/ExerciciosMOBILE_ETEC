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

public class ExcluirDadosActivity extends Activity {

	EditText txtnome, txttelefone, txtemail;
	TextView txtstatus;
	SQLiteDatabase db;
	ImageView imgprimeiro, imganterior, imgproximo, imgultimo;
	Button btexcluirdados;
	int indice, numreg;
	Cursor c;
	DialogInterface.OnClickListener diExluirRegistro;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_excluir_dados);
		
		txtnome = (EditText)findViewById(R.id.txtnome);
		txttelefone = (EditText)findViewById(R.id.txttelefone);
		txtemail = (EditText)findViewById(R.id.txtemail);
		txtstatus = (TextView)findViewById(R.id.txtstatus_registro);
		imgprimeiro =(ImageView)findViewById(R.id.imgprimeiro);
		imganterior =(ImageView)findViewById(R.id.imganterior);
		imgproximo =(ImageView)findViewById(R.id.imgproximo);
		imgultimo =(ImageView)findViewById(R.id.imgultimo);
		btexcluirdados = (Button)findViewById(R.id.btexcluirdados);
		txtnome.setText("");
		txtemail.setText("");
		txttelefone.setText("");
		
		try{
			db=openOrCreateDatabase("banco dados", Context.MODE_PRIVATE,null);
		
		
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
				diExluirRegistro=new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						db.execSQL("delete from usuarios where numreg="+numreg);
						CarregaDados();
						MostraMensagem("dados exluidos com sucesso");
					}
				};
				btexcluirdados.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if(c.getCount()>0){
							AlertDialog.Builder dialogo = new
									AlertDialog.Builder(ExcluirDadosActivity.this);
									dialogo.setTitle("Confirmar");
									dialogo.setMessage("deseja excluir esse registro?");
									dialogo.setPositiveButton("sim",diExluirRegistro);
									dialogo.setNegativeButton("Não",null);
									dialogo.show();
						}else{
							MostraMensagem("não existem registros para excluir");
						}
					}
				});
		} catch (Exception e){
			MostraMensagem("erro:"+e.toString());
		}
	}
	public void CarregaDados(){
		c=db.query("usuarios",new String []{"numreg","nome","telefone","email"},null,null,null,null,null);
		txtnome.setText("");
		txtemail.setText("");
		txttelefone.setText("");
		if(c.getCount()>0){
			c.moveToFirst();
			indice=1;
			numreg=c.getInt(0);
			txtnome.setText(c.getString(1));
			txttelefone.setText(c.getString(2));
			txtemail.setText(c.getString(3));
			txtstatus.setText(indice+"/"+c.getCount());
		}else{
			txtstatus.setText("nehum registro");
		}
	}
	public void MostraMensagem (String str){
		AlertDialog.Builder dialogo = new
		AlertDialog.Builder(ExcluirDadosActivity.this);
		dialogo.setTitle("aviso");
		dialogo.setMessage(str);
		dialogo.setNeutralButton("ok",null);
	dialogo.show();	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.excluir_dados, menu);
		return true;
	}

}
