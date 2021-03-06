package com.example.rentalcar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;


public class aluguelActivity extends AppCompatActivity {


    private EditText entradaDias;
    private Button botaoAlugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aluguel);

        inicializarComponentes();
        botaoAlugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaDias();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.carro:
                Toast.makeText(getApplicationContext(), "Você ja está na página do carro...", Toast.LENGTH_LONG).show();
                return true;
            case R.id.registro:
                Intent intent2 = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(intent2);
                return true;
            case R.id.toaster:
                Toast.makeText(getApplicationContext(), "Exibindo Taoster", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

