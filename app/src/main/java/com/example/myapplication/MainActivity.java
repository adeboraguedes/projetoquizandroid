package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

        TextView txvPergunta;
        RadioGroup rbgPrincipal;
         Button btnResponder;

         int pontuacao = 0;
        int indicePergunta = 0;

        // Perguntas
        private String[] perguntas = {
                "Pergunta 1: ",
                "Pergunta 2: ",
                "Pergunta 3:",
                "Pergunta 4: ",
                "Pergunta 5: "
        };

        // IDs das respostas corretas
        private int[] respostasCorretas = {
                R.id.rb_a, // Pergunta 1 -> rb_a
                R.id.rb_a, // Pergunta 2 -> rb_a
                R.id.rb_b, // Pergunta 3 -> rb_b
                R.id.rb_d, // Pergunta 4 -> rb_d
                R.id.rb_c  // Pergunta 5 -> rb_c
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);
            txvPergunta = findViewById(R.id.txvPerguntas);
            rbgPrincipal = findViewById(R.id.rdgPrincipal);
            btnResponder = findViewById(R.id.btnResponder);


            carregarPergunta();
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),(v,,insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

        }
        private void carregarPergunta() {
            if (indicePergunta < perguntas.length) {
                txvPergunta.setText(perguntas[indicePergunta]);
                rbgPrincipal.clearCheck();
                btnResponder.setEnabled(true);


            } else {
                txvPergunta.setText("Quiz finalizado!");
                btnResponder.setEnabled(false);

            }
        }

