package com.miaosha.service;

import com.miaosha.dao.GoodsDao;
import com.miaosha.domain.MiaoshaGoods;
import com.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;

    // 获取所有商品
    public List<GoodsVo> listGoodsVo() {
        return goodsDao.listGoodsVo();
    }

    // 获取指定时间内即将参加秒杀的商品
    public List<MiaoshaGoods> listMiaoshaGoodsLatest(int startSeconds, int endSeconds) {

    }

    public GoodsVo getGoodsVoByGoodsId(long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }

    public boolean reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        int ret = goodsDao.reduceStock(g);
        return ret > 0;
    }
}
