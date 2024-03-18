package org.parser.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassInfo {

    private String comment;
    private String annotation;
    private String modifier;
    private String name;
    private List<String> fields;
    private List<MethodInfo> methodInfoList;

    public void addFiled(String filed) {
        if (fields == null) {
            fields = new ArrayList<>();
        }
        this.fields.add(filed);
    }

    public void addMethod(MethodInfo methodInfo) {
        if (methodInfoList == null) {
            methodInfoList = new ArrayList<>();
        }
        this.methodInfoList.add(methodInfo);
    }

}
