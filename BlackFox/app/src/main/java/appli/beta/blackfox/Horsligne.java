package appli.beta.blackfox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Horsligne extends Activity implements OnClickListener{

	//
	@Override
	public void onDestroy(){
		super.onDestroy();
		System.runFinalizersOnExit(true);
		System.exit(0);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_horsligne);
		Button acc = (Button)this.findViewById(R.id.button1);
		acc.setOnClickListener(this);
		Button gallerie = (Button)this.findViewById(R.id.button2);
		gallerie.setOnClickListener(this);
		Button regle = (Button)this.findViewById(R.id.button3);
		regle.setOnClickListener(this);
        Button puissance = (Button)this.findViewById(R.id.button4);
        puissance.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.horsligne, menu);
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

	@Override
	public void onClick(View v) {
		if (v == findViewById(R.id.button1)){
			Intent intentAcc = new Intent(this,Presentation.class);
			this.startActivityForResult(intentAcc,10);
		}
		else if (v == findViewById(R.id.button2)){
			Intent intentGall = new Intent(this,Gallerie.class);
			this.startActivityForResult(intentGall,10);
		}
		else if (v == findViewById(R.id.button3)){
			Intent intentReg = new Intent(this,Reglement.class);
			this.startActivityForResult(intentReg,10);
		}
        else if (v == findViewById(R.id.button4)){
            Intent intentPuiss = new Intent(this,Puissance.class);
            this.startActivityForResult(intentPuiss,10);
        }


	}
}
