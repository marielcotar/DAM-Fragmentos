package com.example.listasfragments;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {

    private DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment listFragment = new ListFragment();
        detailFragment = new DetailFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.listFragment, listFragment);
        transaction.replace(R.id.detailFragment, detailFragment);
        transaction.commit();

        // Configurar la comunicación entre fragments
        listFragment.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(Item item, Bundle args) {
        // Pasar los argumentos al DetailFragment
        detailFragment.setArguments(args);
    }
}