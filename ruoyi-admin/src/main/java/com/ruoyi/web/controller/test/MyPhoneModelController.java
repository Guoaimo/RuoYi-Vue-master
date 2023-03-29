package com.ruoyi.web.controller.test;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.domain.MyPhoneModel;
import com.ruoyi.test.service.IMyPhoneModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 型号Controller
 * 
 * @author guo
 * @date 2023-03-29
 */
@RestController
@RequestMapping("/test/model")
public class MyPhoneModelController extends BaseController
{
    @Autowired
    private IMyPhoneModelService myPhoneModelService;

    /**
     * 查询型号列表
     */
    @PreAuthorize("@ss.hasPermi('test:model:list')")
    @GetMapping("/list")
    public TableDataInfo list(MyPhoneModel myPhoneModel)
    {
        startPage();
        List<MyPhoneModel> list = myPhoneModelService.selectMyPhoneModelList(myPhoneModel);
        return getDataTable(list);
    }

    /**
     * 导出型号列表
     */
    @PreAuthorize("@ss.hasPermi('test:model:export')")
    @Log(title = "型号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyPhoneModel myPhoneModel)
    {
        List<MyPhoneModel> list = myPhoneModelService.selectMyPhoneModelList(myPhoneModel);
        ExcelUtil<MyPhoneModel> util = new ExcelUtil<MyPhoneModel>(MyPhoneModel.class);
        util.exportExcel(response, list, "型号数据");
    }

    /**
     * 获取型号详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:model:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(myPhoneModelService.selectMyPhoneModelById(id));
    }

    /**
     * 新增型号
     */
    @PreAuthorize("@ss.hasPermi('test:model:add')")
    @Log(title = "型号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyPhoneModel myPhoneModel)
    {
        return toAjax(myPhoneModelService.insertMyPhoneModel(myPhoneModel));
    }

    /**
     * 修改型号
     */
    @PreAuthorize("@ss.hasPermi('test:model:edit')")
    @Log(title = "型号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyPhoneModel myPhoneModel)
    {
        return toAjax(myPhoneModelService.updateMyPhoneModel(myPhoneModel));
    }

    /**
     * 删除型号
     */
    @PreAuthorize("@ss.hasPermi('test:model:remove')")
    @Log(title = "型号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(myPhoneModelService.deleteMyPhoneModelByIds(ids));
    }
}
