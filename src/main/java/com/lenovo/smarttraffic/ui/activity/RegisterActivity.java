package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.textinput1)
    TextInputLayout textinput1;
    @BindView(R.id.et2)
    EditText et2;
    @BindView(R.id.textinput2)
    TextInputLayout textinput2;
    @BindView(R.id.et3)
    EditText et3;
    @BindView(R.id.textinput3)
    TextInputLayout textinput3;
    @BindView(R.id.et4)
    EditText et4;
    @BindView(R.id.textinput4)
    TextInputLayout textinput4;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(findViewById(R.id.toolbar), true, "注册");

        btnSubmit.setOnClickListener(v ->{
           boolean f =  checkShuru();
           if(!f){
               return;
           }
//本地静态存一个所有的账户和密码，
           Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
           finish();

        });
    }

    @Override
    protected int getLayout() {
        return R.layout.register_activity;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.network_setting, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private boolean checkShuru() {
        //获取四个输入框，从上往下捋
        String et1str = et1.getText().toString();
        String et2str = et2.getText().toString();
        String et3str = et3.getText().toString();
        String et4str = et4.getText().toString();

        if (et1str.length() <= 4) {
            textinput1.setError("用户名不能小于四个字");
            return false;
        }

        if (et2str.length() <= 6) {
            textinput2.setError("邮箱不能小于6个字");
            return false;
        }


        return true;

    }
}
