package wgcv.me.tresenraya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Jugar extends AppCompatActivity {
    private String nombre1,nombre2;
    private int i = 0;
    private ImageButton boton;
    private int[][] juego;
    private TextView turno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nombre1 = extras.getString("nombre1");
            nombre2 = extras.getString("nombre2");
        }
        juego =new int[][] {{0,0,0},{0,0,0},{0,0,0}};
        turno = (TextView) findViewById(R.id.tv_turno);
       // Toast.makeText(getApplicationContext(),"Es el turno de " + nombre1 , Toast.LENGTH_LONG).show();
        turno.setText("Es el turno de  "+ nombre1);
    }
    public void Aplasta(View view){
        boton = (ImageButton) findViewById(view.getId());
        int x = Character.getNumericValue(boton.getTag().toString().charAt(0))-1;
        int y = Character.getNumericValue(boton.getTag().toString().charAt(1))-1;

        if(juego[x][y]==0){

        if(i%2==0){
            boton.setImageResource(R.drawable.equis);
            juego[x][y]=1;

            //  Toast.makeText(getApplicationContext(),"Es el turno de " + nombre2 , Toast.LENGTH_SHORT).show();
            if(comprobar()){
                Toast.makeText(getApplicationContext(),"Gano "+nombre1, Toast.LENGTH_SHORT).show();


            }else{
                int k=0;
                for (int i=0; i<juego.length;i++){
                    for (int j=0; j<juego.length;j++){
                        if(juego[i][j]>0)
                            k++;

                    }
                }
                if(k==9){
                    Toast.makeText(getApplicationContext(),"Empate", Toast.LENGTH_LONG).show();

                }else{
                    turno.setText("Es el turno de  "+ nombre2);

                }
        }}else{
            boton.setImageResource(R.drawable.circulo);
            juego[x][y]=2;

            //  Toast.makeText(getApplicationContext(),"Es el turno de " + nombre1 , Toast.LENGTH_SHORT).show();
            if(comprobar()){
                Toast.makeText(getApplicationContext(),"Gano "+nombre2, Toast.LENGTH_SHORT).show();

            }else{
                int k=0;
                for (int i=0; i<juego.length;i++){
                    for (int j=0; j<juego.length;j++){
                        if(juego[i][j]>0)
                            k++;

                    }
                }
                if(k==9){
                    Toast.makeText(getApplicationContext(),"Empate", Toast.LENGTH_LONG).show();

                }else{
                    turno.setText("Es el turno de  "+ nombre1);

                }

            }
        }

        }

        i++;

    }
    private boolean comprobar(){
        if(juego[0][0]==1 && juego[0][1]==1 && juego[0][2]==1 )
        {
            return true;
        }
        if(juego[1][0]==1 && juego[1][1]==1 && juego[1][2]==1 )
        {
            return true;
        }
        if(juego[2][0]==1 && juego[2][1]==1 && juego[2][2]==1 )
        {
            return true;
        }
        if(juego[0][0]==1 && juego[1][0]==1 && juego[2][0]==1 )
        {
            return true;
        }
        if(juego[0][1]==1 && juego[1][1]==1 && juego[2][1]==1 )
        {
            return true;
        }
        if(juego[0][2]==1 && juego[1][2]==1 && juego[2][2]==1 )
        {
            return true;
        }
        if(juego[0][0]==1 && juego[1][1]==1 && juego[2][2]==1 )
        {
            return true;
        }
        if(juego[0][2]==1 && juego[1][1]==1 && juego[2][0]==1 )
        {
            return true;
        }
        //Jugador 2
        if(juego[0][0]==2 && juego[0][1]==2 && juego[0][2]==2 )
        {
            return true;
        }
        if(juego[1][0]==2 && juego[1][1]==2 && juego[1][2]==2 )
        {
            return true;
        }
        if(juego[2][0]==2 && juego[2][1]==2 && juego[2][2]==2 )
        {
            return true;
        }
        if(juego[0][0]==2 && juego[1][0]==2 && juego[2][0]==2 )
        {
            return true;
        }
        if(juego[0][1]==2 && juego[1][1]==2 && juego[2][1]==2 )
        {
            return true;
        }
        if(juego[0][2]==2 && juego[1][2]==2 && juego[2][2]==2 )
        {
            return true;
        }
        if(juego[0][0]==2 && juego[1][1]==2 && juego[2][2]==2 )
        {
            return true;
        }
        if(juego[0][2]==2 && juego[1][1]==2 && juego[2][0]==2 )
        {
            return true;
        }

        return false;
    }
}
