package baishun.com.mvp.utils;

import baishun.com.mvp.bean.MessageBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
@GET("min/v1/?")
Flowable<MessageBean> Tuijian(@Query("content_type") String type);
}
