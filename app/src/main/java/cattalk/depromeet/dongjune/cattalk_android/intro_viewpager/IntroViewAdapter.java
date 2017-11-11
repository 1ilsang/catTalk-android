package cattalk.depromeet.dongjune.cattalk_android.intro_viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import cattalk.depromeet.dongjune.cattalk_android.R;

/**
 * Created by dongjunekim on 2017-11-11.
 */

public class IntroViewAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;

    public IntroViewAdapter(Context context, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        view = inflater.inflate(R.layout.item_intro_viewpager, null);
        //ImageView img = (ImageView) view.findViewById(R.id.item_intro_viewpager);

        //비트맵으로 변환하여 이미지용량을 줄이고 화질을 낮춤
        /*img.setImageBitmap(getResizedBitmap(context.getResources(), R.drawable.intro_pager01 + position, 2));
        container.addView(view);*/
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public static Bitmap getResizedBitmap(Resources resources, int id, int size) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = size;
        Bitmap src = BitmapFactory.decodeResource(resources, id, options);
        Bitmap resized = Bitmap.createScaledBitmap(src, src.getWidth(), src.getHeight(), true);
        return resized;
    }
}
