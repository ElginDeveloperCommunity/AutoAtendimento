//--------------------------------------------------------------------------------------------------
package com.example.selftest;

//--------------------------------------------------------------------------------------------------
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.elgin.e1.Balanca.BalancaE1;

import java.util.HashMap;
import java.util.Map;

//--------------------------------------------------------------------------------------------------
public class Balanca extends AppCompatActivity {

    //----------------------------------------------------------------------------------------------
    TextView textReturnValueBalanca;
    Spinner spinnerModelos, spinnerProtocols;
    Button buttonConfigurarBalanca;
    Button buttonLerPeso;

    EditText baudRate;

    //----------------------------------------------------------------------------------------------
    String typeModel = "DP30CK";
    String typeProtocol = "PROTOCOL 0";

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balanca);

        textReturnValueBalanca = findViewById(R.id.textReturnValueBalanca);
        spinnerModelos = findViewById(R.id.spinnerModelo);
        spinnerProtocols = findViewById(R.id.spinnerProtocols);
        buttonConfigurarBalanca = findViewById(R.id.buttonConfigurarBalanca);
        buttonLerPeso = findViewById(R.id.buttonLerPeso);
        baudRate = findViewById(R.id.editTextBaudRate);

        buttonConfigurarBalanca.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        listeners();
    }

    //----------------------------------------------------------------------------------------------
    private void listeners(){
        //Balança ----------------------------------------------------------------------------------
        spinnerModelos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                typeModel = adapter.getItemAtPosition(i).toString();
            }
        });

        //Protocolo --------------------------------------------------------------------------------
        spinnerProtocols.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                typeProtocol = adapter.getItemAtPosition(i).toString();
            }
        });

        //------------------------------------------------------------------------------------------
        buttonConfigurarBalanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendConfigBalanca();
            }
        });

        //------------------------------------------------------------------------------------------
        buttonLerPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { sendLerPesoBalanca(); }
        });

        //------------------------------------------------------------------------------------------
    }

    //----------------------------------------------------------------------------------------------
    public void sendConfigBalanca(){
        Map<String, Object> mapValues = new HashMap<>();
        mapValues.put("model", typeModel);
        mapValues.put("protocol", typeProtocol);

        configBalanca(mapValues);
    }

    //----------------------------------------------------------------------------------------------
    public void sendLerPesoBalanca(){
        String retorno = lerPesoBalanca();
        textReturnValueBalanca.setText(retorno);
    }

    //----------------------------------------------------------------------------------------------
    public String configBalanca(Map map) {
        String modelBalanca = (String) map.get("model");
        String protocol = (String) map.get("protocol");

        int MODEL = 3;
        int PROTOCOL = 0;

        switch (modelBalanca) {
            case "DP3005":
                MODEL = 0;
                break;
            case "SA110":
                MODEL = 1;
                break;
            case "DPSC":
                MODEL = 2;
                break;
            case "DP30CK":
                MODEL = 3;
                break;
            default:
                MODEL = 3;
        }

        switch (protocol) {
            case "PROTOCOLO 0":
                PROTOCOL = 0;
                break;
            case "PROTOCOLO 1":
                PROTOCOL = 1;
                break;
            case "PROTOCOLO 2":
                PROTOCOL = 2;
                break;
            case "PROTOCOLO 3":
                PROTOCOL = 3;
                break;
            case "PROTOCOLO 4":
                PROTOCOL = 4;
                break;
            case "PROTOCOLO 5":
                PROTOCOL = 5;
                break;
            case "PROTOCOLO 6":
                PROTOCOL = 6;
                break;
            case "PROTOCOLO 7":
                PROTOCOL = 7;
                break;
            default:
                PROTOCOL = 0;
        }

        int retorno1 = BalancaE1.ConfigurarModeloBalanca(MODEL);
        int retorno2 = BalancaE1.ConfigurarProtocoloComunicacao(PROTOCOL);
        mostrarRetorno(String.format("\nConfigurarModeloBalanca: %d\nConfigurarProtocoloComunicacao: %d", retorno1, retorno2));

        return  String.valueOf(retorno1);
    }

    //----------------------------------------------------------------------------------------------
    public String lerPesoBalanca() {
        String sBaudRate = baudRate.getText().toString();
        int retorno1 = BalancaE1.AbrirSerial( Integer.parseInt(sBaudRate), 8, 'n', 1);
        String retorno2 = BalancaE1.LerPeso(1);
        int retorno3 = BalancaE1.Fechar();
        mostrarRetorno(String.format("\nAbrirSerial: %d\nLerPeso: %s\nFechar: %d", retorno1, retorno2, retorno3));

        return  String.valueOf(retorno2);
    }

    //----------------------------------------------------------------------------------------------
    private void mostrarRetorno(String retorno) {
        Toast.makeText(this, String.format("Retorno: %s", retorno), Toast.LENGTH_SHORT).show();
    }

    //----------------------------------------------------------------------------------------------
}