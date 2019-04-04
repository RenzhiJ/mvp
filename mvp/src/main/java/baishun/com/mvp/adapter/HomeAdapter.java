package baishun.com.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import baishun.com.mvp.R;
import baishun.com.mvp.bean.MessageBean;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHoder> {

    private Context context;
    private List<MessageBean.DataBeanX.DataBean> data;

    public HomeAdapter(Context context, List<MessageBean.DataBeanX.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item, null);

        ViewHoder holder = new ViewHoder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, int i) {


        MessageBean.DataBeanX.DataBean.GroupBean group = data.get(i).getGroup();

        if (group != null) {
            MessageBean.DataBeanX.DataBean.GroupBean.LargeCoverBean large_cover = group.getLarge_cover();
            if (large_cover != null) {
                List<MessageBean.DataBeanX.DataBean.GroupBean.LargeCoverBean.UrlListBeanXXX> url_list = large_cover.getUrl_list();
                if (url_list != null) {
                    int size = url_list.size();
                    for (int i1 = 0; i1 > size; i1++) {
                        Glide.with(context).load(url_list.get(i1).getUrl()).into(viewHoder.img);

                    }
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv_show;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);


            img = itemView.findViewById(R.id.img);
            tv_show = itemView.findViewById(R.id.tv_show);
        }
    }


}
