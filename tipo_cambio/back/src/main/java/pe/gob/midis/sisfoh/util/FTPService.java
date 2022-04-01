package pe.gob.midis.sisfoh.util;

import java.io.File;

import pe.gob.midis.sisfoh.exceptions.FTPErrors;

/**
 * Created by Elvis Susanibar Mesias 27/09/2021
 */
public interface FTPService {
     void connectToFTP(String host, String user, String pass) throws FTPErrors;
     void uploadFileToFTP(File file, String ftpHostDir , String serverFilename) throws FTPErrors;
     void downloadFileFromFTP(String ftpRelativePath, String copytoPath) throws FTPErrors;
     void disconnectFTP() throws FTPErrors;

}
