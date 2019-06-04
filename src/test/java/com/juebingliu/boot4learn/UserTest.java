package com.juebingliu.boot4learn;

import com.juebingliu.boot4learn.mapper.primary.BillMapper;
import com.juebingliu.boot4learn.mapper.secondary.AccinfoMapper;
import com.juebingliu.boot4learn.service.UserService;
import com.juebingliu.boot4learn.service.primary.BillService;
import com.juebingliu.boot4learn.service.secondary.AccInfoService;
import com.juebingliu.boot4learn.service.third.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.JedisPool;

/**
 * @author juebing
 * @date 2018/12/4 11:47
 * @description
 */
public class UserTest extends ApplicationTests{

    @Autowired
    private UserService userService;

//    @Autowired
//    private PersonRepository personRepository;
//
//    @Autowired
//    private MessageContentService messageContentService;

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate2;

    @Autowired
    private BillService billService;

    @Autowired
    private AccInfoService accInfoService;

    @Autowired
    private PersonService personService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private AccinfoMapper accinfoMapper;


    @Test
    public void test() throws Exception {

//        //删除所有用户
//        userService.deleteAllUsers();
//        // 插入5个用户
//        userService.create("a", 1);
//        userService.create("b", 2);
//        userService.create("c", 3);
//        userService.create("d", 4);
//        userService.create("e", 5);
//        userService.create("f", 6);

//        personRepository.save(new Person("AAA", 10));
//        personRepository.save(new Person("BBB", 20));
//        System.out.println(messageContentService.findByMsgId("4765816a33bc4eb58a27d0d309f00b01").getMsgContent());
//        System.out.println(personRepository.findByName("AAA").getAge().toString());
//        System.out.println(jdbcTemplate1.queryForObject("select count(1) from bill",String.class));
//        System.out.println(jdbcTemplate2.queryForObject("select count(1) from accInfo",String.class));

        System.out.println(billService.count());
        System.out.println(accInfoService.count());
        System.out.println(personService.count());
        System.out.println(personService.findByName("AAA").toString());
        System.out.println("--------------------分割线---------------------");
//        System.out.println(billMapper.selectByPrimaryKey("123").toString());
//        System.out.println(accinfoMapper.selectByPrimaryKey("1").toString());
//
//        // 保存字符串
//        stringRedisTemplate.opsForValue().set("aaa", "111");
//        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
//        User user = new User();
//        user.setId(999L);
//        user.setName("ljb");
//        user.setAge(7);
//        redisTemplate.opsForValue().set("user",user);
//        System.out.println(((User)redisTemplate.opsForValue().get("user")).toString());
//        jedisPool.getResource().set("bbb","111");
//        System.out.println(jedisPool.getResource().get("bbb"));
    }

}