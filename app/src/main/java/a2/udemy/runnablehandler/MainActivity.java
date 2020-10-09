package a2.udemy.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    int number;
    Runnable runnable;  //Runnable is a interface which gives a choice more than one time that you decided to condition
    Handler handler;   //Handler is a interface which can work with runnable and message

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.buttonStart);
        number=0;
    }

    public void buttonStart(View view){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: "+number);
                number++;
                textView.setText("Time: "+number);
                //it takes two parameter first one is runnable end second one is delay which shows how many second it works
                handler.postDelayed(runnable,1000);
                button.setEnabled(false);

            }
        };
        handler.post(runnable);
    }
    public void buttonStop(View view){
        //change to button of visibility
        button.setEnabled(true);
        //reset to runnable
        handler.removeCallbacks(runnable);
        //resest to number and text of textView for re-using runnable
        number=0;
        textView.setText("Text: "+number);

    }
}