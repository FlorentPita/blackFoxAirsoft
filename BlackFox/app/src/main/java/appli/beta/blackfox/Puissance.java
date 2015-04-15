package appli.beta.blackfox;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Puissance extends Activity implements OnClickListener {

    private EditText puiss;
    private EditText gramPuiss;
    private EditText gramVoulu;
    private Button valider;
    private String puissance;
    private String gramPuissance;
    private String gammageVoulu;
    private int puissBase;
    private double grammageBase;
    private double grammageVoulu;
    private double resRC;
    private double resultat;
    private String resultatStr;
    private TextView affichResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puissance);

        puiss=(EditText)this.findViewById(R.id.editText);
        gramPuiss=(EditText)this.findViewById(R.id.editText2);
        gramVoulu=(EditText)this.findViewById(R.id.editText3);
        affichResult=(TextView)this.findViewById(R.id.textView3);

        valider=(Button)this.findViewById(R.id.button);
        valider.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_puissance, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.button)){

            puiss.setOnClickListener(this);
            puissance = puiss.getText().toString();
            puissBase = Integer.parseInt(puissance);

            gramPuiss.setOnClickListener(this);
            gramPuissance = gramPuiss.getText().toString();
            grammageBase = Double.valueOf(gramPuissance).doubleValue();

            gramVoulu.setOnClickListener(this);
            gammageVoulu = gramVoulu.getText().toString();
            grammageVoulu = Double.valueOf(gammageVoulu).doubleValue();

            resRC = Math.sqrt(grammageBase/grammageVoulu);
            resultat = Math.ceil(resRC*puissBase);
            affichResult.setText(resultat+" FPS");

        }

    }
}
