package tatyana.hw_androidintro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChangeByClickActivity extends Activity implements View.OnClickListener {

    Button mRedBtn, mYellowBtn, mGreenBtn;
    TextView mTextView;
    int mRedBtnPressed, mYellowBtnPressed, mGreenBtnPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_by_click_activity);

        mRedBtn = (Button)findViewById(R.id.red_btn);
        mYellowBtn = (Button) findViewById(R.id.yellow_btn);
        mGreenBtn = (Button) findViewById(R.id.green_btn);
        mTextView = (TextView) findViewById(R.id.textView);

        mRedBtn.setOnClickListener(this);
        mYellowBtn.setOnClickListener(this);
        mGreenBtn.setOnClickListener(this);
        mTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String redBtnId = String.valueOf(mRedBtn.getId());
        String redBtnText = String.valueOf(mRedBtn.getText());

        String yellowBtnId = String.valueOf(mYellowBtn.getId());
        String yellowBtnText = String.valueOf(mYellowBtn.getText());

        String greenBtnId = String.valueOf(mGreenBtn.getId());
        String greenBtnText = String.valueOf(mGreenBtn.getText());

        if (view.getId() == R.id.red_btn) {
            mRedBtnPressed++;
            mYellowBtnPressed = 0;
            mGreenBtnPressed = 0;

            if (mRedBtn != null) {
                if (mRedBtnPressed < 2) {
                    mTextView.setText(redBtnId);
                }
                else {
                    mTextView.setText(redBtnText);
                }
            }
        }

        if (view.getId() == R.id.yellow_btn) {
            mYellowBtnPressed++;
            mRedBtnPressed = 0;
            mGreenBtnPressed = 0;

            if (mYellowBtn != null) {
                if (mYellowBtnPressed < 2) {
                    mTextView.setText(yellowBtnId);
                }
                else {
                    mTextView.setText(yellowBtnText);
                }
            }
        }

        if (view.getId() == R.id.green_btn) {
            mGreenBtnPressed++;
            mRedBtnPressed = 0;
            mYellowBtnPressed = 0;

            if (mGreenBtn != null) {
                if (mGreenBtnPressed < 2) {
                    mTextView.setText(greenBtnId);
                }
                else {
                    mTextView.setText(greenBtnText);
                }
            }
        }

        String idToShow, textToShow;
        if (view.getId() == R.id.textView) {

            if (mTextView != null) {
                if (mRedBtnPressed > 0) {
                    idToShow = redBtnId;
                    textToShow = redBtnText;
                }
                else if (mYellowBtnPressed > 0) {
                    idToShow = yellowBtnId;
                    textToShow = yellowBtnText;
                }
                else if (mGreenBtnPressed > 0) {
                    idToShow = greenBtnId;
                    textToShow = greenBtnText;
                }
                else {
                    idToShow = "";
                    textToShow = "No button click";
                }

                Intent intent = new Intent(ChangeByClickActivity.this, ShowInfoActivity.class);

                intent.putExtra("BUTTON_ID", idToShow);
                intent.putExtra("BUTTON_TEXT", textToShow);

                startActivity(intent);
            }
        }
    }
}
