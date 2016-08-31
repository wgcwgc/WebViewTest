package com.codingblock.webviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewLoadWeb extends Activity
{
	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		webView = (WebView) findViewById(R.id.wv_webview);
		loadWeb();
		// loadHtmlData();
	}

	public void loadWeb()
	{
		String url = "https://www.baidu.com/";
		// String url = "https://github.com/wgcwgc?tab=repositories";
		// 此方法可以在webview中打开链接而不会跳转到外部浏览器
		webView.setWebViewClient(new WebViewClient());
		webView.setWebChromeClient(new myWebChromeClint());
		webView.loadUrl(url);
	}

	@Override
	public boolean onKeyDown(int keyCode , KeyEvent event )
	{
		// 重写onKeyDown，当浏览网页，WebView可以后退时执行后退操作。
		if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack())
		{
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode ,event);
	}

	public void loadHtmlData()
	{
		String data = "<html>" + "<head>" + "<title>欢迎您</title>" + "</head>" + "<body>" + "<p>我是一段html代码</p>" + "</body>" + "</html>";
		webView.setWebViewClient(new WebViewClient());
		// 使用简单的loadData()方法总会导致乱码，有可能是Android API的Bug
		// webView.loadData(data, "text/html", "GBK");
		webView.loadDataWithBaseURL(null ,data ,"text/html" ,"utf-8" ,null);
	}

	class myWebChromeClint extends WebChromeClient
	{
		@SuppressWarnings("static-access")
		@Override
		public void onProgressChanged(WebView view , int newProgress )
		{
			if(newProgress == 100)
			{
				view.setVisibility(view.VISIBLE);
				// progressBar.set
			}
			// super.onProgressChanged(view ,newProgress);
		}
	}
}
