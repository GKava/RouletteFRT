package allinone.rull.frt.fortrouletteallinone.Fragments;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Random;

import allinone.rull.frt.fortrouletteallinone.ChallengeAdapter;
import allinone.rull.frt.fortrouletteallinone.ChallengeItem;
import allinone.rull.frt.fortrouletteallinone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChallengeOnTime extends Fragment implements View.OnClickListener {
    ProgressBar progressBar;
    TextView tv,txt_score;
    int progress = 0;
    int time = 30;
    int timer;
    private RecyclerView recyclerView;
    private LinearLayoutManager verticalLinearLayoutManager;
    private ChallengeAdapter adapter;
    Button start_stop,retry;
    CountDownTimer yourCountDownTimer;

    int timer_int=0; // нужно для отслеживания кликов
    String timer_string; // записывается оставшееся время
    boolean complete = false; //првоерка на то завершенно ли задание

    public ChallengeOnTime() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenge_on_time, container, false);
        progressBar = view.findViewById(R.id.progressBar);
        tv = view.findViewById(R.id.tv);
        txt_score = view.findViewById(R.id.txt_score);
        start_stop = view.findViewById(R.id.start_stop);
        retry = view.findViewById(R.id.retry);
        start_stop.setOnClickListener(this);
        retry.setOnClickListener(this);

        recyclerView = view.findViewById(R.id.recycler);
        verticalLinearLayoutManager = new LinearLayoutManager(getActivity());
        verticalLinearLayoutManager.setStackFromEnd(false);
        recyclerView.setLayoutManager(verticalLinearLayoutManager);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        retry.setVisibility(View.VISIBLE);
        return view;
    }

    public void createChallenge(int restart){
        if (restart==1){
            progress=0;
            time=30;
        }
        tv.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        for (int i = 0; i < 100; i++) {
            time=time+3;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progress = progress + 1;
                    postProgress(progress);

                }
            }, 30+time);
        }
    }


    private void postProgress(int progress) {
        String strProgress = String.valueOf(progress) + " %";
        progressBar.setProgress(progress);
        if (progress == 0) {
            progressBar.setSecondaryProgress(0);
        } else {
            progressBar.setSecondaryProgress(progress + 5); // полоска опережающая прогресс
        }
        tv.setText(strProgress);

        if (progress==100){
            tv.setText("\nYOUR\nChallenge\n");
            progressBar.setVisibility(ProgressBar.GONE);
            progressBar.setProgress(0);
            start_stop.setVisibility(View.VISIBLE);
            retry.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);

            adapter = new ChallengeAdapter(250);
            recyclerView.setAdapter(adapter);
            adapter.addMessage(ChallengeItem.getLandingPoint().get(new Random().nextInt(ChallengeItem.getLandingPoint().size())));
            adapter.addMessage(ChallengeItem.getKillChallenge().get(new Random().nextInt(ChallengeItem.getKillChallenge().size())));
            adapter.addMessage(ChallengeItem.getSecretChallenge().get(new Random().nextInt(ChallengeItem.getSecretChallenge().size())));
            retry.setText("RETRY");

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_stop:
                if (complete==false ) { // запущен ли челендж

                    retry.setVisibility(View.GONE);
                    txt_score.setVisibility(View.GONE);
                    start_stop.setText("STOP");

                    //УСЛОВИЕ


                    // общее время и интервал в параметрах
                    yourCountDownTimer = new CountDownTimer(5000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            txt_score.setVisibility(View.VISIBLE);
                            NumberFormat f = new DecimalFormat("00");
                            // long hour = (millisUntilFinished / 3600000) % 24;
                            long min = (millisUntilFinished / 60000) % 60;
                            long sec = (millisUntilFinished / 1000) % 60;

                            timer_string = f.format(min) + ":" + f.format(sec);
                            txt_score.setText(f.format(min) + ":" + f.format(sec));
                        }

                        public void onFinish() {
                            // start_stop.setText("00:00:00");
                            retry.setVisibility(View.VISIBLE);
                            start_stop.setText("TRY AGAIN");
                            txt_score.setText("Time is over :(");
                            timer_int = 0;
                            complete = false;
                        }
                    }.start();

                    complete= true;

                }else {
                    yourCountDownTimer.cancel();
                    retry.setVisibility(View.VISIBLE);
                    start_stop.setText("TRY AGAIN");
                    txt_score.setText("Score: " + timer_string );
                    complete = false;
                    timer_int = 0;
                }
                break;

            case R.id.retry:
                start_stop.setText("START");
                txt_score.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                createChallenge(1);
                retry.setVisibility(View.GONE);
                start_stop.setVisibility(View.GONE);
                break;
        }
    }
}
