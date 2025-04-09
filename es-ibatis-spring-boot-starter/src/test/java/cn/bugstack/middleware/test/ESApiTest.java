package cn.bugstack.middleware.test;

import cn.bugstack.middleware.test.po.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class ESApiTest {

    public RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("127.0.0.1", 9200, "http")
            )
    );

    @Test
    public void test_sql() throws IOException {

        // 构建查询条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.queryStringQuery("SELECT id, userId, userNickName, userHead, userPassword, createTime from user"));

        // 创建查询请求对象，将查询条件配置到其中
        SearchRequest request = new SearchRequest("user");
        request.source(searchSourceBuilder);

        // 执行查询，然后处理响应结果
        SearchResponse searchResponse = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(searchResponse));

    }

    /**
     * 新建索引
     *
     * @throws Exception
     */
    @Test
    public void testCreateIndex() throws IOException {
        //创建请求
        CreateIndexRequest request = new CreateIndexRequest("user");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    /**
     * 查询索引
     *
     * @throws IOException
     */
    @Test
    public void testExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("user");
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 删除索引
     *
     * @throws IOException
     */
    @Test
    public void testDeleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("user");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete);
    }

    /**
     * 创建文档
     *
     * @throws IOException
     */
    @Test
    public void testCreateDocument() throws IOException {
        IndexRequest indexRequest = new IndexRequest("user");
        User user_01 = new User();
        user_01.setId(1L);
        user_01.setUserId("184172133");
        user_01.setUserNickName("小傅哥");
        user_01.setUserHead("01_50");
        user_01.setUserPassword("123456");
        user_01.setCreateTime(new Date());
        user_01.setUpdateTime(new Date());
        indexRequest.source(JSONObject.toJSONString(user_01), XContentType.JSON);
        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        User user_02 = new User();
        user_02.setId(2L);
        user_02.setUserId("980765512");
        user_02.setUserNickName("铁锤");
        user_02.setUserHead("02_50");
        user_02.setUserPassword("123456");
        user_02.setCreateTime(new Date());
        user_02.setUpdateTime(new Date());
        indexRequest.source(JSONObject.toJSONString(user_02), XContentType.JSON);
        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        User user_03 = new User();
        user_03.setId(3L);
        user_03.setUserId("796542178");
        user_03.setUserNickName("团团");
        user_03.setUserHead("03_50");
        user_03.setUserPassword("123456");
        user_03.setCreateTime(new Date());
        user_03.setUpdateTime(new Date());
        indexRequest.source(JSONObject.toJSONString(user_03), XContentType.JSON);
        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

        User user_04 = new User();
        user_04.setId(4L);
        user_04.setUserId("523088136");
        user_04.setUserNickName("哈尼克兔");
        user_04.setUserHead("04_50");
        user_04.setUserPassword("123456");
        user_04.setCreateTime(new Date());
        user_04.setUpdateTime(new Date());
        indexRequest.source(JSONObject.toJSONString(user_04), XContentType.JSON);
        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

    }

    /**
     * 文档是否存在
     *
     * @throws IOException
     */
    @Test
    public void testExistDocument() throws IOException {
        //bugstack 索引中     是否存在 1 的文档
        GetRequest getRequest = new GetRequest("bugstack", "1");
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 获取文档信息
     *
     * @throws IOException
     */
    @Test
    public void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("bugstack", "puThmXcBQ1CA69BNZGcz");
        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(documentFields.getSource());
    }

    /**
     * 获取文档信息
     *
     * @throws IOException
     */
    @Test
    public void testUpdatDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("bugstack", "puThmXcBQ1CA69BNZGcz");
        User user = new User();
        user.setId(1L);
        user.setUserId("184172133");
        user.setUserNickName("小傅哥");
        user.setUserHead("01_50");
        user.setUserPassword("123456");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        updateRequest.doc(JSONObject.toJSONString(user), XContentType.JSON);
        UpdateResponse update = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(update.status());
    }

    /**
     * 删除文档信息
     *
     * @throws IOException
     */
    @Test
    public void testDeleteDocument() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("bugstack", "jxeBW3MBYL0QvcF5idvD");
        DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(delete.status());
    }

    /**
     * 查询文档
     */
    @Test
    public void testSearchDocument() throws IOException {
        SearchRequest searchRequest = new SearchRequest("bugstack");
        //匹配字段
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "张飞");
        //构建查询器
        searchRequest.source(new SearchSourceBuilder().query(matchQueryBuilder));
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse.getHits().getTotalHits());
        System.out.println(JSON.toJSONString(searchResponse.getHits()));
    }

}
