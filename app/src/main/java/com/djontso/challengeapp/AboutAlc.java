package com.djontso.challengeapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class AboutAlc extends AppCompatActivity {
    Intent intent;
    // flag for Internet connection status
    Boolean isInternetPresent = false;

    // Connection detector class
    ConnectionDetector cd;

    WebView mwebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_aboutalc);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About ALC");

        cd = new ConnectionDetector(getApplicationContext());
        isInternetPresent = cd.isConnectingToInternet();

        if (isInternetPresent) {


            mwebView = (WebView) findViewById(R.id.myWebView);

            mwebView.getSettings().setJavaScriptEnabled(true);

            mwebView.getSettings().setLoadWithOverviewMode(true);

            mwebView.getSettings().setUseWideViewPort(true);

            mwebView.setHorizontalScrollBarEnabled(false);

            mwebView.setWebViewClient(new WebViewClient() {

                @Override

                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {

                    handler.proceed();

                }

            });

            mwebView.loadUrl("https://www.andela.com/alc");

        }

    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);


        }
    }

    //flip screen not loading again
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }





    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch(keyCode)
            {
                case KeyEvent.KEYCODE_BACK:
                    if(mwebView.canGoBack()){
                        mwebView.goBack();
                    }
                    else
                    {
                        backButtonHandler();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
    public void backButtonHandler() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                AboutAlc.this);


        // Setting Dialog Title
        // Setting Dialog Message

        alertDialog.setTitle("Are you sure to leave? ");
        alertDialog.setIcon(R.drawable.dialog_icon);
        alertDialog.setMessage("Exit Now?");

        // Setting Icon to Dialog
        // Setting Positive "Yes" Button

        alertDialog.setPositiveButton("Exit",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        // Setting Negative "NO" Button

        alertDialog.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        dialog.cancel();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
    }

}
