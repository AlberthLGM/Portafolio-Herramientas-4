package com.example.sucesos_y_mas_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        // Datos de cada noticia
        view.findViewById(R.id.cardNoticia1).setOnClickListener(v ->
                abrirDetalle(
                        "Inauguran nuevo proyecto comunitario",
                        "El municipio presentó este martes las nuevas obras de infraestructura " +
                                "para la región, un proyecto esperado por los residentes desde hace más " +
                                "de tres años.\n\n" +
                                "Las obras incluyen la renovación de calles principales, instalación de " +
                                "alumbrado público y la construcción de un nuevo parque recreativo en el " +
                                "centro de la comunidad.\n\n" +
                                "El alcalde indicó que la inversión total supera los 2 millones de balboas " +
                                "y que los trabajos estarán concluidos antes de fin de año.",
                        "Hoy, 17 de abril de 2026",
                        "9:00am",
                        "📰  COMUNIDAD",
                        0xFF388E3C   // verde oscuro
                )
        );

        view.findViewById(R.id.cardNoticia2).setOnClickListener(v ->
                abrirDetalle(
                        "Entrevista especial esta tarde",
                        "Esta tarde a las 2:10pm, SUCESOS y MÁS transmitirá una entrevista " +
                                "exclusiva con destacadas figuras del sector cultural y social del país.\n\n" +
                                "Los invitados compartirán sus experiencias, proyectos futuros y reflexiones " +
                                "sobre el desarrollo cultural de nuestra región.\n\n" +
                                "No te pierdas este espacio único donde la cultura y la comunidad son los " +
                                "protagonistas. Puedes seguir la transmisión en nuestras redes sociales.",
                        "Hoy, 17 de abril de 2026",
                        "2:10pm",
                        "🎙️  ENTREVISTA",
                        0xFF1976D2   // azul
                )
        );

        view.findViewById(R.id.cardNoticia3).setOnClickListener(v ->
                abrirDetalle(
                        "Resumen de noticias internacionales",
                        "En el panorama mundial de hoy destacan varios eventos de relevancia " +
                                "que marcan la agenda internacional.\n\n" +
                                "Líderes de distintas naciones se reúnen en cumbre sobre cambio climático, " +
                                "mientras los mercados financieros registran movimientos significativos " +
                                "ante nuevas decisiones económicas globales.\n\n" +
                                "Nuestro equipo de periodistas te trae un análisis completo de los hechos " +
                                "más importantes del día en el ámbito internacional.",
                        "Hoy, 17 de abril de 2026",
                        "2:40pm",
                        "🌍  INTERNACIONAL",
                        0xFF7B1FA2   // morado
                )
        );

        return view;
    }

    private void abrirDetalle(String titulo, String cuerpo, String fecha,
                              String hora, String categoria, int color) {

        DetalleNoticiaFragment detalle = DetalleNoticiaFragment.newInstance(
                titulo, cuerpo, fecha, hora, categoria, color
        );

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, detalle)
                .addToBackStack(null)  // ← permite volver atrás con el botón back
                .commit();
    }
}