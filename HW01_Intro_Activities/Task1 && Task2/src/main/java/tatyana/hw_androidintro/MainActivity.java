package tatyana.hw_androidintro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button mBtnStartClickCount, mBtnStartChangeByClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStartClickCount = (Button) findViewById(R.id.btn_start_clickCount);
        mBtnStartChangeByClick = (Button) findViewById(R.id.btn_start_changeByClick);

        mBtnStartClickCount.setOnClickListener(this);
        mBtnStartChangeByClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_start_clickCount) {

            if (mBtnStartClickCount != null) {
                Intent intent = new Intent(MainActivity.this, ClickCountActivity.class);
                startActivity(intent);
            }
        }

        if (view.getId() == R.id.btn_start_changeByClick) {

            if (mBtnStartChangeByClick != null) {
                Intent intent = new Intent(MainActivity.this, ChangeByClickActivity.class);
                startActivity(intent);
            }
        }
    }
}
