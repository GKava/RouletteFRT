package allinone.rull.frt.fortrouletteallinone;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        tv = findViewById(R.id.tv);
        txt_score = findViewById(R.id.txt_score);
        start_stop = findViewById(R.id.start_stop);
        retry = findViewById(R.id.retry);
        start_stop.setOnClickListener(this);
        retry.setOnClickListener(this);

        recyclerView = findViewById(R.id.recycler);
        verticalLinearLayoutManager = new LinearLayoutManager(this);
        verticalLinearLayoutManager.setStackFromEnd(false);
        recyclerView.setLayoutManager(verticalLinearLayoutManager);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        retry.setVisibility(View.VISIBLE);

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
            progressBar.setSecondaryProgress(progress + 5);
        }
        tv.setText(strProgress);

        if (progress==100){
            tv.setText("Challenge");
            progressBar.setVisibility(ProgressBar.GONE);
            progressBar.setProgress(0);


            start_stop.setVisibility(View.VISIBLE);
            retry.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);



            adapter = new ChallengeAdapter(250);
            recyclerView.setAdapter(adapter);
            adapter.addMessage(new ChallengeItem(R.drawable.skull, "Go landing on loot lake"));
            adapter.addMessage(new ChallengeItem(R.drawable.skull,"Not use axe"));
            adapter.addMessage(new ChallengeItem(R.drawable.skull,"Don't use map"));

            retry.setText("RETRY");

        }
    }
//    public void timerChallenge(){
//        //Создаем таймер обратного отсчета на 20 секунд с шагом отсчета
//        //в 1 секунду (задаем значения в миллисекундах):
//
//        new CountDownTimer(20000, 1000) {
//            //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
//            public void onTick(long millisUntilFinished) {
//
//                start_stop.setText("STOP\n"
//                        + millisUntilFinished / 1000);
//                timer=timer+1;
//            }
//            //Задаем действия после завершения отсчета (высвечиваем надпись "Бабах!"):
//            public void onFinish() {
//                start_stop.setText(timer+" sec.");
//            }
//        }
//                .start();
//    }

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
