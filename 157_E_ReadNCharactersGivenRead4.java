/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(n <= 0)  return 0;
        
        int bytesRead = 0;
        boolean eof = false;
        char[] buffer = new char[4];
        
        while(!eof && bytesRead < n) {
            int sz = read4(buffer);
            if(sz < 4) {
                eof = true;
            }
            int curBytesRead = Math.min(n - bytesRead, sz);
            for(int i = 0; i < curBytesRead; i++) {
                buf[bytesRead + i] = buffer[i];
            }
            bytesRead += curBytesRead;
        }
        
        return bytesRead;
    }
}
