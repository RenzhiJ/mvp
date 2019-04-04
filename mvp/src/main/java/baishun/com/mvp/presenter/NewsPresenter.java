package baishun.com.mvp.presenter;

import android.util.Log;

import org.reactivestreams.Subscriber;

import baishun.com.mvp.bean.MessageBean;
import baishun.com.mvp.model.InMdel;
import baishun.com.mvp.view.IView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

public class NewsPresenter implements NewBasePresenter {

    private IView iv;
    public void attach(IView iv){
        this.iv=iv;
    }

    @Override
    public void getData(String type) {
        InMdel imodel = new InMdel(this);
        imodel.getData(type);
    }

    public void getNews(Flowable flowable) {
        Subscriber subscriber = flowable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber() {
                    @Override
                    public void onNext(Object o) {
                        if(o!=null){
                            MessageBean bean = (MessageBean)o;
                            iv.Success(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("zxz",t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
