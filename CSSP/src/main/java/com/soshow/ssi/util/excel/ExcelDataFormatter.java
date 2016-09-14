package com.soshow.ssi.util.excel;
 
import java.util.HashMap;
import java.util.Map;

/**
 * Excel数据导入导出格式化
 * @author xieb
 */
public class ExcelDataFormatter {
     
    private Map<Object,Map<Object,Object>> formatter=new HashMap<Object, Map<Object,Object>>();
 
    public void set(Object key,Map<Object,Object> map){
        formatter.put(key, map);
    }
     
    public Map<Object,Object> get(Object key){
        return formatter.get(key);
    }
     
}