package ftp;

import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;

class Ftp2FileServiceTest extends CamelTestSupport {

  private FakeFtpServer ftpServer;
  private FTPClient ftpClient;

  @BeforeEach
  public void setUp() throws Exception {
    var fileSystem = new UnixFakeFileSystem();
    fileSystem.add(new DirectoryEntry("/home"));
    fileSystem.add(new FileEntry("/home/foobar.txt", "abcdf 123456789"));

    ftpServer = new FakeFtpServer();
    ftpServer.setServerControlPort(21);
    ftpServer.addUserAccount(new UserAccount("user", "password", "/home"));
    ftpServer.setFileSystem(fileSystem);

    ftpServer.start();

    ftpClient = new FTPClient();
    ftpClient.connect("localhost");
    ftpClient.login("user", "password");

    super.setUp();
  }

  @Override
  public void tearDown() throws Exception {
    super.tearDown();

    ftpClient.disconnect();
    ftpServer.stop();
  }

  @Test
  void test() throws Exception {
    var result = new Ftp2FileService(context, template).run();
    System.out.println(result);
  }
}