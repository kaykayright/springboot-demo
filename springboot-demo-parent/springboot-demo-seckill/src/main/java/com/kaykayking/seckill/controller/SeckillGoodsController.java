package com.kaykayking.seckill.controller;

import com.github.pagehelper.PageInfo;
import com.kaykayking.common.config.CommonRes;
import com.kaykayking.common.config.DateUtil;
import com.kaykayking.seckill.pojo.SeckillGoods;
import com.kaykayking.seckill.service.SeckillGoodsService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "SeckillGoodsController")
@RestController
@RequestMapping("/seckillGoods")
@CrossOrigin
public class SeckillGoodsController {

    private Logger logger = LoggerFactory.getLogger(SeckillGoodsController.class);

    @Autowired
    private SeckillGoodsService seckillGoodsService;


    /**
     * 根据时间区间查询秒杀商品频道列表数据
     */
    @RequestMapping("/seckilllist")
    public CommonRes list(String time ){

        List<SeckillGoods> seckillGoodsList = seckillGoodsService.list(time);

        return CommonRes.create(seckillGoodsList);


    }

    /**
     * 获取时间菜单
     */

    @RequestMapping("/menus")
    public CommonRes dateMenus(){

        return CommonRes.create(DateUtil.getDateMenus());
    }


    /**
     * 根据商品ID查询商品详情
     */
    @RequestMapping("/one")
    public CommonRes one(String time ,Long id){

        //调用Service查询商品详情

        SeckillGoods seckillGoods = seckillGoodsService.one(time,id);

        return CommonRes.create(seckillGoods);

    }


    /***
     * SeckillGoods分页条件搜索实现
     * @param seckillGoods
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "SeckillGoods条件分页查询",notes = "分页条件查询SeckillGoods方法详情",tags = {"SeckillGoodsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public CommonRes findPage(@RequestBody(required = false) @ApiParam(name = "SeckillGoods对象",value =
            "传入JSON" +
            "数据",required = false) SeckillGoods seckillGoods, @PathVariable  int page, @PathVariable  int size){
        //调用SeckillGoodsService实现分页条件查询SeckillGoods
        PageInfo<SeckillGoods> pageInfo = seckillGoodsService.findPage(seckillGoods, page, size);
       return CommonRes.create(pageInfo);
        // return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SeckillGoods分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "SeckillGoods分页查询",notes = "分页查询SeckillGoods方法详情",tags = {"SeckillGoodsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public CommonRes findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SeckillGoodsService实现分页查询SeckillGoods
        PageInfo<SeckillGoods> pageInfo = seckillGoodsService.findPage(page, size);
       // return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
        return CommonRes.create(pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param seckillGoods
     * @return
     */
    @ApiOperation(value = "SeckillGoods条件查询",notes = "条件查询SeckillGoods方法详情",tags = {"SeckillGoodsController"})
    @PostMapping(value = "/search" )
    public CommonRes findList(@RequestBody(required = false) @ApiParam(name = "SeckillGoods对象",value = "传入JSON数据",required = false) SeckillGoods seckillGoods){
        //调用SeckillGoodsService实现条件查询SeckillGoods
        List<SeckillGoods> list = seckillGoodsService.findList(seckillGoods);
        //return new Result<List<SeckillGoods>>(true,StatusCode.OK,"查询成功",list);
        return CommonRes.create(list);

    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SeckillGoods根据ID删除",notes = "根据ID删除SeckillGoods方法详情",tags = {"SeckillGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public CommonRes delete(@PathVariable Long id){
        //调用SeckillGoodsService实现根据主键删除
        seckillGoodsService.delete(id);
        //return new Result(true,StatusCode.OK,"删除成功");
        return CommonRes.create("删除成功");
    }

    /***
     * 修改SeckillGoods数据
     * @param seckillGoods
     * @param id
     * @return
     */
    @ApiOperation(value = "SeckillGoods根据ID修改",notes = "根据ID修改SeckillGoods方法详情",tags = {"SeckillGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public CommonRes update(@RequestBody @ApiParam(name = "SeckillGoods对象",value = "传入JSON数据",required = false) SeckillGoods seckillGoods,@PathVariable Long id){
        //设置主键值
        seckillGoods.setId(id);
        //调用SeckillGoodsService实现修改SeckillGoods
        seckillGoodsService.update(seckillGoods);
        //return new Result(true,StatusCode.OK,"修改成功");
        return CommonRes.create("修改成功");
    }

    /***
     * 新增SeckillGoods数据
     * @param seckillGoods
     * @return
     */
    @ApiOperation(value = "SeckillGoods添加",notes = "添加SeckillGoods方法详情",tags = {"SeckillGoodsController"})
    @PostMapping
    public CommonRes add(@RequestBody  @ApiParam(name = "SeckillGoods对象",value = "传入JSON数据",required = true) SeckillGoods seckillGoods){
        //调用SeckillGoodsService实现添加SeckillGoods
        seckillGoodsService.add(seckillGoods);
       // return new Result(true,StatusCode.OK,"添加成功");
        return CommonRes.create("添加成功");
    }

    /***
     * 根据ID查询SeckillGoods数据
     * @param id
     * @return
     */
    @ApiOperation(value = "SeckillGoods根据ID查询",notes = "根据ID查询SeckillGoods方法详情",tags = {"SeckillGoodsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public CommonRes findById(@PathVariable Long id){
        //调用SeckillGoodsService实现根据主键查询SeckillGoods
        SeckillGoods seckillGoods = seckillGoodsService.findById(id);
       // return new Result<SeckillGoods>(true,StatusCode.OK,"查询成功",seckillGoods);
        return CommonRes.create(seckillGoods,"查询成功");
    }

    /***
     * 查询SeckillGoods全部数据
     * @return
     */
    @ApiOperation(value = "查询所有SeckillGoods",notes = "查询所SeckillGoods有方法详情",tags = {"SeckillGoodsController"})
    @GetMapping
    public CommonRes findAll(){
        //调用SeckillGoodsService实现查询所有SeckillGoods
        List<SeckillGoods> list = seckillGoodsService.findAll();
        //return new Result<List<SeckillGoods>>(true, StatusCode.OK,"查询成功",list) ;
        return CommonRes.create(list,"查询成功");
    }
}
