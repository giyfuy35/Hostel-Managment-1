package hostel.guw;

import androidx.appcompat.app.AppCompatActivity;
import hostel.guw.R;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class bank extends AppCompatActivity {
    private WebView mywebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        mywebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings= mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebView.loadUrl("https://netbanking.bankalfalah.com/ib/Login.aspx#");
}}