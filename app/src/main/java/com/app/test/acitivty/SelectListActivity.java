package com.app.test.acitivty;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.test.R;
import com.app.test.util.ConstantUtil;

/**
 * Created by youdianre on 16-12-13.
 */
public class SelectListActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_list);

        final EditText listIndex = (EditText) findViewById(R.id.listindex);
        Button start = (Button) findViewById(R.id.start);

        final String indexString = listIndex.getText().toString();
        System.out.println(indexString);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = listIndex.getText().toString();
                goAnswer(val);
            }
        });

    }

    public void goAnswer(String index){
        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra(ConstantUtil.LIST_INDEX, index);
//        intent.put
        startActivity(intent);
    }
}
