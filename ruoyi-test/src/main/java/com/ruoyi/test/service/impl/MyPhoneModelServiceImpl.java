package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.MyPhoneModelMapper;
import com.ruoyi.test.domain.MyPhoneModel;
import com.ruoyi.test.service.IMyPhoneModelService;

/**
 * 型号Service业务层处理
 * 
 * @author guo
 * @date 2023-03-29
 */
@Service
public class MyPhoneModelServiceImpl implements IMyPhoneModelService 
{
    @Autowired
    private MyPhoneModelMapper myPhoneModelMapper;

    /**
     * 查询型号
     * 
     * @param id 型号主键
     * @return 型号
     */
    @Override
    public MyPhoneModel selectMyPhoneModelById(Long id)
    {
        return myPhoneModelMapper.selectMyPhoneModelById(id);
    }

    /**
     * 查询型号列表
     * 
     * @param myPhoneModel 型号
     * @return 型号
     */
    @Override
    public List<MyPhoneModel> selectMyPhoneModelList(MyPhoneModel myPhoneModel)
    {
        return myPhoneModelMapper.selectMyPhoneModelList(myPhoneModel);
    }

    /**
     * 新增型号
     * 
     * @param myPhoneModel 型号
     * @return 结果
     */
    @Override
    public int insertMyPhoneModel(MyPhoneModel myPhoneModel)
    {
        return myPhoneModelMapper.insertMyPhoneModel(myPhoneModel);
    }

    /**
     * 修改型号
     * 
     * @param myPhoneModel 型号
     * @return 结果
     */
    @Override
    public int updateMyPhoneModel(MyPhoneModel myPhoneModel)
    {
        return myPhoneModelMapper.updateMyPhoneModel(myPhoneModel);
    }

    /**
     * 批量删除型号
     * 
     * @param ids 需要删除的型号主键
     * @return 结果
     */
    @Override
    public int deleteMyPhoneModelByIds(Long[] ids)
    {
        return myPhoneModelMapper.deleteMyPhoneModelByIds(ids);
    }

    /**
     * 删除型号信息
     * 
     * @param id 型号主键
     * @return 结果
     */
    @Override
    public int deleteMyPhoneModelById(Long id)
    {
        return myPhoneModelMapper.deleteMyPhoneModelById(id);
    }
}
