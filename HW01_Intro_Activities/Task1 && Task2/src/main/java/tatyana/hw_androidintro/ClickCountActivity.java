package tatyana.hw_androidintro;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ClickCountActivity extends Activity implements View.OnClickListener {
    
    Button mBtnExplicitDefine;
    int mExplicitBtnPressed, mImplicitButtonPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_count_activity);

        mBtnExplicitDefine = (Button) findViewById(R.id.btn_explicit_define);

        final Button mBtnImplicitDefine = new Button(this);
        mBtnImplicitDefine.setText("Click To Count");

        RelativeLayout clickCountLayout = (RelativeLayout) findViewById(R.id.click_count_layout);
        clickCountLayout.addView(mBtnImplicitDefine);

        mBtnImplicitDefine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mImplicitButtonPressed++;

                if (mBtnImplicitDefine != null) {
                    mBtnImplicitDefine.setText(String.valueOf(mImplicitButtonPressed));
                }
           }
        });

        mBtnExplicitDefine.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_explicit_define) {

            mExplicitBtnPressed++;

            if (mBtnExplicitDefine != null) {
                mBtnExplicitDefine.setText(String.valueOf(mExplicitBtnPressed));
            }
        }
    }
}
