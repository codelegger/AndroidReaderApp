package news.agoda.com.sample;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import enums.MediaImageFormatType;
import utils.Utils;

/**
 * This represents a news item
 */
public class NewsEntity {
    private static final String TAG = NewsEntity.class.getSimpleName();
    private String title;
    @SerializedName("abstract")
    private String summary;
    @SerializedName("url")
    private String articleUrl;
    private String byline;
    private String publishedDate;

    private List<MediaEntity> mediaEntityList;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public void setMediaEntityList(List<MediaEntity> mediaEntityList) {
        this.mediaEntityList = mediaEntityList;
    }

    public NewsEntity() {
    }
//    public NewsEntity(JSONObject jsonObject) {
//        try {
//            title = jsonObject.getString("title");
//            summary = jsonObject.getString("abstract");
//            articleUrl = jsonObject.getString("url");
//            byline = jsonObject.getString("byline");
//            publishedDate = jsonObject.getString("published_date");
//
//
//            mediaEntityList = new ArrayList<>();
//            JSONArray mediaArray = jsonObject.getJSONArray("multimedia");
//            for (int i = 0; i < mediaArray.length(); i++) {
//                JSONObject mediaObject = mediaArray.getJSONObject(i);
//                MediaEntity mediaEntity = new MediaEntity(mediaObject);
//                mediaEntityList.add(mediaEntity);
//            }
//
//        } catch (JSONException exception) {
//            Log.e(TAG, exception.getMessage());
//        }
//    }

    public String getTitle() {
        return title;
    }


    public String getSummary() {
        return summary;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public String getByline() {
        return byline;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public List<MediaEntity> getMediaEntity() {
        return mediaEntityList;
    }

    public void setMediaEntity(List<MediaEntity> mediaEntity) {
        this.mediaEntityList = mediaEntity;
    }

    private String getMediaImageUrl(MediaImageFormatType type) {
        if (mediaEntityList == null || mediaEntityList.isEmpty()) {
            return "";
        }
        for (MediaEntity entity : mediaEntityList) {
            if (entity.getFormat().equalsIgnoreCase(type.toString())) {
                return entity.getUrl();
            }
        }
        return "";
    }

    public String getMediaThumbnailUrl(boolean isTablet) {
        String thumbnailURL = "";
        if (isTablet) {
            thumbnailURL = getMediaImageUrl(MediaImageFormatType.LARGE_THUMBNAIL);
        } else {
            thumbnailURL = getMediaImageUrl(MediaImageFormatType.STANDARD_THUMBNAIL);
        }
        return thumbnailURL;
    }

    public String getMediaBigImageUrl(boolean isTablet) {
        String thumbnailURL = "";
        if (isTablet) {
            thumbnailURL = getMediaImageUrl(MediaImageFormatType.MEDIUM_THREE_BY_TWO);
        } else {
            thumbnailURL = getMediaImageUrl(MediaImageFormatType.NORMAL);
        }
        return thumbnailURL;
    }
}
