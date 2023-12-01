package com.example.listasfragments;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ListFragment extends Fragment {

    public interface OnItemSelectedListener {
        void onItemSelected(Item item, Bundle args);
    }

    private OnItemSelectedListener listener;
    private ArrayAdapter<Item> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Agua", "Helado"));
        itemList.add(new Item("Café", "Caliente"));

        ListView listView = view.findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Item selectedItem = adapter.getItem(position);
            System.out.println(selectedItem.toString());
            if (listener != null && selectedItem != null) {
                Bundle args = new Bundle();
                args.putInt("selectedItemId", position); // Envía la posición como argumento
                listener.onItemSelected(selectedItem, args);
            }
        });

        return view;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        this.listener = listener;
    }
}