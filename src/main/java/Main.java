import java.util.List;
import java.util.stream.IntStream;

// Unnamed Classes and Instance Main Methods (Preview)
void main(String[] args) {

  // String Templates (Preview)
  String name = "Bob";
  System.out.println(STR."Hello, \{name}!");

  // Record Patterns
  record Point(int x, int y) {}

  var p = new Point(3, 5);

  if (p instanceof Point(var x, var y)) {
    System.out.println(STR."[\{x}, \{y}]");
  }

  // Pattern Matching for switch
  Object obj = 1;
  var obj2 = switch (obj) {
    case String s -> s.repeat(10);
    case Integer i -> i * 10;
    case null, default -> obj;
  };
  System.out.println(obj2);

  // Virtual Threads
  List<Thread> threads = IntStream.range(0, 100000)
      .mapToObj(i -> Thread.ofPlatform().start(() -> {
        // Unnamed Patterns and Variables (Preview)
        try {
          Thread.sleep(5000);
        } catch (InterruptedException _) {}
        System.out.println(i);
      }))
      .toList();

  threads.forEach(t -> {
    try {
      t.join();
    } catch (InterruptedException _) {}
  });
}

