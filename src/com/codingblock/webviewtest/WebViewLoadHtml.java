package com.codingblock.webviewtest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewLoadHtml extends Activity
{
	private String url;
	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		// ����Ļ����Ϊȫ��
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
		// ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// ȥ��������
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.webview);
		webView = (WebView) findViewById(R.id.wv_webview);
		url = "file:///android_asset/guide/index.html";
		loadLocalHtml(url);
	}

	@SuppressLint(
	{ "JavascriptInterface", "SetJavaScriptEnabled" })
	public void loadLocalHtml(String url )
	{
		WebSettings ws = webView.getSettings();
		ws.setJavaScriptEnabled(true);// ����JavaScript֧��
		webView.setWebViewClient(new WebViewClient()
		{
			@Override
			public boolean shouldOverrideUrlLoading(WebView view , String url )
			{
				// ��д�˷��������ڲ�׽ҳ���ϵ���ת����http:start
				if("http://start/".equals(url))
				{
					// ��html�����еİ�ť��ת��ַ��Ҫͬ�˵�ַһ��
					Toast.makeText(getApplicationContext() ,"��ʼ����" ,Toast.LENGTH_SHORT).show();
					finish();
				}
				return true;
			}
		});
		webView.loadUrl(url);
	}
}
