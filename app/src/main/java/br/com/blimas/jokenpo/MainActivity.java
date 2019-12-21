package br.com.blimas.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("JOKENPO");
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }


    public void opcaoSelecionada (String escolhaJogador){

        //array de opcoes do jogo
        String[] opcoesJogo = {
                "Pedra",
                "Papel",
                "Tesoura"
        };

        //sorteia uma opcao para o app
        int sortearParaApp = new Random().nextInt(3);
        String escolhaApp = opcoesJogo[sortearParaApp];

        //seleciona campo imagem app
        ImageView imagemEscolhaApp = findViewById(R.id.escolha_app);

        //verifica escolha do app e troca imagem
        if(escolhaApp.equals("Pedra")){
            imagemEscolhaApp.setImageResource(R.drawable.pedra);
        }else if (escolhaApp.equals("Papel")){
            imagemEscolhaApp.setImageResource(R.drawable.papel);
        }else {
            imagemEscolhaApp.setImageResource(R.drawable.tesoura);
        }


        TextView resultadoJogo = findViewById(R.id.texto_resultado);

        if (
                (escolhaApp == "Pedra" && escolhaJogador == "Tesoura") ||
                (escolhaApp == "Papel" && escolhaJogador == "Pedra") ||
                (escolhaApp == "Tesoura" && escolhaJogador == "Papel")
            ){

            resultadoJogo.setText("Você Perdeu! :(");
            resultadoJogo.setTextColor(Color.parseColor("#D62839"));

        }else if(
                (escolhaJogador == "Pedra" && escolhaApp == "Tesoura") ||
                (escolhaJogador == "Papel" && escolhaApp == "Pedra") ||
                (escolhaJogador == "Tesoura" && escolhaApp == "Papel")
        ){
            resultadoJogo.setText("Você Ganhou! ;)");
            resultadoJogo.setTextColor(Color.parseColor("#00B159"));
        }else {
            resultadoJogo.setText("O jogo empatou!");
        }

        //exibe mensagem na tela do usuario
//        Toast.makeText(this, escolhaJogador, Toast.LENGTH_SHORT).show();
    }
}
