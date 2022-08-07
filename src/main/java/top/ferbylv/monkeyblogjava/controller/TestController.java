package top.ferbylv.monkeyblogjava.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ferbylv.monkeyblogjava.bean.Contract;
import top.ferbylv.monkeyblogjava.bean.Test;

@RestController
@RequestMapping("/test")
@Tag(name = "test",description = "test-controller")
public class TestController {
    //getUserInfo
    @Operation(summary = "获取用户信息",description = "获取用户信息")
    @GetMapping("/getUserInfo")
    public Test getUserInfo(@Parameter(description = "用户id",required = true) @RequestBody Integer id){
        Test test = new Test();
        test.setName("ferby");
        test.setSex("男");
        return test;
    }


    @GetMapping("tesetapi")
    @Operation(summary = "testapi",description = "get test")
    public String getInfo(@Parameter(schema = @Schema(implementation = Contract.class)) Contract contract){
        return contract.getContractName();
    }
    @GetMapping("teseta2pi")
    @Operation(summary = "testapi2",description = "get test2")
    public String getInfo2(@Parameter(schema = @Schema(implementation = Test.class)) Test test){
        return test.getName();
    }
}
