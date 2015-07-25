package com.example.androidwebbrowser;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	WebView wv;
	TextView tv;
	Button btn1, btn2, btn3, btn4,btn5;
	EditText et ;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		btn1 = (Button) findViewById(R.id.button1);
		
		et = (EditText)findViewById(R.id.editText1);

		
		wv = (WebView) findViewById(R.id.webView1);
		wv.loadUrl("http://www.google.com");
		wv.setWebViewClient(new webCont());
		
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String url = et.getText().toString();
				wv.loadUrl("http://"+url );
			}
		});
		tv= (TextView) findViewById(R.id.editText1);
		
		
		
		
		
		
		btn5= (Button) findViewById(R.id.button5);
		btn5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		
		btn4 = (Button) findViewById(R.id.button4);
		btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			wv.reload();	
			}
		});
		
		btn3 = (Button) findViewById(R.id.button3);
		btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			wv.goForward();	
			
			}
		});
		
		btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			wv.goBack();	
			}
		});
		wv.requestFocus(View.FOCUS_DOWN);
        wv.setOnTouchListener(new View.OnTouchListener() {
        

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_UP:
                    if (!v.hasFocus()) {
                        v.requestFocus();
                    }
                    break;
            }
				return false;
			}
        });
		
	}
	
	class webCont extends WebViewClient
	{

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(url);
			
			return true;
			
			
		}
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}