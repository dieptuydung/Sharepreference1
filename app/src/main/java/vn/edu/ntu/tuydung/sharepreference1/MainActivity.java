package vn.edu.ntu.tuydung.sharepreference1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    EditText edtName, edtBirthday,edtNumber;
    RadioButton rd1,rd2;
    RadioGroup radioGroup;
    Button b1,b2,b3;

    @Override
    protected void onResume() {
        super.onResume();
        readSharePref();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addVew();
        addEvent();
    }
    private  void addVew()
    {
        edtName =findViewById(R.id.editName);
        edtBirthday =findViewById(R.id.editBirthday);
        edtNumber =findViewById(R.id.editNumber);
        rd1=findViewById(R.id.radioBtn1);
        rd2=findViewById(R.id.radioBtn2);
        radioGroup=findViewById(R.id.radioGr);


    }
    private  void addEvent()
    {
        edtName = findViewById(R.id.editName);
        edtBirthday = findViewById(R.id.editBirthday);
        edtNumber= findViewById(R.id.editNumber);
        rd1= findViewById(R.id.radioBtn1);
        rd2= findViewById(R.id.radioBtn2);
        b1= findViewById(R.id.bt1);
        b2= findViewById(R.id.bt2);
        b3= findViewById(R.id.bt3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

    }
    private  void saveSharePref()
    {
        SharedPreferences sharedPreferences =getSharedPreferences("mySharePref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("name", edtName.getText().toString());
        editor.putString("birthday", edtBirthday.getText().toString());
        editor.putString("number", edtNumber.getText().toString());
        editor.putBoolean("male", rd1.isChecked());
        editor.putBoolean("female", rd2.isChecked());
        editor.commit();



    }
    private void readSharePref()
    {
        SharedPreferences preferences=getSharedPreferences("mySharePref",Context.MODE_PRIVATE);
        edtName.setText(preferences.getString("name","Không tên"));
        edtBirthday.setText(preferences.getString("birthday","Chưa sinh ra"));
        edtNumber.setText(preferences.getString("number","Chưa có số dt"));
       rd1.setChecked(preferences.getBoolean("male",true));
       rd2.setChecked(preferences.getBoolean("female",false));




    }
    private void clearSharePref()
    {
        edtName.setText("");
        edtBirthday.setText("");
        edtNumber.setText("");
        rd1.setChecked(true);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.bt1:
            saveSharePref();break;
            case R.id.bt2:
            readSharePref();break;
            case R.id.bt3 :
             clearSharePref();break;
        }
    }
}
