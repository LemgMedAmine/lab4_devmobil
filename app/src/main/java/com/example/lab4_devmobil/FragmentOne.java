package com.example.lab4_devmobil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    private boolean isHelloDisplayed = false;

    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = view.findViewById(R.id.textOne);
        Button btn = view.findViewById(R.id.btnHello);

        MainActivity activity = (MainActivity) getActivity();

        btn.setOnClickListener(v -> {
            if (!isHelloDisplayed) {
                // Premier clic : Affiche le message
                tv.setText("Bonjour depuis Fragment 1 !");
                isHelloDisplayed = true;
            } else {
                // Deuxième clic : Navigue vers le Fragment 2 (la SeekBar)
                if (activity != null) {
                    activity.replaceFragment(new FragmentTwo(), true);
                }
            }
        });
    }
}