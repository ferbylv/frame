package top.ferbylv.monkeyblogjava.bean;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Test",description = "测试类")
public class Test {
    @Schema(name = "name",title = "名称",description = "描述",example = "ferby")
    String name;
    String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
