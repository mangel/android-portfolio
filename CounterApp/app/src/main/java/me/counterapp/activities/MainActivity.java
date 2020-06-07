package me.counterapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import me.counterapp.R;

public class MainActivity extends AppCompatActivity {

    private int Count;
    private float InitialFontSize;
    private TextView txtvwOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.Count = 0;

        this.txtvwOutput = (TextView)this.findViewById(R.id.txtvwOutput);
        this.InitialFontSize = txtvwOutput.getTextSize();
    }

    public void onbtnCountClicked(View view){
        this.Count += 10;
        this.refreshUI();
    }

    public void onbtnResetClicked(View view){
        this.Count = 0;
        this.txtvwOutput.setTextSize(TypedValue.COMPLEX_UNIT_PX, this.InitialFontSize);
        this.refreshUI();
    }

    private void refreshUI(){
        String output = Integer.toString(this.Count);
        float text_size = this.txtvwOutput.getTextSize();
        float new_text_size = text_size;

        double result = Math.log10(this.Count);

        if (this.Count >= 10 && result % 1 == 0) {
            new_text_size = new_text_size * 0.8f;
        }

        this.txtvwOutput.setTextSize(TypedValue.COMPLEX_UNIT_PX, new_text_size);
        this.txtvwOutput.setText(output);
    }
}