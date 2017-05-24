package arsibi_has_no_website.counter;


import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button counter ;
    TextView display_count;
    long count;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            if (what == 1) {
                count++;
                display_count.setText(String.format("%d", count));

            }
            else
                display_count.setText("Dude Stop!");
            }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        count=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        counter = (Button) findViewById(R.id.counter);
        display_count=(TextView)findViewById(R.id.text);
        display_count.setText("0");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("count",count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        display_count.setText(String.format("%d",count=savedInstanceState.getLong("count")));
    }

    public void increment(View v)
    {
        if(count>=0)
    handler.sendEmptyMessage(1);
        else
    handler.sendEmptyMessage(0);
    }

}
