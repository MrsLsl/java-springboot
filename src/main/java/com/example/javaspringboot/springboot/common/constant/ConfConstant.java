package com.example.javaspringboot.springboot.common.constant;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;

/**
 * @Author: Liusl
 * @Date: 2020/3/27 10:23
 */
public class ConfConstant {
    public enum XMLConfigType {
        RICHTABLE_TYPE(ImmutableMap.of("tab", "http://com/ge/med/dragon/ui/table")),
        RICHTABLE_JSON_TYPE(ImmutableMap.of("tab", "http://com/ge/med/dragon/ui/table")),
        XML_TYPE(ImmutableMap.of("xsi", "http://www.w3.org/2001/XMLSchema-instance")),
        RAI_TYPE(ImmutableMap.of("rai", "http://com/ge/med/dragon/rispacs/report/rai")),
        GUI_JSON_TYPE(ImmutableMap.of("tab", "http://com/ge/med/dragon/ui/table")),
        PROPERTIES_TYPE(ImmutableMap.of());

        @Getter
        ImmutableMap<String, String> nameSpaceMap;
        XMLConfigType(ImmutableMap<String, String> nameSpaceMap){
            this.nameSpaceMap = nameSpaceMap;
        }

    }
}
