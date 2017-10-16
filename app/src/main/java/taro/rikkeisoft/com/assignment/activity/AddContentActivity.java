package taro.rikkeisoft.com.assignment.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import taro.rikkeisoft.com.assignment.R;

/**
 * Created by VjrutNAT on 10/13/2017.
 */

public class AddContentActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mAlarm;
    private Spinner mDate;
    private Spinner mTime;
    private ImageButton mCloseAlarm;
    private LinearLayout mLLAlarm;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);

        TextView tvDateTime = (TextView) findViewById(R.id.tv_time);
        EditText edtTitle = (EditText) findViewById(R.id.edt_title_note);
        EditText edtContent = (EditText) findViewById(R.id.edt_content_note);

        mAlarm = (TextView) findViewById(R.id.tv_alarm);

        mDate = (Spinner) findViewById(R.id.sp_date);
        mTime = (Spinner) findViewById(R.id.sp_time);
        mCloseAlarm = (ImageButton) findViewById(R.id.imv_bt_close_alarm);

        mLLAlarm = (LinearLayout) findViewById(R.id.ll_alarm_select);

        mAlarm.setOnClickListener(this);
        mDate.setOnClickListener(this);
        mTime.setOnClickListener(this);
        mCloseAlarm.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_camera:
                break;
            case R.id.action_opption:
                break;
            case R.id.action_accept:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_alarm:
                mLLAlarm.setVisibility(View.INVISIBLE);
                break;
            case R.id.sp_date:
                break;
            case R.id.sp_time:
                break;
            case R.id.imv_bt_close_alarm:
                mLLAlarm.setVisibility(View.GONE);
                break;
        }
    }
}
