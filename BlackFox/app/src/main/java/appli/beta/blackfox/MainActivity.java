package appli.beta.blackfox;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//page permettant de définir si l'application se lance en mode hors ligne ou en ligne
public class MainActivity extends Activity {

	Boolean isInternetPresent = false;

	ConnectionDetector cd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cd= new ConnectionDetector(getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		
		//Test de connexion et redirection
		if(isInternetPresent){
			Intent intentEl = new Intent(this,Enligne.class);
			this.startActivityForResult(intentEl,10);
		}		else{
			Intent intentHl = new Intent(this,Horsligne.class);
			this.startActivityForResult(intentHl,10);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

		if(id== R.id.action_quit){
			finish();

		}

		return super.onOptionsItemSelected(item);
	}

}
