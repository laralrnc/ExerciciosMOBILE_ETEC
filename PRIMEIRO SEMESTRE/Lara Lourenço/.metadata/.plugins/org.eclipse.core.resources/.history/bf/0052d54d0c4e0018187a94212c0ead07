package MainActivity.java;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.quiz_lara.R;

public class MainActivity extends AppCompatActivity {

    
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

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setContentView(int activityMain) {
		// TODO Auto-generated method stub
		
	}

	public void startEvaluation(View view) {
        String[] answers = evaluateGui11();

        int result = evaluateQuiz(answers);

        toastResult(result);
    }

			String[] evaluateGui11() {
	        String[] ret = new String[10];
	        CheckBox checkBoxQuestion1SP = findViewById(R.id.question_1_SP);
	        CheckBox checkBoxQuestion1RJ = findViewById(R.id.question_1_RJ);
	        CheckBox checkBoxQuestion1BH = findViewById(R.id.question_1_BH);

	        setAnswerQuestion1(false);

	        if (checkBoxQuestion1SP.isChecked() == true && checkBoxQuestion1RJ.isChecked() == false && checkBoxQuestion1BH.isChecked() == false) {
	            setAnswerQuestion1(true);}
	        
	 			
		        
		        CheckBox checkBoxQuestion2PAC = findViewById(R.id.question_2_PAC);
		        CheckBox checkBoxQuestion2CC = findViewById(R.id.question_2_CC);
		        CheckBox checkBoxQuestion2VG = findViewById(R.id.question_2_VG);

		         setAnswerQuestion2(false);

		        if (checkBoxQuestion2PAC.isChecked() == true && checkBoxQuestion2CC.isChecked() == false && checkBoxQuestion2VG.isChecked() == false) {
		            setAnswerQuestion2(true);}
		        
	 			
				
				
				CheckBox checkBoxQuestion3jupiter = findViewById(R.id.question_3_jupiter);
				CheckBox checkBoxQuestion3saturno = findViewById(R.id.question_3_saturno);
				CheckBox checkBoxQuestion3marte = findViewById(R.id.question_3_marte);
				
				setAnswerQuestion3(false);
				
			if (checkBoxQuestion3jupiter.isChecked() == true && checkBoxQuestion3saturno.isChecked() == false && checkBoxQuestion3marte.isChecked() == false) {
				setAnswerQuestion3(true);}
			        		        
			
				
			
				CheckBox checkBoxQuestion4verao = findViewById(R.id.question_4_verao);
				CheckBox checkBoxQuestion4inverno = findViewById(R.id.question_4_inverno);
				CheckBox checkBoxQuestion4outono = findViewById(R.id.question_4_outono);
				
				setAnswerQuestion4(false);
				
			if (checkBoxQuestion4verao.isChecked() == false && checkBoxQuestion4inverno.isChecked() == true && checkBoxQuestion4outono.isChecked() == false) {
				setAnswerQuestion4(true);}
			       	
			
				
				
				CheckBox checkBoxQuestion5rio = findViewById(R.id.question_5_rio);
				CheckBox checkBoxQuestion5gramado = findViewById(R.id.question_5_gramado);
				CheckBox checkBoxQuestion5campos= findViewById(R.id.question_5_campos);
				
				setAnswerQuestion5(false);
				
			if (checkBoxQuestion5rio.isChecked() == true && checkBoxQuestion5gramado.isChecked() == false && checkBoxQuestion5campos.isChecked() == false) {
				setAnswerQuestion5(true);}
			        	
			
				
				CheckBox checkBoxQuestion6peru = findViewById(R.id.question_6_peru);
				CheckBox checkBoxQuestion6chile = findViewById(R.id.question_6_chile);
				CheckBox checkBoxQuestion6uruguai = findViewById(R.id.question_6_uruguai);
				
				 setAnswerQuestion6(false);
				
			if (checkBoxQuestion6peru.isChecked() == true && checkBoxQuestion6chile.isChecked() == false && checkBoxQuestion6uruguai.isChecked() == false) {
				setAnswerQuestion6(true);}
			        	
			
				
				
				CheckBox checkBoxQuestion7ovni1 = findViewById(R.id.question_7_ovni1);
				CheckBox checkBoxQuestion7ovni2 = findViewById(R.id.question_7_ovni2);
				CheckBox checkBoxQuestion7ovni3 = findViewById(R.id.question_7_ovni3);
				
				 setAnswerQuestion7(false);
				
			if (checkBoxQuestion7ovni1.isChecked() == true && checkBoxQuestion7ovni2.isChecked() == false && checkBoxQuestion7ovni3.isChecked() == false) {
				setAnswerQuestion7(true);}
			        	
			
				;
				
				CheckBox checkBoxQuestion8sol = findViewById(R.id.question_8_sol);
				CheckBox checkBoxQuestion8lua = findViewById(R.id.question_8_lua);
				CheckBox checkBoxQuestion8alfa = findViewById(R.id.question_8_alfa);
				
				 setAnswerQuestion8(false);
			
			if (checkBoxQuestion8sol.isChecked() == true && checkBoxQuestion8lua.isChecked() == false && checkBoxQuestion8alfa.isChecked() == false) {
				setAnswerQuestion8(true);}
			     
			
				
				
				CheckBox checkBoxQuestion9onu1 = findViewById(R.id.question_9_onu1);
				CheckBox checkBoxQuestion9onu2 = findViewById(R.id.question_9_onu2);
				CheckBox checkBoxQuestion9onu3 = findViewById(R.id.question_9_onu3);
				
				 setAnswerQuestion9(false);
				
			if (checkBoxQuestion9onu1.isChecked() == true && checkBoxQuestion9onu2.isChecked() == false && checkBoxQuestion9onu3.isChecked() == false) {
				setAnswerQuestion9(true);}
			        
			
				
				
				CheckBox checkBoxQuestion10_50 = findViewById(R.id.question_10_50);
				CheckBox checkBoxQuestion10_40 = findViewById(R.id.question_10_40);
				CheckBox checkBoxQuestion10_35 = findViewById(R.id.question_10_35);
				
				 answerQuestion10 = false;
				
			if (checkBoxQuestion10_50.isChecked() == true && checkBoxQuestion10_40.isChecked() == false && checkBoxQuestion10_35.isChecked() == false) {
				answerQuestion10 = true;}
			return ret;
			        
     
	 }

    private CheckBox findViewById(Object question_1) {
		// TODO Auto-generated method stub
		return null;
	}

	public int evaluateQuiz(String[] answers) {
        int result = 0;
        String[] correctAnswers = {"SÃO PAULO", "Pedro Álvares Cabral", "jupiter", "primavera", "rio de janeiro" , "Peru" , "Objeto Voador Não Identificado", "sol","Organização das Nações Unidas","50 anos"};

        for (int i = 0; i < correctAnswers.length; i++) {
            if (answers[i].equals(correctAnswers[i])) {
                result++;
            }
        }

        return result;
    }

    public void toastResult(int result) {
        String message = result + " DE 10. ";

        if ((result == 0) || (result ==4)) {
            message += "I.";
        } else if ((result == 5) || (result == 7)) {
            message += "R.";
        } else if ((result == 8) || (result ==9)) {
            message += "B.";
        } else if (result == 10) {
            message += "MB!!!";
        }



        Toast reportResult = Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT);
        reportResult.show();
    }

   

    private Context getApplicationContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public void reset(View view) {
     

        CheckBox checkBox = findViewById(R.id.question_1_SP);
        checkBox.setChecked(true);

        checkBox = findViewById(R.id.question_2_PAC);
        checkBox.setChecked(true);

        checkBox = findViewById(R.id.question_3_jupiter);
        checkBox.setChecked(true);

        checkBox = findViewById(R.id.question_4_inverno);
        checkBox.setChecked(true);

        checkBox = findViewById(R.id.question_5_rio);
        checkBox.setChecked(true);

        checkBox = findViewById(R.id.question_6_peru);
        checkBox.setChecked(true);

        checkBox = findViewById(R.id.question_7_ovni2);
        checkBox.setChecked(true);

        checkBox = findViewById(R.id.question_8_sol);
        checkBox.setChecked(true);
        
        checkBox = findViewById(R.id.question_9_onu1);
        checkBox.setChecked(true);
        
        checkBox = findViewById(R.id.question_10_50);
        checkBox.setChecked(true);
    }

	public Boolean getAnswerQuestion1() {
		return answerQuestion1;
	}

	public void setAnswerQuestion1(Boolean answerQuestion1) {
		this.answerQuestion1 = answerQuestion1;
	}

	public Boolean getAnswerQuestion2() {
		return answerQuestion2;
	}

	public void setAnswerQuestion2(Boolean answerQuestion2) {
		this.answerQuestion2 = answerQuestion2;
	}

	public Boolean getAnswerQuestion3() {
		return answerQuestion3;
	}

	public void setAnswerQuestion3(Boolean answerQuestion3) {
		this.answerQuestion3 = answerQuestion3;
	}

	public Boolean getAnswerQuestion5() {
		return answerQuestion5;
	}

	public void setAnswerQuestion5(Boolean answerQuestion5) {
		this.answerQuestion5 = answerQuestion5;
	}

	public Boolean getAnswerQuestion4() {
		return answerQuestion4;
	}

	public void setAnswerQuestion4(Boolean answerQuestion4) {
		this.answerQuestion4 = answerQuestion4;
	}

	public Boolean getAnswerQuestion6() {
		return answerQuestion6;
	}

	public void setAnswerQuestion6(Boolean answerQuestion6) {
		this.answerQuestion6 = answerQuestion6;
	}

	public Boolean getAnswerQuestion7() {
		return answerQuestion7;
	}

	public void setAnswerQuestion7(Boolean answerQuestion7) {
		this.answerQuestion7 = answerQuestion7;
	}

	public Boolean getAnswerQuestion8() {
		return answerQuestion8;
	}

	public void setAnswerQuestion8(Boolean answerQuestion8) {
		this.answerQuestion8 = answerQuestion8;
	}

	public Boolean getAnswerQuestion9() {
		return answerQuestion9;
	}

	public void setAnswerQuestion9(Boolean answerQuestion9) {
		this.answerQuestion9 = answerQuestion9;
	}
}