package top.ferbylv.monkeyblogjava.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;
 
/**
 * 作者：zhuLin
 * 日期：2020-08-21 11:51
 * 备注：redis数据失效事件
 */
@Slf4j
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {



    public RedisKeyExpirationListener(RedisMessageListenerContainer redisMessageListenerContainer) {
        super(redisMessageListenerContainer);
    }
 
//    @Autowired
//    private OrderInfoMapper orderInfoMapper;
 
    /**
     * 针对redis数据失效事件，进行数据处理
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
      try {
          String key = message.toString();

          System.out.println(key);
          //从失效key中筛选代表订单失效的key
//          if (key != null && key.startsWith("order_")) {
//              //截取订单号，查询订单，如果是未支付状态则为-取消订单
//              String orderNo = key.substring(6);
//              QueryWrapper<OrderInfoEntity> queryWrapper = new QueryWrapper<>();
//              queryWrapper.eq("order_no",orderNo);
//              OrderInfoEntity orderInfo = orderInfoMapper.selectOne(queryWrapper);
//              if (orderInfo != null) {
//                  if (orderInfo.getOrderState() == 0) {   //待支付
//                      orderInfo.setOrderState(4);         //已取消
//                      orderInfoMapper.updateById(orderInfo);
//                      log.info("订单号为【" + orderNo + "】超时未支付-自动修改为已取消状态");
//                  }
//              }
//          }
      } catch (Exception e) {
          e.printStackTrace();
          log.error("【修改支付订单过期状态异常】：" + e.getMessage());
      }
    }
}