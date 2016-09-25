package tatyana.hw_androidintro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowInfoActivity extends Activity {

    TextView mShowIdView, mShowTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_info_activity);

        mShowIdView = (TextView) findViewById(R.id.show_id_view);
        mShowTextView = (TextView) findViewById(R.id.show_text_view);

        if (getIntent() != null && mShowIdView != null && mShowTextView != null) {

            String pressedBtnId = getIntent().getStringExtra("BUTTON_ID");
            String pressedBtnText = getIntent().getStringExtra("BUTTON_TEXT");

            mShowIdView.setText(pressedBtnId);
            mShowTextView.setText(pressedBtnText);
        }
    }
}
