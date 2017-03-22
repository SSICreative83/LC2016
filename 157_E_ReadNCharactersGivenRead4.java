/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
      
      //self
    public int read(char[] buf, int n) {
        
        int index = 0;
        boolean eof = false;
        int numRead = 0;
        char[] bufferRead4 = new char[4];
        
        while(numRead < n && !eof) {
            int justRead = read4(bufferRead4);
            if(justRead < 4) {
                eof = true;
            }
            if(numRead + justRead > n) {
                justRead = n - numRead;
            }
            numRead += justRead;
            //copy just read to destination
            for(int i = 0; i < justRead; i++) {
                buf[index] = bufferRead4[i];
                index++;
            }
            
        }
        return numRead;
    }      
      
    public int read(char[] buf, int n) {
        if(n <= 0)  return 0;
        
        int bytesRead = 0;
        boolean eof = false;
        char[] buffer = new char[4];
        
        while(!eof && bytesRead < n) {
            int canRead = read4(buffer);
            if(canRead < 4) {
                eof = true;
            }
            int curBytesRead = Math.min(n - bytesRead, canRead);    //in case needToRead is smaller than canRead
            for(int i = 0; i < curBytesRead; i++) {
                buf[bytesRead + i] = buffer[i];
            }
            bytesRead += curBytesRead;
        }
        
        return bytesRead;
    }
      

}
