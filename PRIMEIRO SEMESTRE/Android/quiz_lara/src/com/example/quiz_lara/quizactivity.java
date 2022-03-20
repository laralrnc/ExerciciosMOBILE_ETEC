package com.example.quiz_lara;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class quizactivity {
	

	public void btnresponderOnClick(View v){
        RadioGroup rgrespostas = (RadioGroup)findViewById(R.id.rgrespostas);
        Intent intent = new Intent();
        intent.putExtra("acertou", rgrespostas.getCheckedRadioButtonId() == R.id.rbresposta1);
        startActivity(intent);
}
private RadioGroup findViewById(Object rgrespostas) {
		// TODO Auto-generated method stub
		return null;
	}
private void startActivity(Intent intent) {
		// TODO Auto-generated method stub
		
	}
}