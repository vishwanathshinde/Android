package com.example.progress_bar;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

    private static int progress;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    // Called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = 0;
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        //--do some work in background thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                //--do some work here
                while(progressStatus < 10)
                {
                    progressStatus = doSomeWork();
                }

                //--hides the progress bar
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // 0-VISIBLE, 4-INVISIBLE, 8-GONE
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
            //--do some long lasting work here
            private int doSomeWork()
            {
                try{
                    //--simulate doing some work
                    Thread.sleep(500);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                return ++progress;
            }
        }).start();
    }
}