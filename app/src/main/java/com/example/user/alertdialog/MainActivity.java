package com.example.user.alertdialog;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (TextView) this.findViewById(R.id.textView1);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        button.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
    }
    public void dialog1(){
        dialog =new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("你确定要退出？");
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",listener);
        dialog.show();
    }
    public void dialog2(){
        dialog =new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗？");
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
               String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str ="平时轻松";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str ="平时一般";
                        break;
                }
                view.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",listener);
        dialog.show();
    }
    public void dialog3(){
        dialog =new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗？");
        final EditText edit =new EditText(this);
        dialog.setView(edit);
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
              view.setText("输入的是:"+edit.getText().toString());
            }

        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog4(){
        final String item[]=new String[]{"北京","广州","上海"};
        final boolean bSelect[] =new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mlistenter=new DialogInterface.OnMultiChoiceClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        builder =new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mlistenter);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
               String str="你选择了：";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]) {
                        str = str + "\n" + item[i];
                    }
                }
                view.setText(str);
            }

        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }
    public void dialog5(){
        final String item[]=new String[]{"北京","广州","上海"};
        final boolean bSelect[] =new boolean[item.length];
        DialogInterface.OnClickListener slistenter=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;
            }
        };
        builder= new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,slistenter);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]) {
                        str = str + "\n" + item[i];
                    }
                }
                view.setText(str);
            }

        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();

    }
    public void dialog6(){
        final String item[]=new String[]{"北京","广州","上海"};
        final boolean bSelect[] =new boolean[item.length];
        DialogInterface.OnClickListener slistenter=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
               String str="你选择了："+item[which];
                view.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,slistenter);
        dialog =builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
            }

        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
    public void dialog7(){
        LayoutInflater inflater=getLayoutInflater();
    }
    }

