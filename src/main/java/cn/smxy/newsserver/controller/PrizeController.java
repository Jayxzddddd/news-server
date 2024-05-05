package cn.smxy.newsserver.controller;

import cn.smxy.newsserver.entity.Prize;
import cn.smxy.newsserver.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
public class PrizeController {
    @Autowired
    private PrizeService prizeService;

    @GetMapping("/prize/findAll")
    public Map<String,Object> findAll(){
        Map<String,Object> map=new HashMap<>();
        List<Prize> prizeList = prizeService.findAll();
        if(prizeList!=null && prizeList.size()>0){
            map.put("code",200);
            map.put("msg","奖品检索成功");
            map.put("dataobject",prizeList);
        }
        else {
            map.put("code",404);
            map.put("msg","无奖品数据");
            map.put("dataobject",null);
        }
        return map;
    }

    @PostMapping("/prize/get")
    public void getPrize(@RequestBody Prize prize){
        Map<String,Object> map=new HashMap<>();
        //库存-1
        prize.setNumber(prize.getNumber()-1);
        prizeService.update(prize);
        map.put("code",200);
        map.put("msg","奖品领取成功");
        map.put("dataobject",null);
    }

    @PostMapping("/prize/add")
    public void addPrize(@RequestBody Prize prize){
        Map<String,Object> map=new HashMap<>();
        prizeService.add(prize);
        map.put("code",200);
        map.put("msg","奖品添加成功");
        map.put("dataobject",null);
    }

    @GetMapping("/prize/del")
    public void addPrize(Integer id){
        Map<String,Object> map=new HashMap<>();
        prizeService.delById(id);
        map.put("code",200);
        map.put("msg","奖品删除成功");
        map.put("dataobject",null);
    }
}
