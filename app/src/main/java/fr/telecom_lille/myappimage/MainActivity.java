package fr.telecom_lille.myappimage;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button BTakePhoto = null; // creation des variables de la gestions des boutons
    private Button BPhotoLibrary = null;
    private Button BAnalysis = null;
    public final static int KEY_LIBRARY = 1; // variable des Intents
    public final static String NOMBRE_PICTURE = "fr.telecom_lille.myappimage.NOMBRES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createButton(BTakePhoto,R.id.TakePhoto);
        /*BTakePhoto = (Button) findViewById(R.id.TakePhoto);
        BTakePhoto.setOnClickListener(this);*/
        createButton(BPhotoLibrary,R.id.PhotoLibrary);
       /*BPhotoLibrary = (Button) findViewById(R.id.PhotoLibrary);
        BPhotoLibrary.setOnClickListener(this);*/
        createButton(BAnalysis,R.id.Analysis);
        /*BAnalysis = (Button) findViewById(R.id.Analysis);
        BAnalysis.setOnClickListener(this);*/
        //BAnalysis.setClickable(false);
        //BAnalysis.setBackgroundColor(Color.DKGRAY);
      //  ImageView imgView = (ImageView)findViewById(R.id.MainPicture);
       //imgView.setImageDrawable(getResources().getDrawable(R.drawable.coca));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // vérification à quel intent on fait référence ici à l'aide de notre identifiant
        if (requestCode == KEY_LIBRARY) {
            // vérification que l'opération s'est bien déroulée
            if (resultCode == RESULT_OK) {
                // affichage du bouton choisi
                Toast.makeText(this, "le code est  "+ data.getIntExtra(NOMBRE_PICTURE,-1), Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void onClick(View v) {
        switch(v.getId()) {
            // Si l'identifiant de la vue est celui du bouton capture
            case R.id.TakePhoto:
                Toast.makeText(this, "Capture", Toast.LENGTH_SHORT).show();
                //BAnalysis.setClickable(true);
                //BAnalysis.setBackgroundColor(Color.LTGRAY);
                Intent intentTakePhoto = new Intent(MainActivity.this, CaptureActivity.class);
                startActivity(intentTakePhoto);
                break;
            // Si l'identifiant de la vue est celui du bouton photo library
            case R.id.PhotoLibrary:
                Toast.makeText(this, "Library", Toast.LENGTH_SHORT).show();
                //BAnalysis.setClickable(true);
                //BAnalysis.setBackgroundColor(Color.LTGRAY);
                Intent intentPhotoLibrary = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(intentPhotoLibrary);
                break;
            // Si l'identifiant de la vue est celui du bouton de l'analyse
            case R.id.Analysis:
                Toast.makeText(this, "Analysis", Toast.LENGTH_SHORT).show();
                Log.v("Etiquette", "Message à envoyer");// d=debug, e=erreur, w=warning i = information v=commun
                Intent intentAnalysis = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intentAnalysis);
                break;
        }
    }

    private boolean createButton(Button but, int R){
        but = (Button)findViewById(R);
        but.setOnClickListener((View.OnClickListener) this);
        return true;
    }
}
