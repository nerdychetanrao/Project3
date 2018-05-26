package com.chetan.project3_a2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WebViewFragment extends Fragment
{
    public WebViewFragment() {
        // Required empty public constructor

    }
    private static final String TAG = "QuotesFragment";

    private String m_url = null;
    private int mCurrIdx = -1;
    private int mQuoteArrLen;

    int getShownIndex() {
        return mCurrIdx;
    }
    String get_custom_url(){
        return m_url;
    }
    // Show the Quote string at position newIndex
    void showQuoteAtIndex(int newIndex) {
        if (newIndex < 0 || newIndex >= mQuoteArrLen)
            return;
        mCurrIdx = newIndex;
        m_url = MainActivity.mURLArray[mCurrIdx];
    }
    private WebView mWebView;
    @Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    // Retain this Fragment across Activity reconfigurations
    setRetainInstance(true);

}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.webview_fragment, container, false);
        mWebView = (WebView)view.findViewById(R.id.webview);
        // Enable Javascript
        Bundle b = getArguments();
            if (!b.getString("url_str").equals(null)){
            String myurl = b.getString("url_str");
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.loadUrl(myurl);
        }


        return view;
    }
    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();

    }


    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public void onStart() {

        super.onStart();
    }

    @Override
    public void onStop() {

        super.onStop();
    }

}
