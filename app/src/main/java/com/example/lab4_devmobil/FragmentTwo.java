package com.example.lab4_devmobil;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = view.findViewById(R.id.tvValue);
        SeekBar seekBar = view.findViewById(R.id.seekBar);

        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            int currentVal = activity.getSharedValue();
            seekBar.setProgress(currentVal);
            tv.setText("Valeur : " + currentVal);
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int p, boolean fromUser) {
                if (activity != null) {
                    activity.setSharedValue(p);
                    tv.setText("Valeur : " + p);
                }
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}