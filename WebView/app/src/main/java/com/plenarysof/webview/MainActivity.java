package com.plenarysof.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    EditText etEnterURL;
    ImageButton ibEnterURL;
    WebView wvViewWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initWebView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        etEnterURL = findViewById(R.id.et_enter_url);
        ibEnterURL = findViewById(R.id.im_submit);
        wvViewWeb = findViewById(R.id.wv_view_load);
    }

    private class MyBrowser extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    private void initWebView() {
        wvViewWeb.setWebViewClient(new MyBrowser());

        ibEnterURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etEnterURL.getText().toString();

                wvViewWeb.getSettings().setLoadsImagesAutomatically(true);
                wvViewWeb.getSettings().setJavaScriptEnabled(true);
                wvViewWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wvViewWeb.loadUrl(url);
            }
        });
    }
}

