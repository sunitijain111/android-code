package com.example.lab7;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity  {
    Button b1, back, frwd;
    EditText ed1;

    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        ed1=(EditText)findViewById(R.id.editText);
        back=(Button)findViewById(R.id.button_back);
        frwd=(Button)findViewById(R.id.button_frwd);

        wv1=(WebView)findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser());
        wv1.loadUrl("https://www.shutterstock.com/photos");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = ed1.getText().toString();

                wv1.getSettings().setLoadsImagesAutomatically(true);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv1.loadUrl(url);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( wv1.canGoBack()) {
                    wv1.goBack();
                    //return true;
                }

            }
        });
        frwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( wv1.canGoForward()) {
                    wv1.goForward();
                    //return true;
                }

            }
        });
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }
}