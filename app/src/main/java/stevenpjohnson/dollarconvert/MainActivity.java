package stevenpjohnson.dollarconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void cnvToJPY(View view){

        Log.i("Info", "*****inside cnvToJPY start");

        //get currInputView val
        EditText currInput = (EditText) findViewById(R.id.currInputView);

        if(currInput.getText().toString().length() == 0){
            Log.i("Info", "*****inside currInput if");
            Toast.makeText(this, "You must enter a value", Toast.LENGTH_LONG).show();
            return;
        } else {
            Log.i("Info", "*****inside currInput else");
            Log.i("Info", "***" + currInput.getText().toString() + "***");
            double currInputVal = Double.parseDouble(currInput.getText().toString());

            //multiply by conversion rate
            currInputVal = currInputVal * 112.66;

            //display returned val to newCurrView
            TextView currOutput = (TextView) findViewById(R.id.newCurrView);
            currOutput.setText(String.valueOf(currInputVal));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
