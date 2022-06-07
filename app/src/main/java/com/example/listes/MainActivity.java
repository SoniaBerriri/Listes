package com.example.listes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*1 Variables globales*/

    private ListView listView;
    private String[] stagiaires = new String[]{
            "Nelson",
            "Charbel",
            "Hicham",
            "Walid",
            "Antoine",
            "Nassir",
            "Ben",
            "Sonia",
            "Ons",
            "Anh Hoang"
    };

    /* 2 Initialisation des composants */
    private void initUI(){
        listView= findViewById(R.id.lvStagiaires);
    }

    /** Methodes perso pour l'application **/
    private void affichageDataDansListView(){
        // Méthode 1 - Depuis un tableau situé dans le JAVA (cette classe)
        //final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        //this, android.R.layout.simple_list_item_1,stagiaires);


//Méthode 2 - depuis un tableau présents dans le fichier strings
 String []listDepuisStringes = getResources().getStringArray(R.array.liste_stagiaires);
        final ArrayAdapter<String>adapter =new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_checked,listDepuisStringes);
        listView.setAdapter(adapter);

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String valeurItemClique =(String) listView.getItemAtPosition(position);
              Toast.makeText(MainActivity.this, "Le stagiaire est " + valeurItemClique, Toast.LENGTH_SHORT).show();
          }
      });

    }



    /** Cycles des vies**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*3 lancement de la methode d'initialisation*/
        initUI();

        affichageDataDansListView();
    }
}