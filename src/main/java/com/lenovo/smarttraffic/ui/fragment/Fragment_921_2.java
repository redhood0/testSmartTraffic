package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Fragment_921_2 extends SupportFragment {
    Unbinder unbinder;

    @BindView(R.id.tl_password)
    TextInputLayout textInputLayout;

    @BindView(R.id.et_password)
    EditText et_password;


    public static Fragment_921_2 fragment_921_2;

    public static Fragment_921_2 newInstance(){
        if(fragment_921_2 == null){
            fragment_921_2 = new  Fragment_921_2();
        }
        return fragment_921_2;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_921_2,container,false);
        unbinder = ButterKnife.bind(this,v);


        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("onTextChanged", "onTextChanged:>>>> "+count+"-"+start +"-"+before );
                if(s.length() == 0){
                    textInputLayout.setError("不能为空");
                    textInputLayout.setErrorEnabled(true);
                }else {
                    textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return v;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
