//----------------------------------------------------------------------------------------------
package com.example.selftest;

//--------------------------------------------------------------------------------------------------
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.elgin.e1.Impressora.Termica;

//--------------------------------------------------------------------------------------------------
public class MainActivity extends AppCompatActivity {
       ImageView imgImpressora, imgPinpad, imgLeitor, imgBalanca;

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgImpressora = (ImageView) findViewById(R.id.imgImpressora);
        imgPinpad = (ImageView) findViewById(R.id.imgPinpad);
        imgLeitor = (ImageView) findViewById(R.id.imgLeitor);
        imgBalanca = (ImageView) findViewById(R.id.imgBalanca);

        listeners();
    }

    //----------------------------------------------------------------------------------------------
    private void listeners(){

        imgImpressora.setOnClickListener(v->{
            telaImpressora();
        });

        imgPinpad.setOnClickListener(v->{
            telaPinpad();
        });

        imgLeitor.setOnClickListener(v->{
            telaLeitor();
        });

        imgBalanca.setOnClickListener(v->{
            telaBalanca();
        });
    }

    //----------------------------------------------------------------------------------------------
    private void telaImpressora(){
        Intent intentImpressora = new Intent(this, Impressora.class);
        startActivity(intentImpressora);
    }

    //----------------------------------------------------------------------------------------------
    private void telaPinpad(){
        Intent intentPinpad = new Intent(this, Pinpad.class);
        startActivity(intentPinpad);
    }

    //----------------------------------------------------------------------------------------------
    private void telaLeitor(){
        Intent intentLeitor = new Intent(this, Leitor.class);
        startActivity(intentLeitor);
    }

    //----------------------------------------------------------------------------------------------
    private void telaBalanca(){
        Intent intentBalanca = new Intent(this, Balanca.class);
        startActivity(intentBalanca);

        //pinpad.SetBaudRate(2400, 8, 1 , 0);
        //pinpad.TestePIX4();
    }

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Termica.FechaConexaoImpressora();
    }

    //----------------------------------------------------------------------------------------------
}