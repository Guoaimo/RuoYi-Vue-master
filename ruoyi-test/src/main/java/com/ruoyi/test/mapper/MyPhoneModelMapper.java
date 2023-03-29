package com.ruoyi.test.mapper;

import java.util.List;
import com.ruoyi.test.domain.MyPhoneModel;

/**
 * 型号Mapper接口
 * 
 * @author guo
 * @date 2023-03-29
 */
public interface MyPhoneModelMapper 
{
    /**
     * 查询型号
     * 
     * @param id 型号主键
     * @return 型号
     */
    public MyPhoneModel selectMyPhoneModelById(Long id);

    /**
     * 查询型号列表
     * 
     * @param myPhoneModel 型号
     * @return 型号集合
     */
    public List<MyPhoneModel> selectMyPhoneModelList(MyPhoneModel myPhoneModel);

    /**
     * 新增型号
     * 
     * @param myPhoneModel 型号
     * @return 结果
     */
    public int insertMyPhoneModel(MyPhoneModel myPhoneModel);

    /**
     * 修改型号
     * 
     * @param myPhoneModel 型号
     * @return 结果
     */
    public int updateMyPhoneModel(MyPhoneModel myPhoneModel);

    /**
     * 删除型号
     * 
     * @param id 型号主键
     * @return 结果
     */
    public int deleteMyPhoneModelById(Long id);

    /**
     * 批量删除型号
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyPhoneModelByIds(Long[] ids);
}
