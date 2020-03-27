package com.example.rentalcar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText entradaEmail, entradaSenha;
    private Button botaoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        botaoLogin = findViewById(R.id.botao_login);

    }

    //FUNÇÃO PARA VALIDAÇÃO DE CAMPOS
    private void validaCampos(){

        boolean res = false;

        String email = entradaEmail.getText().toString();
        String senha = entradaSenha.getText().toString();

        if (isCampoVazio(senha)){
            res = true;
        }

        if(res = isCampoVazio(email)){
            res = true;
        }

        if (res) {
            // EXIBE MENSAGEM DE CAMPOS EM BRANCO
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("AVISO");
            dlg.setMessage("Existem campos em branco, revise-os e tente novamente!");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        } else {

            // EXIBIR O EMAIL E SENHA DIGITADOS COM TOASTER
            Toast.makeText(getApplicationContext(),"Olá! você digitou o e-mail: " + email +
                    " e a senha: " + senha,Toast.LENGTH_LONG).show();
        }

    }

    //VERIFICA SE EXISTE CAMPOS VAZIOS
    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

}
