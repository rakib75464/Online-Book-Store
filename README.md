# Online-Book-Store

This folder contains the Final Project for the "Online Book Store" — a Java desktop application (GUI) including source (.java) and compiled (.class) files and images. Use this README to build, run, package, and understand the project layout.

Table of Contents
- Project Overview
- Requirements
- Build & Run (quick)
- Run compiled distribution 
- Build from source (compile)
- Create an executable JAR
- Project structure
- Notes about data & images
- Troubleshooting
- Suggestions
- contact

---

Project overview
----------------
This is a Java-based GUI application that provides a book store interface (browsing categories like Novels, StoryBooks, Detective; user registration/login; admin operations; buying flow). It appears to be implemented using plain Java), and includes both .java sources and compiled .class files.


- Java classes (sources and many compiled .class files)
  - Start.java, Start.class
  - Welcome.java, Welcome.class (+ inner classes)
  - Home.java, Home.class (+ inner classes)
  - Login.java, Login.class (+ inner classes)
  - Registration.java, Registration.class (+ inner classes)
  - UserData.java, UserData.class (+ inner classes)
  - Admin.java, Admin.class (+ inner classes)
  - AdminLogin.java, AdminLogin.class (+ inner classes)
  - AdminAdd.java, AdminAdd.class (+ inner classes)
  - AdminPassword.java, AdminPassword.class (+ inner classes)
  - Home, Welcome, Dashboard1, Dashboard1.java, Dashboard1.class, etc.
  - Book category classes: Novels.java, Novels2.java, StoryBook.java, StoryBook2.java, Detective.java, Detective2.java (+ associated .class files and inner classes/handlers)
  - Buy.java, Buy.class
  - Contribution.java, Contribution.class
  - Data.java, Data.class (a package/folder named `Data` present)
  - End.java, End.class
  - Others: many inner classes and handler classes suffixed with `$1`, `$2`, `Handler`, etc.
- Images
  - Images/ (folder)
  - pr.png (large image present at repo root)

Because the repo contains both .java and .class files, you can run the existing compiled classes or recompile the source. See the Build & Run sections below.

Requirements
------------
- Java Development Kit (JDK) 8 or newer (JDK 11+ recommended).
- Optional: an IDE (Eclipse, IntelliJ IDEA, NetBeans) for easier editing, debugging, and packaging.

Quick: Run compiled distribution (if .class files are present)
-------------------------------------------------------------
If the repository already contains compiled .class files that match the .java sources, you can run the application without compiling.

1. Open a terminal in the repository root (where Start.class is located).
2. Run:
   - java Start

Notes:
- If classes are in packages (they don't appear to be based on file listing), you must run from the appropriate root directory and include the package name.
- If you see "Could not find or load main class", ensure you're in the directory that is the root of the classpath (the folder that contains `Start.class`), and run `java Start`.

Build from source (compile all .java)
-------------------------------------
To recompile source files:

1. Open a terminal in the repository root (where the .java files are).
2. Compile all Java source files:
   - On Unix/macOS:
     javac *.java
   - Or recursively:
     find . -name "*.java" -print | xargs javac

3. Run the app:
   - java Start

If compilation reports missing classes or package issues, import the project into an IDE and use the IDE's build tools — it will make it easier to identify dependencies and set classpaths.

Creating a runnable JAR
-----------------------
Create a manifest file (Manifest.txt) containing the main class:

Manifest.txt:
```
Main-Class: Start
```

Then create the jar (from repo root):
```
jar cfm OnlineBookStore.jar Manifest.txt *.class Data/*.class Images/* *.png
```

Run:
```
java -jar OnlineBookStore.jar
```

If inner directories or package folders exist, include them or build the jar from the correct root.

Project structure
----------------------------

- Admin.java, Admin.class (+ Admin$1..$4.class)
- AdminAdd.java, AdminAdd.class (+ inner classes)
- AdminLogin.java, AdminLogin.class (+ inner classes)
- AdminPassword.java, AdminPassword.class (+ inner classes)
- Buy.java, Buy.class (+ Buy$1..$7.class)
- Contribution.java, Contribution.class (+ Contribution$1.class)
- Dashboard1.java, Dashboard1.class (+ Dashboard1$1..$5.class)
- Data.java, Data.class
- (a directory named `Data/` exists)
- Detective.java, Detective.class (+ Detective$1..$3.class, Detective$Handler.class)
- Detective2.java, Detective2.class (+ inner classes, handler)
- End.java, End.class
- Home.java, Home.class (+ Home$1..$5.class)
- Login.java, Login.class (+ Login$1..$3.class)
- Novels.java, Novels.class (+ Novels$1..$3.class, Novels$Handler.class)
- Novels2.java, Novels2.class (+ Novels2$1..$2.class, handler)
- Registration.java, Registration.class (+ Registration$1..$4.class)
- Start.java, Start.class
- StoryBook.java, StoryBook.class (+ StoryBook$1..$3.class, handler)
- StoryBook2.java, StoryBook2.class (+ StoryBook2$1..$2.class, handler)
- UserData.java, UserData.class (+ UserData$1..$5.class)
- Welcome.java, Welcome.class (+ Welcome$1..$3.class)
- pr.png
- Images/ (folder)

Notes about data & images
-------------------------
- There is a `Data` folder and `Data.java` / `Data.class`. Likely this project stores or reads book/user/order data from file(s). Before running, check the code to see expected file paths, permissions, and directories. If the app writes/reads files at runtime, ensure the working directory is correct and writable.
- The `Images` folder and `pr.png` indicate UI resources. Confirm image paths used by the code; relative paths are typically expected (e.g., `Images/book1.png`).

Troubleshooting
---------------
- "NoClassDefFoundError" or "ClassNotFoundException": Ensure you run `java` from the classpath root (the folder that contains the .class files). Use `java -cp . Start`.
- GUI windows not appearing or exceptions: Run from IDE to view stack traces easily.
- Encoding/locale issues: set `-Dfile.encoding=UTF-8` when running if text appears garbled.
- Permissions: If the app needs to create or modify files, make sure the process has write permissions.

Maintenance & cleanup suggestions
--------------------------------
- Remove committed .class files from the repository and keep only .java source code and build artifacts (.jar) in releases. Add .class to `.gitignore`.
- Add a build system (Maven/Gradle/Ant) to compile, run, test, and package reliably.
- Document the exact Java version required and include a `.gitignore`, `LICENSE`, and `CHANGELOG`.
- Add a small sample dataset and example screenshots under `docs/screenshots/`.
- If data is sensitive, avoid committing it. Use sample/test data for repo.

contact
-------------------------------
- Contact: owner/author: rakib75464
- Email  : rakibss974@gmail.com
