package com.example.ttt;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

	public class MainActivity extends Activity {
	
	private int result;
	private Button startEvaluation;
	TextView res;
	private int result2;
	private int respostas;
	private Boolean answerQuestion1;
	private Boolean answerQuestion2;
	private Boolean answerQuestion3;
	private Boolean answerQuestion4;
	private Boolean answerQuestion5;
	private Boolean answerQuestion6;
	private Boolean answerQuestion7;
	private Boolean answerQuestion8;
	private Boolean answerQuestion9;
	private Boolean answerQuestion10;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startEvaluation = (Button)findViewById(R.id.evaluate);
        startEvaluation.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				res();
			}
		});
    }
    		public void res(){
    	setContentView(R.layout.resposta);
    	
        }
    



		
    		public String[] evaluateGui11() {
    				String[] ret = new String[10];
	        CheckBox checkBoxQuestion1SP = (CheckBox) findViewById(R.id.question_1_SP);
	        CheckBox checkBoxQuestion1RJ = (CheckBox)findViewById(R.id.question_1_RJ);
	        CheckBox checkBoxQuestion1BH = (CheckBox)findViewById(R.id.question_1_BH);

	        answerQuestion1 = false;

	        if (checkBoxQuestion1SP.isChecked() == true && checkBoxQuestion1RJ.isChecked() == false && checkBoxQuestion1BH.isChecked() == false) {
	        	answerQuestion1 = true;
	        	result = +1;}
	        
	 			
		        
		        CheckBox checkBoxQuestion2PAC = (CheckBox)findViewById(R.id.question_2_PAC);
		        CheckBox checkBoxQuestion2CC = (CheckBox)findViewById(R.id.question_2_CC);
		        CheckBox checkBoxQuestion2VG = (CheckBox)findViewById(R.id.question_2_VG);

		        answerQuestion2 = false;

		        if (checkBoxQuestion2PAC.isChecked() == true && checkBoxQuestion2CC.isChecked() == false && checkBoxQuestion2VG.isChecked() == false) {
		        	answerQuestion2 = true;
		        	result = +1;}
		        
	 			
				
				
				CheckBox checkBoxQuestion3jupiter =(CheckBox) findViewById(R.id.question_3_jupiter);
				CheckBox checkBoxQuestion3saturno = (CheckBox)findViewById(R.id.question_3_saturno);
				CheckBox checkBoxQuestion3marte = (CheckBox)findViewById(R.id.question_3_marte);
				answerQuestion3 = false;
				
				
			if (checkBoxQuestion3jupiter.isChecked() == true && checkBoxQuestion3saturno.isChecked() == false && checkBoxQuestion3marte.isChecked() == false) {
				answerQuestion3 = true;
				result = +1;;}
			        		        
			
				
			
				CheckBox checkBoxQuestion4verao = (CheckBox)findViewById(R.id.question_4_verao);
				CheckBox checkBoxQuestion4inverno = (CheckBox)findViewById(R.id.question_4_inverno);
				CheckBox checkBoxQuestion4outono = (CheckBox)findViewById(R.id.question_4_outono);
				
				answerQuestion4 = false;
				
			if (checkBoxQuestion4verao.isChecked() == false && checkBoxQuestion4inverno.isChecked() == true && checkBoxQuestion4outono.isChecked() == false) {
				answerQuestion4 = true;
				result = +1;}
			       	
			
				
				
				CheckBox checkBoxQuestion5rio = (CheckBox)findViewById(R.id.question_5_rio);
				CheckBox checkBoxQuestion5gramado = (CheckBox)findViewById(R.id.question_5_gramado);
				CheckBox checkBoxQuestion5campos= (CheckBox)findViewById(R.id.question_5_campos);
				
				answerQuestion5 = false;
				
			if (checkBoxQuestion5rio.isChecked() == true && checkBoxQuestion5gramado.isChecked() == false && checkBoxQuestion5campos.isChecked() == false) {
				answerQuestion5= true;
				result = +1;}
			        	
			
				
				CheckBox checkBoxQuestion6peru = (CheckBox)findViewById(R.id.question_6_peru);
				CheckBox checkBoxQuestion6chile = (CheckBox)findViewById(R.id.question_6_chile);
				CheckBox checkBoxQuestion6uruguai = (CheckBox)findViewById(R.id.question_6_uruguai);
				
				answerQuestion6 = false;
				
			if (checkBoxQuestion6peru.isChecked() == true && checkBoxQuestion6chile.isChecked() == false && checkBoxQuestion6uruguai.isChecked() == false) {
				answerQuestion6 = true;
				result = +1;}
			        	
			
				
				
				CheckBox checkBoxQuestion7ovni1 = (CheckBox)findViewById(R.id.question_7_ovni1);
				CheckBox checkBoxQuestion7ovni2 = (CheckBox)findViewById(R.id.question_7_ovni2);
				CheckBox checkBoxQuestion7ovni3 = (CheckBox)findViewById(R.id.question_7_ovni3);
				
				answerQuestion7 = false;
				
			if (checkBoxQuestion7ovni1.isChecked() == true && checkBoxQuestion7ovni2.isChecked() == false && checkBoxQuestion7ovni3.isChecked() == false) {
				answerQuestion7 = true;
				result = +1;}
			        	
			
				;
				
				CheckBox checkBoxQuestion8sol = (CheckBox)findViewById(R.id.question_8_sol);
				CheckBox checkBoxQuestion8lua = (CheckBox)findViewById(R.id.question_8_lua);
				CheckBox checkBoxQuestion8alfa = (CheckBox)findViewById(R.id.question_8_alfa);
				
				answerQuestion8 = false;
			
			if (checkBoxQuestion8sol.isChecked() == true && checkBoxQuestion8lua.isChecked() == false && checkBoxQuestion8alfa.isChecked() == false) {
				answerQuestion8 = true;
				result = +1;}
			     
			
				
				
				CheckBox checkBoxQuestion9onu1 = (CheckBox)findViewById(R.id.question_9_onu1);
				CheckBox checkBoxQuestion9onu2 = (CheckBox)findViewById(R.id.question_9_onu2);
				CheckBox checkBoxQuestion9onu3 = (CheckBox)findViewById(R.id.question_9_onu3);
				
				answerQuestion9 = false;
				
			if (checkBoxQuestion9onu1.isChecked() == true && checkBoxQuestion9onu2.isChecked() == false && checkBoxQuestion9onu3.isChecked() == false) {
				answerQuestion9 = true;
				result = +1;}
			        
			
				
				
				CheckBox checkBoxQuestion10_50 = (CheckBox)findViewById(R.id.question_10_50);
				CheckBox checkBoxQuestion10_40 = (CheckBox)findViewById(R.id.question_10_40);
				CheckBox checkBoxQuestion10_35 = (CheckBox)findViewById(R.id.question_10_35);
				
				 answerQuestion10 = false;
				
			if (checkBoxQuestion10_50.isChecked() == true && checkBoxQuestion10_40.isChecked() == false && checkBoxQuestion10_35.isChecked() == false) {
				answerQuestion10 = true;
				result = +1;}
			return ret;
			
		}  
     
	 


    
	

}



   

    
    

