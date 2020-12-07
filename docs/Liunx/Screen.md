### 创建Screen执行脚本

```
#!/bin/sh

biteway_server_screen1="biteway_server_screen1";
screen -dmS $biteway_server_screen1;
screen -S biteway_server_screen1 -p 0 -X stuff $'java -jar biteway-server-1.0.jar --spring.profiles.active=peer1';
screen -S biteway_server_screen1 -p 0 -X stuff $'\n';

biteway_server_screen2="biteway_server_screen2";
screen -dmS $biteway_server_screen2;
screen -S biteway_server_screen2 -p 0 -X stuff $'java -jar biteway-server-1.0.jar --spring.profiles.active=peer2';
screen -S biteway_server_screen2 -p 0 -X stuff $'\n';

biteway_server_screen3="biteway_server_screen3";
screen -dmS $biteway_server_screen3;
screen -S biteway_server_screen3 -p 0 -X stuff $'java -jar biteway-server-1.0.jar --spring.profiles.active=peer3';
screen -S biteway_server_screen3 -p 0 -X stuff $'\n';

biteway_admin_screen="biteway_admin_screen";
screen -dmS $biteway_admin_screen;
screen -S biteway_admin_screen -p 0 -X stuff $'java -jar biteway-admin-1.0.jar';
screen -S biteway_admin_screen -p 0 -X stuff $'\n';

screen_biteway_turbine="screen_biteway_turbine";
screen -dmS $screen_biteway_turbine;
screen -S screen_biteway_turbine -p 0 -X stuff $'java -jar biteway-turbine-1.0.jar';
screen -S screen_biteway_turbine -p 0 -X stuff $'\n';


zipkin_server_screen="zipkin_server_screen";
screen -dmS $zipkin_server_screen;
screen -S zipkin_server_screen -p 0 -X stuff $'java -jar zipkin-server-2.20.0-exec.jar';
screen -S zipkin_server_screen -p 0 -X stuff $'\n';
```

