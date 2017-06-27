package com.wyl.bihu.Model;

import com.wyl.bihu.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/26.
 */
@Setter
@Getter
public class ResponseMsg {
    private Map map;
    private ResponseStatus status;

    public ResponseMsg(){
        map = new HashMap<String,Object>();
    }

    public ResponseMsg(ResponseStatus status){
        this();
        this.status = status;
    }

    public void addMsg(String key,Object value){
        map.put(key,value);
    }
}
