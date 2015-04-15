package appli.beta.blackfox;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class Reglement extends Activity {
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		System.runFinalizersOnExit(true);
		System.exit(0);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reglement);
		//Utilisation d'un webView pour afficher un texte formaté et mis en page
		WebView webView = (WebView)findViewById(R.id.webView1);
		//Utilise la ressource HTML présente dans string.xml
		webView.loadDataWithBaseURL(null, getString(R.string.html_content), "text/html", "utf-8", null);
		//Règle les problèmes d'affichage selon la version SDK (carrés noir lors du défilement)
		if (Build.VERSION.SDK_INT >= 11) {
			webView.setBackgroundColor(0x01000000);
		} else {
			webView.setBackgroundColor(0x00000000);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reglement, menu);
		return true;
	}

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
		
		else if(id== R.id.action_quit){
			finish();

		}
		return super.onOptionsItemSelected(item);
	}
}
