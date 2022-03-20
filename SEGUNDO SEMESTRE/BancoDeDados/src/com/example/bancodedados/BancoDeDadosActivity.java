package com.example.bancodedados;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class BancoDeDadosActivity extends Activity {
	Button btcadastrardados,btcadastrardados2,btconsultardados,btalterardados,btalterardos2,btexcluirdados,btexcluirdados2;
	
	SQLiteDatabase db;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_de_dados);
    
        btcadastrardados=(Button) findViewById(R.id.btcadastardados);
        btcadastrardados2=(Button) findViewById(R.id.btcadastardados2);
        btalterardados=(Button) findViewById(R.id.btalterardados);
        btalterardos2=(Button) findViewById(R.id.btalterardados2);
        btexcluirdados=(Button) findViewById(R.id.btexcluirdados);
        btexcluirdados2=(Button) findViewById(R.id.btexcluirdados2);
        btconsultardados=(Button) findViewById(R.id.btconsultardados);
        
        try{
        	db = openOrCreateDatabase("Banco_dados", Context.MODE_PRIVATE, null);
        	
        	db.execSQL("create table if not existe usuarios"+"(numreg integer primary key autoincrement,"+"nome text not null,"+"email text not null)");
        	
        	AlertDialog.Builder dialogo = new AlertDialog.Builder(BancoDeDadosActivity.this);
        	dialogo.setTitle("Aviso").setMessage("Banco de Dados Criado com sucesso").setNeutralButton("OK", null).show();
        } catch (Exception e){
        	//TODO: handle exception
        	
        }
        btcadastrardados.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent gravaRegistroActivity = new
		Intent (BancoDeDadosActivity.this,
		GravaRegistrosActivity.class);
		BancoDeDadosActivity.this.startActivity(gravaRegistroActivity);
		
	}
});
        btcadastrardados2.setOnClickListener(new View.OnClickListener() {
        	
        	@Override
        	public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		Intent gravaRegistro2Activity = new
        		Intent (BancoDeDadosActivity.this,
        		GravaRegistro2Activity.class);
        		BancoDeDadosActivity.this.startActivity(gravaRegistro2Activity);
        		
        	}
        });
        btconsultardados.setOnClickListener(new View.OnClickListener() {
        	
        	@Override
        	public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		Intent ConsultarDadosActivity = new
        		Intent (BancoDeDadosActivity.this,
        		ConsultarDadosActivity.class);
        		BancoDeDadosActivity.this.startActivity(ConsultarDadosActivity);
        		
        	}
        });

        btalterardados.setOnClickListener(new View.OnClickListener() {
        	
        	@Override
        	public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		Intent AlterarDadosActivity = new
        		Intent (BancoDeDadosActivity.this,
        		AlterarDadosActivity.class);
        		BancoDeDadosActivity.this.startActivity(AlterarDadosActivity);
        		
        	}
        }); 
        btalterardos2.setOnClickListener(new View.OnClickListener() {
    	
    	@Override
    	public void onClick(View arg0) {
    		// TODO Auto-generated method stub
    		Intent AlterarDados2Activity = new
    		Intent (BancoDeDadosActivity.this,
    		AlterarDados2Activity.class);
    		BancoDeDadosActivity.this.startActivity(AlterarDados2Activity);
    		
    	}
    });
		btexcluirdados.setOnClickListener(new View.OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View arg0) {
	    		// TODO Auto-generated method stub
	    		Intent ExcluirDadosActivity = new
	    		Intent (BancoDeDadosActivity.this,
	    		ExcluirDadosActivity.class);
	    		BancoDeDadosActivity.this.startActivity(ExcluirDadosActivity);
	    		
	    	}
	    });
btexcluirdados2.setOnClickListener(new View.OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View arg0) {
	    		// TODO Auto-generated method stub
	    		Intent ExcluirDados2Activity = new
	    		Intent (BancoDeDadosActivity.this,
	    		ExcluirDados2Activity.class);
	    		BancoDeDadosActivity.this.startActivity(ExcluirDados2Activity);
	    		
	    	}
	    });
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.banco_de_dados, menu);
        return true;
    }
    
}
