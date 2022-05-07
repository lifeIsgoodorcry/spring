package com.example.demo1.javac;

import com.sun.source.util.JavacTask;
import com.sun.tools.javac.api.JavacTool;

import javax.tools.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaComplier extends ForwardingJavaFileManager<JavaFileManager> {


    /**
     * Creates a new instance of ForwardingJavaFileManager.
     *
     * @param fileManager delegate to this file manager
     */
    protected JavaComplier(JavaFileManager fileManager) {
        super(fileManager);
    }

    public static void main(String[] args) {

        JavaFileObject sfo = new SimpleJavaFileObject(URI.create("/Users/qiuhua/Downloads/projects/spring/demo1/src/test/java/com/example/demo1/javac/Test.java"), JavaFileObject.Kind.SOURCE) {
            public CharSequence getCharContent(boolean ignoreEncodingErrors) {
                return "class BadName { User u; }";
            }
        };

        List<? extends JavaFileObject> files = Arrays.asList(sfo);  //需要编译的文件
        JavaCompiler compiler = JavacTool.create();

        List<String> optionList = new ArrayList<String>();
        // set compiler's classpath to be same as the runtime's

        String s = System.getProperty("java.class.path");
        s = s + ":/Users/qiuhua/Downloads/projects/spring/demo1/classes/User.class";
        optionList.addAll(Arrays.asList("-classpath", s));


        System.out.println(s);
        JavacTask c = (JavacTask) compiler.getTask(null, null, null,
                optionList, null, files);
        boolean ok = c.call();
        if (!ok)
            throw new Error("compilation failed");

    DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
    // JavaCompiler.CompilationTask task = compiler.getTask(null,this,diagnosticsCollector,optionList,null,jfos);

}
}
