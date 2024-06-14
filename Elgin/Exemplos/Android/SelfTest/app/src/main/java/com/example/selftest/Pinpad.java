//--------------------------------------------------------------------------------------------------
package com.example.selftest;

//--------------------------------------------------------------------------------------------------
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.libpinpadaar.libPinpadAAR;

//--------------------------------------------------------------------------------------------------
public class Pinpad extends AppCompatActivity {
    TextView textoStatus;
    EditText editTextoPinpad;
    Button buttonStatusPinpad, buttonEscrevePinpad;

    libPinpadAAR pinpad;

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinpad);

        textoStatus = findViewById(R.id.textoStatus);
        editTextoPinpad = findViewById(R.id.editTextoPinpad);
        buttonStatusPinpad = findViewById(R.id.buttonStatusPinpad);
        buttonEscrevePinpad = findViewById(R.id.buttonEscrevePinpad);

        pinpad = new libPinpadAAR(this);

        buttonStatusPinpad.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        listeners();
    }

    //----------------------------------------------------------------------------------------------
    private void listeners(){

        buttonStatusPinpad.setOnClickListener(v->{
            VerificarStatusPinpad();
        });

        buttonEscrevePinpad.setOnClickListener(v->{
            //TestarPIX4();
            EscreverTextoPinpad();
        });
    }

    //----------------------------------------------------------------------------------------------
    private void VerificarStatusPinpad(){
        AtualizarStatus(pinpad.VerificarPresencaPinpad());
    }

    //----------------------------------------------------------------------------------------------
    private void EscreverTextoPinpad(){
        String sTexto = editTextoPinpad.getText().toString();
        AtualizarStatus(pinpad.EscreverTextoPinpad(sTexto));
    }

    //----------------------------------------------------------------------------------------------
    private void AtualizarStatus(boolean b){
        if(b)
            textoStatus.setText("Pinpad encontrado com sucesso");
        else
            textoStatus.setText("Pinpad não encontrado");
    }

    //----------------------------------------------------------------------------------------------
    private void TestarPIX4(){
        pinpad.SetBaudRate(2400, 8, 1 , 0);
        pinpad.TestePIX4();
    }

    //----------------------------------------------------------------------------------------------
}