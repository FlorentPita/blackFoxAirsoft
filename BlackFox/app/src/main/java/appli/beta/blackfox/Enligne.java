package appli.beta.blackfox;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class Enligne extends Activity {
	WebView wv;
	Boolean isInternetPresent = false;
	ConnectionDetector cd;
	public Intent intentHl ;

	//Instance de la methode onDestroy permettant de quitter l'application
	@Override
	public void onDestroy(){
		super.onDestroy();
		System.runFinalizersOnExit(true);
		System.exit(0);
	}

	//Surcharge du bouton retour	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if (keyCode == KeyEvent.KEYCODE_BACK){
			wv.goBack();
		}
		return true;
	}
	//Création du lien et chargement du site via un webView	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enligne);
		wv = (WebView)findViewById(R.id.webView1);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.loadUrl("http://blackfoxairsoft.16mb.com");
		wv.setWebViewClient(new MyWebViewClient());
		cd= new ConnectionDetector(getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		intentHl = new Intent(this,Horsligne.class);

	}

	public class MyWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			if(!isInternetPresent){
				Toast.makeText(getApplicationContext(), "Reseau introuvable, redirection vers mode hors-ligne",
						Toast.LENGTH_SHORT).show();
				startActivityForResult(intentHl,10);

			}
			else{ 
				view.loadUrl(url);
				Toast.makeText(getApplicationContext(), "Connexion en cours",
						Toast.LENGTH_SHORT).show();

			}
			return true;
		}}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		//menu.add(0, intMenu_Exit, 2, R.string.menu_exit);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intentPropos = new Intent(this,Apropos.class);
			this.startActivityForResult(intentPropos,10);
		}
		//Quitte l'application via la methode onDestroy appellée par finish
		if(id== R.id.action_quit){
			finish();

		}

		return super.onOptionsItemSelected(item);
	}

}
