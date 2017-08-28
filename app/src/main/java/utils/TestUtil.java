package utils;

import java.util.ArrayList;
import java.util.Random;

import news.agoda.com.sample.MediaEntity;
import news.agoda.com.sample.NewsEntity;

/**
 * Created by uba on 29/08/2017.
 */

public class TestUtil {

    public final static String DUMMY_RESPONSE = "{\"status\":\"OK\",\"copyright\":\"Copyright (c) 2015 The New York Times Company. All Rights Reserved.\",\"section\":\"technology\",\"last_updated\":\"2015-08-18T10:15:06-05:00\",\"num_results\":24,\"results\":[{\"section\":\"Business Day\",\"subsection\":\"\",\"title\":\"Mock Title\",\"abstract\":\"Top-tier employers may be changing their official policies in a nod to work-life balance, but brutal competition remains an inescapable component of workers’ daily lives.\",\"url\":\"http://www.nytimes.com/2015/08/18/business/work-policies-may-be-kinder-but-brutal-competition-isnt.html\",\"byline\":\"By NOAM SCHEIBER\",\"item_type\":\"Article\",\"updated_date\":\"2015-08-17T22:10:02-5:00\",\"created_date\":\"2015-08-17T22:10:04-5:00\",\"published_date\":\"2015-08-18T04:00:00-5:00\",\"material_type_facet\":\"News\",\"kicker\":\"\",\"des_facet\":[\"Workplace Environment\",\"Executives and Management (Theory)\",\"Paid Time Off\",\"Legal Profession\",\"Banking and Financial Institutions\",\"Computers and the Internet\"],\"org_facet\":[\"Amazon.com Inc\",\"Cravath Swaine & Moore\"],\"per_facet\":[\"Bezos, Jeffrey P\"],\"geo_facet\":[\"Silicon Valley (Calif)\"],\"multimedia\":[{\"url\":\"http://static01.nyt.com/images/2015/08/18/business/18EMPLOY/18EMPLOY-thumbStandard.jpg\",\"format\":\"Standard Thumbnail\",\"height\":75,\"width\":75,\"type\":\"image\",\"subtype\":\"photo\",\"caption\":\"People eating at the Brave Horse Tavern on the Amazon campus in Seattle in June.\",\"copyright\":\"Matthew Ryan Williams for The New York Times\"}]}]}";
    public static NewsEntity createMockNewsEntity(){
        NewsEntity story = new NewsEntity();
        story.setTitle("Mock Story");
        story.setArticleUrl("www.google.com");
        story.setSummary("summary");
        ArrayList<MediaEntity> mediaEntityList = new ArrayList<MediaEntity>();
        mediaEntityList.add(createMockMediaEntity());
        story.setMediaEntity(mediaEntityList);
        return story;
    }

    public static MediaEntity createMockMediaEntity(){
        MediaEntity mediaEntity = new MediaEntity();
        mediaEntity.setUrl("www.xyz.com");
        mediaEntity.setType("type");
        return mediaEntity;
    }



}
