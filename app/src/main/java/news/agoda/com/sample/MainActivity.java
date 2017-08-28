package news.agoda.com.sample;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import managers.DataManager;
import managers.JsonParseManger;
import utils.Utils;

public class MainActivity
        extends ListActivity
         {

    private static final String TAG = MainActivity.class.getSimpleName();
    private List<NewsEntity> newsItemList;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);

        newsItemList = new ArrayList<>();

        DataManager manager = new DataManager();
        manager.loadResource(callback);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private Callback callback = new Callback() {
        @Override
        public void onResult(String data) {
            processResult(data);
        }
    };
    private void processResult(final String data) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                JSONObject jsonObject;

                newsItemList = new ArrayList<NewsEntity>();
                try {
//                    jsonObject = new JSONObject(data);
//                    JSONArray resultArray = jsonObject.getJSONArray("results");
                    newsItemList = new JsonParseManger().parseNewsArrayResponse(data);
                } catch (Exception e) {
                    Log.e(TAG, "fail to parse json string");
                }
                NewsListAdapter adapter = new NewsListAdapter(MainActivity.this, R.layout.list_item_news, newsItemList);
                setListAdapter(adapter);

                ListView listView = getListView();
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        NewsEntity newsEntity = newsItemList.get(position);
                        String title = newsEntity.getTitle();
                        String articleUrl = newsEntity.getArticleUrl();
                        String summary = newsEntity.getSummary();

                        Intent intent = new Intent(MainActivity.this, DetailViewActivity.class);
                        intent.putExtra("title", title);
                        intent.putExtra("storyURL", articleUrl);
                        intent.putExtra("summary", summary);
                        intent.putExtra("imageURL", newsEntity.getMediaBigImageUrl(Utils.isTablet(MainActivity.this)));

                        startActivity(intent);
                    }
                });
            }
        }, 0);
    }

}
