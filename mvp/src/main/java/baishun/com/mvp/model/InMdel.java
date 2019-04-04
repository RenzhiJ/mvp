package baishun.com.mvp.model;

import baishun.com.mvp.presenter.NewsPresenter;
import baishun.com.mvp.utils.RetrofitUtils;
import io.reactivex.Flowable;

public class InMdel {
    private NewsPresenter presenter;

    public InMdel(NewsPresenter presenter) {
        this.presenter = presenter;
    }
    public void getData(String type){
        Flowable flowable = RetrofitUtils.getInstance().getApiService().Tuijian(type);
        presenter.getNews(flowable);
    }
}
