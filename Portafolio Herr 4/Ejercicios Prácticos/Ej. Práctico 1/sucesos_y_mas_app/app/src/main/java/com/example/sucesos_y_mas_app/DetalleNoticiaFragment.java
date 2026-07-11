package com.example.sucesos_y_mas_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetalleNoticiaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleNoticiaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Claves para recibir los datos
    public static final String ARG_TITULO    = "titulo";
    public static final String ARG_CUERPO    = "cuerpo";
    public static final String ARG_FECHA     = "fecha";
    public static final String ARG_HORA      = "hora";
    public static final String ARG_CATEGORIA = "categoria";
    public static final String ARG_COLOR     = "color";


    public DetalleNoticiaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleNoticiaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleNoticiaFragment newInstance(String param1, String param2) {
        DetalleNoticiaFragment fragment = new DetalleNoticiaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    // Método estático para crear el fragment con datos
    public static DetalleNoticiaFragment newInstance(String titulo, String cuerpo,
                                                     String fecha, String hora, String categoria, int color) {

        DetalleNoticiaFragment fragment = new DetalleNoticiaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITULO,    titulo);
        args.putString(ARG_CUERPO,    cuerpo);
        args.putString(ARG_FECHA,     fecha);
        args.putString(ARG_HORA,      hora);
        args.putString(ARG_CATEGORIA, categoria);
        args.putInt(ARG_COLOR,        color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_noticia, container, false);

        // Recuperar los datos enviados
        Bundle args = getArguments();
        if (args != null) {
            String titulo = args.getString(ARG_TITULO);
            String cuerpo = args.getString(ARG_CUERPO);
            String fecha = args.getString(ARG_FECHA);
            String hora = args.getString(ARG_HORA);
            String categoria = args.getString(ARG_CATEGORIA);
            int color = args.getInt(ARG_COLOR);

            // Asignar datos a las vistas
            view.findViewById(R.id.bannerNoticia)
                    .setBackgroundColor(color);

            ((TextView) view.findViewById(R.id.tvTituloDetalle))
                    .setText(titulo);
            ((TextView) view.findViewById(R.id.tvCategoria))
                    .setText(categoria);
            ((TextView) view.findViewById(R.id.tvCuerpo))
                    .setText(cuerpo);
            ((TextView) view.findViewById(R.id.tvFecha))
                    .setText(fecha);
            ((TextView) view.findViewById(R.id.tvHora))
                    .setText(hora);
        }

        return view;
    }
}