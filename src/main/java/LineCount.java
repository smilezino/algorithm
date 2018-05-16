import java.io.*;
import java.util.Stack;

/**
 * 统计某个目录下文件行数
 */
public class LineCount {
    /**
     * 递归算法
     * @param path
     * @return
     * @throws IOException
     */
    public long count(String path) throws IOException {
        File file = new File(path);
        if(file.isFile()) {
            return countLine(file);
        }
        int count = 0;
        if(file.isDirectory() && file.listFiles() != null) {
            for (File f : file.listFiles()) {
                count += count(f.getAbsolutePath());
            }
        }
        return count;
    }

    /**
     * 非递归
     * @param path
     * @return
     * @throws IOException
     */
    public long countNormal(String path) throws IOException {
        File file = new File(path);
        if(file.isFile()) {
            return countLine(file);
        }
        Stack<String> stack = new Stack<>();
        long count = 0;
        if(file.isDirectory() && file.listFiles() != null) {
            stack.push(path);
            while (!stack.empty()) {
                String filepath = stack.pop();
                for (File f : new File(filepath).listFiles()) {
                    if(f.isDirectory()) {
                        stack.push(f.getAbsolutePath());
                    } else {
                        count += countLine(f);
                    }
                }
            }
        }
        return count;
    }

    /**
     * 某个文件行数
     * @param file
     * @return
     * @throws IOException
     */
    private long countLine(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try {
            long count = 0;
            while (reader.readLine() != null) {
                count++;
            }
            return count;
        } finally {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new LineCount().count("/Users/zino/study/algorithm/src/main/java/leetcode"));
        System.out.println(new LineCount().countNormal("/Users/zino/study/algorithm/src/main/java/leetcode"));
    }
}
