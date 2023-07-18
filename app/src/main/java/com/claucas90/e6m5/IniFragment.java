package com.claucas90.e6m5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import com.claucas90.e6m5.databinding.FragmentIniBinding;
import java.util.ArrayList;
import java.util.List;

public class IniFragment extends Fragment implements Adapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<DatosLista> dataList;
    public FragmentIniBinding iniBinding;
    public int indice;

    List<DatosLista> data=new ArrayList<>();

    public IniFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        iniBinding=FragmentIniBinding.inflate(inflater, container, false);
        if (dataList!=null){
            dataList.clear();
        }
        dataList=getData();
        recyclerView=iniBinding.recyclerFragment;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new Adapter(dataList);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);


        return iniBinding.getRoot();
    }
    //agregar datos a la lista
    private List<DatosLista> getData(){
        DatosLista item=new DatosLista("https://www.educaciontrespuntocero.com/wp-content/uploads/2019/02/girasoles-978x652.jpg","Girasoles");
        data.add(item);
        DatosLista item1=new DatosLista("https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640","Zhuo Cheng you");
        data.add(item1);
        DatosLista item02 = new DatosLista("https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640","billow926");
        data.add(item02);
        DatosLista item03 = new DatosLista("https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640","Philipp Deiß");
        data.add(item03);
        DatosLista item04 = new DatosLista("https://images.unsplash.com/photo-1689611947724-c02161745093?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=435&q=80","Rio Amazonas");
        data.add(item04);
        DatosLista item05 = new DatosLista("https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640","Melnychuk Nataliya");
        data.add(item05);
        DatosLista item06 = new DatosLista("https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640","Teagan Maddux");
        data.add(item06);
        DatosLista item07 = new DatosLista("https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640","Chen Liu");
        data.add(item07);
        DatosLista item08 = new DatosLista("https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640","John Fornander");
        data.add(item08);
        DatosLista item09 = new DatosLista("https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640","Parker");
        data.add(item09);
        DatosLista item10 = new DatosLista("https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640","XPS");
        data.add(item10);
        DatosLista item11 = new DatosLista("https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640","J. whack");
        data.add(item11);
        DatosLista item12 = new DatosLista("https://images.unsplash.com/photo-1688098379407-fbbb35f1d9d5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=871&q=80", "Hyundai");
        data.add(item12);
        return data;
    }

    @Override
    public void onItemClick(int position) {
        indice=position;
        DatosLista eleccion=dataList.get(indice);

        Bundle bundle=new Bundle();
        bundle.putString("url", eleccion.getUrl());
        bundle.putString("dato", eleccion.getDato());

        NavController navController= Navigation.findNavController(getActivity(), R.id.fragmentContainerView);
        navController.navigate(R.id.action_iniFragment_to_imageFragment,bundle);
    }
}