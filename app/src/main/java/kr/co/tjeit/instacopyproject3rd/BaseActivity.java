package kr.co.tjeit.instacopyproject3rd;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by the on 2017-09-05.
 */

//sadasd

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext = this;

    public abstract void setupEvents();
    public abstract void setValues();
    public abstract void bindViews();

}
