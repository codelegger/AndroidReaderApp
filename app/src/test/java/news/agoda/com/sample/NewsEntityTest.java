package news.agoda.com.sample;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import managers.JsonParseManger;
import utils.TestUtil;

public class NewsEntityTest {

 private JsonParseManger parser;
    private  NewsEntity story;

    @Before
    public void setup(){

        parser = new JsonParseManger();
        story = TestUtil.createMockNewsEntity();
    }

    @Test
    public void TestParse(){

        List<NewsEntity> stories = parser.parseNewsArrayResponse(TestUtil.DUMMY_RESPONSE);
        Assert.assertEquals("parsing json response ",1, stories.size());
        Assert.assertTrue("parsing json response::check title parsed",stories.get(0).getTitle().equals("Mock Title"));
    }

    @Test
    public void testNewsEntityModelFunctions()
    {
        Assert.assertTrue("NewsEntity::mock",story!=null);
        Assert.assertTrue("NewsEntity::getTitle",story.getTitle().equals("Mock Story"));
        Assert.assertTrue("NewsEntity::getArticleURL",story.getArticleUrl().equals("www.google.com"));
        Assert.assertTrue("NewsEntity::getSummary",story.getSummary().equals("summary"));

    }

    @Test
    public void TestMediaEntityInNewsEntity() {

        Assert.assertTrue("NewsEntity::getMediaEntity",story.getMediaEntity().size()>0);

    }



}
