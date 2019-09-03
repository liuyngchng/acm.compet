# 1. Sample
some sample for algorithm.
# 2. jdb
* console 1
```
java -Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y DeleteChar
```
最后一个字符为类名，如果有控制台输入，需要在console1下输入
* console 2
```
jdb -connect com.sun.jdi.SocketAttach:hostname=localhost,port=8000
run
stop at
next
```
在console 2 下进行debug控制
