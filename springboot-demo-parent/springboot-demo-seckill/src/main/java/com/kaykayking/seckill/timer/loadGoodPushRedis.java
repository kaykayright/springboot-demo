package com.kaykayking.seckill.timer;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 5:04 下午 2022/8/13.
 * @Modified By:
 */

import com.kaykayking.common.config.DateUtil;
import com.kaykayking.seckill.dao.SeckillGoodsMapper;
import com.kaykayking.seckill.pojo.SeckillGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * todo
 *
 * @author hk
 * @version Id
 * : loadGoodPushRedis.java, v 0.1 2022/8/13 5:04 下午 Exp $$
 */
@Component
public class loadGoodPushRedis {

    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Autowired
    private RedisTemplate redisTemplate;




    @Scheduled(cron =  "0/30 * * * * ?")
    public void loadGoodsPushRedis(){

        List<Date> dateMenus = DateUtil.getDateMenus();

        for(Date startTime : dateMenus){
            String nameSpace = "SeckillGoods_"+DateUtil.date2Str(startTime);
//            System.out.println("nameSpace:"+nameSpace);
//            System.out.println("startTime:"+startTime);
            Example example = new Example(SeckillGoods.class);
            Example.Criteria criteria = example.createCriteria();
            //商品审核状态为通过 status = 1
            criteria.andEqualTo("status","1");
            // 库存必须大于0
            criteria.andGreaterThan("stockCount",0);
            // 开始时间 <= 活动开始时间
            criteria.andGreaterThanOrEqualTo("startTime",startTime);
            //活动结束时间 < 开始时间+2小时
            criteria.andLessThan("endTime",DateUtil.addDateHour(startTime,2));

            // 排除已经存入Redis中的SeckillGoods
            // 1) 求出当前命名空间内所有商品的ID(key)
            // 2) 每次查询数据库前 排除已经存在的商品key的数据
            Set keys = redisTemplate.boundHashOps(nameSpace).keys();
            if(keys!=null && keys.size()>0){
                criteria.andNotIn("id",keys);
            }
            //查询数据
            List<SeckillGoods> seckillGoods = seckillGoodsMapper.selectByExample(example);

            for(SeckillGoods seckillGood : seckillGoods){
                redisTemplate.boundHashOps("SeckillGoods_"+nameSpace).put(seckillGood.getId(),seckillGood);
            }

        }

    }

    public static void main(String[] args) {


        List<Date> dateMenus = DateUtil.getDateMenus();
        for(Date date : dateMenus){

            System.out.println(DateUtil.date2Str(date));


        }
    }


}