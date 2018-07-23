package com.answerlyl.netty.lylnettyserver.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.answerlyl.netty.lylnettyserver.bean.AnswerFinance;
import com.answerlyl.netty.lylnettyserver.bean.JsonResult;
import com.answerlyl.netty.lylnettyutils.bean.NettyChannelMap;
import com.answerlyl.netty.lylnettyutils.bean.ReplyMsg;
import com.answerlyl.netty.lylnettyutils.bean.ReplyServerBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/netty-api/")
@Api(value="NettyRestController",description="netty服务接口",tags={"netty服务接口"})
public class NettyRestController {

    /**
     * 推送数据
     * @param answerFinance
     * @return
     */
    @ApiOperation(value="推送数据", notes="向netty推送数据")
    //@ApiImplicitParam(name = "answerFinance", value = "财务详细实体answerFinance", required = true, dataType = "answerFinance")
    @RequestMapping(value = "answerFinance", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody AnswerFinance answerFinance){
        JsonResult r = new JsonResult();
        try {

            String info = JSON.toJSONString(answerFinance);

            ReplyMsg msg = new ReplyMsg();
            msg.setBody(new ReplyServerBody(info));

            NettyChannelMap.get("18201150091").writeAndFlush(msg);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserById (@PathVariable(value = "id") Integer id){
        JsonResult r = new JsonResult();
        try {
            r.setResult("hehe");
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }




}
