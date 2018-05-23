package com.zhb.dataAnalysis.marketing.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.WriteConcern;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@Component
public class MongoDBUtil {
	
	public static String MONGOIP;
	
	@Value("${mongo.ip}")
    public void setDatabase(String ip) {
		System.out.println(ip);
    	MONGOIP = ip;
    }
   
    
    public static int MONGOPORT;
    
    @Value("${mongo.port}")
    public void setMongoPort(int port) {
    	MONGOPORT = port;
    	System.out.println(MONGOPORT);
    }
    
public static String MONGODB;
	
	@Value("${mongo.db}")
    public void setDatabaseDB(String db) {
		System.out.println(db);
    	MONGODB = db;
    }
	
    /** 
     * MongoDB连接实例 
     */  
    public static MongoClient mongoClient = null;  
      
    /** 
     * MongoDB数据库实例 
     */  
    public static MongoDatabase mongoDatabase= null;  
    
    /** 
     * 构造方法 
     * 获取数据库实例 
     * @param DB_Name 
     */  
//    public MongoDBUtil(String DB_Name){  
//        this.mongoClient = new MongoClient(CONN_HOST, CONN_PORT);  
//        this.mongoDatabase = this.mongoClient.getDatabase(DB_Name);  
//    }  
    public static void init() {
        System.out.println("===============MongoDBUtil初始化========================");

        // 从配置文件中获取属性值
        //IP
//        String ip = .p.getProperty("mongoDB_ip");
        
        String ip = MONGOIP;
        System.out.println(ip);
        //端口号
//        int port = Integer.valueOf(StringUtils.isNotBlank(CommonConfig.p.getProperty("mongoDB_port"))?CommonConfig.p.getProperty("mongoDB_port"):"27017");
        
        int port = MONGOPORT;
        System.out.println(port);
        //链接的库
//        String DB = CommonConfig.p.getProperty("mongoDB_Database");
        
        String DB = MONGODB;
        if(StringUtils.isNotBlank(ip)){
	        mongoClient = new MongoClient(ip, port);
	
	        // or, to connect to a replica set, with auto-discovery of the primary, supply a seed list of members
	        // List<ServerAddress> listHost = Arrays.asList(new ServerAddress("localhost", 27017),new ServerAddress("localhost", 27018));
	        // instance.mongoClient = new MongoClient(listHost);
	
	        // 大部分用户使用mongodb都在安全内网下，但如果将mongodb设为安全验证模式，就需要在客户端提供用户名和密码：
	        // boolean auth = db.authenticate(myUserName, myPassword);
	        Builder options = new MongoClientOptions.Builder();
	        // options.autoConnectRetry(true);// 自动重连true
	        // options.maxAutoConnectRetryTime(10); // the maximum auto connect retry time
	        options.connectionsPerHost(300);// 连接池设置为300个连接,默认为100
	        options.connectTimeout(15000);// 连接超时，推荐>3000毫秒
	        options.maxWaitTime(5000); //
	        options.socketTimeout(0);// 套接字超时时间，0无限制
	        options.threadsAllowedToBlockForConnectionMultiplier(5000);// 线程队列数，如果连接线程排满了队列就会抛出“Out of semaphores to get db”错误。
	        options.writeConcern(WriteConcern.SAFE);//
	        options.build();
	        //映射的库
	        mongoDatabase = mongoClient.getDatabase(DB);
        }
    }
    
    /** 
     * 创建数据库集合 
     * @param collName 数据库表名 
     */  
    public static boolean createCollection(String collName){  
        try  
        {  
            mongoDatabase.createCollection(collName);  
        }  
        catch(Exception e)  
        {  
            System.out.println(e.getMessage());  
            return false;  
        }  
        return true;  
    }  
    
    /** 
     * 获取数据库集合 
     * @param collName 
     * @return 
     */  
    public static MongoCollection<Document> getCollection(String collName){  
        return mongoDatabase.getCollection(collName);  
    }  
      
    /** 
     * 插入单个文档 
     * @param doc Bson文档 
     * @param collName 集合名称 
     */  
    public static void insert(Document doc, String collName){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        coll.insertOne(doc);  
    }  
      
    /** 
     * 批量插入文档 
     * @param list List类型文档 
     * @param collName 集合名称 
     */  
    public static void insert(List<Document> list, String collName){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        coll.insertMany(list);  
    }  
  
    /** 
     * 查找集合内所有Document 
     * @param collName 
     * @return 
     */  
    public static List<Document> findAll(String collName){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        List<Document> result = new ArrayList<Document>();  
        FindIterable<Document> findIterable = coll.find();  
        MongoCursor<Document> mongoCursor = findIterable.iterator();  
        while(mongoCursor.hasNext()){  
            result.add(mongoCursor.next());  
        }  
        return result;  
    }  
      
    /** 
     * 指定条件查找 
     * @param query 
     * @param collName 
     * @return 
     */  
    public static List<Document> findAll(BasicDBObject query, String collName){ 
    	init();
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        List<Document> result = new ArrayList<Document>();  
        FindIterable<Document> findIterable = coll.find(query);
        MongoCursor<Document> mongoCursor = findIterable.iterator();  
        while(mongoCursor.hasNext()){  
            result.add(mongoCursor.next());  
        }  
        mongoClient.close();
        return result;  
    }  
    
    /**
     * 指定条件查找  带分页和排序 
     * @param query 查询条件
     * @param collName 表名
     * @param sort 排序字段
     * @param sortVal 1为升序 -1为降序
     * @param pageNo 当前页数
     * @param pageSize 每页条数
     * @return
     */
    public static List<Document> findByPage(BasicDBObject query, String collName,String sort,int sortVal,int pageNo, int pageSize){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        List<Document> result = new ArrayList<Document>();  
        FindIterable<Document> findIterable = coll.find(query).sort(new BasicDBObject(sort, sortVal)).skip((pageNo - 1) * pageSize).limit(pageSize);
        MongoCursor<Document> mongoCursor = findIterable.iterator();  
        while(mongoCursor.hasNext()){  
            result.add(mongoCursor.next());  
        }  
        return result;  
    }  
    
    /**
     * 指定条件查找  带排序 
     * @param query 查询条件
     * @param collName 表名
     * @param sort 排序字段
     * @param sortVal 1为升序 -1为降序
     * @return
     */
    public static List<Document> findBySort(BasicDBObject query, String collName,String sort,int sortVal){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        List<Document> result = new ArrayList<Document>();  
        FindIterable<Document> findIterable = coll.find(query).sort(new BasicDBObject(sort, sortVal));
        MongoCursor<Document> mongoCursor = findIterable.iterator();  
        while(mongoCursor.hasNext()){  
            result.add(mongoCursor.next());  
        }  
        return result;  
    }  
      
  
    /** 
     * 指定条件查找指定字段 
     * @param query 
     * @param collName 
     * @return 
     */  
    public static List<Document> findAll(BasicDBObject query, BasicDBObject key, String collName){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        List<Document> result = new ArrayList<Document>();  
        FindIterable<Document> findIterable = coll.find(query).projection(key);  
        MongoCursor<Document> mongoCursor = findIterable.iterator();  
        while(mongoCursor.hasNext()){  
            result.add(mongoCursor.next());  
        }  
        return result;  
    }  
      
      
      
    /** 
     * 查找一个 
     * @param query 
     * @param collName 
     * @return 
     */  
    public static Document findOne(BasicDBObject query,String collName){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        Document result = new Document();  
        FindIterable<Document> findIterable = coll.find(query).limit(1);  
        result = findIterable.iterator().next();  
        return result;  
    }  
      
  
    /** 
     * 删除集合中的所有数据 
     * @param collName 
     */  
    public static void deleteAll(String collName){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        BasicDBObject delDbo=new BasicDBObject();  
        delDbo.append("_id", -1);  
        coll.deleteMany(Filters.not(delDbo));  
    }  
      
      
    /** 
     * 删除指定的所有数据 
     * @param b 
     * @param collName 
     */  
    public static void deleteAll(Bson b, String collName){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        coll.deleteMany(b);  
    }  
      
      
    /** 
     * 删除指定的一条数据 
     * @param b 
     * @param collName 
     */  
    public static void deleteOne(Bson b, String collName){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        coll.deleteOne(b);  
    }  
      
      
    //collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes",200)) );    
      
    /** 
     * 按查询条件批量修改 
     * @param b 
     * @param doc 
     * @param collName 
     */  
    public static void updateAll(Bson b, Document doc, String collName){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        coll.updateMany(b, doc);  
    }  
    
    /** 
     * 按查询条件批量修改 
     * @param b 
     * @param doc 
     * @param collName 
     */  
    public static void updateOne(Bson b,Document doc, String collName){  
        MongoCollection<Document> coll = mongoDatabase.getCollection(collName);  
        coll.updateOne(b, doc);
    }  
    
    public static int getCount(String collName){
		long count = mongoDatabase.getCollection(collName).count();
    	return new Long(count).intValue();
    }
    
    public static int getCount(String collName,Bson b){
    	long count = mongoDatabase.getCollection(collName).count(b);
    	return new Long(count).intValue();
    }
    
    public static void main(String[] args) {
//    	BasicDBObject q  = new BasicDBObject();
//		q.put("userId", "12da49d33e364784995d69eaebb40545");
//		q.put("productDetailId", "3b5ae1ccc1c14e4e8c887cc3fd38cc30");
//		List<Document> docList = MongoDBUtil.findAll(q, "browsinghistory");
//		if(docList != null && docList.size() > 0){
//			for (Document document : docList) {
//				System.out.println(document);
//			}
//		}
	}
}
