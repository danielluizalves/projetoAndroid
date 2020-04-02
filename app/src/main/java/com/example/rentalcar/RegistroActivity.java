package com.example.rentalcar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegistroActivity extends AppCompatActivity {

    private EditText entradaEmail, entradaSenha, entradaConfirma;
    private Button botaoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        inicializarComponentes();

        //AÇÕES DO BOTÃO
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaCampos();
            }
        });

    }

    private void inicializarComponentes() {
        entradaEmail = findViewById(R.id.email);
        entradaSenha  = findViewById(R.id.dias);
        entradaConfirma = findViewById(R.id.senha2);
        botaoLogin = findViewById(R.id.botao_login);

    }

    //FUNÇÃO PARA VALIDAÇÃO DE CAMPOS
    private void validaCampos(){

        boolean res = false;
        boolean confirma = false;

        String email = entradaEmail.getText().toString();
        String senha = entradaSenha.getText().toString();
        String senha2 = entradaConfirma.getText().toString();

        if (isCampoVazio(senha)){
            res = true;
        }

        if(isCampoVazio(email)){
            res = true;
        }

        if(isCampoVazio(senha2)){
            res = true;
        }

        if(senha.equals(senha2)){
            confirma = true;
        }

        if (res) {
            // EXIBE MENSAGEM DE CAMPOS EM BRANCO
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("AVISO");
            dlg.setMessage("Existem campos em branco, revise-os e tente novamente!");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }else {
            if(confirma){
                chamaTela();
            } else {
                // EXIBE MENSAGEM DE SENHAS DIFERENTES
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setTitle("AVISO");
                dlg.setMessage("As senhas informadas são diferentes, revise-as e tente novamente!");
                dlg.setNeutralButton("OK", null);
                dlg.show();
            }
        }

    }

    //VERIFICA SE EXISTE CAMPOS VAZIOS
    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    private void chamaTela(){
        Intent objIntent = new Intent(RegistroActivity.this, aluguelActivity.class);
        startActivity(objIntent);

        Toast.makeText(getApplicationContext(),"Cadastrado com sucesso! Já pode alugar seus carros." ,Toast.LENGTH_LONG).show();

    }

}
