package com.example.sucesos_y_mas_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.maplibre.android.MapLibre;
import org.maplibre.android.camera.CameraPosition;
import org.maplibre.android.geometry.LatLng;
import org.maplibre.android.maps.MapView;

import org.maplibre.android.maps.Style;
import org.maplibre.android.annotations.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UbicacionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UbicacionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MapView mapView;


    public UbicacionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UbicacionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UbicacionFragment newInstance(String param1, String param2) {
        UbicacionFragment fragment = new UbicacionFragment();
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

        // Inicializar MapLibre UNA VEZ
        MapLibre.getInstance(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ubicacion, container, false);

        // Coordenadas de la empresa
        double latitud  =  8.42133175202879;   // ←  latitud
        double longitud = -82.43116014954535;  // ← longitud
        String nombreEmpresa = "Sucesos y Más";

        // Cargar mapa en WebView
        WebView webView = view.findViewById(R.id.webViewMapa);
        webView.getSettings().setJavaScriptEnabled(true);

        /*String urlMapa = "https://maps.google.com/maps?q="
                + latitud + "," + longitud
                + "&z=16&output=embed";*/
        String urlMapa = "https://www.google.com/maps/place/Radio+Chiriqu%C3%AD/@8.4213117,-82.4319525,18.54z/data=!4m16!1m9!3m8!1s0x8fa59d78126f9745:0xdfe3e743201ed0f!2sRadio+Chiriqu%C3%AD!8m2!3d8.4212392!4d-82.4311762!9m1!1b1!16s%2Fg%2F11bw476lhv!3m5!1s0x8fa59d78126f9745:0xdfe3e743201ed0f!8m2!3d8.4212392!4d-82.4311762!16s%2Fg%2F11bw476lhv?entry=ttu&g_ep=EgoyMDI2MDQxNC4wIKXMDSoASAFQAw%3D%3D";
        webView.loadUrl(urlMapa);


        //Mao lib
       /* mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(mapboxMap -> {

            mapboxMap.setStyle("https://demotiles.maplibre.org/style.json", style -> {

                LatLng ubicacion = new LatLng(-82.43116014954535, 8.42133175202879);

                mapboxMap.addMarker(new MarkerOptions()
                        .position(ubicacion)
                        .title("Marcador en Fragment"));

                CameraPosition position = new CameraPosition.Builder()
                        .target(ubicacion)
                        .zoom(14.0)
                        .build();

                mapboxMap.setCameraPosition(position);
            });
        });*/

        return view;
    }
    // 🔁 Lifecycle del MapView (CLAVE)
    /*@Override public void onStart() { super.onStart(); mapView.onStart(); }
    @Override public void onResume() { super.onResume(); mapView.onResume(); }
    @Override public void onPause() { mapView.onPause(); super.onPause(); }
    @Override public void onStop() { mapView.onStop(); super.onStop(); }
    @Override public void onLowMemory() { super.onLowMemory(); mapView.onLowMemory(); }
    @Override public void onDestroyView() {
        mapView.onDestroy();
        super.onDestroyView();
    }*/
}