package com.example.emsala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private TextView resultado;
    private CheckBox chkVerde;
    private CheckBox chkVermelho;
    private CheckBox chkBranca;
    private TextView corVerdeSel;
    private TextView corVermelhoSel;
    private TextView corBrancaSel;
    private RadioGroup imagemSexo;
    private ImageView figura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.txtNome);
        email = findViewById(R.id.txtEmail);
        resultado = findViewById(R.id.txtResultado);
        chkVerde = findViewById(R.id.chkVerde);
        chkVermelho = findViewById(R.id.chkVermelho);
        chkBranca = findViewById(R.id.chkBranca);
        corVerdeSel = findViewById(R.id.corVerdeSel);
        corVermelhoSel = findViewById(R.id.corVermelhoSel);
        corBrancaSel = findViewById(R.id.corBrancaSel);
        imagemSexo = findViewById(R.id.radioGroupSexo);
        figura = findViewById(R.id.figura);

        redioButtonSel();
    }

    public void capturar (View v)
    {

        String getNome = nome.getText().toString();
        String getEmail = email.getText().toString();
        String texto = "Nome: " + getNome + " | Email: " + getEmail;
        resultado.setText(texto);
        checkBoxSel();
    }

    public void limpar(View v)
    {
        nome.setText("");
        email.setText("");
        resultado.setText("");
        chkVerde.setChecked(false);
        chkVermelho.setChecked(false);
        chkBranca.setChecked(false);
    }

    public void checkBoxSel()
    {
        if ( chkVerde.isChecked())
            corVerdeSel.setBackgroundColor(getResources().getColor(R.color.green,getTheme()));
        else
            corVerdeSel.setBackgroundColor(getResources().getColor(R.color.black,getTheme()));

        if ( chkVermelho.isChecked())
            corVermelhoSel.setBackgroundColor(getResources().getColor(R.color.red,getTheme()));
        else
            corVermelhoSel.setBackgroundColor(getResources().getColor(R.color.black,getTheme()));

        if ( chkBranca.isChecked())
            corBrancaSel.setBackgroundColor(getResources().getColor(R.color.white,getTheme()));
        else
            corBrancaSel.setBackgroundColor(getResources().getColor(R.color.black,getTheme()));

    }

    public void redioButtonSel()
    {
        imagemSexo.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            if ( checkedId == R.id.radioFeminino) {
                figura.setImageResource(R.drawable.ic_baseline_pregnant_woman_24);
            } else if ( checkedId == R.id.radioMasculino)
                figura.setImageResource(R.drawable.ic_baseline_emoji_people_24);
        });
    }

}