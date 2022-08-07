package top.ferbylv.monkeyblogjava.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.ferbylv.monkeyblogjava.bean.Contract;

@Mapper
public interface ContractMapper extends BaseMapper<Contract> {
}