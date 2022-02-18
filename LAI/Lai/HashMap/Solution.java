package Lai.HashMap;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Solution solution = new Solution();
        // solution.mkdir("/foo/bar");
        solution.mkdir("/foo");
        solution.mkdir("/foo/bar");
        solution.writeFile("/foo/bar/file.txt", "abcd");
        // solution.readFile("/foo/bar/file.txt");
        System.out.println(solution.readFile("/foo/bar/file.txt"));
    }
    //Assumption: path is valid
    public void mkdir(String path){
        String[] dirs = path.split("/");
        File node = root;
        for(int i = 0; i < dirs.length; i++){
            if(dirs[i].length() == 0){//check length
                continue;
            }
            if(!node.children.containsKey(dirs[i])){
                if(i != dirs.length - 1){
                    	throw new IllegalArgumentException("Invalid Path!");
                }else{
                    node.children.put(dirs[i], new File());
                }
            }else{
                node = node.children.get(dirs[i]);
            }
        }
    }
    
    // /foo/bar/file.txt
    public void writeFile(String path, String content){
        String[] dirs = path.split("/");
        File node = root;
        for(int i = 0; i < dirs.length; i++){
            if(dirs[i].length() == 0){//check length
                continue;
            }
            if(!node.children.containsKey(dirs[i])){
                if(i != dirs.length - 1){
                    	throw new IllegalArgumentException("Invalid Path!");
                }else{
                    node.children.put(dirs[i], new File());
                }
            }
            node = node.children.get(dirs[i]);
        }
        //node found
        node.content = content;// Overridden
        node.isFile = true;
//        print(root);
    }
    
    public String readFile(String path){
        String[] dirs = path.split("/");
        File node = root;
        for(int i = 0; i < dirs.length; i++){
            if(dirs[i].length() == 0){//check length
                continue;
            }
            if(!node.children.containsKey(dirs[i])){
                throw new IllegalArgumentException("Invalid Path!");
                // if(i != dirs.length - 1){
                //     throw new IllegalArgumentException("Invalid Path!");
                // }else{
                //     node.children.put(dirs[i], new File());
                // }
            }
             else{
                node = node.children.get(dirs[i]);
             }
        }
        //node found
        return node.content;
    }
    
    public Solution(){
        root = new File();
    }
    
    private File root;
    
    static class File{
        boolean isFile;
        Map<String, File> children = new HashMap<>();//
        String content;
        public File(){
            this.children = new HashMap<>();
            this.content = "";
        }
    }
    
}
