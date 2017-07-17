package stevenpjohnson.dollarconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {



    public void cnvCurr(View view){

        HashMap<String, Double> currRates = new HashMap<String, Double>();
        //in future TODO: populate rates from api call
        currRates.put("JPY", 112.66);
        currRates.put("EUR", 0.87);
        currRates.put("GBP", 0.77);

        //get currInputView
        EditText currInput = (EditText) findViewById(R.id.currInputView);

        if(currInput.getText().toString().length() == 0){

            Toast.makeText(this, "You must enter a value", Toast.LENGTH_LONG).show();

        } else {

            double currInputVal = Double.parseDouble(currInput.getText().toString());

            //get target currency code from spinner
            Spinner currCodes = (Spinner) findViewById(R.id.resCurr);

            //multiply by conversion rate
            currInputVal = currInputVal * currRates.get(currCodes.getSelectedItem());

            //display returned val to newCurrView
            TextView currOutput = (TextView) findViewById(R.id.newCurrView);
            String outputVal = String.format("%.2f", currInputVal);
            currOutput.setText(outputVal + " " + currCodes.getSelectedItem());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
