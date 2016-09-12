package ml.chromaryu.serverworldbackup.api;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static ml.chromaryu.serverworldbackup.main.logger;

/**
 * Created by chroma on 16/09/11.
 */
public class FTPclient { // TODO: 16/09/11 Make FTP support
    private FTPClient client = new FTPClient();
    public boolean connect(String host,String username,String password) {
        try {
            client.connect(host);
            client.login(username,password);
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
