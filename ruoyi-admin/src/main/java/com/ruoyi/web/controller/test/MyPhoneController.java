package com.ruoyi.web.controller.test;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.domain.MyPhone;
import com.ruoyi.test.service.IMyPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 手机Controller
 * 
 * @author guo
 * @date 2023-03-29
 */
@RestController
@RequestMapping("/test/phone")
public class MyPhoneController extends BaseController
{
    @Autowired
    private IMyPhoneService myPhoneService;

    /**
     * 查询手机列表
     */
    @PreAuthorize("@ss.hasPermi('test:phone:list')")
    @GetMapping("/list")
    public TableDataInfo list(MyPhone myPhone)
    {
        startPage();
        List<MyPhone> list = myPhoneService.selectMyPhoneList(myPhone);
        return getDataTable(list);
    }

    /**
     * 导出手机列表
     */
    @PreAuthorize("@ss.hasPermi('test:phone:export')")
    @Log(title = "手机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyPhone myPhone)
    {
        List<MyPhone> list = myPhoneService.selectMyPhoneList(myPhone);
        ExcelUtil<MyPhone> util = new ExcelUtil<MyPhone>(MyPhone.class);
        util.exportExcel(response, list, "手机数据");
    }

    /**
     * 获取手机详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:phone:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(myPhoneService.selectMyPhoneById(id));
    }

    /**
     * 新增手机
     */
    @PreAuthorize("@ss.hasPermi('test:phone:add')")
    @Log(title = "手机", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyPhone myPhone)
    {
        return toAjax(myPhoneService.insertMyPhone(myPhone));
    }

    /**
     * 修改手机
     */
    @PreAuthorize("@ss.hasPermi('test:phone:edit')")
    @Log(title = "手机", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyPhone myPhone)
    {
        return toAjax(myPhoneService.updateMyPhone(myPhone));
    }

    /**
     * 删除手机
     */
    @PreAuthorize("@ss.hasPermi('test:phone:remove')")
    @Log(title = "手机", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(myPhoneService.deleteMyPhoneByIds(ids));
    }
}
