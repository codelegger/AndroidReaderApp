package managers;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import news.agoda.com.sample.DetailViewActivity;
import news.agoda.com.sample.MainActivity;
import news.agoda.com.sample.MediaEntity;
import news.agoda.com.sample.NewsEntity;
import news.agoda.com.sample.NewsListAdapter;
import news.agoda.com.sample.R;


/**
 * Created by uba on 25/08/2017.
 */

public class JsonParseManger {
    private static final String TAG = JsonParseManger.class.getSimpleName();

    public List parseNewsArrayResponse(String data) {
        JSONObject jsonObject;

        List newsItemList = new ArrayList();
        try {
            jsonObject = new JSONObject(data);
            JSONArray resultArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < resultArray.length(); i++) {
                JSONObject newsObject = resultArray.getJSONObject(i);

                NewsEntity newsEntity = parseNewsJsonObject(newsObject);
                newsItemList.add(newsEntity);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "fail to parse json string");
        }
        return newsItemList;
    }


    public static NewsEntity parseNewsJsonObject(JSONObject newsObject) {
        NewsEntity newsEntity = new Gson().fromJson(newsObject.toString(), NewsEntity.class);
        try {
            if (newsObject.has("multimedia") && newsObject.getJSONArray("multimedia").length() > 0) {
                newsEntity.setMediaEntity(parseMultiMediaJsonObject(newsObject.getJSONArray("multimedia")));
            } else {
                newsEntity.setMediaEntity(new ArrayList<MediaEntity>());
            }
        } catch (JSONException e) {
            newsEntity.setMediaEntity(new ArrayList<MediaEntity>());
            e.printStackTrace();
        }
        return newsEntity;
    }

    public static ArrayList<MediaEntity> parseMultiMediaJsonObject(JSONArray mediaObject) {
        ArrayList<MediaEntity> mediaEntity = new Gson().fromJson(mediaObject.toString(), new TypeToken<List<MediaEntity>>() {
        }.getType());
        return mediaEntity;


    }
}
