package news.agoda.com.sample;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import managers.JsonParseManger;
import utils.TestUtil;

public class MediaEntityTest {

 private JsonParseManger parser;
    private  MediaEntity mediaEntity;
    private NewsEntity story;
    @Before
    public void setup(){

        parser = new JsonParseManger();
        mediaEntity = TestUtil.createMockMediaEntity();
    }

    @Test
    public void TestParse(){

        List<NewsEntity> stories = parser.parseNewsArrayResponse(TestUtil.DUMMY_RESPONSE);
        Assert.assertEquals("parsing json response ",1, stories.size());
        story = stories.get(0);
        Assert.assertTrue("StoryEntity ",story!=null);
        Assert.assertTrue("parsing json response::check media entity",stories.get(0).getMediaEntity().size() > 0);
        Assert.assertTrue("parsing json response::check media entity type",stories.get(0).getMediaEntity().get(0).getType().equals("image"));
        Assert.assertTrue("MediaEntity::TestMediaThumbnailImage",story.getMediaThumbnailUrl(false).length()>0);

    }

    @Test
    public void testNewsEntityModelFunctions()
    {
        Assert.assertTrue("mediaEntity::mock",mediaEntity!=null);
        Assert.assertTrue("mediaEntity::getType",mediaEntity.getType().equals("type"));
        Assert.assertTrue("mediaEntity::getURL",mediaEntity.getUrl().equals("www.xyz.com"));


    }





}
