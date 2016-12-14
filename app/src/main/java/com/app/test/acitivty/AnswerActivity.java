package com.app.test.acitivty;

import android.content.Intent;
import android.os.Bundle;

import com.app.test.R;
import com.app.test.util.ConstantUtil;

/**
 * Created by youdianre on 16-12-13.
 */
public class AnswerActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Intent intent = this.getIntent();
        String listIndex = intent.getExtras().getString(ConstantUtil.LIST_INDEX);
        Bundle extras = intent.getExtras();
        System.out.println(listIndex);

    }
}
