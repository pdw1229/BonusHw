import java.io.*;
import java.util.zip.*;
 

public void creatZipFile() throws Exception {
  

    File f = new File("D:/file/fileup");
  
    String path = "D:/file/fileup";

    String files[] = f.list(); // f object 에 있는 파일목록
    
    // Create a buffer for reading the files
    byte[] buf = new byte[1024];
    
    try {

   

        // Create the ZIP file
        String outFilename = "D:/outfile.zip";
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));
    
        // Compress the files
        for (int i=0; i<files.length; i++) {
    
            FileInputStream in = new FileInputStream( path + "/" + files[i]);
    
            // Add ZIP entry to output stream.
            out.putNextEntry(new ZipEntry(files[i])); // Zip 파일에 경로를 정하여 저장할수 있다.
    
            // Transfer bytes from the file to the ZIP file
            int len;
            while ((len = in.read(buf)) > 0) {

                out.write(buf, 0, len);
            }
    
            // Complete the entry
            out.closeEntry();
            in.close();
        }
    
        // Complete the ZIP file
        out.close();
    }catch(Exception e) {

        throw e;
    }

}