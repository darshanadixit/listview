package in.bitcode.listview2;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ImageAdapter extends BaseAdapter {

    private int [] mArrImageIds;
    private Context mContext;
    private boolean [] mArrImageState;

    public ImageAdapter(Context context, int [] arrImageIds ,boolean [] arrImageState) {
        mContext = context;
        mArrImageIds = arrImageIds;
        mArrImageState = arrImageState;
    }

    @Override
    public int getCount() {
        Log.e("tag", "getCount " + mArrImageIds.length );
        return mArrImageIds.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ImageView imageView;

        if( convertView == null ) {
            //create new imaage view
            Log.e("tag", "New view created for " + position );
            imageView = new ImageView( mContext );
            imageView.setLayoutParams(
                    new ListView.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT )
            );
        }
        else {
            //reuse the convert view
            Log.e("tag", "convert view reused for  " + position );
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource( mArrImageIds[position] );
        if(mArrImageState[position] == true){
            imageView.setBackgroundColor(Color.GRAY);
        }
        else {
            imageView.setBackgroundColor(Color.WHITE);
        }

        return imageView;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
