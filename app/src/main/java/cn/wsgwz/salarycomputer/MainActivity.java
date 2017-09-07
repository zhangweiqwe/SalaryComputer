package cn.wsgwz.salarycomputer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private TextView tv_00;
    private Spinner s_00;
    private List<String> spinnerCategory0;
    private SpinnerCategoryAdapter spinnerCategoryAdapter0;

    private TextView tv_01;
    private EditText et_00;

    private TextView tv_02;
    private EditText et_01;

    private TextView tv_03;
    private Spinner s_01;

    private Button b_00,b_01;
    private List<String> spinnerCategory1;
    private SpinnerCategoryAdapter spinnerCategoryAdapter1;

    private TextView tv_04;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }
    private void initData(){
        spinnerCategory0 = new ArrayList<>();
        spinnerCategory0.add("工资、薪金所得（月薪）");
        spinnerCategory0.add("工资、薪金所得（月薪 税后）");
        spinnerCategory0.add("年终奖所得");
        spinnerCategory0.add("劳务报酬所得");
        spinnerCategory0.add("个体工商户生产、经营所得");
        spinnerCategory0.add("对企事业单位的承包、承租经营所得承租经营所得承租经营所得");
        spinnerCategory0.add("稿酬所得");
        spinnerCategory0.add("特许权使用费所得");
        spinnerCategory0.add("财产租赁所得");
        spinnerCategory0.add("财产转让所得");
        spinnerCategory0.add("利息、股息、红利所得");
        spinnerCategory0.add("偶然所得");
        spinnerCategoryAdapter0 = new SpinnerCategoryAdapter(spinnerCategory0,this);

        spinnerCategory1 = new ArrayList<>();
        spinnerCategory1.add("3500");
        spinnerCategory1.add("4800");
        spinnerCategoryAdapter1 = new SpinnerCategoryAdapter(spinnerCategory1,this);



        s_00.setAdapter(spinnerCategoryAdapter0);
        s_01.setAdapter(spinnerCategoryAdapter1);


        s_00.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,spinnerCategory0.get(i),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        s_01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,spinnerCategory1.get(i),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        b_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,((Button)view).getText().toString(),Toast.LENGTH_SHORT).show();
                simulationResultData();
            }
        });

        b_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,((Button)view).getText().toString(),Toast.LENGTH_SHORT).show();
                simulationResetResult();
            }
        });
    }

    private void simulationResultData(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("应纳税所得额\t"+0+"元"+"\r\n");
        stringBuilder.append("适用税率\t"+0+"%"+"\r\n");
        stringBuilder.append("速算扣除数\t"+0+"元"+"\r\n");
        stringBuilder.append("应缴税款\t"+0+"元"+"\r\n");
        stringBuilder.append("实发工资\t"+0+"元"+"\r\n");
        tv_04.setText(stringBuilder);
    }

    private void simulationResetResult(){
        s_00.setSelection(0);
        et_00.setText(null);
        et_01.setText(null);
        s_01.setSelection(0);

        tv_04.setText(null);
    }

    private void initView(){
        tv_00 = (TextView) findViewById(R.id.tv_00);
        s_00 = (Spinner) findViewById(R.id.s_00);
        tv_01 = (TextView) findViewById(R.id.tv_01);
        et_00 = (EditText) findViewById(R.id.et_00);
        tv_02 = (TextView) findViewById(R.id.tv_02);
        et_01 = (EditText) findViewById(R.id.et_01);
        tv_03 = (TextView) findViewById(R.id.tv_03);
        s_01 = (Spinner) findViewById(R.id.s_01);
        b_00 = (Button) findViewById(R.id.b_00);
        b_01 = (Button) findViewById(R.id.b_01);
        tv_04 = (TextView) findViewById(R.id.tv_04);
    }




    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
