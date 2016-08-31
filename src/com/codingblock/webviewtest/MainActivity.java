package com.codingblock.webviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity
{
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClickLoadWeb(View v )
	{
		intent = new Intent(this , WebViewLoadWeb.class);
		startActivity(intent);
	}

	public void onClickLoadHtml(View v )
	{
		intent = new Intent(this , WebViewLoadHtml.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu )
	{
		getMenuInflater().inflate(R.menu.main ,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item )
	{

		if(item.getItemId() == android.R.id.home)
		{
			finish();
//			onBackPressed();
			return true;
		}

		int id = item.getItemId();
		switch(id)
		{
			case R.id.action_settings:
				System.out.println("…Ë÷√");
				break;

			default:
				System.out.println("∆‰À˚");
				break;
		}

		return super.onOptionsItemSelected(item);
	}

}
