package ro.pub.cs.systems.eim.practicaltest01var06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var06MainActivity extends AppCompatActivity implements TextWatcher {

    private EditText upperEditText = null;
    private EditText urlEditText = null;
    private Button detailsButton = null;
    private Button passButton = null;
    private Button navigateToSecondary = null;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (urlEditText.getText().toString().equals("http://www.cs.pub.ro")) {
            passButton.setBackgroundColor(0xFF00FF00);
            passButton.setText("pass");
        }

        else {
            passButton.setBackgroundColor(0xFFFF0000);
            passButton.setText("fail");
        }
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.details_button:
                    if (passButton.getVisibility() == View.VISIBLE && urlEditText.getVisibility() == View.VISIBLE) {
                        passButton.setVisibility(View.GONE);
                        urlEditText.setVisibility(View.GONE);
                        detailsButton.setText("More details");
                    }

                    else {
                        passButton.setVisibility(View.VISIBLE);
                        urlEditText.setVisibility(View.VISIBLE);
                        detailsButton.setText("Less details");
                    }
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        upperEditText = (EditText)findViewById(R.id.upper_edit_text);
        urlEditText = (EditText)findViewById(R.id.url_edit_text);

        detailsButton = (Button)findViewById(R.id.details_button);
        passButton = (Button)findViewById(R.id.pass_button);
        navigateToSecondary = (Button)findViewById(R.id.second_activity_button);

        detailsButton.setOnClickListener(buttonClickListener);
        urlEditText.addTextChangedListener(this);
    }
}
