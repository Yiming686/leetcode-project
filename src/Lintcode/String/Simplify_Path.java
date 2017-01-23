package Lintcode.String;

import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;

/**
 Simplify Path

 Description
 Notes
 Testcase
 Judge
Given an absolute path for a file (Unix-style), simplify it.

Have you met this question in a real interview? Yes
Example
"/home/", => "/home"

"/a/./b/../../c/", => "/c"

Challenge 
Did you consider the case where path = "/../"?

In this case, you should return "/".

Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".

In this case, you should ignore redundant slashes and return "/home/foo".

Tags 
String Stack


 *
 */
public class Simplify_Path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        String result = "2,,";
//        String[] stubs = result.split(",");
		System.out.println(""+simplifyPath("../../.."));
		System.out.println(""+simplifyPath("/..."));
		System.out.println(""+simplifyPath("/home//"));
		System.out.println(""+simplifyPath("/a/./b/../../c/"));
		System.out.println(""+simplifyPath("/home//foo/"));
	}

    public static String simplifyPath(String path) {
        // Write your code here
        String[] stubs = path.split("/+");
        ArrayList<String> paths = new ArrayList<String>();
        for (String s : stubs){
            if(s.equals("..")){
                int size = paths.size();
                if(size > 0){//ArrayIndexOutOfBoundsException: -1
                    paths.remove(size - 1);
                } 
            // ignore "." and ""
            //if no !s.equals(""), print   //...//home //c //home/foo
            }else if (!s.equals(".") && !s.equals("")){
                paths.add(s);
            }
        }
 // 解法一：very clear,very short, best
        String result = "/";
        if(!paths.isEmpty()){
            result = "";
            for (String s : paths){
                result +=  "/" + s;
            }
        }

// 解法二：result共用，第一个prefix为空，以后都为“/”
        // String result = "/";
        // String prefix = "";
        // for (String s : paths){
        //     result +=  prefix + s;
        //     prefix = "/";
        // }

// 解法三：遍历，除了最后一个
        // String result = "/";
        // int size = paths.size();
        // String suffix = "/";
        // for (int i = 0; i < size; i++){
        //     String s = paths.get(i);
        //     if(i == size - 1) {
        //         suffix = "";
        //     }
        //     result += s + suffix;
        // }
        return result;
    }

}
