package org.parser.service;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import org.parser.constants.Constants;
import org.parser.domain.ClassInfo;
import org.parser.domain.MethodInfo;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.parser.constants.Constants.*;

public class Processor {

    public void parserToJava(String sourceFilePath, String targetFilePath) {

        try {
            // Parse the Java source file
            FileInputStream inputStream = new FileInputStream(sourceFilePath);
            ParseResult<CompilationUnit> parseResult = new JavaParser().parse(inputStream);

            // Retrieve the compilation unit
            CompilationUnit unit = parseResult.getResult().orElseThrow(() -> new FileNotFoundException("Unable to parse file: " + sourceFilePath));

            // Define a visitor to analyze classes, methods, and variables
            NodeList<TypeDeclaration<?>> types = unit.getTypes();
            Optional<TypeDeclaration<?>> first = types.getFirst();
            TypeDeclaration<?> typeDeclaration = first.get();

            List<Node> nodes = typeDeclaration.getChildNodes();

            ClassInfo classInfo = new ClassInfo();

            /*
                1. Class 주석정보 (고정)
                2. 어노테이션 (고정)
                3. 접근제한자, 클래스명
                4. 멤버변수 정보
                5. 함수 정보
            */

            for (Node node : nodes) {

                /** TODO - Class 주석 내용 변경시 작성
                 if (isEqualTypeName(node, Constants.JAVADOC_COMMENT)) {
                 //@BxcmCatetgory 내용으로 변경
                 }
                 */

                if (isEqualTypeName(node, Constants.ANNOTATION)) {
                    classInfo.setAnnotation("@Service");
                }

                if (isEqualTypeName(node, Constants.MODIFIER)) {
                    classInfo.setModifier(node.toString());
                }

                if (isEqualTypeName(node, Constants.CLASSNAME)) {
                    classInfo.setName(node.toString().replace("Impl",""));
                }

                // 멤버변수에 @Resource가 있을경우 @Autowired 로 변경
                if (isEqualTypeName(node, Constants.FIELD)) {
                    String content = node.toString();
                    Pattern regex = Pattern.compile(Constants.REGEX_RESOURCE);
                    Matcher matcher = regex.matcher(content);
                    classInfo.addFiled(matcher.replaceAll("@Autowired"));
                }

                // Method 정보 추출
                if (isEqualTypeName(node, Constants.METHOD)) {
                    MethodDeclaration content = (MethodDeclaration) node;
                    if (content.getName() != null) {
                        MethodInfo methodInfo = getMethodInfo(content);
                        classInfo.addMethod(methodInfo);
                    }
                }
            }

            // Class 주석 생성
            String comment = "@BxmCategory(logicalName=\"" + classInfo.getName() + "\", description=\"" + classInfo.getName() + "\")";
            classInfo.setComment(comment);

            // Java Content 생성
            String javaContent = writeJavaContent(classInfo);

            // Java File 생성
            createJavaFile(targetFilePath, javaContent);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + sourceFilePath);
            e.printStackTrace();
        }
    }



    /**
     * Method 내 정보를 추출한다
     * @param content
     * @return
     */
    private static MethodInfo getMethodInfo(MethodDeclaration content) {
        // 함수 주석 추출
        String comment = content.getComment().isEmpty() ?
                content.getNameAsString() :
                content.getComment().get().toString();

        // 함수 파라미터 추출
        String params = content.getParameters().stream()
                .map(param -> param.toString())
                .collect(Collectors.joining(", "));

        // 함수 오류 추출
        String exceptions = content.getThrownExceptions().stream()
                .map(ex -> ex.toString())
                .collect(Collectors.joining(", "));

        // 함수 내용 추출
        StringBuffer body = new StringBuffer();
        convertMethodBody(content, body);

        // 함수 정보 세팅
        MethodInfo methodInfo = MethodInfo.builder()
                .comment(comment)
                .modifier(content.getModifiers().get(0).toString())
                .rType(content.getTypeAsString())
                .name(content.getNameAsString())
                .pType(params)
                .exception(exceptions)
                .body(body.toString())
                .build();
        return methodInfo;
    }

    /**
     * Method Body 내용을 변환한다
     * @param content
     * @param body
     */
    private static void convertMethodBody(MethodDeclaration content, StringBuffer body) {
        List<String> strings = Arrays.stream(content.getBody().get().toString().split(NEW_LINE)).toList();

        // 함수내용 Prefix
        body.append(TAB).append(strings.get(0)).append(NEW_LINE);
        body.append("//").append(TAB2).append("TODO - 주석을 풀고 작성하세요."+NEW_LINE);

        // 함수내용 원본에 '//' 주석 추가
        for (int i = 1; i < strings.size()-1; i++) {
            String string = strings.get(i);
            body.append("// "+string + NEW_LINE);
        }

        // 함수내용 Suffix
        body.append(TAB2).append("throw new Exception(\"개발중 코드\");").append(NEW_LINE);
        body.append(TAB2).append("return null;").append(NEW_LINE);
        body.append(TAB).append(strings.get(strings.size()-1)).append(NEW_LINE);
    }

    /**
     * Java Parser 타입체크
     * @param node
     * @param typeName
     * @return
     */
    private static boolean isEqualTypeName(Node node, String typeName) {
        return node.getClass().getName().equals(typeName);
    }

    /**
     * ClassInfo 정보로 Java 내용을 작성한다.
     *
     * @param clazz
     * @param targetFilePath
     */
    public static String writeJavaContent(ClassInfo clazz) {
        StringBuffer content = new StringBuffer();
        // TODO - 패키지정보 ?
        content.append("// FIXME - package 패키지 경로를 적어주세요 ").append(NEW_LINE).append(NEW_LINE);
        content.append("// FIXME - import 정보를 적어주세요 ").append(NEW_LINE).append(NEW_LINE);

        // 어노테이션 작성
        content.append(NEW_LINE)
                .append(clazz.getAnnotation()).append(NEW_LINE)
                .append(clazz.getComment()).append(NEW_LINE);

        // 접근제어자 작성
        content.append(clazz.getModifier()).append("class").append(SPACE)
                .append(clazz.getName()).append(SPACE).append(LB_).append(NEW_LINE).append(NEW_LINE);

        // 멤버변수 작성
        for (String filed: clazz.getFields()) {
            content.append(TAB).append(filed.replaceAll(NEW_LINE,NEW_LINE+TAB)).append(NEW_LINE).append(NEW_LINE);
        }

        // 함수 작성
        for (MethodInfo method: clazz.getMethodInfoList()) {
            content.append(writeMethod(method));
            content.append(NEW_LINE);
        }

        return content.toString();
    }

    /**
     * 수집된 Method 정보로 Java Method 부분을 작성한다
     * @param methodInfo
     * @return
     */
    public static String writeMethod(MethodInfo methodInfo) {
        StringBuffer content = new StringBuffer();

        // 어노테이션
        content.append(TAB).append("@BxmCategory(logicalName=\"")
                .append("FIXME-"+methodInfo.getName())
                .append("\", description=\"")
                .append("FIXME-"+methodInfo.getName())
                .append("\")").append(NEW_LINE);

        // 접근제어, 리턴타입, 함수명
        content.append(TAB)
                .append(methodInfo.getModifier())
                .append(methodInfo.getRType()).append(SPACE)
                .append(methodInfo.getName()).append(LB)
                .append(methodInfo.getPType()).append(RB)
                .append(" throws ").append(methodInfo.getException()).append(NEW_LINE)
                .append(methodInfo.getBody());
        return content.toString();
    }

    /**
     * 최종 Java 파일을 만든다
     * @param fileName
     * @param content
     */
    public static void createJavaFile(String fileName, String content) {
        try {
            File file = new File(fileName);

            if (!file.exists()) {
                File parentDir = file.getParentFile();
                if (!parentDir.exists()) {
                    parentDir.mkdirs();
                }
            }
            FileWriter writer = new FileWriter(file, false);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
