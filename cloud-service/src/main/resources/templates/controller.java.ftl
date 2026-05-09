package ${package.Controller};

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import java.util.List;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle?? && controllerMappingHyphenStyle>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
public class ${table.controllerName} {

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    /**
     * 新增或修改
     */
    @PostMapping("/save")
    public String save(@RequestBody ${entity} entity) {
        ${table.serviceName?uncap_first}.saveOrUpdate(entity);
        return "操作成功";
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        ${table.serviceName?uncap_first}.removeById(id);
        return "删除成功";
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    public List<${entity}> findAll() {
        return ${table.serviceName?uncap_first}.list();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public ${entity} findOne(@PathVariable Long id) {
        return ${table.serviceName?uncap_first}.getById(id);
    }
}