package com.lenovo.smarttraffic.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.gson.JsonObject;
import com.lenovo.smarttraffic.InitApp;
import com.lenovo.smarttraffic.MainActivity;
import com.lenovo.smarttraffic.R;

import com.lenovo.smarttraffic.bean.ReqBean1;
import com.lenovo.smarttraffic.bean.TestBean1;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.HashMap;

import okhttp3.OkHttpClient;

/**
 * @author Amoly
 * @date 2019/4/11.
 * description：
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener, MyCallBack {

    private EditText mEditTextName;
    private EditText mEditTextPassword;
    private TextInputLayout mTextInputLayoutName;
    private TextInputLayout mTextInputLayoutPswd;
    Button regBtn;


    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(findViewById(R.id.toolbar), true, getString(R.string.login));

        mTextInputLayoutName = findViewById(R.id.textInputLayoutName);
        mTextInputLayoutPswd = findViewById(R.id.textInputLayoutPassword);
        regBtn = findViewById(R.id.regBtn);

        mEditTextName = findViewById(R.id.editTextName);
        //important!!!!!!!!!!!!
        //mTextInputLayoutName.setErrorEnabled(true);
        mTextInputLayoutName.setErrorEnabled(true);
        mEditTextPassword = findViewById(R.id.editTextPassword);
        mTextInputLayoutPswd.setErrorEnabled(true);
        Button loginButton = findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(this);

        mEditTextName.addTextChangedListener(new TextWatcher() {
            @Override/*内容要改变之前调用*/
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                /*从start位置开始，count个字符（空字符是0）将被after个字符替换*/

            }

            @Override/*内容要改变时调用*/
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /*说明在s字符串中，从start位置开始的count个字符刚刚取代了长度为before的旧文本*/
            }

            @Override/*内容要改变之后调用*/
            public void afterTextChanged(Editable s) {
                //这个方法被调用，那么说明s字符串的某个地方已经被改变。
                checkName(s.toString(), false);
            }
        });

        mEditTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkPwd(s.toString(), false);
            }
        });

       Toolbar toolbar =  findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
//                    try {
//                        JSONObject jsonObject = new JSONObject("aaa");
//                        jsonObject.get("a");
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                    ReqBean1 reqBean1 = new ReqBean1(1,"user1");
                    HashMap<String,Object> hashMap = new HashMap<>();
                    hashMap.put("CarId",1);
                    hashMap.put("UserName","user1");

                    OkHttpUtil.doPost("GetCarAccountBalance.do",hashMap, JsonObject.class, LoginActivity.this,1);
                    Toast.makeText(LoginActivity.this, "5555555", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }
        regBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        });
    }

    //网络设置
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.network_setting, menu);
//        return true;
//    }
// todo:练习
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.network_setting,menu);

        MenuItem item = menu.findItem(R.id.action_settings2);
        item.getActionView().setOnClickListener(v ->{
            onOptionsItemSelected(item);
            Toast.makeText(this, "3333333", Toast.LENGTH_SHORT).show();
        });
        item.getActionView().findViewById(R.id.xxxxxxx).setOnClickListener(v->{

        });

//        MenuItem item2 = menu.findItem(R.id.xxxxxxx);
//
//        item2.getActionView().setOnClickListener(v->{
//            Toast.makeText(this, "444", Toast.LENGTH_SHORT).show();
//        });

        return true;
    }
//todo:练习
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_settings2){
            Toast.makeText(this, "111111", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(item.getItemId() == R.id.action_settings){
//            Toast.makeText(this, "22222", Toast.LENGTH_SHORT).show();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginBtn) {
            hideSoftInput(v);
            if (!checkName(mEditTextName.getText(), true))
                return;
            if (!checkPwd(mEditTextPassword.getText(), true))
                return;
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private boolean checkPwd(CharSequence pswd, boolean isLogin) {
        if (TextUtils.isEmpty(pswd)) {
            if (isLogin) {
                mTextInputLayoutPswd.setError(getString(R.string.error_pwd_empty));
                return false;
            }
        } else {
            mTextInputLayoutPswd.setError(null);
        }
        return true;
    }

    private boolean checkName(CharSequence name, boolean isLogin) {
        if (TextUtils.isEmpty(name)) {
            if (isLogin) {
                mTextInputLayoutName.setError("用户名不能为kong");
                return false;
            }
        } else {
            mTextInputLayoutName.setError(null);
        }
        return true;
    }


    /**
     * 隐藏键盘输入法
     *
     * @param view The view.
     */
    public static void hideSoftInput(final View view) {
        InputMethodManager imm =
                (InputMethodManager) InitApp.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0, new ResultReceiver(new Handler()) {
            @Override
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode == InputMethodManager.RESULT_UNCHANGED_SHOWN
                        || resultCode == InputMethodManager.RESULT_SHOWN) {
                    toggleSoftInput();
                }
            }
        });
    }

    /**
     * 软键盘切换
     */
    public static void toggleSoftInput() {
        InputMethodManager imm =
                (InputMethodManager) InitApp.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE);
        //noinspection ConstantConditions
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

    }

    @Override
    public void sendResult(Object t, int typeId) {
        runOnUiThread(()->{
            Toast.makeText(this, "" + ((JsonObject)t).toString(), Toast.LENGTH_SHORT).show();
        });

    }
}
