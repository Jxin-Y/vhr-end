package com.niit.vhrend.controller.system.basic;


import com.niit.vhrend.model.JObLevel;
import com.niit.vhrend.model.RespBean;
import com.niit.vhrend.service.JObLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@Api(value = "职称管理Controller", tags = { "职称管理访问接口" })
@RequestMapping("/system/basic/job")
public class JObLevelController {
    @Autowired
    JObLevelService jObLevelService;

    @ApiOperation(value = "查询所有职称")
    @GetMapping("/")
    public RespBean getAllJObLevel() {
        List<JObLevel> jObLevelControllers = jObLevelService.getAllJObLevle();
        return RespBean.ok("获取成功", jObLevelControllers);
    }


    @ApiOperation(value = "添加职称")
    @PostMapping("/")
    public RespBean addJObLevel(@RequestBody JObLevel jObLevel) {
        if(jObLevelService.addJObLevel(jObLevel) == 1 ) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "修改职称")
    @PutMapping("/")
    public RespBean updateJObLevel(@RequestBody JObLevel jObLevel) {
        if(jObLevelService.updateJObLevel(jObLevel) == 1 ) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除一条职称数据")
    @DeleteMapping("/{id}")
    public RespBean deleteJObLevel(@PathVariable Integer id) {
        if(jObLevelService.deleteJObLevel(id) == 1 ) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "批量删除职称数据")
    @DeleteMapping("/")
    public RespBean deleteJObLevel(Integer[] ids) {
        if(jObLevelService.deleteJObLevel(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}
