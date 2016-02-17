package pl.neducatio.myapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import pl.neducatio.myapplication.BaseApplication;
import pl.neducatio.myapplication.models.IPModel;
import pl.neducatio.myapplication.services.IPService;
import pl.neducatio.myapplication.R;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private Context context;

    @Inject
    IPService ipService;

    @ViewById(R.id.textView)
    TextView textView;

    @ViewById(R.id.textView2)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((BaseApplication) getApplication()).component().inject(this);

        context = this;
    }

    @Click(R.id.button)
    @LongClick(R.id.button)
    public void clickButton(){
        ipService.getMyIp().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IPModel>() {
                    @Override
                    public void onCompleted() {
                        textView.setText("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(IPModel ip) {
                        Intent intent = new Intent(context, SecondActivity_.class);
                        intent.putExtra("IP", ip.getIp());
                        startActivity(intent);
                    }
                });

    }
}
