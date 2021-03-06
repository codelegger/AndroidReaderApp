package news.agoda.com.sample;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class represents a media item
 */
public class MediaEntity {
    private String url;
    private String format;
    private int height;
    private int width;
    private String type;
    private String subType;
    private String caption;
    private String copyright;

    public MediaEntity() {
    }
//    public MediaEntity(JSONObject jsonObject) throws JSONException {
//        url = jsonObject.getString("url");
//        format = jsonObject.getString("format");
//        height = jsonObject.getInt("height");
//        width = jsonObject.getInt("width");
//        type = jsonObject.getString("type");
//        subType = jsonObject.getString("subtype");
//        caption = jsonObject.getString("caption");
//        copyright = jsonObject.getString("copyright");
//    }

    public String getUrl() {
        return url;
    }

    public String getFormat() {
        return format;
    }



    public String getType() {
        return type;
    }



    public void setUrl(String url) {
        this.url = url;
    }



    public void setType(String type) {
        this.type = type;
    }


}
