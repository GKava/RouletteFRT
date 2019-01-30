package allinone.rull.frt.fortrouletteallinone;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import allinone.rull.frt.fortrouletteallinone.Fragments.MainMenuFragment;

public class MainActivity extends AppCompatActivity  {
    public static FragmentManager fragmentManager;
    protected PowerManager.WakeLock mWakeLock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragment_container)!=null){
            if (savedInstanceState!=null){
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new MainMenuFragment()).commit();
        }
        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");
        this.mWakeLock.acquire();


    }

    @Override
    public void onDestroy() {
        this.mWakeLock.release();
        super.onDestroy();
    }

//    public void startAnimGame(){
//        for (int ti=2000; ti<=4000; ti=ti+2000) {
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Animation animation1 = null;
//                    animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
//                    move_anim.startAnimation(animation1);
//                }
//            }, ti);
//        }
//    }
}
