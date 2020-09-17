package in.bitcode.listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView mListViewImages;
    private int [] mArrImageIds = {
            R.drawable.img1,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img5,R.drawable.img6,
            R.drawable.img7,R.drawable.img8,R.drawable.img9,
            R.drawable.img1,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img5,R.drawable.img6,
            R.drawable.img7,R.drawable.img8,R.drawable.img9,
            R.drawable.img1,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img5,R.drawable.img6,
            R.drawable.img7,R.drawable.img8,R.drawable.img9
    };
    private boolean mArrImageState [] = new boolean[mArrImageIds.length];

    private ImageAdapter mAdapterImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        mListViewImages = findViewById( R.id.listViewImages );

        mAdapterImages = new ImageAdapter( this, mArrImageIds,mArrImageState );
        mListViewImages.setAdapter(mAdapterImages);

        mListViewImages.setOnItemClickListener(
                new ImagesItemClickListener()
        );

    }

    private class ImagesItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            Toast toast =
                    Toast.makeText(
                            MainActivity.this,
                            position + "",
                            Toast.LENGTH_LONG
                    );
            toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0 );
            toast.show();
            if(mArrImageState[position]==true){
                mArrImageState[position]=false;
                view.setBackgroundColor(Color.WHITE);
            }
            else {
                mArrImageState[position] = true;
                view.setBackgroundColor(Color.GRAY);

            }

        }
    }
}
