package com.example.listasfragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    private TextView detailTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        detailTextView = view.findViewById(R.id.detailTextView);

        // Recuperar el argumento
        Bundle args = getArguments();
        if (args != null) {
            int selectedItemId = args.getInt("selectedItemId", -1); // Valor por defecto o manejo de errores
            System.out.println(selectedItemId);
            if (selectedItemId != -1) {
                // Usa el ID para obtener los detalles (por ejemplo, de una lista)
                String details = obtenerDetallesPorId(selectedItemId);
                detailTextView.setText(details);
            }
        }

        return view;
    }

    // Este método simula obtener detalles por ID
    private String obtenerDetallesPorId(int itemId) {
        String[] detalles = {"Detalles de Agua", "Detalles de Café"};

        if (itemId >= 0 && itemId < detalles.length) {
            return detalles[itemId];
        } else {
            return "ID no válido";
        }
    }
}