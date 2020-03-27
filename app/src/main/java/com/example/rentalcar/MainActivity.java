package com.example.rentalcar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText entradaDias;
    private Button botaoAlugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
        botaoAlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaDias();

            }
        });
    }

    //INICIALIZAÇÃO DOS COMPONENTES
    private void inicializarComponentes() {
        entradaDias = findViewById(R.id.dias);
        botaoAlugar = findViewById(R.id.btnAlugar);
    }

    private void validaDias() {

        String diasTxt = entradaDias.getText().toString();
        boolean res = false;

        if (isCampoVazio(diasTxt)) {
            res = true;
        }
        if (res) {
            // EXIBE MENSAGEM DE CAMPOS EM BRANCO
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("AVISO");
            dlg.setMessage("O campo de dias está em branco, preencha-o e tente novamente!");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        } else {
            // CONVERTE DIAS EM INTEIRO
            int dias = Integer.parseInt(entradaDias.getText().toString());
            // EXIBE MENSAGEM CASO SEJA DIGITADO ZERO
            if (dias == 0) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("AVISO");
                dlg.setMessage("Quantidade de dias inválido. Tente novamente.");
                dlg.setNeutralButton("OK", null);
                dlg.show();
            } else {
                if (dias <= 5) {
                    // EXIBE MENSAGEM DE SUCESSO PARA A RETIRADA DO CARRO
                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setTitle("AVISO");
                    dlg.setMessage("Veículo alugado por " + dias + " dias com sucesso! Dirija-se a uma loja da Rua Saubrigonal para retirá-lo.");
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                } else {
                    // EXIBE MENSAGEM DE QUE O CARRO NÃO ESTÁ DISPONÍVEL PARA ESSA QUANTIDADE DE DIAS
                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setTitle("AVISO");
                    dlg.setMessage("Veículo indisponível para esta quantidade de dias, tente uma quantidade menor ou outro veículo.");
                    dlg.setNeutralButton("OK", null);
                    dlg.show();
                }
            }

        }

    }

    // FUNÇÃO DE VALIDAÇÃO DE CAMPO VAZIO
    private boolean isCampoVazio(String valor) {
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }
}

