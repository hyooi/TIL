package ftp;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;

class FtpServiceTest extends CamelTestSupport {

  private FakeFtpServer ftpServer;

  @BeforeEach
  public void setUp() throws Exception {
    var fileSystem = new UnixFakeFileSystem();
    fileSystem.add(new DirectoryEntry("/home"));
    fileSystem.add(new FileEntry("/home/foobar.txt", "abcdf 123456789"));

    ftpServer = new FakeFtpServer();
    ftpServer.addUserAccount(new UserAccount("user", "password", "/home"));
    ftpServer.setFileSystem(fileSystem);

    ftpServer.start();

    super.setUp();
  }

  @Test
  void test() {
    var result =
        new FtpService("user", "localhost", "/home/foobar.txt", context(), template()).run();
    System.out.println(result);
  }

  @Override
  public void tearDown() throws Exception {
    ftpServer.stop();
  }
}