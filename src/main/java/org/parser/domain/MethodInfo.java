package org.parser.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class MethodInfo {

    private String comment;
    private String modifier;
    private String rType;
    private String name;
    private String pType;
    private String exception;
    private String body;

    @Override
    public String toString() {

//        log.info("함수 주석 정보 : {}", comment);
//        log.info("\t 접근제어자: {} ", modifier);
//        log.info("\t 리턴타입: {} ", rType);
//        log.info("\t 함수명 : {} ", name);
//        log.info("\t 파라미터 : {} ", pType);
//        log.info("\t 오류정보 : {} ", exception);
//        log.info("\t 함수내용 : {} ", body);

        return "MethodInfo{" +
                "comment='" + comment + '\'' +
                ", modifier='" + modifier + '\'' +
                ", rType='" + rType + '\'' +
                ", name='" + name + '\'' +
                ", pType='" + pType + '\'' +
                ", exception='" + exception + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
