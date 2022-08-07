package top.ferbylv.monkeyblogjava.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 合同
    */
@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "test.contract")
public class Contract {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description="主键")
    private Integer id;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @Schema(description="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @Schema(description="更新时间")
    private Date updateTime;

    /**
     * 合同编码
     */
    @TableField(value = "contract_code")
    @Schema(description="合同编码")
    private String contractCode;

    /**
     * 关联订单;订单编码
     */
    @TableField(value = "order_serial")
    @Schema(description="关联订单;订单编码")
    private String orderSerial;

    /**
     * 合同名称
     */
    @TableField(value = "contract_name")
    @Schema(description="合同名称")
    private String contractName;

    /**
     * 签约金额
     */
    @TableField(value = "signed_amount")
    @Schema(description="签约金额")
    private BigDecimal signedAmount;

    /**
     * 签约时间
     */
    @TableField(value = "signed_time")
    @Schema(description="签约时间")
    private Date signedTime;

    /**
     * 经办人
     */
    @TableField(value = "agent")
    @Schema(description="经办人")
    private String agent;

    /**
     * 合同附件
     */
    @TableField(value = "attachment")
    @Schema(description="合同附件")
    private String attachment;

    /**
     * 合同类型;0签约合同1订单合同
     */
    @TableField(value = "contract_type")
    @Schema(description="合同类型;0签约合同1订单合同")
    private Integer contractType;

    /**
     * 是否有效
     */
    @TableField(value = "`valid`")
    @Schema(description="是否有效")
    private Integer valid;

    /**
     * 合同有效期;合同类型为签约合同时有效
     */
    @TableField(value = "validity")
    @Schema(description="合同有效期;合同类型为签约合同时有效")
    private String validity;
}