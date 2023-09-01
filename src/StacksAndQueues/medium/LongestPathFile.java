package StacksAndQueues.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestPathFile {
    public class Solution {
        public int lengthLongestPath(String input) {
            Deque<Integer> stack = new ArrayDeque<>();
            String[] arr = input.split("\n");
            int maxLen = 0;
            stack.push(0); //dummy null length
            for (String s: arr) {
            /*
            numOfTabs is the number of "\t", numOfTabs = 0
            when "\t" is not found, because s.lastIndexOf("\t") returns -1.
            So normally, the first parent "dir" have numOfTabs 0.
            */
                int numOfTabs = s.lastIndexOf("\t") + 1;
            /* Level is defined as numOfTabs + 1.
            For example, in "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext",
            dir is level 1, subdir1 and subdir2 are level 2, file.ext is level3
            */
                int level = numOfTabs + 1;
            /*
            The following part of code is the case that we want to consider when there are
            several subdirectories in a same level. We want to remove
            the path length of the directory or the file of same level
            that we added during previous step, and calculate
            the path length of current directory or file that we are currently looking at.
            */
                while (level < stack.size()) stack.poll();
                int curLen = stack.peek() + s.length() - numOfTabs + 1;
                stack.push(curLen);
                if (s.contains(".")) maxLen = Math.max(maxLen, curLen - 1); //Only update the maxLen when a file is discovered,
                // And remove the "/" at the end of file
            }
            return maxLen;
        }
    }
}
