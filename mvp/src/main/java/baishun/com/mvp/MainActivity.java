package baishun.com.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import baishun.com.mvp.adapter.HomeAdapter;
import baishun.com.mvp.bean.MessageBean;
import baishun.com.mvp.view.IView;

public class MainActivity extends AppCompatActivity implements IView{
    private static final String TAG = "MainActivity";

    private RecyclerView mRec;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview() {
        mRec=findViewById(R.id.rcy);
    }

    @Override
    public void Success(Object o) {


        MessageBean bean= (MessageBean) o;

        List<MessageBean.DataBeanX.DataBean>data=bean.getData().getData();
        if (data !=null){
            HomeAdapter homeAdapter = new HomeAdapter(MainActivity.this, data);

            mRec.setLayoutManager(manager);
            mRec.setAdapter(homeAdapter);
        }



    }

    @Override
    public void onFiled(Exception e) {

    }
}
