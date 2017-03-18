### Operating System (Ubuntu 15.10 / MacOS 10.10 / Windows 10)

Use `uname -a` if on Linux.

### JDK (Oracle 1.8.0_72, OpenJDK 1.8.x, Azul Zing)

Paste the output from `java -version` at the command line.

### Library Dependencies

If this is an issue that involves integration with another system, include the exact version and OS of the other system, including any intermediate drivers or APIs i.e. if you connect to a MySQL database, include both the version / OS of MySQL and the JDBC driver version used to connect to the database.

### Expected Behavior

Please describe the expected behavior of the issue, starting from the first action.

1.
2.
3.

### Actual Behavior

Please provide a description of what actually happens, working from the same starting point.

Be descriptive: "it doesn't work" does not describe what the behavior actually is -- instead, say "the page renders a 500 error code with no body content."  Copy and paste logs, and include any URLs.  Turn on internal Play logging with `<logger name="play" value="TRACE"/>` if there is no log output.  

1.
2.
3.

### Reproducible Test Case

Please provide a PR with a failing test.  

If the issue is more complex or requires configuration, please provide a link to a project on Github that reproduces the issue.

