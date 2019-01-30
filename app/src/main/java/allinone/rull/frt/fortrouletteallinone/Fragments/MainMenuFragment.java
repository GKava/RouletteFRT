package allinone.rull.frt.fortrouletteallinone.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import allinone.rull.frt.fortrouletteallinone.MainActivity;
import allinone.rull.frt.fortrouletteallinone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment implements View.OnClickListener {
Button onTimeChallenge,justChallenge;

    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        onTimeChallenge = view.findViewById(R.id.onTimeChallenge);
        justChallenge = view.findViewById(R.id.justChallenge);
        onTimeChallenge.setOnClickListener(this);
        justChallenge.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.onTimeChallenge:
                ChallengeOnTime frag1 = new ChallengeOnTime();
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, frag1)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.justChallenge:
                JustChallenge frag2 = new JustChallenge();
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, frag2)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
