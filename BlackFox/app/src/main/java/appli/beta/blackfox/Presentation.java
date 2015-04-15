package appli.beta.blackfox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Presentation extends Activity {
	
	TextView tv;
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		System.runFinalizersOnExit(true);
		System.exit(0);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_presentation);
		tv = (TextView)findViewById(R.id.textView2);
		tv.setText("Nous sommes une association d'airsoft exerçant dans le 77 dans les alentours de Melun. Sur notre appli vous retrouverez des informations relatives à notre association. Vous êtes actuellement sur la page hors ligne de notre application, afin d'en profiter pleinement, activez votre connexion et relancez la.");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.presentation, menu);
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
