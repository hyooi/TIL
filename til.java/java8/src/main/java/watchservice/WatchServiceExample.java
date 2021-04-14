package watchservice;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class WatchServiceExample {

  private final WatchService watchService;
  private final Map<WatchKey, Path> keys;

  public WatchServiceExample(Path path) throws IOException {
    watchService = FileSystems.getDefault().newWatchService();
    keys = new HashMap<>();

    walkAndRegisterDirectories(path);
  }

  private void walkAndRegisterDirectories(Path path) throws IOException {
    Files.walkFileTree(path, new SimpleFileVisitor<>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
          throws IOException {
        registerDirectory(dir);
        return FileVisitResult.CONTINUE;
      }

      private void registerDirectory(Path dir) throws IOException {
        var key = path.register(watchService, ENTRY_CREATE,
            ENTRY_DELETE, ENTRY_MODIFY);

        keys.put(key, dir);
      }
    });
  }

  private void processEvents() throws InterruptedException, IOException {
    while (true) {
      var key = watchService.take();
      var dir = keys.get(key);

      if (dir == null) {
        System.err.println("Watchkey not recognized.");
        continue;
      }

      for (var event : key.pollEvents()) {
        var kind = event.kind();
        var name = ((WatchEvent<Path>) event).context();
        var child = dir.resolve(name);

        System.out.println(event.kind().name() + ":" + child);

        if (kind == ENTRY_CREATE) { //신규 디렉토리 생성 시 watcherService에 추가
          if (Files.isDirectory(child)) {
            walkAndRegisterDirectories(child);
          }
        }
      }

      if (!key.reset()) {
        keys.remove(key);

        if (keys.isEmpty()) {
          break;
        }
      }

    }
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    new WatchServiceExample(Paths.get(""))
        .processEvents();
  }

}
